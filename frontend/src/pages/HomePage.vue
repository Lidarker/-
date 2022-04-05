<template>
  <div>
    <PageHeader v-if="!$store.state.access_token"/>
    <TopMenu activeIndex="/"/>
    <KeywordSearch />
    <HouseTable id="house-table"/>
  </div>
</template>

<script>
import PageHeader from "../components/PageHeader.vue";
import TopMenu from "../components/TopMenu.vue";
import KeywordSearch from "../components/KeywordSearch.vue";
import HouseTable from "../components/HouseTable.vue";
export default {
  data(){
    return {
      
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
#house-table {
  padding-right: 20px;
  padding-left: 20px;
  padding-top: 15px;
}
</style>