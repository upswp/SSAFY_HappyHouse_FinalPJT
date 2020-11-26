<template>
  <!-- 주변 환경 정보 Vue -->
  <div>
    <div v-if="envs.length == 0">
      <h2>
        해당 지역의 환경정보 데이터가 없습니다.
      </h2>
    </div>
    <v-data-table
      v-else
      :headers="headers"
      :items="envs"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </div>
</template>

<script>
export default {
  name: 'EnvInfo',
  props: ['sido', 'gugun', 'dong', 'envs'],
  data() {
    return {
      sidoname: '',
      headers: [
        {
          text: '업체명',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: '업종명', value: 'sname' },
        { text: '점검사항', value: 'chkspec' },
        { text: '주소', value: 'locaddr' },
      ],
    };
  },
};
</script>

<style></style>
