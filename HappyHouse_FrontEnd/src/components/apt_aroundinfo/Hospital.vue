<template>
  <!--코로나19 안심병원 Vue-->
  <div>
    <div v-if="hospitals.length == 0">
      <h2>
        해당 지역의 코로나19 안심병원 정보 데이터가 없습니다.
      </h2>
    </div>
    <v-data-table
      v-else
      :headers="headers"
      :items="hospitals"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </div>
</template>

<script>
export default {
  name: 'Hospital',
  props: ['hospitals'],
  data() {
    return {
      headers: [
        {
          text: '병원이름',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: '주소', value: 'address' },
        { text: '전화번호', value: 'tel' },
      ],
    };
  },
};
</script>

<style></style>
