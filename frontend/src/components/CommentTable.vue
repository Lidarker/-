<template>
  <div>
    <div id="all">
      <div v-for="item in this.commentData" :key="item.comment.cid">
        <el-row>
          <el-col :span="20">
            <div>{{item.comment.detail}}</div>
            <div>{{item.comment.time}}</div>
          </el-col>
          <el-col :span="4">
            <span>{{item.user.account}}</span>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      commentData: [
        {
          comment:{
            cid:"",
            detail:"",
            time:""
          },
          user:{
            account:""
          }
        }
      ],
      roomId:"",
    };
  },
  created() {
    this.roomId=this.$route.query.id;
    console.log("在这发送请求获取评论数据")
    // axios.get("http://172.19.241.36:8081/xxx").then((Response) => {
    //   console.log("数据", Response.data);
    //   console.log(this.tableData);
    //   this.commentData = Response.data;
    // });
  },
  mounted(){
    axios.get("http://localhost:8081/getCommentByRoomId",{params:{rid:this.roomId}}).then((Response) => {
      console.log("数据", Response.data);
      console.log(this.tableData);
      this.commentData = Response.data;
    });
}

};
</script>
<style>

</style>