<template>
  <div style="margin-right: 10px; margin-left: 10px">
    <PageHeader />
    <el-link
      href="https://element.eleme.io"
      target="_blank"
      style="font-size: 30px; display: block"
    >
      长租公寓平台
    </el-link>
    <div style="font-size: 14px">
      <el-link type="primary" icon="el-icon-house">主页</el-link>
      <span>/登录</span>
    </div>
    <el-card class="box-card" style="margin-left: 30%; margin-right: 30%">
      <el-form ref="form" :model="form">
        <el-form-item>
          <el-input
            v-model="form.userName"
            placeholder="账户"
            prefix-icon="el-icon-user-solid"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            v-model="form.password"
            placeholder="密码"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-link style="float: left" href="#">忘记密码</el-link>
          <el-link style="float: right">管理员登录</el-link>
        </el-form-item>
        <el-form-item style="text-align: center">
          <el-button type="primary" @click="onSubmit" style="width: 100%">
            登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import PageHeader from "./PageHeader.vue";

export default {
  data() {
    return {
      form: {
        userName: "",
        password: "",
      },
    };
  },
  methods: {
    onSubmit() {
      console.log(this.form);
    },
  },
  components: {
    PageHeader,
  },
};
</script>

<style>
</style>