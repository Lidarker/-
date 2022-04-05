import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
import VueRouter from 'vue-router'
import {
  Table, TableColumn,
  Button,
  Popover,
  Tag,
  Image,
  Link,
  Menu,
  Submenu, MenuItem,
  Row, Col,
  Input,
  Card,
  Form, FormItem,
  Carousel, CarouselItem,
  Avatar,
  Dialog,
  PageHeader,
  Divider,
  Dropdown, DropdownMenu, DropdownItem,
  Breadcrumb, BreadcrumbItem,
  Container, Header, Aside, Main,
  Switch,
  TimePicker,
  Select, Option,
  CheckboxGroup, Checkbox,
  Tooltip,
  MessageBox,
  Message,
  Upload
} from 'element-ui'

import './assets/icon/iconfont.css'
import store from './store'
import router from './router'

Vue.config.productionTip = false

Vue.use(VueRouter)

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
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Avatar)
Vue.use(Dialog)
Vue.use(PageHeader)
Vue.use(Divider)
Vue.use(Dropdown)
Vue.use(DropdownMenu)
Vue.use(DropdownItem)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Switch)
Vue.use(TimePicker)
Vue.use(Select)
Vue.use(Option)
Vue.use(CheckboxGroup)
Vue.use(Checkbox)
Vue.use(Tooltip)
Vue.use(Upload)

Vue.prototype.$prompt = MessageBox.prompt
Vue.prototype.$message = Message

new Vue({
  render: h => h(App),
  store,
  router,
  beforeCreate(){
    Vue.prototype.$bus=this
  }
}).$mount('#app')
