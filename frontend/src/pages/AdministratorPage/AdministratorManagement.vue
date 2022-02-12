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
      <el-table-column label="ID" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 5px">{{ scope.row.uid }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账号" width="180">
        <template slot-scope="scope">
          {{ scope.row.account }}
        </template>
      </el-table-column>
      <el-table-column label="密码" width="180">
        <template slot-scope="scope">
          {{ scope.row.password }}
        </template>
      </el-table-column>
      <el-table-column label="电话号码" width="180">
        <template slot-scope="scope">
          {{ scope.row.phone }}
        </template>
      </el-table-column>
      <!-- <el-table-column label="邮箱" width="180">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="权限" width="200px">
        <template slot-scope="scope">
          <el-checkbox-group
            v-model="scope.row.permissionList"
            style="dispaly: inline"
          >
            <el-tooltip
              class="item"
              effect="dark"
              content="系统设置"
              placement="top"
            >
              <el-checkbox label="系统设置">&nbsp;</el-checkbox>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="dark"
              content="用户管理"
              placement="top"
            >
              <el-checkbox label="用户管理">&nbsp;</el-checkbox>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="dark"
              content="消息管理"
              placement="top"
            >
              <el-checkbox label="消息管理">&nbsp;</el-checkbox>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="dark"
              content="房源管理"
              placement="top"
            >
              <el-checkbox label="房源管理">&nbsp;</el-checkbox>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="dark"
              content="审核中心"
              placement="top"
            >
              <el-checkbox label="审核中心">&nbsp;</el-checkbox>
            </el-tooltip>
            <el-button
              type="success"
              icon="el-icon-check"
              circle
              size="mini"
            ></el-button>
          </el-checkbox-group>
        </template>
      </el-table-column> -->
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
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
          value: "username",
          label: "账号",
        },
        {
          value: "name",
          label: "姓名",
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
        //   address: "上海市普陀区金沙江路 1518 弄",
        //   permissionList: ["复选框 A"],
        // },
        // {
        //   date: "2016-05-04",
        //   name: "王小虎",
        //   address: "上海市普陀区金沙江路 1517 弄",
        //   permissionList: [],
        // },
        // {
        //   date: "2016-05-01",
        //   name: "王小虎",
        //   address: "上海市普陀区金沙江路 1519 弄",
        //   permissionList: [],
        // },
        // {
        //   date: "2016-05-03",
        //   name: "王小虎",
        //   address: "上海市普陀区金沙江路 1516 弄",
        //   permissionList: [],
        // },
      ],
      selectValue: "username",
      searchValue: "",
    };
  },
  created(){
    axios.get("http://localhost:8081/user/findAll",{
      params:{
        isAdmin:true
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