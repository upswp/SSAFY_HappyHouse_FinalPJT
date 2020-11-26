<template>
  <!--코로나19 선별 진료소 Vue-->
  <div>
    <div v-if="clinics.length == 0">
      <h2>
        해당 지역의 코로나19 선별진료소 정보 데이터가 없습니다.
      </h2>
    </div>
    <v-data-table
      v-else
      :headers="headers"
      :items="clinics"
      :items-per-page="5"
      class="elevation-1"
    ></v-data-table>
  </div>
</template>

<script>
export default {
  name: 'CoronaClinic',
  props: ['clinics'],
  data() {
    return {
      headers: [
        {
          text: '병원이름',
          align: 'start',
          sortable: false,
          value: 'hospitalName',
        },
        { text: '주소', value: 'address' },
        { text: '평일 진료시간', value: 'weekDayOp' },
        { text: '토요일 진료시간', value: 'satOp' },
        { text: '공휴일 진료시간', value: 'sunOp' },
        { text: '전화번호', value: 'tel' },
      ],
    };
  },
};
</script>

<style></style>
