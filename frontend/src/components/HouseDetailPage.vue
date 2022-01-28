<template>
  <div class="detail-info">
    <div class="static-detail-info">
      <h2>佳木斯&nbsp;二室一厅</h2>
      <el-carousel height="300px" style="width: 40%; display: inline-block">
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

      <div style="width: 35%; display: inline-block">
        <div><span>2000&nbsp;元/月</span></div>
        <div>
          <span>房屋类型：二室一厅</span>
        </div>

        <div>
          <span>详细地址：佳木斯 </span>
        </div>
        <div>
          <span>房屋优势：有暖气 </span>
        </div>
        <div>
          <span>房屋描述：佳木斯二室一厅2000有暖气 </span>
        </div>
        <div>
          <el-button
            type="warning"
            @click="leaveMessageVisible = true"
            icon="aliiconfont al-iconliuyan"
          >
            留言
          </el-button>
          <el-button
            type="danger"
            @click="collectVisible = true"
            icon="aliiconfont al-iconshoucang"
          >
            收藏
          </el-button>
        </div>
      </div>
      <div
        class="static-detail-info-host"
        style="width: 20%; display: inline-block"
      >
        <div><h3>房东</h3></div>
        <div>
          <el-avatar
            :size="100"
            src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
          ></el-avatar>
        </div>
        <div>
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

    <el-dialog title="提示" :visible.sync="leaveMessageVisible" width="30%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="leaveMessageVisible = false">取 消</el-button>
        <el-button type="primary" @click="leaveMessageVisible = false">
          确 定
        </el-button>
      </span>
    </el-dialog>

    <el-dialog title="提示" :visible.sync="collectVisible" width="30%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="collectVisible = false">取 消</el-button>
        <el-button type="primary" @click="collectVisible = false">
          确 定
        </el-button>
      </span>
    </el-dialog>

    <el-dialog title="提示" :visible.sync="complaintVisible" width="30%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="complaintVisible = false">取 消</el-button>
        <el-button type="primary" @click="complaintVisible = false">
          确 定
        </el-button>
      </span>
    </el-dialog>

    <div>
      <button class="upload-room-buttom" onclick="showAddModel()">
        添加评论
      </button>
    </div>

    <div class="dynamic-detail-info" style="height: 100px">
      <span style="color: #d8703f; margin: 10px 50px; font-size: 36px">
        评论
      </span>
      <div class="comment"></div>
    </div>

    <div id="all">
      <div id="back">
        <div id="comment"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      leaveMessageVisible: false,
      collectVisible: false,
      complaintVisible: false,
    };
  },
};
</script>

<style>
</style>