<template>
  <div>
    <div id="all">
      <div v-for="item in this.commentData" :key="item.id">
        <el-row>
          <el-col :span="20">
            <div>{{item.comment}}</div>
            <div>{{item.time}}</div>
          </el-col>
          <el-col :span="4">
            <span>{{item.username}}</span>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      commentData: [
        {
          id: 0,
          comment: "这是一条评论",
          time: "评论时间",
          username: "发布此评论的用户名"
        }
      ],
    };
  },
  created() {
    console.log("在这发送请求获取评论数据")
    // axios.get("http://172.19.241.36:8081/xxx").then((Response) => {
    //   console.log("数据", Response.data);
    //   console.log(this.tableData);
    //   this.commentData = Response.data;
    // });
  },
};
</script>
<style>

</style>