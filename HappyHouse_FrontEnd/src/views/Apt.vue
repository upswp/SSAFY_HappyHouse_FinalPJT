<template>
  <div>
    <v-container>
      <v-row>
        <v-col>
          <h2>아파트 매매 정보</h2>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-btn @click="searchDong">동별 검색</v-btn>
        </v-col>
        <v-col>
          <v-btn @click="searchApt">아파트별 검색</v-btn>
        </v-col>
      </v-row>

      <!-- 시,군구,동 별 검색 -->
      <v-row>
        <v-col class="d-flex" cols="4" sm="4">
          <v-select
            label="시"
            v-bind:items="sidos"
            v-model="selectSido"
            item-text="sidoName"
            item-value="sidoCode"
            max-height="auto"
            autocomplete
            v-on:change="selectedSido"
          >
            <template slot="selection" slot-scope="data">
              {{ data.item.sidoName }}
            </template>
          </v-select>
        </v-col>
        <v-col class="d-flex" cols="4" sm="4">
          <v-select
            label="구/군"
            v-bind:items="guguns"
            v-model="selectGugun"
            item-text="gugunName"
            item-value="gugunCode"
            max-height="auto"
            autocomplete
            v-on:change="selectedGugun"
          >
            <template slot="selection" slot-scope="data">
              {{ data.item.gugunName }}
            </template>
          </v-select>
        </v-col>
        <v-col v-if="isSearchDong == 0" class="d-flex" cols="4" sm="4">
          <v-select
            label="동"
            v-bind:items="dongs"
            v-model="selectDong"
            item-text="dongName"
            item-value="dongName"
            max-height="auto"
            autocomplete
            v-on:change="selectedDong"
          >
            <template slot="selection" slot-scope="data">
              {{ data.item.dongName }}
            </template>
          </v-select>
        </v-col>
        <v-col v-else-if="isSearchDong == 1">
          <search-bar @apt-name="sendAptName" />
        </v-col>
      </v-row>
      <!-- MAP and Apt List-->
      <v-row>
        <h3>총 {{ aptsBydong.length }} 개의 결과물이 있습니다.</h3>
      </v-row>
      <v-row>
        <v-col cols="12"
          ><KakaoMap
            :si="sidoName"
            :gugun="gugunName"
            :dong="selectDong"
            :aptlist="aptsBydong"
        /></v-col>
      </v-row>

      <!-- apt 상세정보 -->
      <v-row>
        <v-col cols="12">
          <div id="aptdetail">
            <div hidden style="height:40px;"></div>
            <v-row style="margin-top:40px;">
              <v-col cols="6" align="left">
                <apt-list
                  :aptlist="aptsBydong"
                  @select-apt="selectedApt"
                  @select-img="selectedImage"
                  :dongCode="selectDong"
                />
              </v-col>
              <v-col cols="6">
                <h2>아파트 상세정보</h2>
                <apt-detail :apt="selectApt" :img="selectImage" />
              </v-col>
            </v-row>
          </div>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" align="center">
          <apt-around-info
            :sido="selectSido"
            :sidoname="sidoName"
            :gugun="selectGugun"
            :gugunname="gugunName"
            :dong="selectDong"
            :envs="envs"
          />
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import SearchBar from '@/components/SearchBar.vue';
import AptList from '@/components/AptList.vue';
import AptDetail from '@/components/AptDetail.vue';
import KakaoMap from '@/components/map/KakaoMap.vue';
import AptAroundInfo from '@/components/AptAroundInfo.vue';
import http from '../http-common';

// vue cli enviroment variables 검색
// 반드시 VUE_APP으로 시작해야 한다.
const API_KEY = process.env.VUE_APP_APT_DEAL_API_KEY; //env 파일이름으로
const API_URL =
  'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev';

export default {
  name: 'Apt',
  components: {
    SearchBar,
    AptList,
    AptDetail,
    KakaoMap,
    AptAroundInfo,
  },
  data() {
    return {
      dongCode: '',
      selectApt: '', // AptList에서 선택된 아파트
      selectImage: '', // AptList에서 선택된 아파트 이미지
      apts: [], // selectGugun에 해당하는 아파트 배열
      aptsBydong: [], // 동별 검색 후 가져온 아파트들
      selectSido: '', // 시도 코드
      selectGugun: '', // 구군 코드
      selectDong: '', // 동 이름
      sidos: [],
      guguns: [],
      dongs: [],
      sidoName: '', // 시도 이름
      gugunName: '', // 구군 이름
      dongName: '',
      envs: [],
      isSearchDong: 0, // 동(0)으로 검색할것인가 아파트(1)로 검색할것인가
    };
  },
  mounted() {
    http
      .get('/map/sido')
      .then((response) => (this.sidos = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
  methods: {
    sendAptName(aptname) {
      this.aptsBydong = [];
      const params = {
        LAWD_CD: this.selectGugun,
        DEAL_YMD: '201912',
        serviceKey: decodeURIComponent(API_KEY),
      };
      http
        .get(API_URL, {
          params,
        })
        .then((response) => {
          console.log(response.data);
          this.apts = response.data.response.body.items.item;
          // 아파트 동이름으로 가져오기
          this.apts.forEach((element) => {
            if (element.아파트.includes(aptname)) {
              console.log(element.아파트);
              this.aptsBydong.push(element);
            }
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    sendDongCode(dongCode) {
      this.aptsBydong = [];
      this.dongCode = dongCode;

      const params = {
        LAWD_CD: this.dongCode,
        DEAL_YMD: '201912',
        serviceKey: decodeURIComponent(API_KEY),
      };
      http
        .get(API_URL, {
          //params:params
          params,
        })
        .then((response) => {
          this.apts = response.data.response.body.items.item;

          // 아파트 동이름으로 가져오기
          this.apts.forEach((element) => {
            if (element.법정동 == ' ' + this.selectDong) {
              console.log(element.법정동);
              this.aptsBydong.push(element);
            }
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    selectedApt: function(apt) {
      this.selectApt = apt;
    },
    selectedImage: function(img) {
      this.selectImage = img;
    },
    selectedSido: function() {
      http
        .get('/map/sido/' + this.selectSido)
        .then((response) => (this.guguns = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    selectedGugun: function() {
      http
        .get('/map/sido/gugun/' + this.selectGugun)
        .then((response) => (this.dongs = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => {
          this.loading = false;
        });
    },
    selectedDong: function() {
      console.log('동 고름');
      // 동까지 골라지면
      this.sendDongCode(this.selectGugun);
      http // 시코드로 시이름 구하고
        .get('/map/getSiName/' + this.selectSido)
        .then((response) => (this.sidoName = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => {
          this.loading = false;
        });
      http // 구군코드로 구군이름 얻어오고
        .get('/map/getGugunName/' + this.selectGugun)
        .then((response) => (this.gugunName = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => {
          console.log(this.gugunName);
          console.log(this.selectDong);
          http // 해당 동의 환경정보 가져옴
            .get(
              '/aptaround/env/' +
                this.sidoName +
                ' ' +
                this.gugunName +
                '/' +
                this.selectDong
            )
            .then((response) => (this.envs = response.data))
            .catch(() => {
              this.errored = true;
            })
            .finally(() => (this.loading = false));
        });
    },
    searchDong() {
      this.isSearchDong = 0;
    },
    searchApt() {
      this.isSearchDong = 1;
    },
  },
};
</script>

<style>
#aptdetail {
  align-content: center;
  height: 600px;
  width: 100%;
  border: 1px solid black;
}
</style>
