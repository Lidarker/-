<template>
  <div id="app">
    <HouseDetailPage />
  </div>
</template>

<script>
import HomePage from "./components/HomePage";
import LoginPage from "./components/LoginPage";
import HouseDetailPage from "./components/HouseDetailPage"

export default {
  name: "App",
  components: {
    HomePage,
    LoginPage,
    HouseDetailPage
  },
};
</script>

<style>
</style>
