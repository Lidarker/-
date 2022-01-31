<template>
  <div>
    <TopMenu :isLogin="true" :isMyHouse="true" />
    <el-card
      class="box-card"
      style="margin-top: 20px; margin-right: 15%; margin-left: 15%"
    >
      <div style="display: inline-block">
        <el-avatar
          :size="80"
          src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
        ></el-avatar>
        <el-upload
          style="margin-left: 5px"
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          :auto-upload="false"
        >
          <el-button type="text">上传头像</el-button>
        </el-upload>
      </div>
      <div
        style="display: inline-block; vertical-align: top; margin-left: 30px"
      >
        <div style="margin-top: 10px"><span>账号：</span>123456</div>
        <div style="margin-top: 10px"><span>注册时间：</span>2020/09/09</div>
      </div>
    </el-card>
    <el-table :data="tableData" style="width: 70%; margin: 20px auto">
      <el-table-column prop="col1">
        <template slot-scope="scope">
          <strong>{{ scope.row.col1 }}</strong>
        </template>
      </el-table-column>
      <el-table-column prop="col2">
        <template slot-scope="scope">
          <i
            v-if="scope.row.col2"
            style="color: green; font-size: 20px"
            class="el-icon-success"
          ></i>
          <i
            v-else
            style="color: red; font-size: 20px"
            class="el-icon-question"
          ></i>
        </template>
      </el-table-column>
      <el-table-column prop="col3" width="300px"> </el-table-column>
      <el-table-column prop="col4">
        <template slot-scope="scope">
          <template v-if="scope.row.edit">
            <el-select v-if="scope.row.col1 == '性别'" v-model="scope.row.col4">
              <el-option key="男" label="男" value="男"> </el-option>
              <el-option key="女" label="女" value="女"> </el-option>
            </el-select>
            <el-input
              v-else-if="scope.row.col1 == '登录密码'"
              show-password
              v-model="scope.row.col4"
            >
            </el-input>
            <el-dialog
              v-else-if="scope.row.col1 == '身份证'"
              title="身份验证"
              :visible.sync="scope.row.edit"
              width="60%"
            >
              <el-form
                :model="identityForm"
                :rules="rules"
                ref="IDCardForm"
                label-width="80px"
                style="width: 80%"
              >
                <el-form-item label="真实姓名" prop="name">
                  <el-input
                    v-model="identityForm.name"
                    placeholder="请输入姓名"
                  ></el-input>
                </el-form-item>
                <el-form-item label="证件类型" prop="type" required>
                  <el-select v-model="identityForm.type" style="width: 250px">
                    <el-option value="大陆居民身份证"></el-option>
                    <el-option value="港澳台往来通行证"></el-option>
                    <el-option value="护照"></el-option>
                    <el-option value="暂住证"></el-option>
                    <el-option value="居住证"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="证件号码" prop="code">
                  <el-input
                    v-model="identityForm.code"
                    placeholder="请输入证件号码"
                  ></el-input>
                </el-form-item>
                <el-form-item label="上传证件" prop="uploadIDCard">
                  <el-upload
                    :on-change="handleChange"
                    :on-remove="handleRemove"
                    ref="upload"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :file-list="fileList"
                    :auto-upload="false"
                    :limit="1"
                  >
                    <el-button slot="trigger" size="small" type="primary">
                      选取文件
                    </el-button>
                  </el-upload>
                </el-form-item>
              </el-form>
              <span slot="footer" class="dialog-footer">
                <el-button @click="scope.row.edit = false">取消</el-button>
                <el-button
                  type="primary"
                  @click="submitUploadIDCard(scope.row)"
                >
                  提交修改
                </el-button>
              </span>
            </el-dialog>
            <el-input v-else v-model="scope.row.col4"> </el-input>
          </template>
          <template v-else>
            <el-input
              class="setting-password"
              v-if="scope.row.col1 == '登录密码'"
              show-password
              readonly="readonly"
              :value="scope.row.col4"
            >
            </el-input>
            <div v-else>{{ scope.row.col4 }}</div>
          </template>
        </template>
      </el-table-column>
      <el-table-column prop="col5">
        <template slot-scope="scope">
          <el-button
            v-if="!scope.row.edit"
            type="primary"
            size="mini"
            @click="handleEdit(scope.row)"
          >
            编辑
          </el-button>
          <el-button
            v-else
            type="danger"
            size="mini"
            @click="handleSave(scope.row)"
          >
            保存
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
import TopMenu from "../components/TopMenu.vue";

export default {
  data() {
    var validateFile = (rule, value, callback) => {
      console.log(this.fileList.length);
      if (this.fileList.length == 0) {
        return callback(new Error("请上传证件图片"));
      }
    };
    return {
      tableData: [
        {
          col1: "手机号",
          col2: false,
          col3: "设置手机号有助于系统在第一时间联系您",
          col4: "",
          col5: "edit",
          edit: false,
        },
        {
          col1: "性别",
          col2: true,
          col3: "上传您的性别，称呼您为“先生”还是“女士”",
          col4: "男",
          col5: "edit",
          edit: false,
        },
        {
          col1: "登录密码",
          col2: true,
          col3: "安全性高的密码可以使帐号更安全。建议您定期更换密码，设置一个包含字母，符号或数字中至少两项且长度超过6位的密码。",
          col4: "******",
          col5: "edit",
          edit: false,
        },
        {
          col1: "身份证",
          col2: true,
          col3: "上传您的身份证有助于我们确定您的信息，提高您的信用。只有上传了身份证后才能在此网站上上传房源。",
          col4: "2536456457467",
          col5: "edit",
          edit: false,
        },
        {
          col1: "邮箱",
          col2: true,
          col3: "上传您的邮箱有助于我们验证您的信息，系统的推送将会发送您的邮箱。",
          col4: "123456@qq.com",
          col5: "edit",
          edit: false,
        },
      ],
      identityForm: {
        name: "",
        type: "大陆居民身份证",
        code: "",
      },
      fileList: [],
      rules: {
        name: [{ required: true, message: "请输入活动名称", trigger: "blur" }],
        code: [{ required: true, message: "请输入证件号码", trigger: "blur" }],
        uploadIDCard: [
          { required: true, validator: validateFile, trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    handleAvatarSuccess() {},
    beforeAvatarUpload() {},
    handleEdit(row) {
      row.edit = true;
    },
    handleSave(row) {
      // axios.post
      row.edit = false;
      if (row.col4 != "") {
        row.col2 = true;
      }
    },
    submitUploadIDCard(row) {
      this.$refs["IDCardForm"].validate((valid) => {
        if (valid) {
          row.edit = false;
          // this.$refs.upload.submit();
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    handleChange(file, fileList) {
      this.fileList = fileList;
    },
    handleRemove(file, fileList) {
      this.fileList = fileList;
    },
  },
  components: {
    TopMenu,
  },
};
</script>

<style>
.setting-password .el-input__inner {
  border: none !important;
  background: rgba(255, 255, 255, 0);
  padding: 0;
}
</style>