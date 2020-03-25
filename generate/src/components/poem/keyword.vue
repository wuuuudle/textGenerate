<template>
    <el-card v-loading="loading" class="back2">
        <div slot="header" class="banner">
            <div class="banner_title">
                意境诗
            </div>
            <div class="banner_info">
                依托唐宋诗词和对抗神经网络，选择意境，生成诗词
            </div>
        </div>
        <div class="catalog">
            <div class="catalog_l">
                <div style="text-align: left;margin-bottom: 10px;color: white;">选择意境：
                </div>
                <el-radio-group v-model="style" size="small">
                    <el-radio-button v-for="item in theme" :key="item.index" :label="item.index">
                        {{item.text}}
                    </el-radio-button>
                </el-radio-group>
                <el-input
                        type="textarea"
                        placeholder="请输入关键词，关键词以空格分割"
                        v-model="textarea"
                        style="flex-grow: 1;background-color: rgba(0,0,0,0)">
                </el-input>
                <el-button-group style="width: 100%;background-color: rgba(0,0,0,0)">
                    <el-button style="width: 50%;background-color: rgba(255,255,255,0.1);" @click="getPoem(5)">五言绝句
                    </el-button>
                    <el-button style="width: 50%;background-color: rgba(255,255,255,0.1);" @click="getPoem(7)">七言绝句
                    </el-button>
                </el-button-group>
            </div>
            <div class="catalog_r">
                <div v-for="i in body" :key="i" class="poem">{{i}}</div>
            </div>
        </div>
    </el-card>
</template>

<script>
    import {getPoemByKeyWords} from "../../api/generator";

    export default {
        name: "keyword",
        data() {
            return {
                loading: false,
                body: '',
                theme: [{text: '萧瑟凄凉', index: 0},
                    {text: '忆旧感喟', index: 1},
                    {text: '孤寂惆怅', index: 2},
                    {text: '思乡忧老', index: 3},
                    {text: '渺远孤逸', index: 4}],
                style: 0,
                textarea: '',
            }
        },
        methods: {
            getPoem(length) {
                if (this.textarea === '') {
                    this.$message.error('请输入关键词');
                    return;
                }
                this.loading = true;
                getPoemByKeyWords(this.textarea, length, this.style).then(response => {
                    this.body = response.data.body;
                    this.loading = false;
                });
            }
        },
        mounted() {

        }
    }
</script>

<style>
    .back2 {
        background-image: url("../../assets/back2.jpg");
        background-size: cover;
        border: 0;
    }

    .el-button {
        color: white;
    }

    .el-radio-button__inner {
        background-color: rgba(255, 255, 255, 0.1);
        border-color: white;
        color: white;
    }

    .el-textarea__inner {
        height: 100%;
        background-color: rgba(255, 255, 255, 0.1);
        color: white;
        font-size: 16px;
    }

    .el-textarea__inner::-webkit-input-placeholder {
        color: white;
    }

    .el-radio-button__inner:hover {
        color: rgba(255, 255, 255, 0.5);
    }

    .el-radio-button__orig-radio:checked + .el-radio-button__inner {
        background-color: rgba(255, 255, 255, 0.5);
        border-color: white;
    }

    .poem {
        margin-top: 15px;
        font-size: 20px;
        color: white;
        letter-spacing: 5px;
    }
</style>