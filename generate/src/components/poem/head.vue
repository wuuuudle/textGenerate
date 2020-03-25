<template>
    <el-card v-loading="loading" class="back">
        <div slot="header" class="banner">
            <div class="banner_title">
                藏头诗
            </div>
            <div class="banner_info">
                依托唐宋诗词和对抗神经网络，生成具有意境的藏头诗
            </div>
        </div>
        <div class="catalog">
            <div class="catalog_l">
                <el-input
                        type="textarea"
                        placeholder="请输入四字词语"
                        v-model="textarea"
                        style="flex-grow: 1;background-color: rgba(0,0,0,0)">
                </el-input>
                <!--                <el-button style="width: 50%;background-color: rgba(255,255,255,0.3);" @click="getPoem(5)">五言绝句</el-button>-->
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
    import {getPoemByHeadWord} from "../../api/generator";

    export default {
        name: "head",
        data() {
            return {
                textarea: '',
                body: [],
                loading: false
            }
        },
        methods: {
            getPoem(length) {
                if (this.textarea.length !== 4) {
                    this.$message.error('请输入四字词语');
                    return;
                }
                this.loading = true;
                getPoemByHeadWord(this.textarea, length).then(response => {
                    let res = response.data;
                    if (res.status === 0) {
                        this.body = res.body;
                    } else {
                        this.$message.error(res.body[0]);
                    }
                    this.loading = false;
                });
            }
        },
        mounted() {
        }
    }
</script>

<style>
    .el-textarea__inner {
        height: 100%;
        background-color: rgba(255, 255, 255, 0.1);
        color: white;
        font-size: 16px;
    }

    .el-button {
        color: white;
    }

    .el-textarea__inner::-webkit-input-placeholder {
        color: white;
    }

    .poem {
        margin-top: 15px;
        font-size: 20px;
        color: white;
        letter-spacing: 5px;
    }

    .back {
        background-image: url("../../assets/back.jpg");
        background-size: cover;
        border: 0;
    }
</style>