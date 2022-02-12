import VueRouter from "vue-router";
import HomePage from "../pages/HomePage"
import LoginPage from "../pages/LoginPage"
import ForgetPasswordPage from "../pages/ForgetPasswordPage"
import RegisterPage from "../pages/RegisterPage"
import HouseDetailPage from "../pages/HouseDetailPage"
import MyHousePage from "../pages/MyHousePage"
import UserSettingPage from "../pages/UserSettingPage"
import AdministratorPage from "../pages/AdministratorPage"

import SystemOpenSetting from "../pages/AdministratorPage/SystemOpenSetting";
import AdministratorManagement from "../pages/AdministratorPage/AdministratorManagement";
import UserManagement from "../pages/AdministratorPage/UserManagement"
import HouseManagement from "../pages/AdministratorPage/HouseManagement"
import UserAudit from "../pages/AdministratorPage/UserAudit"

import axios from "axios"

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '',
            component: HomePage,
        },
        {
            path: '/login',
            component: LoginPage,
            meta: {
                requireAuth: true,
            }
        },
        {
            path: '/register',
            component: RegisterPage
        },
        {
            path: '/house-detail',
            component: HouseDetailPage
        },
        {
            path: '/my-house',
            component: MyHousePage,
            meta: {
                requireUserAuth: true,
            }
        },
        {
            path: '/user-setting',
            component: UserSettingPage
        },
        {
            path: '/forget-password',
            component: ForgetPasswordPage
        },
        {
            path: '/administrator',
            component: AdministratorPage,
            props(route) {
                return {
                    activeIndex: route.fullPath
                }
            },
            children: [
                {
                    path: 'open-setting',
                    component: SystemOpenSetting,
                    meta: {
                        requireAdminAuth: true,
                    },
                },
                {
                    path: 'administrator-management',
                    component: AdministratorManagement,
                    meta: {
                        requireAdminAuth: true,
                    },
                },
                {
                    path: 'user-management',
                    component: UserManagement,
                    meta: {
                        requireAdminAuth: true,
                    },
                },
                {
                    path: 'house-management',
                    component: HouseManagement,
                    meta: {
                        requireAdminAuth: true,
                    },
                },
                {
                    path: 'user-audit',
                    component: UserAudit,
                    meta: {
                        requireAdminAuth: true,
                    },
                },
            ]

        }
    ]
})

//数据库设计没有考虑到token，现在用不到，先注释掉

// router.beforeEach((to, from, next) => {
//     if (to.meta.requireAdminAuth) {
//         if (!localStorage.getItem('admin_access_token')) {
//             next('/login')
//         }
//         else {
//             // 验证当前admin_access_token是否有效
//             axios.get('https://api.github.com/search/users?q=querryton').then(
//                 response => {
//                     // 如果有效，则转向admin主页面
//                     if (true) {
//                         next()
//                     }
//                     // 如果无效，则进入login界面，且丢弃当前admin_access_token
//                     else {
//                         localStorage.removeItem("admin_access_token");
//                         next('/login')
//                     }
//                 },
//                 error => {

//                 }
//             )
//         }
//     }
//     else if (to.meta.requireUserAuth) {
//         if (!localStorage.getItem('access_token')) {
//             next("/login")
//         } else {
//             // 验证当前access_token是否有效
//             axios.get('https://api.github.com/search/users?q=querryton').then(
//                 response => {
//                     // 如果有效，则前进
//                     if (true) {
//                         next()
//                     }
//                     // 如果无效，则进入login界面，且丢弃当前access_token
//                     else {
//                         localStorage.removeItem("access_token");
//                         next('/login')
//                     }
//                 },
//                 error => {

//                 }
//             )
//         }
//     }
//     else{
//         if (to.fullPath === "/login") {
//             if (!localStorage.getItem('access_token')) {
//                 next()
//             }
//             else {
//                 // 发送请求验证当前access_token是否有效
//                 axios.get('https://api.github.com/search/users?q=querryton').then(
//                     response => {
//                         // 如果有效，则转向主页面
//                         if (true) {
//                             next("/")
//                         }
//                         // 如果无效，则进入login界面，且丢弃当前access_token
//                         else {
//                             localStorage.removeItem("access_token");
//                             next()
//                         }
//                     },
//                     error => {

//                     }
//                 )
//             }
//         }
//         else if (to.fullPath === "/administrator") {
//             next("/administrator/open-setting")
//         }
//         else {
//             next()
//         }
//     }
// })

export default router