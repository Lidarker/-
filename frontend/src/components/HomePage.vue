<template>
  <div>
    <PageHeader v-if="!isLogin"/>
    <TopMenu :isLogin="isLogin"/>
    <KeywordSearch />
    <HouseTable />
  </div>
</template>

<script>
import PageHeader from "./PageHeader.vue";
import TopMenu from "./TopMenu.vue";
import KeywordSearch from "./KeywordSearch.vue";
import HouseTable from "./HouseTable.vue";
export default {
  data(){
    return {
      isLogin: true,
    }
  },
  components: {
    PageHeader,
    TopMenu,
    KeywordSearch,
    HouseTable,
  },
};
</script>

<style>
</style>