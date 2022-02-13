<template>
  <el-card class="box-card" style="margin-left: 40px; margin-right: 40px; margin-top: 20px; ">
    <div class="home-key-words-search">
      <div class="home-key-words">
        <span>城市：</span>
        <span class="home-key-words-choice">
          <el-button type="text" class="span-active">不限</el-button>
          <el-button type="text">北京</el-button>
          <el-button type="text">上海</el-button>
          <el-button type="text">广州</el-button>
          <el-button type="text">深圳</el-button>
          <el-button type="text">武汉</el-button>
          <el-button type="text">其他</el-button>
        </span>
      </div>
      <div class="home-key-words">
        <span>租金：</span>
        <span class="home-key-words-choice">
          <el-button type="text" class="span-active">不限</el-button>
          <el-button type="text" @click="filter('500元以下')">500元以下</el-button>
          <el-button type="text"  @click="filter('500-1000元')">500-1000元</el-button>
          <el-button type="text">1000-1500元</el-button>
          <el-button type="text">1500-2000元</el-button>
          <el-button type="text">2000-4000元</el-button>
          <el-button type="text">4000-6000元</el-button>
          <el-button type="text">6000-9000元</el-button>
          <el-button type="text">9000元以上</el-button>
        </span>
      </div>
      <div class="home-key-words">
        <span>厅室：</span>
        <span class="home-key-words-choice">
          <el-button type="text">不限</el-button>
          <el-button type="text">一室</el-button>
          <el-button type="text">二室</el-button>
          <el-button type="text">三室</el-button>
          <el-button type="text">四室</el-button>
          <el-button type="text">四室以上</el-button>
        </span>
      </div>
    </div>
  </el-card>
</template>

<script>
export default {
  methods:{
    filter(keyword){
      console.log(keyword);
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