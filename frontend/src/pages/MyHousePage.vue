<template>
  <div>
    <TopMenu activeIndex="/my-house" />
    <MyHouseTable />
    <PublishHouse />
    
  </div>
</template>

<script>
import TopMenu from "../components/TopMenu";
import MyHouseTable from "../components/MyHouseTable";
import PublishHouse from "../components/PublishHouse";
export default {
  components: {
    TopMenu,
    MyHouseTable,
    PublishHouse
  },
};
</script>

<style>

</style>