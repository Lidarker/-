import VueRouter from "vue-router";
import HomePage from "../pages/HomePage"
import LoginPage from "../pages/LoginPage"
import ForgetPasswordPage from "../pages/ForgetPasswordPage"
import RegisterPage from "../pages/RegisterPage"
import HouseDetailPage from "../pages/HouseDetailPage"
import MyHousePage from "../pages/MyHousePage"
import UserSettingPage from "../pages/UserSettingPage"
import AdministratorPage from "../pages/AdministratorPage"

import SystemOpenSetting from "../components/SystemOpenSetting";
import AdministratorManagement from "../components/AdministratorManagement";
import UserManagement from "../components/UserManagement"
import HouseManagement from "../components/HouseManagement"
import UserAudit from "../components/UserAudit"



const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '',
            component: HomePage,
        },
        {
            path: '/login',
            component: LoginPage
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
                requireAuth: true,
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

                },
                {
                    path: 'administrator-management',
                    component: AdministratorManagement,

                },
                {
                    path: 'user-management',
                    component: UserManagement,

                },
                {
                    path: 'house-management',
                    component: HouseManagement,

                },
                {
                    path: 'user-audit',
                    component: UserAudit,
                },
            ]

        }
    ]
})



//全局前置守卫：初始化时执行、每次路由切换前执行
router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) { //判断当前路由是否需要进行权限控制
        if (localStorage.getItem('access_token')) { //权限控制的具体规则
            next()
        } else {
            next("/login")
        }

    } else {
        next() //放行
    }
})

export default router