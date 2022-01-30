<template>
  <div style="margin-left: 10px; margin-right: 10px">
    <el-link type="primary" @click="routerPush('/login')" icon="aliiconfont al-iconlogin">登录</el-link>
    <el-link type="primary" @click="routerPush('/register')" icon="aliiconfont al-iconzhuce">注册</el-link>
  </div>
</template>

<script>
export default {
  methods: {
    routerPush(to) {
      this.$router.push(to);
    },
  },
};
</script>

<style>
</style>