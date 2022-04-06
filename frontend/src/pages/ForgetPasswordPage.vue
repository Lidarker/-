<template>
  <div style="margin-right: 10px; margin-left: 10px">
    <CommonTop pos="忘记密码" />
    <el-card class="box-card" style="margin-left: 30%; margin-right: 30%">
       <el-form ref="form" :model="form" :rules="rules">
        <el-form-item prop="phone">
          <el-input
            v-model="form.phone"
            placeholder="手机号"
            prefix-icon="el-icon-phone"
          ></el-input>
        </el-form-item>
        <el-form-item prop="account">
          <el-input
            v-model="form.account"
            placeholder="账户"
            prefix-icon="el-icon-user-solid"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            show-password
            v-model="form.password"
            placeholder="密码"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item prop="repeatPassword">
          <el-input
            show-password
            v-model="form.repeatPassword"
            placeholder="密码确认"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item style="text-align: center">
          <el-button type="primary" @click="onSubmit" style="width: 100%">
            修改
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import CommonTop from "../components/CommonTop";

export default {
  data() {
    return {
      form: {
        phone: "",
        account: "",
        password: "",
        repeatPassword: "",
      },
    };
  },
  methods: {
    onSubmit() {
      console.log(this.form);
    },
  },
  components: {
    CommonTop,
  },
};
</script>

<style>
</style>