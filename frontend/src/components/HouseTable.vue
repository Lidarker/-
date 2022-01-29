<template>
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
  </el-table>
</template>

<script>
export default {
  data() {
    return {
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
  },
};
</script>

<style>
</style>