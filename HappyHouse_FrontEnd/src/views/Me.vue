<template>
  <v-card id="tableCard">
    <h3>마이페이지</h3>
    <v-simple-table>
      <template v-slot:default>
        <tbody>
          <tr>
            <td>아이디</td>
            <td id="dataText">{{ user.userid }}</td>
          </tr>
          <tr>
            <td>이름</td>
            <td id="dataText">{{ user.username }}</td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td id="dataText">{{ user.userpwd }}</td>
          </tr>
          <tr>
            <td>생년월일</td>
            <td id="dataText">{{ user.yy }}-{{ user.mm }}-{{ user.dd }}</td>
          </tr>
          <tr>
            <td>이메일</td>
            <td id="dataText">{{ user.email }}</td>
          </tr>
          <tr>
            <td>주소</td>
            <td id="dataText">{{ user.address }}</td>
          </tr>
          <tr>
            <td>결혼여부</td>
            <td id="dataText">{{ user.marriage_type }}</td>
          </tr>
          <tr>
            <td>관심지역</td>
            <td id="dataText">{{ user.interest_area }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <br />
    <div>
      <v-btn name="수정하기" @click="updateArticle(user.no)">
        수정하기
      </v-btn>
      <v-btn name="탈퇴하기" @click="deleteArticle(user.no)">
        탈퇴하기
      </v-btn>
      <br />
      <br />
    </div>
  </v-card>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      user: '',
    };
  },
  methods: {
    updateArticle(did) {
      this.$router.push('/updateMember/' + did);
    },
    deleteArticle(did) {
      axios
        .delete(`${SERVER_URL}/user/deleteMember/` + did)
        .then((response) => {
          if (response.data == 'success') {
            alert('삭제처리를 하였습니다.');
            this.retrieveArticle();
          } else {
            alert('삭제처리를 하지 못했습니다.');
            this.$router.push('/');
          }
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
  },

  created() {
    // 가져온 Token값을 header에 넣어주는 작업 실시.
    axios.defaults.headers.common['auth-token'] = this.$store.state.accessToken;
    axios
      .get(`${SERVER_URL}/user/info`)
      .then((response) => {
        this.user = response.data.user;
      })
      .catch(() => {
        // this.$store.dispatch('LOGOUT').then(() => this.$router.replace('/'));
      });
  },
};
</script>

<style>
#tableCard {
  width: 800px;
  align-self: center;
}
#dataText {
  text-align: left;
}
</style>
