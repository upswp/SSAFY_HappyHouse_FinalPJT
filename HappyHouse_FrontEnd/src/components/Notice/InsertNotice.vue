<template>
  <div>
    <h3>공지사항 작성하기</h3>
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
    <div v-if="!submitted">
      <form
        action
        method="post"
        id="_frmForm"
        name="frmForm"
        @submit.prevent="insertBoard"
      >
        <v-simple-table
          style="width:500px; margin-left:auto; margin-right:auto;"
          dense
        >
          <tr>
            <th>작성자</th>
            <td>
              {{ user.username }}
            </td>
          </tr>
          <tr>
            <th>제목</th>
            <td>
              <v-text-field
                data-msg="제목"
                type="text"
                name="title"
                id="_title"
                size="20"
                v-model="title"
              />
            </td>
          </tr>
          <tr>
            <th>내용</th>
            <td>
              <v-text-field
                data-msg="내용"
                type="text"
                name="content"
                id="_content"
                size="30"
                height="300"
                v-model="content"
              />
            </td>
          </tr>
          <tr>
            <td colspan="2" style="height:50px; text-align:center;">
              <v-btn type="submit" name="button">글등록</v-btn>
            </td>
          </tr>
        </v-simple-table>
      </form>
    </div>

    <div v-else>
      <h4>성공적으로 글등록이 완료하였습니다!</h4>
      <router-link class="btn btn-primary" to="/insertNotice"
        >새 글 작성</router-link
      >
      |
      <router-link class="btn btn-primary" to="/notice">목록으로</router-link>
    </div>
  </div>
</template>
<script>
import http from '../../http-common';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: 'InsertNotice',
  data() {
    return {
      info: null,
      loading: true,
      errored: false,
      writer: null,
      title: null,
      content: '',
      user: '',
      subnav: [
        { title: '모든 글 보기', path: '/notice' },
        { title: '글 등록하기 ', path: '/insertNotice' },
      ],
      elsenav: { title: '공지사항 전체보기', path: '/notice' },

      submitted: false,
    };
  },
  mounted() {
    http
      .get('/insert')
      .then((response) => (this.info = response.data))
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
  methods: {
    insertBoard() {
      if (this.title == '') {
        alert('제목을 선택하세요.');
        return;
      }
      if (this.title == '') {
        alert('내용을 선택하세요.');
        return;
      }

      http
        .post('/noticeboard/insertBoard', {
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
  },
};
</script>

<style scoped>
#subtitle {
  float: right;
}
</style>
