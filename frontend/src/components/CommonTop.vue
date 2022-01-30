<template>
  <div>
    <PageHeader />
    <el-divider></el-divider>
    <el-link
      @click="router_push('/')"
      target="_blank"
      style="font-size: 30px"
    >
      长租公寓平台
    </el-link>
    <div style="font-size: 14px; margin-top: 15px">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item to="/">
          <i class="el-icon-house"></i>主页
        </el-breadcrumb-item>
        <el-breadcrumb-item> {{ pos }}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  </div>
</template>

<script>
import PageHeader from "./PageHeader";
export default {
  components: {
    PageHeader,
  },
  props: ["pos"],
  methods: {
    router_push(to) {
      this.$router.push(to);
    },
  },
};
</script>

<style>
</style>