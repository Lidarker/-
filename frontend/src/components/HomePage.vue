<template>
  <div>
    <PageHeader />
    <TopMenu />
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