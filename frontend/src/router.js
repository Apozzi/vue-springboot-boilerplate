import Vue from 'vue'
import Router from 'vue-router'
import store from './store'

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [
        { 
            path: '/', 
            component: () => import('@/pages/Hello.vue')
        },
        { 
            path: '/products', 
            name: "products", 
            component: () => import('@/pages/ProductPages/Products.vue')
        },
        { 
            path: '/product', 
            name: "product", 
            component: () => import('@/pages/ProductPages/Product.vue')
        },
        { 
            path: '/stock-movements',
            name: "stock-movements", 
            component: () => import('@/pages/StackMovementPages/StockMovements.vue')
        },
        { 
            path: '/stock-movement',
            name: "stock-movement", 
            component: () => import('@/pages/StackMovementPages/StockMovement.vue')
        },
        { 
            path: '/search-products-by-type',
            name: "search-products-by-type", 
            component: () => import('@/pages/AdvancedSearchPages/ProductsByType.vue')
        },
        { 
            path: '/search-profit-by-product',
            name: "search-profit-by-product", 
            component: () => import('@/pages/AdvancedSearchPages/ProfitByProduct.vue')
        },
        { 
            path: '/login',
            name: "login",
            component: () => import('@/pages/LoginPages/Login.vue')
        },
        {
            path: '/protected',
            component: () => import('@/pages/LoginPages/Protected.vue'),
            meta: {
                requiresAuth: true
            }
        },
        { 
            path: '/user',
            name: "user",
            component: () => import('@/pages/User.vue')
        },
        { path: '*', redirect: '/' }
    ]
});

router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        if (!store.getters.isLoggedIn) {
            next({
                path: '/login'
            })
        } else next();
        
    } else next();
});

export default router;