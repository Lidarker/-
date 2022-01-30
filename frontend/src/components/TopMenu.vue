<template>
  <el-row
    type="flex"
    align="middle"
    style="margin-right: 10px; margin-left: 10px"
  >
    <el-col :span="4">
      <el-link
        @click="routerPush('/')"
        target="_blank"
        style="font-size: 30px"
      >
        长租公寓平台
      </el-link>
    </el-col>
    <el-col :span="10">
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        router
      >
        <el-menu-item index="/">主页</el-menu-item>
        <el-menu-item index="2">收藏</el-menu-item>
        <el-menu-item index="/my-house">我的房源</el-menu-item>
        <el-submenu index="4">
          <template slot="title">个人中心</template>
          <el-menu-item index="4-1">我的消息</el-menu-item>
          <el-menu-item index="4-2">浏览记录</el-menu-item>
          <el-menu-item index="4-3">账户设置</el-menu-item>
        </el-submenu>
        <el-menu-item index="5" v-if="false">客服</el-menu-item>
      </el-menu>
    </el-col>
    <el-col :span="6" style="align: middle">
      <el-input
        v-if="activeIndex === '/'"
        placeholder="请输入内容"
        v-model="searchInput"
        class="input-with-select"
      >
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </el-col>
    <el-col
      :span="3"
      style="text-align: center; height: 60px; line-height: 60px"
    >
      <span
        v-if="!$store.state.isLogin"
        class="avater"
        style="text-align: center; color: #999999"
      >
        未登录
      </span>
      <el-dropdown v-else trigger="click" @command="routerPush">
        <el-avatar
          class="el-dropdown-link"
          src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
          style="vertical-align: middle; cursor: pointer"
        ></el-avatar>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>我的消息</el-dropdown-item>
          <el-dropdown-item>浏览记录</el-dropdown-item>
          <el-dropdown-item command="user-setting">账户设置</el-dropdown-item>
          <el-dropdown-item>退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-col>
  </el-row>
</template>

<script>
export default {
  data() {
    return {
      searchInput: "",
    };
  },
  props:["activeIndex"],
  methods: {
    handleSelect(key, keyPath) {
      // console.log(key, keyPath);
    },
    routerPush(to) {
      this.$router.push(to);
    },
  },
};
</script>

<style scoped>
</style>