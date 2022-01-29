<template>
  <div style="margin-right: 10px; margin-left: 10px">
    <CommonTop pos="登录" />
    <el-card class="box-card" style="margin-left: 30%; margin-right: 30%">
      <el-form ref="form" :model="userForm">
        <el-form-item>
          <el-input
            v-model="userForm.userName"
            placeholder="账户"
            prefix-icon="el-icon-user-solid"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            show-password
            v-model="userForm.password"
            placeholder="密码"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-link style="float: left" href="#">忘记密码</el-link>
          <el-link style="float: right" @click="administratorVisible = true">
            管理员登录
          </el-link>
        </el-form-item>
        <el-form-item style="text-align: center">
          <el-button
            type="primary"
            @click="onUserLoginSubmit"
            style="width: 100%"
          >
            登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <el-dialog
      title="管理员登录"
      :visible.sync="administratorVisible"
      width="30%"
    >
      <el-form ref="form" :model="administratorForm">
        <el-form-item>
          <el-input
            v-model="administratorForm.userName"
            placeholder="账户"
            prefix-icon="el-icon-user-solid"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            show-password
            v-model="administratorForm.password"
            placeholder="密码"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button
          type="primary"
          @click="onAdministratorLoginSubmit"
          style="width: 100%"
        >
          登录
        </el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import CommonTop from "./CommonTop";

export default {
  data() {
    return {
      administratorVisible: false,
      userForm: {
        userName: "",
        password: "",
      },
      administratorForm: {
        userName: "",
        password: "",
      },
    };
  },
  methods: {
    onUserLoginSubmit() {
      console.log(this.userForm);
    },
    onAdministratorLoginSubmit() {
      console.log(this.administratorForm);
    },
  },
  components: {
    CommonTop,
  },
};
</script>

<style>
</style>