<template>
  <div style="margin-right: 10px; margin-left: 10px">
    <CommonTop pos="注册" />
    <el-card class="box-card" style="margin-left: 30%; margin-right: 30%">
      <el-form ref="form" :model="form">
        <el-form-item>
          <el-input
            v-model="form.email"
            placeholder="邮箱"
            prefix-icon="aliiconfont al-iconyouxiang"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            v-model="form.userName"
            placeholder="账户"
            prefix-icon="el-icon-user-solid"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            show-password
            v-model="form.password"
            placeholder="密码"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            show-password
            v-model="form.repeatPassword"
            placeholder="密码确认"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item style="text-align: center">
          <el-button type="primary" @click="onSubmit" style="width: 100%">
            注册
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import CommonTop from "./CommonTop";

export default {
  data() {
    return {
      form: {
        email: "",
        userName: "",
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