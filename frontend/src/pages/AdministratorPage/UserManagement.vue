<template>
  <div>
    <el-select v-model="selectValue" placeholder="请选择" style="width: 15%">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      >
      </el-option>
    </el-select>
    <el-input placeholder="请输入内容" v-model="searchValue" style="width: 65%">
      <i slot="prefix" class="el-input__icon el-icon-search"></i>
    </el-input>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="ID" width="160">
        <template slot-scope="scope">
          <span style="margin-left: 5px">{{ scope.row.uid }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账号" width="160">
        <template slot-scope="scope">
          {{ scope.row.account }}
        </template>
      </el-table-column>
      <el-table-column label="密码" width="160">
        <template slot-scope="scope">
          {{ scope.row.password }}
        </template>
      </el-table-column>
      <!-- <el-table-column label="性别" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column> -->
      <el-table-column label="电话号码" width="160">
        <template slot-scope="scope">
          {{ scope.row.phone }}
        </template>
      </el-table-column>
      <!-- <el-table-column label="邮箱" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="活跃" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="冻结" width="160">
        <template slot-scope="scope">
          <el-button v-if="scope.row.isFreeze" size="mini" type="primary">
            解冻
          </el-button>
          <el-button v-else size="mini" type="danger">冻结</el-button>
        </template>
      </el-table-column>
      <el-table-column label="身份证" width="80">
        <template slot-scope="scope">
          <a @click="getIdCard" style="cursor: pointer">
            <i class="aliiconfont al-iconyanjing"></i>
          </a>
        </template>
      </el-table-column> -->
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      options: [
        {
          value: "ID",
          label: "ID",
        },
        {
          value: "nickname",
          label: "昵称",
        },
        {
          value: "realName",
          label: "真实姓名",
        },
        {
          value: "gender",
          label: "性别",
        },
      ],
      tableData: [
        // {
        //   date: "2016-05-02",
        //   name: "王小虎",
        //   isFreeze: true,
        //   address: "上海市普陀区金沙江路 1518 弄",
        //   permissionList: ["复选框 A"],
        // },
        // {
        //   date: "2016-05-02",
        //   name: "王小虎",
        //   isFreeze: false,
        //   address: "上海市普陀区金沙江路 1518 弄",
        //   permissionList: ["复选框 A"],
        // },
      ],
      selectValue: "ID",
      searchValue: "",
    };
  },
  methods: {
    getIdCard() {
      console.log("getIdCard");
    },
  },
  created(){
    axios.get("http://localhost:8081/user/findAll",{
      params:{
        isAdmin:false
      }
    })
    .then((Response)=>{
      console.log("数据",Response.data);
      console.log(this.tableData);
      this.tableData=Response.data;
    })
  }
};
</script>

<style scoped>
.el-checkbox {
  margin-right: 0px;
}
</style>