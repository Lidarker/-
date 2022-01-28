import Vue from 'vue'
import App from './App.vue'
import { Table, TableColumn, Button, Popover, Tag, Image, Link, Menu, Submenu, MenuItem, Row, Col, Input, Card } from 'element-ui'

import './assets/icon/iconfont.css'

Vue.config.productionTip = false

Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Button)
Vue.use(Popover)
Vue.use(Tag)
Vue.use(Image)
Vue.use(Link)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(Row)
Vue.use(Col)
Vue.use(Input)
Vue.use(Card)



new Vue({
  render: h => h(App),
}).$mount('#app')
