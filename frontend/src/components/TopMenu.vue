<template>
  <el-row
    type="flex"
    align="middle"
    style="margin-right: 10px; margin-left: 10px"
  >
    <el-col :span="4">
      <el-link
        href="https://element.eleme.io"
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
      >
        <el-menu-item index="1">主页</el-menu-item>
        <el-menu-item index="2">收藏</el-menu-item>
        <el-menu-item index="3">我的房源</el-menu-item>
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
        placeholder="请输入内容"
        v-model="input3"
        class="input-with-select"
      >
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </el-col>
    <el-col
      :span="3"
      style="text-align: center; height: 60px; line-height: 60px"
    >
      <span class="avater" style="text-align: center; color: #999999"
        >未登录</span
      >
    </el-col>
  </el-row>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style scoped>
h3 {
  display: inline;
}
</style>