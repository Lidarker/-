<template>
  <div>
    <TopMenu :isLogin="true" :isMyHouse="true" />
    <MyHouseTable />
  </div>
</template>

<script>
import TopMenu from "./TopMenu.vue";
import MyHouseTable from "./MyHouseTable.vue";
export default {
  components: {
    TopMenu,
    MyHouseTable,
  },
};
</script>

<style>
</style>