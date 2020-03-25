<template>
    <div style="display: flex;flex-direction: column;height: 100%">
        <el-menu :default-active="activeIndex"
                 mode="horizontal"
                 @select="handleSelect"
                 text-color="#000"
                 active-text-color="#000">
            <el-menu-item index="index">
                <el-image :src="require('../assets/logo.jpg')"
                          style="height: 60px;width: 180px"
                          fit="contain">
                </el-image>
            </el-menu-item>
            <el-submenu index="poem">
                <template slot="title">诗词</template>
                <el-menu-item index="headPoem">藏头诗</el-menu-item>
                <el-menu-item index="keywordPoem">意境诗</el-menu-item>
            </el-submenu>
            <el-menu-item index="textGen">
                文本生成
            </el-menu-item>
        </el-menu>
        <div style="flex-grow: 1">
            <router-view/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Main",
        data() {
            return {
                activeIndex: 'head'
            }
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
                this.$router.push(key);
            }
        },
        mounted() {
        }
    }
</script>

<style>
    .el-card {
        height: 100%;
        display: flex;
        flex-direction: column;
    }

    .el-card__header {
        padding: 0;
    }

    .el-card__body {
        height: 100%;
    }

    .banner {
        height: 400px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .banner_title {
        padding-bottom: 24px;
        font-size: 48px;
        letter-spacing: 5px;
        color: white;
    }

    .banner_info {
        width: 500px;
        margin: 0 auto;
        padding-bottom: 24px;
        font-size: 16px;
        line-height: 28px;
        color: white;
    }

    .catalog {
        /*background-image: url("../../assets/intro-common2.jpg");*/
        background-size: cover;
        height: 100%;
        display: flex;
        /*margin: 20px;*/
    }

    .catalog_l {
        width: 50%;
        display: flex;
        flex-direction: column;
        color: rgba(0, 0, 0, 0);
    }

    .catalog_r {
        width: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
</style>