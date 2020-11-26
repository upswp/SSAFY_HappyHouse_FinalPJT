<template>
  <div>
    <h3>공지사항 상세보기</h3>
    <br />
    <!-- 관리자일때 등록, 수정 가능하도록  -->
    <template v-if="user.userno == 1">
      <v-btn
        id="subtitle"
        v-for="(sub, index) in subnav"
        :key="index"
        :to="sub.path"
        text
      >
        {{ sub.title }}
      </v-btn>
    </template>
    <!-- 관리자가 아닐경우 조회만 가능하도록  -->
    <template v-else>
      <v-btn id="subtitle" :to="elsenav.path">{{ elsenav.title }}</v-btn>
    </template>
    <br /><br />
    <v-card class="mt-3" id="card">
      <v-simple-table>
        <template v-slot:default>
          <tbody>
            <tr>
              <td>글번호</td>
              <td id="text" v-html="article.no"></td>
            </tr>
            <tr>
              <td>작성자</td>
              <td id="text" v-html="article.writer"></td>
            </tr>
            <tr>
              <td>제목</td>
              <td id="text" v-html="article.title"></td>
            </tr>
            <tr>
              <td>내용</td>
              <td id="text" v-html="article.content"></td>
            </tr>
            <tr>
              <td>작성시간</td>
              <td id="text" v-html="article.regtime"></td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </v-card>
    <br />
    <template v-if="user.userid == article.writer">
      <v-btn name="수정하기" @click="updateArticle(article.no)">
        수정하기
      </v-btn>
    </template>
  </div>
</template>

<script>
import http from '../../http-common';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: 'SelectNoticeByNo',
  props: ['no'],
  data() {
    return {
      upHere: false,
      article: {},
      user: '',
      subnav: [
        { title: '모든 글 보기', path: '/notice' },
        { title: '글 등록하기 ', path: '/insertNotice' },
      ],
      elsenav: { title: '공지사항 전체보기', path: '/notice' },

      loading: true,
      errored: false,
    };
  },
  methods: {
    updateArticle(did) {
      this.$router.push('/updateNotice/' + did);
    },
  },
  mounted() {
    http
      .get('/noticeboard/detail/' + this.no)
      .then((response) => (this.article = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
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

<style scoped>
#text {
  text-align: left;
}
#card {
  position: relative;
}
#subtitle {
  float: right;
}
</style>
