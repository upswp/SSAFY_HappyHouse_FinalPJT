import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import createPersistedState from 'vuex-persistedstate';
Vue.use(Vuex);

const SERVER_URL = process.env.VUE_APP_SERVER_URL;
//const SERVER_URL = 'http://localhost:9999/happyhouse/api';
export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    accessToken: null,
    userId: '',
    userName: '',
  },
  getters: {
    getAccessToken(state) {
      return state.accessToken;
    },
    getUserId(state) {
      return state.userId;
    },
    getUserName(state) {
      return state.userName;
    },
  },
  mutations: {
    LOGIN(state, payload) {
      state.accessToken = payload['auth-token'];
      state.userId = payload['user-id'];
      state.userName = payload['user-name'];
    },
    LOGOUT(state) {
      state.accessToken = null;
      state.userId = '';
      state.userName = '';
    },
  },
  actions: {
    LOGIN(context, user) {
      return axios
        .post(`${SERVER_URL}/user/confirm/login`, user)
        .then((response) => {
          if (`${response.data['status']}` == 'true') {
            alert(
              '반갑습니다!' +
                `${response.data['user-name']}` +
                '님! 당신의 Happyhouse입니다.'
            );
            context.commit('LOGIN', response.data);
            axios.defaults.headers.common[
              'auth-token'
            ] = `${response.data['auth-token']}`;
          } else {
            alert('올바른 계정정보를 입력하세요.');
          }
        });
    },
    LOGOUT(context) {
      context.commit('LOGOUT');
      axios.defaults.headers.common['auth-token'] = undefined;
    },
  },
  modules: {},
});
