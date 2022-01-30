import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const actions = {
    // jia(context,value){
    // 	context.commit('JIA',value)
    // },
}

const mutations = {
    // JIA(state,value){
    // 	state.sum += value
    // }
}

const state = {
    isLogin: false,
}

export default new Vuex.Store({
    actions,
    mutations,
    state,
})