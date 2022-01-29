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
      <div style="display: inline-block; vertical-align: top; margin-left: 30px;">
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
      <el-table-column prop="col4"> </el-table-column>
      <el-table-column prop="col5">
        <template slot-scope="scope">
          <el-button type="primary" size="mini">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import TopMenu from "./TopMenu.vue";
export default {
  data() {
    return {
      tableData: [
        {
          col1: "手机号",
          col2: false,
          col3: "设置手机号有助于系统在第一时间联系您",
          col4: "",
          col5: "edit",
        },
        {
          col1: "性别",
          col2: true,
          col3: "上传您的性别，称呼您为“先生”还是“女士”",
          col4: "男",
          col5: "edit",
        },
        {
          col1: "登录密码",
          col2: true,
          col3: "安全性高的密码可以使帐号更安全。建议您定期更换密码，设置一个包含字母，符号或数字中至少两项且长度超过6位的密码。",
          col4: "******",
          col5: "edit",
        },
        {
          col1: "身份证",
          col2: true,
          col3: "上传您的身份证有助于我们确定您的信息，提高您的信用。只有上传了身份证后才能在此网站上上传房源。",
          col4: "2536456457467",
          col5: "edit",
        },
        {
          col1: "邮箱",
          col2: true,
          col3: "上传您的邮箱有助于我们验证您的信息，系统的推送将会发送您的邮箱。",
          col4: "123456@qq.com",
          col5: "edit",
        },
      ],
    };
  },
  components: {
    TopMenu,
  },
};
</script>

<style scoped>
</style>