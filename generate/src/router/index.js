import VueRouter from "vue-router";
import Vue from 'vue'

Vue.use(VueRouter);

const Head = () => import('../components/poem/head');
const KeyWord = () => import('../components/poem/keyword');
const Text = () => import('../components/text');
const Index = () => import('../components/index');

export default new VueRouter({
    routes: [
        {path: '/headPoem', component: Head},
        {path: '/keywordPoem', component: KeyWord},
        {path: '/textGen', component: Text},
        {path: '/index', component: Index},
        {path: '/', redirect: '/index'}
    ]
});