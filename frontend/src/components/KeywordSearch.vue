<template>
  <el-card class="box-card" style="margin-left: 40px; margin-right: 40px; margin-top: 20px; ">
    <div class="home-key-words-search">
      <div class="home-key-words">
        <span>城市：</span>
        <span class="home-key-words-choice">
          <el-button type="text" @click="searchCity()" class="span-active">不限</el-button>
          <el-button type="text" @click="searchCity('北京')">北京</el-button>
          <el-button type="text" @click="searchCity('上海')">上海</el-button>
          <el-button type="text" @click="searchCity('广州')">广州</el-button>
          <el-button type="text" @click="searchCity('深圳')">深圳</el-button>
          <el-button type="text" @click="searchCity('武汉')">武汉</el-button>
          <el-button type="text" @click="searchCity('其他')">其他</el-button>
        </span>
      </div>
      <div class="home-key-words">
        <span>租金：</span>
        <span class="home-key-words-choice">
          <el-button type="text" @click="searchMoney()" class="span-active">不限</el-button>
          <el-button type="text" @click="searchMoney(0,500)">500元以下</el-button>
          <el-button type="text" @click="searchMoney(500,1000)">500-1000元</el-button>
          <el-button type="text" @click="searchMoney(1000,1500)">1000-1500元</el-button>
          <el-button type="text" @click="searchMoney(1500,2000)">1500-2000元</el-button>
          <el-button type="text" @click="searchMoney(2000,4000)">2000-4000元</el-button>
          <el-button type="text" @click="searchMoney(4000,6000)">4000-6000元</el-button>
          <el-button type="text" @click="searchMoney(6000,9000)">6000-9000元</el-button>
          <el-button type="text" @click="searchMoney(9000,900000)">9000元以上</el-button>
        </span>
      </div>
      <div class="home-key-words">
        <span>厅室：</span>
        <span class="home-key-words-choice">
          <el-button type="text" @click="searchType()">不限</el-button>
          <el-button type="text" @click="searchType('一室')">一室</el-button>
          <el-button type="text" @click="searchType('二室')">二室</el-button>
          <el-button type="text" @click="searchType('三室')">三室</el-button>
          <el-button type="text" @click="searchType('四室')">四室</el-button>
          <el-button type="text" @click="searchType('四室以上')">四室以上</el-button>
        </span>
      </div>
    </div>
  </el-card>
</template>

<script>
import axios from 'axios';
export default {
  methods:{
    searchCity(key){
      if(key==null)
      {
        axios.get("http://localhost:8081/room/getAllRoom").then((Response)=>{
          this.$bus.$emit('getData',Response.data)
        });
      }else{
        axios.get("http://localhost:8081/room/getRoom",{params:{city:key}}).then((Response)=>{
        this.$bus.$emit('getData',Response.data)
        });
      }
    },
    searchMoney(key1,key2){
       if(key1==null)
      {
        axios.get("http://localhost:8081/room/getAllRoom").then((Response)=>{
          this.$bus.$emit('getData',Response.data)
        });
      }else{
        axios.get("http://localhost:8081/room/getRoom",{params:{lowmoney:key1,highmoney:key2}}).then((Response)=>{
        this.$bus.$emit('getData',Response.data)
        });
      }
    },
    searchType(key){
       if(key==null)
      {
        axios.get("http://localhost:8081/room/getAllRoom").then((Response)=>{
          this.$bus.$emit('getData',Response.data)
        });
      }else{
        axios.get("http://localhost:8081/room/getRoom",{params:{type:key}}).then((Response)=>{
        this.$bus.$emit('getData',Response.data)
        });
      }
    }
  }
};
</script>

<style scoped>
span {
  font-size: 16px;
  display: inline-block;
}
a {
  font-size: 16px;
  height: 16px;
  line-height: 16px;
  margin-left: 10px;
}
</style>