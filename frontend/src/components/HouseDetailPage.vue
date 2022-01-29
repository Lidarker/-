<template>
  <div class="detail-info">
    <el-page-header @back="goBack" content="详情页面"> </el-page-header>
    <div class="static-detail-info">
      <h2>佳木斯&nbsp;二室一厅</h2>
      <el-divider></el-divider>
      <el-carousel
        height="300px"
        style="width: 40%; display: inline-block; vertical-align: top"
      >
        <el-carousel-item
          v-for="item in 4"
          :key="item"
          style="text-align: center"
        >
          <el-image
            style="height: 100%"
            src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
            fit="fill"
          ></el-image>
        </el-carousel-item>
      </el-carousel>

      <div style="width: 55%; display: inline-block; vertical-align: top">
        <div style="width: 63.7%; display: inline-block; vertical-align: top">
          <div style="color: #d8703f; font-size: 36px">2000&nbsp;元/月</div>
          <div style="padding: 5px; font-size: 18px; color: #999999">
            房屋类型：二室一厅
          </div>
          <div style="padding: 5px; font-size: 18px; color: #999999">
            详细地址：佳木斯
          </div>
          <div style="padding: 5px; font-size: 18px; color: #999999">
            房屋优势：有暖气
          </div>
          <div style="padding: 5px; font-size: 18px; color: #999999">
            房屋描述：佳木斯二室一厅2000有暖气
          </div>
          <div style="padding: 5px; font-size: 18px; color: #999999">
            <el-button
              type="warning"
              @click="leaveMessageVisible = true"
              icon="aliiconfont al-iconliuyan"
            >
              留言
            </el-button>
            <el-button
              type="danger"
              @click="collect"
              icon="aliiconfont al-iconshoucang"
            >
              收藏
            </el-button>
          </div>
        </div>
        <div style="width: 36%; display: inline-block; vertical-align: top">
          <div><h3>房东</h3></div>
          <div>
            <el-avatar
              :size="100"
              src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
            ></el-avatar>
          </div>
          <div style="margin-top: 15x; margin-bottom: 15px;">
            gggg
            <span style="color: orange; font-size: 12px">（未认证）</span>
          </div>
          <el-button
            type="primary"
            @click="complaintVisible = true"
            icon="aliiconfont al-icontousu"
          >
            投诉
          </el-button>
        </div>
      </div>
    </div>
    <el-divider></el-divider>
    <div style="height: 50px; line-height: 50px">
      <span style="color: #d8703f; font-size: 36px"> 评论 </span>
      <el-button type="primary" @click="commentVisible = true">
        添加评论
      </el-button>
    </div>
    <div id="all">
      <div v-for="count in 4" :key="count">这是一条评论</div>
    </div>

    <el-dialog
      title="给房东留言"
      :visible.sync="leaveMessageVisible"
      width="30%"
    >
      <el-input
        type="textarea"
        :rows="10"
        placeholder="请输入内容"
        v-model="leaveMessageContent"
      >
      </el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="leaveMessageVisible = false">取 消</el-button>
        <el-button type="primary" @click="leaveMessageVisible = false">
          确 定
        </el-button>
      </span>
    </el-dialog>

    <el-dialog title="投诉房源" :visible.sync="complaintVisible" width="30%">
      <el-input
        type="textarea"
        :rows="10"
        placeholder="请输入内容"
        v-model="complaintContent"
      >
      </el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="complaintVisible = false">取 消</el-button>
        <el-button type="primary" @click="complaintVisible = false">
          确 定
        </el-button>
      </span>
    </el-dialog>

    <el-dialog title="评论" :visible.sync="commentVisible" width="30%">
      <el-input
        type="textarea"
        :rows="10"
        placeholder="请输入内容"
        v-model="commentContent"
      >
      </el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="commentVisible = false">取 消</el-button>
        <el-button type="primary" @click="commentVisible = false">
          确 定
        </el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      leaveMessageVisible: false,
      complaintVisible: false,
      commentVisible: false,
      leaveMessageContent: "",
      complaintContent: "",
      commentContent: "",
    };
  },
  methods: {
    collect() {
      console.log("collect");
    },
    goBack() {
      console.log("go back");
    },
  },
};
</script>

<style>
</style>