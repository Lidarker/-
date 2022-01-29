<template>
  <div>
    <UserSettingPage />
  </div>
</template>

<script>
import HomePage from "./components/HomePage";
import MyHousePage from "./components/MyHousePage";
import UserSettingPage from "./components/UserSettingPage"
import LoginPage from "./components/LoginPage";
import FogerPasswordPage from "./components/ForgetPasswordPage";
import RegisterPage from "./components/RegisterPage";
import HouseDetailPage from "./components/HouseDetailPage";
import AdministratorPage from "./components/AdministratorPage";

export default {
  name: "App",
  components: {
    HomePage,
    MyHousePage,
    UserSettingPage,
    LoginPage,
    FogerPasswordPage,
    RegisterPage,
    HouseDetailPage,
    AdministratorPage,
  },
};
</script>

<style>
#app {
  height: 100%;
}
</style>
