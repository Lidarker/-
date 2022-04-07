<template>
  <div>
    <el-table :data="tableData" style="width: 100%" @row-click="handleRowClick">
      <el-table-column label="房屋图片" width="280">
        <template slot-scope="scope">
          <img
            style="width: 100px; height: 100px"
            :src="'/static/img/' + scope.row.rimage"
          />
        </template>
      </el-table-column>
      <el-table-column label="房屋简介">
        <template slot-scope="scope">
          <span style="font-size: 24px">
            {{ scope.row.raddress }}&nbsp;{{ scope.row.rtype }}
          </span>
          <p style="font-size: 10px; margin: 0; padding-top: 5px">
            {{ scope.row.rtype }}
          </p>
          <p style="font-size: 10px; margin: 0">{{ scope.row.raddress }}</p>
          <p style="font-size: 10px; margin: 0">{{ scope.row.description }}</p>
        </template>
      </el-table-column>
      <el-table-column label="房屋价格" width="300">
        <template slot-scope="scope">
          <div class="room-price" style="font-size: 24px; color: red">
            {{ scope.row.rprice }}元/月
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="300">
        <template slot-scope="scope">
          <div @click.stop>
            <el-popover placement="top" width="160" v-model="visible">
              <p>确定取消收藏此房源吗？</p>
              <div style="text-align: right; margin: 0">
                <el-button size="mini" type="text" @click="visible = false"
                  >取消</el-button
                >
                <el-button
                  type="primary"
                  size="mini"
                  @click.stop="handleDelete(scope.$index, scope.row)"
                  >确定</el-button
                >
              </div>
              <el-button slot="reference" type="danger" size="mini">
                取消收藏
              </el-button>
            </el-popover>
          </div>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      tableData: [
        {
          rid: "",
          rtype: "",
          raddress: "",
          rprice: "",
          description: "",
          rimage: "",
          certificateid: "",
        },
      ],
      account: {},
      visible: false,
    };
  },
  methods: {
    handleDelete(index, row) {
      this.visible = false;
      console.log(index, row, row.rid);
    },
    handleRowClick(row, column) {
      console.log(row.rid);
      this.$router.push({ path: "/house-detail", query: { id: row.rid } });
    },
  },
  created() {
    // sessionStorage.getItem("access_token") 可以取出当前登录的用户的用户名
    // console.log("@", sessionStorage.getItem("access_token"));
    this.account = sessionStorage.getItem("access_token");
  },
  mounted() {
    axios
      .get("http://localhost:8081/browse/getAllBrowse", {
        params: { account: this.account },
      })
      .then((Response) => {
        console.log("数据", Response.data);
        console.log(this.tableData);
        this.tableData = Response.data;
      });
  },
  updated() {
    // axios
    //   .get("http://localhost:8081/getRoomByAccount", {
    //     params: { account: this.account },
    //   })
    //   .then((Response) => {
    //     this.tableData = Response.data;
    //   });
  },
};
</script>

<style>
</style>