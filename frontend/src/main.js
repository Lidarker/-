import Vue from 'vue'
import App from './App.vue'
import { 
  Table, TableColumn, 
  Button, 
  Popover, 
  Tag, 
  Image, 
  Link, 
  Menu, 
  Submenu, MenuItem, 
  Row, 
  Col, 
  Input, 
  Card, 
  Form, FormItem, 
  Carousel, CarouselItem, 
  Avatar,
  Dialog
} from 'element-ui'

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
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.use(Avatar)
Vue.use(Dialog)

new Vue({
  render: h => h(App),
}).$mount('#app')
