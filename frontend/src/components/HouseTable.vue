<template>
  <el-table
    :data="tableData"
    style="width: 100%"
    @row-click="handleClick"
    class="house-table"
  >
    <el-table-column label="房屋图片" width="280">
      <template slot-scope="scope">
        <img
          style="width: 100px; height: 100px"
          :src="'http://localhost:8081/pic/getPic?rid=' + scope.row.rid"
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
  </el-table>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      tableData: [
        {
          rid: '',
          rtype: '',
          raddress: '',
          rprice: '',
          description: '',
          rimage: '',
          certificateid: ''
        }
      ],
    };
  },
  methods: {
    handleClick(row,column) {
      console.log(row.rid)
      this.$router.push({path:'/house-detail', query:{id:row.rid}});
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    getData(value){
      this.tableData=value;
    }
  },
  created() {
    axios.get("http://localhost:8081/room/getAllRoom").then((Response) => {
      console.log("数据", Response.data);
      console.log(this.tableData);
      this.tableData = Response.data;

    });
  },
  mounted(){
    this.$bus.$on("getData",this.getData);
  },
  beforedestory(){
    this.$off('getData');
  }
};
</script>

<style>
.house-table .el-table__row {
  cursor: pointer;
}
</style>