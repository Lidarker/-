<template>
  <div>
    <div id="all">
      <div v-for="item in this.commentData" :key="item.comment.cid">
        <el-row>
          <el-col :span="20">
            <div>{{ item.comment.detail }}</div>
            <div class="comment-time">
              {{
                (item.comment.time.length != 0)
                  ? datetimeFormater(item.comment.time)
                  : ""
              }}
            </div>
          </el-col>
          <el-col :span="4">
            <span>{{ item.user.account }}</span>
          </el-col>
        </el-row>
        <el-divider class="comment-divider" />
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import moment from "moment";
export default {
  data() {
    return {
      commentData: [
        {
          comment: {
            cid: "",
            detail: "",
            time: "",
          },
          user: {
            account: "",
          },
        },
      ],
      roomId: "",
    };
  },
  methods: {
    updateNow() {
      console.log("父组件让我更新数据");
      axios
        .get("http://localhost:8081/getCommentByRoomId", {
          params: { rid: this.roomId },
        })
        .then((Response) => {
          console.log("数据", Response.data);
          console.log(this.tableData);
          this.commentData = Response.data;
        });
    },
    datetimeFormater(dateStr, pattern = "YYYY-MM-DD HH:mm:ss") {
      return moment(dateStr).format(pattern);
    },
  },
  created() {
    this.roomId = this.$route.query.id;
  },
  mounted() {
    axios
      .get("http://localhost:8081/getCommentByRoomId", {
        params: { rid: this.roomId },
      })
      .then((Response) => {
        console.log("数据", Response.data);
        console.log(this.tableData);
        this.commentData = Response.data;
      });
  },
};
</script>
<style>
.comment-time {
  color: #ccc;
  font-size: 12px;
  margin-top: 10px;
}
.comment-divider {
  margin-top: 10px;
}
</style>