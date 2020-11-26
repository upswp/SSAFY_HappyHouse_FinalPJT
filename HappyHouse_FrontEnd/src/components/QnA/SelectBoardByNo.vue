<template>
  <div>
    <h3>QnA 상세보기</h3>
    <br />
    <v-btn
      id="subtitle"
      v-for="(sub, index) in subnav"
      :key="index"
      :to="sub.path"
      text
    >
      {{ sub.title }}
    </v-btn>
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

    <br /><br />

    <!--  댓글  -->
    <label>comment</label>
    <v-simple-table
      style="width:500px; margin-left:auto; margin-right:auto;"
      dense
    >
      <tr>
        <td>{{ user.userid }}:::</td>
        <td>
          <v-text-field
            data-msg="내용"
            type="text"
            name="content"
            id="_content"
            size="30"
            v-model="content"
          />
        </td>
        <td colspan="2" style="height:50px; text-align:center;">
          <v-btn type="submit" name="button">commit</v-btn>
        </td>
      </tr>
    </v-simple-table>
  </div>
</template>

<script>
import http from '../../http-common';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: 'SelectBoardByNo',
  props: ['no'],
  data() {
    return {
      upHere: false,
      article: {},
      user: '',
      comments: [],
      subnav: [
        { title: '모든 글 보기', path: '/qnaboard' },
        { title: '글 등록하기 ', path: '/insert' },
      ],

      loading: true,
      errored: false,
    };
  },
  methods: {
    insertBoard() {
      if (this.content == '') {
        alert('댓글을 작성하세요.');
        return;
      }

      http
        .post('/comment/insert', {
          writer: this.user.userid,
          title: this.title,
          content: this.content,
        })
        .then((response) => {
          if (response.data == 'success') {
            alert('글등록 처리를 하였습니다.');
          } else {
            alert('글등록 처리를 하지 못했습니다.');
          }
        });
      this.submitted = true;
    },
    updateArticle(did) {
      this.$router.push('/update/' + did);
    },
  },
  mounted() {
    http
      .get('/comment/list/' + this.no)
      .then((response) => (this.comments = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));

    http
      .get('/qnaboard/qdetail/' + this.no)
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
