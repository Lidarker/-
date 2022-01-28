<template>
  <div id="app">
    <PageHeader />
    <TopMenu />
    <KeywordSearch />
    <HouseTable />
  </div>
</template>

<script>
import PageHeader from "./components/PageHeader.vue";
import TopMenu from "./components/TopMenu.vue";
import KeywordSearch from "./components/KeywordSearch.vue";
import HouseTable from "./components/HouseTable.vue";

export default {
  name: "App",
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
