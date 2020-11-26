<template>
  <v-card>
    <v-card-title>
      [관리자]회원관리
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search for UserID"
        single-line
        hide-details
        @keypress.enter="searchMember(search)"
      ></v-text-field>
    </v-card-title>
    <div>
      <v-simple-table class="table">
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left" id="no" :search="search">ID</th>
              <th class="text-left" id="writer" :search="search">이름</th>
              <th class="text-left" id="title" :search="search">Email</th>
              <th class="text-left" id="comment_count" :search="search">
                주소
              </th>
              <th class="text-left" id="regtime" :search="search">관심지역</th>
              <th class="text-left" id="regtime" :search="search">결혼여부</th>
              <th class="text-left" id="check">Delete</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in userinfo" :key="user.no">
              <td v-html="user.userid"></td>
              <td v-html="user.username"></td>
              <td v-html="user.email"></td>
              <td v-html="user.address"></td>
              <td v-html="user.interest_area"></td>
              <td v-html="user.marriage_type"></td>
              <td>
                <template>
                  <v-btn name="삭제" @click="deleteArticle(user.no)">
                    삭제
                  </v-btn>
                </template>
              </td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </div>
  </v-card>
</template>

<script>
import http from '../http-common';
export default {
  name: 'SelectMember',
  data() {
    return {
      search: '',
      headers: [
        {
          text: 'ID(user)',
          align: 'start',
          sortable: false,
          value: 'userid',
        },
      ],
      upHere: false,
      userinfo: [],
      loading: true,
      errored: false,
    };
  },
  methods: {
    retrieveArticle() {
      http
        .get('/user/selectMember')
        .then((response) => (this.userinfo = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    searchMember(name) {
      http
        .get('/user/searchMember/' + name)

        .then((response) => (this.userinfo = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
      this.submitted = true;
    },
    deleteArticle(did) {
      // alert(this.userinfo.username + '가 삭제합니다.');
      http
        .delete('/user/deleteMember/' + did)
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
};
</script>
