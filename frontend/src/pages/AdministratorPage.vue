<template>
  <el-container style="height: 100%">
    <el-header>
      <h2
        style="
          color: black;
          display: inline-block;
          margin-top: 5px;
          margin-bottom: 5px;
        "
      >
        长租公寓平台
      </h2>
      <i
        class="aliiconfont al-icontuichu"
        style="float: right; font-size: 25px; margin-top: 13px; cursor: pointer"
        @click="logOut"
      ></i>
      <span id="adm-name" style="float: right; margin-top: 15px">
        123456，您好！
      </span>
      <el-divider style="margin-top: 5px; margin-bottom: 5px"></el-divider>
    </el-header>
    <el-container style="height: 100%">
      <el-aside width="200px">
        <el-menu
          style="height: 100%"
          :default-active="activeIndex"
          class="el-menu-vertical-demo"
          router
        >
          <el-menu-item index="/administrator/open-setting">
            <span slot="title">开关系统</span>
          </el-menu-item>
          <el-menu-item index="/administrator/administrator-management">
            <span slot="title">管理员管理</span>
          </el-menu-item>
          <el-menu-item index="/administrator/user-management">
            <span slot="title">用户管理</span>
          </el-menu-item>
          <el-menu-item index="/administrator/house-management">
            <span slot="title">房源管理</span>
          </el-menu-item>
          <el-menu-item index="5">
            <span slot="title">消息管理</span>
          </el-menu-item>
          <el-menu-item index="6">
            <span slot="title">评论举报</span>
          </el-menu-item>
          <el-menu-item index="7">
            <span slot="title">房源投诉</span>
          </el-menu-item>
          <el-menu-item index="/administrator/user-audit">
            <span slot="title">用户审核</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  components: {},
  props: ["activeIndex"],
  methods: {
    routerPush(to) {
      this.$router.push(to);
    },
    logOut() {
      localStorage.removeItem('admin_access_token');
      this.$store.commit("UPDATE_TOKEN")
      this.routerPush('/login');
    }
  },
};
</script>

<style scoped>
.el-header,
.el-footer {
  color: #333;
  text-align: center;
}

.el-aside {
  margin-left: 30px;
  margin-top: 7px;
}

.el-main {
  background-color: #ffffff;
  color: #333;
  text-align: center;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
.al-icontuichu:hover {
  color: rgb(255, 72, 0);
}
</style>