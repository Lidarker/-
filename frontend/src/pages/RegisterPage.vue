<template>
  <div style="margin-right: 10px; margin-left: 10px">
    <CommonTop pos="注册" />
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
            注册
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import CommonTop from "../components/CommonTop";
import axios from "axios";
export default {
  data() {
    var passwordValidator = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.form.password !== "") {
          this.$refs.form.validateField("repeatPassword");
        }
        callback();
      }
    };
    var repeatPasswordValidator = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.form.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };

    return {
      form: {
        phone: "",
        account: "",
        password: "",
        repeatPassword: "",
      },
      rules: {
        phone: [
          { required: true, message: "请输入手机号码", trigger: "blur" },
          { min: 11, max: 11, message: "请输入11位手机号码", trigger: "blur" },
          {
            pattern:
              /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
            message: "请输入正确的手机号码",
          },
        ],
        account: [{ required: true, message: "请输入用户名", trigger: "blur" }],
        password: [
          { required: true, validator: passwordValidator, trigger: "blur" },
        ],
        repeatPassword: [
          {
            required: true,
            validator: repeatPasswordValidator,
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    onSubmit() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          axios
            .get("http://172.19.241.36:8081/user/register", {
              params: {
                phone: this.form.phone,
                userName: this.form.account,
                password: this.form.password,
              },
            })
            .then((Response) => {
              console.log("数据", Response.data);
              alert(Response.data);
              if (Response.data == "注册成功") {
                this.$router.push({ path: "/login" });
              }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
  components: {
    CommonTop,
  },
};
</script>

<style>
</style>