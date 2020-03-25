<template>
    <el-card v-loading="loading" class="back3">
        <div slot="header" class="banner">
            <div class="banner_title">
                文本生成
            </div>
            <div class="banner_info">
                依托互联网海里数据和对抗神经网络，构建的一个长文本生成模型。
            </div>
        </div>
        <div class="catalog1">
            <div style="display:flex;margin-bottom: 20px">
                <el-input
                        placeholder="请输入主题"
                        v-model="textarea"
                        style="background-color: rgba(255,255,255,0.1);color: white">
                </el-input>
                <el-button @click="_getParagraph"
                           style="margin-left: 10px;background-color: rgba(255,255,255,0.1);color: white">生成
                </el-button>
            </div>
            <el-input type="textarea" v-model="text" :rows="30" disabled></el-input>
        </div>
    </el-card>
</template>

<script>
    import {getParagraph} from "../api/generator";

    export default {
        name: "text",
        data() {
            return {
                loading: false,
                textarea: '一天掉多少根头发',
                text: ''
            }
        },
        methods: {
            _getParagraph() {
                this.loading = true;
                getParagraph(this.textarea).then(response => {
                    this.loading = false;
                    this.text = response.data.text;
                });
            }
        },
        beforeRouteEnter(to, from, next) {
            next();
            if (from.path !== '/')
                location.reload();
        }
    }
</script>

<style>
    .el-card__body {
        height: 100%;
    }

    .back3 {
        background-image: url("../assets/back3.jpg");
        background-size: cover;
        border: 0;
    }

    .el-input__inner {
        background-color: rgba(255, 255, 255, 0.1);
        color: white;
    }

    .catalog1 {
        display: flex;
        flex-direction: column;
    }

    .el-textarea.is-disabled {
        color: white;
    }

    .el-textarea.is-disabled .el-textarea__inner {
        background-color: rgba(255, 255, 255, 0.1);
        color: white;
        font-size: 18px;
    }
</style>