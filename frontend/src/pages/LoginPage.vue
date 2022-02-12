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
          <el-link style="float: left" @click="routerPush('/forget-password')"
            >忘记密码</el-link
          >
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
import CommonTop from "../components/CommonTop";
import axios from "axios";

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
      // console.log(this.userForm);
      axios.get("http://localhost:8081/login",{
        params:{
          userName:this.userForm.userName,
          password:this.userForm.password
        }
      }).then(
        (response) => {
          console.log(response.data);
          // localStorage.setItem("access_token", "123");
          // this.$store.commit("UPDATE_TOKEN")
          if(response.data){
            this.routerPush('/')
          }else{
            window.alert('账号或密码错误')
          }
        },
        (error) => {
          console.log(error.message);
        }
      );
    },
    onAdministratorLoginSubmit() {
      // console.log(this.administratorForm);
      axios.get("http://localhost:8081/AdminLogin",{
        params:{
          userName:this.administratorForm.userName,
          password:this.administratorForm.password
        }
      }
      ).then(
        (response) => {
          console.log(response.data);
          // localStorage.setItem("admin_access_token", "123");
          // this.$store.commit("UPDATE_TOKEN")
          if(response.data){
            this.routerPush('/administrator')
          }else{
            window.alert('账号或密码错误')
          }
        },
        (error) => {
          console.log(error.message);
        }
      );
    },
    routerPush(to) {
      this.$router.push(to);
    },
  },
  components: {
    CommonTop,
  },
};
</script>

<style>
</style>