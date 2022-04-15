<template>
  <div>
    <el-button
      @click="uploadVisible = true"
      type="warning"
      class="upload-room-button"
    >
      发布房源
    </el-button>
    <el-dialog title="发布房源" :visible.sync="uploadVisible" width="40%">
      <el-form
        :rules="rules"
        :model="houseData"
        ref="houseForm"
        label-position="right"
        label-width="100px"
      >
        <el-form-item label="所在地址" prop="address">
          <el-input v-model="houseData.address"></el-input>
        </el-form-item>
        <el-form-item label="月租/元" prop="price">
          <el-input type="number" v-model="houseData.price"></el-input>
        </el-form-item>
        <el-form-item label="房屋类型" prop="type">
          <el-input v-model="houseData.type"></el-input>
        </el-form-item>
        <el-form-item label="房产证编号" prop="number">
          <el-input v-model="houseData.number"></el-input>
        </el-form-item>
        <el-form-item label="优劣" prop="advance">
          <el-input
            type="textarea"
            :rows="4"
            placeholder="请输入内容"
            v-model="houseData.advance"
          >
          </el-input>
        </el-form-item>
        <el-form-item label="图片" prop="picture">
          <el-upload
            ref="upload"
            action="image/jpeg"
            :limit="3"
            :before-upload="beforeAvatarUpload"
            :on-change="handleChange"
            :on-remove="handleRemove"
            :on-exceed="handleExceed"
            :file-list="fileList"
            :auto-upload="false"
          >
            <el-button slot="trigger" size="small" type="primary"
              >选取文件</el-button
            >
            <div slot="tip" class="el-upload__tip">
              只能上传jpg文件，且不超过500kb
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="uploadVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitHouseForm"> 发 布 </el-button>
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
      uploadVisible: false,
      houseData: {
        address: "",
        price: undefined,
        type: "",
        number: "",
        advance: "",
      },
      fileList: [],
      rules: {
        address: [{ required: true, message: "请输入地址", trigger: "blur" }],
        price: [{ required: true, message: "请输入月租", trigger: "blur" }],
        type: [{ required: true, message: "请输入房屋类型", trigger: "blur" }],
        number: [
          { required: true, message: "请输入房产证编号", trigger: "blur" },
        ],
        advance: [
          { required: true, message: "请输入房屋优劣", trigger: "blur" },
        ],
        picture: [{ required: true, validator: validateFile, trigger: "blur" }],
      },
    };
  },
  methods: {
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
    handleChange(file, fileList) {
      this.fileList = fileList;
    },
    handleRemove(file, fileList) {
      this.fileList = fileList;
    },
    handleExceed(files, fileList) {
      this.$message.warning(
        `当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${
          files.length + fileList.length
        } 个文件`
      );
    },
    submitHouseForm() {
      this.$refs["houseForm"].validate((valid) => {
        if (valid) {
          this.uploadVisible = false;
          var forms = new FormData();
          for (var key in this.houseData) {
            forms.append(key, this.houseData[key]);
          }
          forms.append("pic_uid", this.fileList[0].uid);
          forms.append("picture", this.fileList[0].raw);
          forms.append("account", sessionStorage.getItem("access_token"));
          axios
            .post("http://172.19.241.36:8081/room/insertHouse", forms, {
              headers: {
                "Content-Type": "multipart/form-data",
              },
            })
            .then((Response) => {
              if (Response.data == "添加成功") {
                this.houseData = {
                  address: "",
                  price: undefined,
                  type: "",
                  number: "",
                  advance: "",
                };
                this.fileList = [];
                this.$bus.$emit("change");
              }
            });
          return true;
        } else {
          console.log("error submit!!");
          console.log("666")
          return false;
        }
      });
    },
  },
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