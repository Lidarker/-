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

router.beforeEach((to, from, next) => {
    if (to.meta.requireAdminAuth) {
        if (!sessionStorage.getItem('admin_access_token')) {
            next('/login')
        }
        else {
            next()
        }
    }
    else if (to.meta.requireUserAuth) {
        if (!sessionStorage.getItem('access_token')) {
            next("/login")
        } else {
            next()
        }
    }
    else{
        if (to.fullPath === "/login") {
            if (!sessionStorage.getItem('access_token')) {
                next()
            }
            else {
                next("/")
            }
        }
        else if (to.fullPath === "/administrator") {
            next("/administrator/open-setting")
        }
        else {
            next()
        }
    }
})

export default router