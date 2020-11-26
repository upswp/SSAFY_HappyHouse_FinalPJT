<template>
  <v-footer dark padless default>
    <v-card flat tile class="gray lighten white--text text-center">
      <v-card-text>
        <v-btn v-for="icon in icons" :key="icon" class="mx-4 white--text" icon>
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text class="white--text pt-0">
        <div>
          <a href="">이용약관</a> <a href="">매물신고운영</a>
          <a href="">개인정보처리방침</a> <a href="">부동산 고객센터</a>
          <br />
          <b>상우현정</b> 해피하우스에서 제공하는 부동산 정보는 각 콘텐츠
          제공업체로부터 받는 정보로 참고용입니다. <br />정보의 정확성이나
          신뢰성을 보증하지 않으며, 서비스 이용의 결과에 대해서 어떠한 법적인
          책임을 지지 않습니다. 게시된 정보는 무단으로 배포할 수 없습니다.
        </div>
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>Happy House</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: ['mdi-facebook', 'mdi-twitter', 'mdi-linkedin', 'mdi-instagram'],
  }),
};
</script>

<style scoped>
v-footer {
  width: 100%;
}
v-card {
  width: 100%;
}
v-card-text {
  width: 100%;
  text-align: center;
}
div {
  width: 100%;
}
</style>
