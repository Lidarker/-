<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="房屋图片" width="280">
        <template slot-scope="scope">
          <img
            style="width: 100px; height: 100px"
            :src="'/static/img/'+scope.row.rimage"
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
          <el-button type="primary" size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button type="danger" size="mini" @click="deleteHint">
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
    <el-dialog title="发布房源" :visible.sync="uploadVisible" width="40%">
      <el-form
        :rules="rules"
        :model="editData"
        ref="houseForm"
        label-position="right"
        label-width="100px"
      >
        <el-form-item label="所在地址" prop="address">
          <el-input v-model="editData.address"></el-input>
        </el-form-item>
        <el-form-item label="月租/元" prop="price">
          <el-input type="number" v-model="editData.price"></el-input>
        </el-form-item>
        <el-form-item label="房屋类型" prop="type">
          <el-input v-model="editData.type"></el-input>
        </el-form-item>
        <el-form-item label="房产证编号" prop="number">
          <el-input v-model="editData.number"></el-input>
        </el-form-item>
        <el-form-item label="优劣" prop="advance">
          <el-input
            type="textarea"
            :rows="4"
            placeholder="请输入内容"
            v-model="editData.advance"
          >
          </el-input>
        </el-form-item>
        <el-form-item label="图片" prop="picture">
          <el-upload
            ref="upload"
            action="https://jsonplaceholder.typicode.com/posts/"
            :limit="10"
            :before-upload="beforeAvatarUpload"
            :on-change="handleChange"
            :on-remove="handleRemove"
            :file-list="fileList"
            :auto-upload="false"
          >
            <el-button slot="trigger" size="small" type="primary"
              >选取文件</el-button
            >
            <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件，且不超过500kb
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="uploadVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitHouseForm"> 发 布 </el-button>
      </span>
    </el-dialog>
    <el-button
      @click="uploadVisible = true"
      type="warning"
      class="upload-room-button"
    >
      发布房源
    </el-button>
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
    };
    return {
      editVisible: false,
      editData: {
        raddress: "",
        rprice: undefined,
        rtype: "",
        certificateid: "",
        description: "",
        rid:"",
      },
      uploadVisible: false,

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
      fileList: [],
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
      account:{

      },
      editResult:""
    };
  },
  methods: {
    handleEdit(index, row) {
      this.editData.rid=row.rid;
      this.editVisible = true;
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    deleteHint() {
      this.$prompt("请输入删除理由", "删除", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
      })
        .then(({ value }) => {
          this.$message({
            type: "success",
            message: "删除成功",
          });
        })
        .catch(() => {});
    },
    handleExceed(files, fileList) {
      this.$message.warning(
        `当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${
          files.length + fileList.length
        } 个文件`
      );
    },
    handleChange(file, fileList) {
      this.fileList = fileList;
    },
    handleRemove(file, fileList) {
      this.fileList = fileList;
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 < 500;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 500KB!");
      }
      return isJPG && isLt2M;
    },
    submitHouseForm() {
      this.$refs["houseForm"].validate((valid) => {
        if (valid) {
          this.uploadVisible = false;
          // this.$refs.upload.submit();
          alert("发布房源!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    submitEditForm() {
      this.$refs["editForm"].validate((valid) => {
        if (valid) {
          this.editVisible = false;
          // this.$refs.upload.submit();
          axios.post("http://localhost:8081/room/updateRoom",this.editData).then(res=>{
            console.log('res=>',res);  
            this.editResult=res.data;
            alert(this.editResult);
          })
        } else {
          console.log("error submit!!");
          return false;
        }

      });
    },
  },
  created() {
    // sessionStorage.getItem("access_token") 可以取出当前登录的用户的用户名
    console.log("@", sessionStorage.getItem("access_token"));
    this.account=sessionStorage.getItem("access_token");
  },
  mounted(){
     axios.get("http://localhost:8081/getRoomByAccount",{params:{account:this.account}}).then((Response) => {
      console.log("数据", Response.data);
      console.log(this.tableData);
      this.tableData = Response.data;
    });
  },
  updated(){
    axios.get("http://localhost:8081/getRoomByAccount",{params:{account:this.account}}).then((Response) => {
      this.tableData = Response.data;
    });
  }
};
</script>

<style>
.upload-room-button {
  top: 10%;
  right: 10px;
  position: fixed;
  border-radius: 8px;
  height: 60px;
  font-size: 20px;
}
</style>