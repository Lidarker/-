<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="房屋图片" width="280">
        <template slot-scope="scope">
          <img
            style="width: 100px; height: 100px"
            :src="'http://172.19.241.36:8081/pic/getPic?rid=' + scope.row.rid"
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
          <el-button
            type="primary"
            size="mini"
            @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            type="danger"
            size="mini"
            @click="deleteHint(scope.$index, scope.row)"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="修改房屋信息" :visible.sync="editVisible" width="40%">
      <el-form
        :model="editData"
        :rules="rules"
        ref="editForm"
        label-position="right"
        label-width="100px"
      >
        <el-form-item label="所在地址" prop="raddress">
          <el-input v-model="editData.raddress"></el-input>
        </el-form-item>
        <el-form-item label="月租/元" prop="rprice">
          <el-input type="number" v-model="editData.rprice"></el-input>
        </el-form-item>
        <el-form-item label="房屋类型" prop="rtype">
          <el-input v-model="editData.rtype"></el-input>
        </el-form-item>
        <el-form-item label="房产证编号" prop="certificateid">
          <el-input v-model="editData.certificateid"></el-input>
        </el-form-item>
        <el-form-item label="优劣" prop="description">
          <el-input
            type="textarea"
            :rows="4"
            placeholder="请输入内容"
            v-model="editData.description"
          >
          </el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitEditForm"> 修 改 </el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    var validateFile = (rule, value, callback) => {
      if (this.fileList.length == 0) {
        return callback(new Error("请上传房子图片"));
      }
      return callback();
    };
    return {
      editVisible: false,
      editData: {
        raddress: "",
        rprice: undefined,
        rtype: "",
        certificateid: "",
        description: "",
        rid: "",
      },
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
      rules: {
        raddress: [{ required: true, message: "请输入地址", trigger: "blur" }],
        rprice: [{ required: true, message: "请输入月租", trigger: "blur" }],
        rtype: [{ required: true, message: "请输入房屋类型", trigger: "blur" }],
        certificateid: [
          { required: true, message: "请输入房产证编号", trigger: "blur" },
        ],
        description: [
          { required: true, message: "请输入房屋优劣", trigger: "blur" },
        ],
        picture: [{ required: true, validator: validateFile, trigger: "blur" }],
      },
      editResult: "",
    };
  },
  methods: {
    handleEdit(index, row) {
      this.editData.rid = row.rid;
      this.editData.rtype = row.rtype;
      this.editData.raddress = row.raddress;
      this.editData.rprice = row.rprice;
      this.editData.description = row.description;
      this.editData.certificateid = row.certificateid;
      this.editVisible = true;
    },
    deleteHint(index, row) {
      this.$prompt("请输入删除理由", "删除", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
      })
        .then(({ value }) => {
          axios
            .get("http://172.19.241.36:8081/room/deleteRoom", {
              params: { rid: row.rid },
            })
            .then((Response) => {
              this.changeData();
              this.$message({
                type: "success",
                message: "删除成功",
              });
            });
        })
        .catch(() => {});
    },
    submitEditForm() {
      this.$refs["editForm"].validate((valid) => {
        if (valid) {
          this.editVisible = false;
          axios
            .post("http://172.19.241.36:8081/room/updateRoom", this.editData)
            .then((res) => {
              this.changeData();
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    changeData() {
      axios
        .get("http://172.19.241.36:8081/getRoomByAccount", {
          params: { account: this.account },
        })
        .then((Response) => {
          this.tableData = Response.data;
        });
    },
  },
  created() {
    // sessionStorage.getItem("access_token") 可以取出当前登录的用户的用户名
    this.account = sessionStorage.getItem("access_token");
  },
  mounted() {
    axios
      .get("http://172.19.241.36:8081/getRoomByAccount", {
        params: { account: this.account },
      })
      .then((Response) => {
        this.tableData = Response.data;
      });
    this.$bus.$on("change", (val) => {
      this.changeData();
    });
  },
  updated() {},
};
</script>

<style>
</style>