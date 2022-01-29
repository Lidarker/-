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
          <span style="margin-left: 5px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column label="类型" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="房东ID" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="房产证号" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="地址" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="价格（元/月）" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="图片" width="160">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="删除" width="160">
        <template slot-scope="scope">
          <el-button size="mini" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      options: [
        {
          value: "ID",
          label: "ID",
        },
        {
          value: "type",
          label: "类型",
        },
        {
          value: "landlordID",
          label: "房东ID",
        },
        {
          value: "housePropertyCardNumber",
          label: "房产证号",
        },
      ],
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          isFreeze: true,
          address: "上海市普陀区金沙江路 1518 弄",
          permissionList: ["复选框 A"],
        },
        {
          date: "2016-05-02",
          name: "王小虎",
          isFreeze: false,
          address: "上海市普陀区金沙江路 1518 弄",
          permissionList: ["复选框 A"],
        },
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
};
</script>

<style scoped>
.el-checkbox {
  margin-right: 0px;
}
</style>