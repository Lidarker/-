import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const actions = {
    // jia(context,value){
    // 	context.commit('JIA',value)
    // },
}

const mutations = {
    UPDATE_TOKEN(state) {
        state.access_token = sessionStorage.getItem("access_token")
        state.admin_access_token = sessionStorage.getItem("admin_access_token")
    }
}

const state = {
    access_token: sessionStorage.getItem("access_token"),
    admin_access_token: sessionStorage.getItem("admin_access_token")
}

export default new Vuex.Store({
    actions,
    mutations,
    state,
})