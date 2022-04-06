<template lang="">
    <div>
        <TopMenu activeIndex="/collection" />
        <CollectionHouseTable />
    </div>
</template>
<script>
import TopMenu from "../components/TopMenu";
import CollectionHouseTable from "../components/CollectionHouseTable";
export default {
  components: {
    TopMenu,
    CollectionHouseTable,
  },
};
</script>
<style>
</style>