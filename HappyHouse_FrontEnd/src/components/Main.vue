<template>
  <v-container fluid style="width:100%">
    <!-- 홈 -->
    <v-carousel v-model="model" cycle height="600px">
      <v-carousel-item v-for="img in imgs" :key="img">
        <v-sheet color="#e0eeee" height="600px" tile>
          <img :src="img" style="height:600px; width:100%" />
          <v-container fill-height fluid pa-0 ma-0 pb-3>
            <v-layout fill-height align-end pb-4 mb-4>
              <v-flex xs12>
                <v-card color="black" class="pa-2">
                  <span class="headline white--text">Happy House </span>
                </v-card>
              </v-flex>
            </v-layout>
          </v-container>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
    <br /><br />
    <br />
    <v-row>
      <!-- 관심 매물 카드 -->
      <v-col cols="4">
        <v-card class="mx-auto" max-width="100%">
          <v-toolbar color="black" dark>
            <v-app-bar-nav-icon></v-app-bar-nav-icon>

            <v-toolbar-title>관심 매물</v-toolbar-title>

            <v-spacer></v-spacer>

            <v-btn icon>
              <v-icon>mdi-magnify</v-icon>
            </v-btn>
          </v-toolbar>

          <v-container fluid>
            <v-row dense>
              <v-col v-for="card in cards" :key="card.title" :cols="card.flex">
                <v-card>
                  <v-img
                    :src="card.src"
                    class="white--text align-end"
                    gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                    height="200px"
                  >
                    <v-card-title v-text="card.title"></v-card-title>
                  </v-img>

                  <v-card-actions>
                    <v-spacer></v-spacer>

                    <v-btn icon>
                      <v-icon>mdi-heart</v-icon>
                    </v-btn>

                    <v-btn icon>
                      <v-icon>mdi-bookmark</v-icon>
                    </v-btn>

                    <v-btn icon>
                      <v-icon>mdi-share-variant</v-icon>
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
        </v-card>
      </v-col>
      <!-- 공지사항, 뉴스, 아파트정보 카드 -->
      <v-col cols="8">
        <div class="around">
          <v-card class="mx-auto" max-width="100%">
            <v-tabs v-model="tab" grow color="white" dark height="65px">
              <v-tab v-for="item in items" :key="item">
                <p style="font-size:20px;">{{ item }}</p>
              </v-tab>
            </v-tabs>
            <v-tabs-items v-model="tab">
              <v-tab-item v-for="item in items" :key="item">
                <v-card flat>
                  <v-card-text v-if="tab == 0">
                    <div>
                      <v-simple-table class="table">
                        <template v-slot:default>
                          <thead>
                            <tr>
                              <th class="text-left" id="no">글번호</th>
                              <th class="text-left" id="writer">글쓴이</th>
                              <th class="text-left" id="title">제목</th>
                              <th class="text-left" id="comment_count">
                                조회수
                              </th>
                              <th class="text-left" id="regtime">등록일</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr v-for="article in articles" :key="article.no">
                              <td v-html="article.no"></td>
                              <td v-html="article.writer"></td>
                              <td v-html="article.title"></td>
                              <td v-html="article.comment_count"></td>
                              <td v-html="article.regtime"></td>
                            </tr>
                          </tbody>
                        </template>
                      </v-simple-table>
                    </div>
                  </v-card-text>
                  <!-- 뉴스 카드 -->
                  <v-card-text v-else-if="tab == 1">
                    <div class="spot_headline">
                      <div class="section_news">
                        <div class="bg_news">
                          <div class="news_area NE=a:hla">
                            <h3 class="tit_h3 h_today">
                              <h1><span tabindex="0">TODAY NEWS</span></h1>
                            </h3>
                            <div class="group ">
                              <v-row dense>
                                <v-col cols="12">
                                  <v-card color="white">
                                    <v-card-title class="headline">
                                      <a
                                        href="https://land.naver.com/news/newsRead.nhn?type=headline&amp;bss_ymd=&amp;prsco_id=629&amp;arti_id=0000054247"
                                        class="NPI=a:title1,i:629_0000054247"
                                        >‘서울 집값 기본 10억 원 시대‘…종...</a
                                      >
                                    </v-card-title>
                                    <v-card-subtitle>
                                      올해 종부세 3조3210억 원…내년에는 5조 원
                                      돌파 전망[더팩트｜윤정원 기자] 국세청이
                                      올해 종합부동산세를 고지하자 서울을
                                      중심으로 세금 폭탄을 맞는 납세자들이
                                      속...<span class="writing">더팩트</span>
                                    </v-card-subtitle>
                                    <span class="date">2020.11.25</span>
                                  </v-card></v-col
                                >
                              </v-row>
                              <v-row dense>
                                <v-col cols="12">
                                  <v-card color="black" dark>
                                    <v-card-title class="headline">
                                      <a
                                        href="https://land.naver.com/news/newsRead.nhn?type=headline&amp;bss_ymd=&amp;prsco_id=003&amp;arti_id=0010206008"
                                        class="NP=r:1,i:003_0010206008"
                                        >[Q&amp;A]"배우자 공동 소유시 종부세
                                        6억씩 ...</a
                                      ></v-card-title
                                    >
                                    <v-card-subtitle>뉴시스</v-card-subtitle>
                                    <span class="date">2020.11.25</span>
                                  </v-card>
                                </v-col></v-row
                              >
                            </div>
                            <div class="group line">
                              <v-row dense>
                                <v-col cols="12">
                                  <v-card color="white">
                                    <v-card-title class="headline">
                                      <a
                                        href="https://land.naver.com/news/newsRead.nhn?type=headline&amp;bss_ymd=&amp;prsco_id=421&amp;arti_id=0005010840"
                                        class="NPI=a:title2,i:421_0005010840"
                                        >임대차3법에 대비하나…‘분쟁조정위...</a
                                      ></v-card-title
                                    >
                                    <v-card-subtitle>
                                      국토교통부가 임대차3법의 후속조치로
                                      임대차분쟁조정위원회를 2021년까지 18개로
                                      늘린다. 내년 상반기까지 6개소를 추가
                                      개소해 전국적으로 촘촘한 분쟁조정망을
                                      구축하고 임대차3법의 개정으로 생기는
                                      분쟁을 적극적으로 관리하겠다는 계획이...
                                    </v-card-subtitle>
                                    <span class="writing">뉴스1</span>
                                    <span class="date">2020.11.25</span>
                                  </v-card></v-col
                                ></v-row
                              >
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </v-card-text>
                  <v-card-text v-else-if="tab == 2">{{ user }}</v-card-text>
                </v-card>
              </v-tab-item>
            </v-tabs-items>
          </v-card>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import http from '../http-common';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: 'Main',
  data: () => ({
    user: '',
    model: 0,
    imgs: [
      require('../assets/home1.jpg'),
      require('../assets/home2.jpg'),
      require('../assets/home3.jpg'),
    ],
    tab: null,
    items: ['공지사항', '뉴스', '아파트정보'],
    articles: [],
    cards: [
      {
        title: '관심 지역',
        src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg',
        flex: 12,
      },
      {
        title: '관심 매물',
        src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg',
        flex: 6,
      },
      {
        title: 'Favorite Area',
        src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg',
        flex: 6,
      },
    ],
  }),
  created() {
    this.retrieveArticle();
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
  components: {},
  methods: {
    retrieveArticle() {
      http
        .get('/noticeboard/select')
        .then((response) => (this.articles = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
  },
};
</script>
