<template>
  <div style="margin-top: 10%">
    <div>
      系统开关
      <el-switch
        v-model="systemSwitch"
        active-color="#13ce66"
        inactive-color="#ff4949"
      ></el-switch>
    </div>
    <div>
      开始
      <el-time-picker
        v-model="startTime"
        :picker-options="{
          selectableRange: '00:00:00 - 23:59:59',
        }"
        placeholder="任意时间点"
      >
      </el-time-picker>
    </div>
    <div>
      结束
      <el-time-picker
        v-model="endTime"
        :picker-options="{
          selectableRange: '00:00:00 - 23:59:59',
        }"
        placeholder="任意时间点"
      >
      </el-time-picker>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      systemSwitch: true,
      startTime: new Date(''),
      endTime: new Date(''),
    };
  },
};
</script>

<style>
</style>