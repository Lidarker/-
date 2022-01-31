<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="身份证" width="80">
        <template slot-scope="scope">
          <a @click="getIdCard" style="cursor: pointer">
            <i class="aliiconfont al-iconyanjing"></i>
          </a>
        </template>
      </el-table-column>
      <el-table-column label="审核" width="160">
        <template slot-scope="scope">
          <el-button size="mini" type="primary">同意</el-button>
          <el-button size="mini" type="danger">拒绝</el-button>
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