<template>
  <div>
    <h3>QnA</h3>
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
    <br />
    <br />
    <div>
      <v-simple-table class="table">
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left" id="no">글번호</th>
              <th class="text-left" id="writer">글쓴이</th>
              <th class="text-left" id="title">제목</th>
              <th class="text-left" id="comment_count">댓글</th>
              <th class="text-left" id="regtime">등록일</th>
              <th class="text-left" id="check">비고</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="article in articles" :key="article.no">
              <td v-html="article.no"></td>
              <td v-html="article.writer"></td>
              <td v-html="article.title"></td>
              <td v-html="article.comment_count"></td>
              <td v-html="article.regtime"></td>
              <td>
                <v-btn name="상세보기" @click="detailArticle(article.no)">
                  상세보기
                </v-btn>
                <template
                  v-if="user.userid == article.writer || user.userno == 1"
                >
                  <v-btn name="삭제" @click="deleteArticle(article.no)">
                    삭제
                  </v-btn>
                </template>
              </td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </div>
</template>

<script>
import http from '../http-common';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: 'SelectBoard',
  data() {
    return {
      upHere: false,
      articles: [],
      user: '',
      subnav: [
        { title: '모든 글 보기', path: '/qnaboard' },
        { title: '글 등록하기 ', path: '/insert' },
      ],
      loading: true,
      errored: false,
    };
  },
  methods: {
    detailArticle(did) {
      this.$router.push('/detail/' + did);
    },
    retrieveArticle() {
      http
        .get('/qnaboard/qselect')
        .then((response) => (this.articles = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    deleteArticle(did) {
      alert(did + '가 삭제합니다.');
      http
        .delete('/qnaboard/qdelete/' + did)
        .then((response) => {
          if (response.data == 'success') {
            alert('삭제처리를 하였습니다.');
            this.retrieveArticle();
          } else {
            alert('삭제처리를 하지 못했습니다.');
          }
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
  },
  mounted() {
    this.retrieveArticle();
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#no {
  width: 10%;
}
#writer {
  width: 20%;
}
#title {
  width: 30%;
}
#comment_count {
  width: 10%;
}
#regitime {
  width: 10%;
}
#check {
  width: 20%;
}
#subtitle {
  float: right;
}
</style>
