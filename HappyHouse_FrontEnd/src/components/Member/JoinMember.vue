<template>
  <div id="wrapper">
    <!-- content-->
    <div id="content">
      <!-- ID -->
      <div>
        <h3 class="join_title">
          <label for="id">아이디</label>
        </h3>
        <span class="box int_id">
          <input
            type="text"
            id="pswd1"
            class="int"
            maxlength="20"
            v-model="userid"
          />
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- PW1 -->
      <div>
        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
        <span class="box int_pass">
          <input
            type="password"
            id="pswd1"
            class="int"
            maxlength="20"
            v-model="userpwd"
          />
          <span id="alertTxt">사용불가</span>
          <img
            src="@/assets/join/m_icon_pass.png"
            id="pswd1_img1"
            class="pswdImg"
          />
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- PW2 -->
      <div>
        <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
        <span class="box int_pass_check">
          <input
            type="password"
            id="pswd2"
            class="int"
            maxlength="20"
            v-model="checkpwd"
          />
          <img
            src="@/assets/join/m_icon_check_disable.png"
            id="pswd2_img1"
            class="pswdImg"
          />
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- NAME -->
      <div>
        <h3 class="join_title"><label for="name">이름</label></h3>
        <span class="box int_name">
          <input
            type="text"
            id="pswd1"
            class="int"
            maxlength="20"
            v-model="username"
          />
        </span>
        <span class="error_next_box"></span>
      </div>

      <!-- BIRTH -->
      <div>
        <h3 class="join_title"><label for="yy">생년월일</label></h3>

        <div id="bir_wrap">
          <!-- BIRTH_YY -->
          <div id="bir_yy">
            <span class="box">
              <input
                type="text"
                id="yy"
                class="int"
                maxlength="4"
                placeholder="년(4자)"
                v-model="yy"
              />
            </span>
          </div>

          <!-- BIRTH_MM -->
          <div id="bir_mm">
            <span class="box">
              <input
                type="text"
                id="mm"
                class="int"
                maxlength="2"
                placeholder="일"
                v-model="mm"
              />
            </span>
          </div>

          <!-- BIRTH_DD -->
          <div id="bir_dd">
            <span class="box">
              <input
                type="text"
                id="dd"
                class="int"
                maxlength="2"
                placeholder="일"
                v-model="dd"
              />
            </span>
          </div>
        </div>
        <span class="error_next_box"></span>
      </div>
      <!-- 관심지역 -->
      <div>
        <h3 class="join_title">
          <label for="email">이메일</label>
        </h3>
        <span class="box int_email">
          <input
            type="email"
            class="int"
            maxlength="100"
            placeholder="필수입력"
            v-model="email"
          />
        </span>
        <span class="error_next_box">관심지역 다시 확인해주세요.</span>
      </div>
      <!-- marriage -->
      <div>
        <h3 class="join_title"><label for="gender">결혼여부</label></h3>
        <span class="box gender_code">
          <input
            type="text"
            class="int"
            maxlength="100"
            placeholder="미혼/기혼"
            v-model="marriage_type"
          />
        </span>
        <span class="error_next_box">필수 정보입니다.</span>
      </div>

      <!-- 주소 -->
      <div>
        <h3 class="join_title">
          <label for="email">주소</label>
        </h3>
        <span class="box int_email">
          <input
            type="text"
            class="int"
            maxlength="100"
            placeholder="필수입력"
            v-model="address"
          />
        </span>
        <span class="error_next_box">주소를 다시 확인해주세요.</span>
      </div>

      <!-- 관심지역 -->
      <div>
        <h3 class="join_title">
          <label for="email">관심지역</label>
        </h3>
        <span class="box int_email">
          <input
            type="text"
            class="int"
            maxlength="100"
            placeholder="필수입력"
            v-model="interest_area"
          />
        </span>
        <span class="error_next_box">관심지역 다시 확인해주세요.</span>
      </div>

      <!-- JOIN BTN-->
      <div class="btn_area">
        <v-btn type="button" id="btnJoin" @click="updateBoard">
          <span>가입하기</span>
        </v-btn>
      </div>
    </div>
    <!-- content-->
  </div>
</template>

<script>
import http from '../../http-common';

export default {
  data() {
    return {
      info: null,
      checkpwd: '',
      userid: null,
      username: null,
      userpwd: null,
      email: null,
      address: null,
      yy: null,
      mm: null,
      dd: null,
      interest_area: null,
      marriage_type: null,
    };
  },

  methods: {
    updateBoard() {
      if (this.userpwd != this.checkpwd) {
        alert('비밀번호를 다시 확인해주세요.');
        return;
      }
      if (this.userid == '') {
        alert('아이디를 작성하세요.');
        return;
      }
      if (this.username == '') {
        alert('이름을 작성하세요.');
        return;
      }
      if (this.email == '') {
        alert('email을 작성하세요.');
        return;
      }
      if (this.address == '') {
        alert('주소를 작성하세요.');
        return;
      }

      if (this.yy == '') {
        alert('생년월일을 작성하세요.');
        return;
      }

      if (this.mm == '') {
        alert('생년월일을 작성하세요.');
        return;
      }

      if (this.dd == '') {
        alert('생년월일을 작성하세요.');
        return;
      }

      if (this.interest_area == '') {
        alert('관심 지역을 작성하세요.');
        return;
      }
      if (this.marriage_type == '') {
        alert('결혼 여부을 작성하세요.');
        return;
      } else {
        this.$router.push('/');
      }

      http
        .post('/user/joinMember', {
          userid: this.userid,
          username: this.username,
          userpwd: this.userpwd,
          email: this.email,
          address: this.address,
          yy: this.yy,
          mm: this.mm,
          dd: this.dd,
          interest_area: this.interest_area,
          marriage_type: this.marriage_type,
        })
        .then((response) => {
          if (response.data == 'success') {
            alert('회원가입이 완료하였습니다.');
          } else {
            alert('회원가입이 실패하였습니다.');
          }
        });
      this.submitted = true;
    },
    newCustomer() {
      (this.submitted = false),
        (this.userid = null),
        (this.userpwd = null),
        (this.username = null),
        (this.contemailent = null),
        (this.address = null),
        (this.yy = null),
        (this.mm = null),
        (this.dd = null),
        (this.interest_area = null),
        (this.marriage_type = null);
    },
  },
};
</script>

<style>
/* 레이아웃 틀 */
html {
  height: 100%;
}

body {
  margin: 0;
  height: 100%;
  font-family: Dotum, '돋움', Helvetica, sans-serif;
}
#logo {
  width: 240px;
  height: 44px;
  cursor: pointer;
}

#header {
  padding-top: 62px;
  padding-bottom: 20px;
  text-align: center;
}
#wrapper {
  position: relative;
  height: 100%;
}

#content {
  position: absolute;
  left: 50%;
  transform: translate(-50%);
  width: 460px;
}

/* 입력폼 */

input:focus {
  outline: none;
}

h3 {
  margin: 19px 0 8px;
  font-size: 14px;
  font-weight: 700;
}

.box {
  display: block;
  width: 100%;
  height: 51px;
  border: solid 1px #dadada;
  padding: 10px 14px 10px 14px;
  box-sizing: border-box;
  background: #fff;
  position: relative;
}

.int {
  display: block;
  position: relative;
  width: 100%;
  height: 29px;
  border: none;
  background: #fff;
  font-size: 15px;
}

input {
  font-family: Dotum, '돋움', Helvetica, sans-serif;
}

.box.int_id {
  padding-right: 110px;
}

.box.int_pass {
  padding-right: 40px;
}

.box.int_pass_check {
  padding-right: 40px;
}

.step_url {
  /*@naver.com*/
  position: absolute;
  top: 16px;
  right: 13px;
  font-size: 15px;
  color: #8e8e8e;
}

.pswdImg {
  width: 18px;
  height: 20px;
  display: inline-block;
  position: absolute;
  top: 50%;
  right: 16px;
  margin-top: -10px;
  cursor: pointer;
}

#bir_wrap {
  display: table;
  width: 100%;
}

#bir_yy {
  display: table-cell;
  width: 147px;
}

#bir_mm {
  display: table-cell;
  width: 147px;
  vertical-align: middle;
}

#bir_dd {
  display: table-cell;
  width: 147px;
}

#bir_mm,
#bir_dd {
  padding-left: 10px;
}

select {
  width: 100%;
  height: 29px;
  font-size: 15px;
  background: #fff
    url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50%
    no-repeat;
  background-size: 20px 8px;
  -webkit-appearance: none;
  display: inline-block;
  text-align: start;
  border: none;
  cursor: default;
  font-family: Dotum, '돋움', Helvetica, sans-serif;
}

/* 에러메세지 */

.error_next_box {
  margin-top: 9px;
  font-size: 12px;
  color: red;
  display: none;
}

#alertTxt {
  position: absolute;
  top: 19px;
  right: 38px;
  font-size: 12px;
  color: red;
  display: none;
}

/* 버튼 */

.btn_area {
  margin: 30px 0 91px;
}

#btnJoin {
  width: 100%;
  padding: 21px 0 17px;
  border: 0;
  cursor: pointer;
  color: #fff;
  background-color: #434d46;
  font-size: 20px;
  font-weight: 400;
  font-family: Dotum, '돋움', Helvetica, sans-serif;
}

#id {
  text-align: center;
  padding-left: 100px;
}
#id2 {
  text-align: center;
}
</style>
