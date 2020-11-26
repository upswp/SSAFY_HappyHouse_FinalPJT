<template>
  <!-- 아파트 상세정보 Vue -->
  <div v-if="apt" class="detail-list" style="width:500px;">
    <v-card color="white">
      <v-card-title text-align="center" class="white darken-4">
        <h3>{{ apt.아파트 }}</h3>
      </v-card-title>
      <br /><br />
      <img :src="img" alt="행복 아파트" style="width:100%;" />
      <div style="margin: 10px"></div>
      <v-card-text>
        <ul align="left">
          <li variant="info">일련번호 : {{ apt.일련번호 }}</li>
          <li variant="light">아파트 이름 : {{ apt.아파트 }}</li>
          <li variant="dark">법정동 : {{ apt.법정동 }}</li>
          <li variant="info">층수 : {{ apt.층 }}</li>
          <li variant="light">
            거래금액 : {{ (apt.거래금액.replace(',', '') * 10000) | price }}원
          </li>
        </ul>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  name: 'AptDetail',
  props: {
    apt: [Object, String], //apt를 Object로 받음
    img: String,
  },
  filters: {
    price: function(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    },
  },
};
</script>

<style scoped>
.detail-list {
  width: 480px;
}
img {
  height: 200px;
  width: 300px;
}
</style>
