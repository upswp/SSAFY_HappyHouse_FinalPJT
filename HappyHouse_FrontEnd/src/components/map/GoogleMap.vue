<!-- 설치 
npm install vuetify-dialog
npm i vue2-google-maps
=>main.js-->
<template>
  <!-- vuetify 이용한 구글 맵-->
  <GmapMap
    :center="{ lat: 10, lng: 10 }"
    :zoom="7"
    map-type-id="terrain"
    style="width: 500px; height: 300px"
  >
    <GmapMarker
      :key="index"
      v-for="(m, index) in markers"
      :position="m.position"
      :clickable="true"
      :draggable="true"
      @click="clickMarker"
    />
  </GmapMap>
</template>

<script>
export default {
  name: 'GoogleMap',
  clickMarker: function() {
    // ----------MAP------------
    this.$dialog.confirm({
      text:
        "What's your name? <img src='https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Natgeologo.svg/1200px-Natgeologo.svg.png' height=100/><input value='input'></input>",
      title: 'Warning',
    });
  },
};
</script>
