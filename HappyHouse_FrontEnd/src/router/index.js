import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import Apt from '@/views/Apt.vue';
import SelectBoard from '@/views/Board.vue';
import Login from '@/views/Login.vue';
import Notice from '@/views/Notice.vue';
import Me from '@/views/Me.vue';
import MemberMgt from '@/views/MemberMgt.vue';

import JoinMember from '@/components/Member/JoinMember.vue';
import UpdateMember from '@/components/Member/UpdateMember.vue';
import store from '@/store';
import InsertBoard from '@/components/QnA/InsertBoard.vue';
import SelectBoardByNo from '@/components/QnA/SelectBoardByNo.vue';
import UpdateBoard from '@/components/QnA/UpdateBoard.vue';
import InsertNotice from '@/components/Notice/InsertNotice.vue';
import SelectNoticeByNo from '@/components/Notice/SelectNoticeByNo.vue';
import UpdateNotice from '@/components/Notice/UpdateNotice.vue';

Vue.use(VueRouter);
// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const requireAuth = () => (to, from, next) => {
  const nextRoute = to.path;

  if (store.getters.getAccessToken) {
    return next();
  } else next('/login' + nextRoute);
};
const routes = [
  // Home
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  // 아파트 정보 페이지 이동
  {
    path: '/apt',
    name: 'Apt',
    component: Apt,
  },
  // 로그인 페이지
  {
    path: '/login',
    name: 'Login',
    component: Login,
    //로그인 시 로그인페이지에서 home 화면으로 이동
    beforeEnter(to, from, next) {
      if (store.getters.getAccessToken) {
        next({ name: 'Home' });
      } else {
        next();
      }
    },
  },
  // 로그인 이후
  {
    path: '/login/:nextRoute',
    name: 'LoginNextRoute',
    component: Login,
  },

  // 관리자페이지
  {
    path: '/memberMgt',
    name: 'MemberMgt',
    component: MemberMgt,
  },
  // 공지사항 리스트 조회
  {
    path: '/notice',
    name: 'Notice',
    component: Notice,
  },
  // 공지사항 글 등록
  {
    path: '/insertNotice',
    name: 'InsertNotice',
    component: InsertNotice,
  },
  // 공지사항 상세보기
  {
    path: '/detailNotice/:no',
    name: 'SelectNoticeByNo',
    component: SelectNoticeByNo,
    props: true,
  },
  // 공지사항 수정
  {
    path: '/updateNotice/:no',
    name: 'UpdateNotice',
    component: UpdateNotice,
    props: true,
  },
  // 회원 마이페이지 이동
  {
    path: '/me',
    name: 'Me',
    component: Me,
    beforeEnter: requireAuth(),
  },
  // 회원 등록
  {
    path: '/joinMember/',
    name: 'JoinMember',
    component: JoinMember,
  },
  // 마이페이지 수정
  {
    path: '/updateMember/:no',
    name: 'UpdateMember',
    component: UpdateMember,
    props: true,
  },
  // QnA 글 리스트 조회
  {
    path: '/qnaboard',
    name: 'SelectBoard',
    component: SelectBoard,
  },
  // QnA 글 등록
  {
    path: '/insert',
    name: 'InsertBoard',
    component: InsertBoard,
  },
  // QnA 글번호에 따른 상세보기
  {
    path: '/detail/:no',
    name: 'SelectBoardByNo',
    component: SelectBoardByNo,
    props: true,
  },
  // QnA업데이트
  {
    path: '/update/:no',
    name: 'UpdateBoard',
    component: UpdateBoard,
    props: true,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
