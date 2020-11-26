<template>
  <div>
    <h3>공지사항 수정</h3>
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
              <td v-html="article.no"></td>
            </tr>
            <tr>
              <td>작성자</td>
              <td v-html="article.writer"></td>
            </tr>
            <tr>
              <td>제목</td>
              <td>
                <v-text-field
                  data-msg="제목"
                  type="text"
                  name="title"
                  id="_title"
                  size="20"
                  v-model="article.title"
                />
              </td>
            </tr>
            <tr>
              <td>내용</td>
              <td>
                <v-text-field
                  data-msg="내용"
                  type="text"
                  name="content"
                  size="30"
                  v-model="article.content"
                  style="width:100%; height:100px;"
                />
              </td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </v-card>
    <br />
    <template v-if="user.userno == 1">
      <v-btn type="submit" name="button" @click="updateBoard">
        글수정
      </v-btn>
    </template>
  </div>
</template>

<script>
import http from '../../http-common';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: 'UpdateNotice',
  props: ['no'],
  data() {
    return {
      upHere: false,
      article: {},
      subnav: [
        { title: '모든 글 보기', path: '/notice' },
        { title: '글 등록하기 ', path: '/insertNotice' },
      ],
      elsenav: { title: '공지사항 전체보기', path: '/notice' },

      user: '',
      loading: true,
      errored: false,
    };
  },
  methods: {
    updateBoard() {
      if (this.article.title == '') {
        alert('제목을 작성하세요.');
        return;
      }
      if (this.article.content == '') {
        alert('내용을 작성하세요.');
        return;
      } else {
        this.$router.push('/notice/');
      }

      http
        .put('/noticeboard/update/' + this.article.no, this.article)
        .then((response) => {
          if (response.data == 'success') {
            alert('글등록 업데이트처리를 하였습니다.');
          } else {
            alert('글등록 업데이트처리를 하지 못했습니다.');
          }
        });
      this.submitted = true;
    },
    newCustomer() {
      (this.submitted = false),
        (this.writer = null),
        (this.title = null),
        (this.content = null);
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
