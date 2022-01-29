<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="房屋图片" width="280">
        <template slot-scope="scope">
          <el-image
            style="width: 100px; height: 100px"
            :src="scope.row.src"
          ></el-image>
        </template>
      </el-table-column>
      <el-table-column label="房屋简介">
        <template slot-scope="scope">
          <span style="font-size: 24px">
            {{ scope.row.city }}&nbsp;{{ scope.row.rooms }}
          </span>
          <p style="font-size: 10px; margin: 0; padding-top: 5px">
            {{ scope.row.rooms }}
          </p>
          <p style="font-size: 10px; margin: 0">{{ scope.row.city }}</p>
          <p style="font-size: 10px; margin: 0">{{ scope.row.description }}</p>
        </template>
      </el-table-column>
      <el-table-column label="房屋价格" width="300">
        <template slot-scope="scope">
          <div class="room-price" style="font-size: 24px; color: red">
            {{ scope.row.price }}元/月
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="300">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="editVisible = true"
            >编辑</el-button
          >
          <el-button type="danger" size="mini" @click="deleteHint">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="修改房屋信息" :visible.sync="editVisible" width="40%">
      <el-form label-position="right" label-width="100px">
        <el-form-item label="所在地址">
          <el-input v-model="editData.address"></el-input>
        </el-form-item>
        <el-form-item label="月租/元">
          <el-input type="number" v-model="editData.price"></el-input>
        </el-form-item>
        <el-form-item label="房屋类型">
          <el-input v-model="editData.type"></el-input>
        </el-form-item>
        <el-form-item label="房产证编号">
          <el-input v-model="editData.number"></el-input>
        </el-form-item>
        <el-form-item label="优劣">
          <el-input
            type="textarea"
            :rows="4"
            placeholder="请输入内容"
            v-model="editData.advance"
          >
          </el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editVisible = false">取 消</el-button>
        <el-button type="primary" @click="editVisible = false">
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
      editVisible: false,
      editData: {
        address: "",
        price: 0,
        type: "",
        number: "",
        advance: "",
      },
      tableData: [
        {
          src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          city: "佳木斯",
          rooms: "二室一厅",
          description: "有暖气",
          price: 2000,
        },
        {
          src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          city: "佳木斯",
          rooms: "二室一厅",
          description: "有暖气",
          price: 2000,
        },
        {
          src: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          city: "佳木斯",
          rooms: "二室一厅",
          description: "有暖气",
          price: 2000,
        },
      ],
    };
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
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
  },
};
</script>

<style>
</style>