<template>
  <el-card class="box-card" style="margin-left: 40px; margin-right: 40px; margin-top: 20px; ">
    <div class="home-key-words-search">
      <div class="home-key-words">
        <span>城市：</span>
        <span class="home-key-words-choice">
          <el-link class="span-active">不限</el-link>
          <el-link>北京</el-link>
          <el-link>上海</el-link>
          <el-link>广州</el-link>
          <el-link>深圳</el-link>
          <el-link>武汉</el-link>
          <el-link>其他</el-link>
        </span>
      </div>
      <div class="home-key-words">
        <span>租金：</span>
        <span class="home-key-words-choice">
          <el-link class="span-active">不限</el-link>
          <el-link class="">500元以下</el-link>
          <el-link>500-1000元</el-link>
          <el-link>1000-1500元</el-link>
          <el-link>1500-2000元</el-link>
          <el-link>2000-4000元</el-link>
          <el-link>4000-6000元</el-link>
          <el-link>6000-9000元</el-link>
          <el-link>9000元以上</el-link>
        </span>
      </div>
      <div class="home-key-words">
        <span>厅室：</span>
        <span class="home-key-words-choice">
          <el-link class="span-active">不限</el-link>
          <el-link>一室</el-link>
          <el-link>二室</el-link>
          <el-link>三室</el-link>
          <el-link>四室</el-link>
          <el-link>四室以上</el-link>
        </span>
      </div>
    </div>
  </el-card>
</template>

<script>
export default {};
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