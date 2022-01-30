<template>
  <div>
    <TopMenu activeIndex="/my-house"/>
    <MyHouseTable />
  </div>
</template>

<script>
import TopMenu from "../components/TopMenu.vue";
import MyHouseTable from "../components/MyHouseTable.vue";
export default {
  components: {
    TopMenu,
    MyHouseTable,
  },
};
</script>

<style>
</style>