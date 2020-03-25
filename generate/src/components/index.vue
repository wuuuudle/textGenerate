<template>
    <el-card class="front">
        <div slot="header">
            <el-carousel indicator-position="outside" height="450px" style="width: 100%">
                <el-carousel-item v-for="item in banner" :key="item.path">
                    <div :style="item.url" class="shows">
                        {{item.texts}}
                        <el-button style="background-color: rgba(0,0,0,0);margin-top: 50px;color: white"
                                   @click="_click(item.path)">了解详情
                        </el-button>
                    </div>
                </el-carousel-item>
            </el-carousel>
        </div>
        <div style="display: flex;flex-direction: column;align-items: center">
            <div style="font-size: 25px;">
                项目简介
            </div>
            <div class="intro t1">
                <div style="font-size: 20px;color: white;padding-top: 30px">
                    现有研究不足
                </div>
                <div style="display: flex;flex-direction: row;align-items: center;height: 100%;margin-top: 20px">
                    <div class="essay">
                        <i class="el-icon-s-opportunity" style="font-size: 50px"></i>
                        <div class="details">
                            <div>
                                机器学习方法在对人类语言的学习仍然停留在文字符号表面，缺失写作的内在动因。
                            </div>
                        </div>
                    </div>
                    <div class="essay">
                        <i class="el-icon-s-custom" style="font-size: 50px"></i>
                        <div class="details">
                            <div>
                                人类在写作文本时，可以随时对文本的质量进行动态衡量，例如语义是否完整、语法是否正确、文章结构是否明晰以及想要表述的内容是否已经表达清楚等，但人工智能系统想要做到这些却十分困难。
                            </div>
                        </div>
                    </div>
                    <div class="essay">
                        <i class="el-icon-s-data" style="font-size: 50px"></i>
                        <div class="details">
                            <div>
                                深度学习技术在学术界和工业界都取得了巨大的突破，在文本生成领域也早有应用，但现有的深度模型普遍面向 30 字以内的短文本生成，而在长文本生成任务上还没有革命性的成果出现。100
                                字以上的长文本生成任务所面临的训练高度不可控、反向传播困难、模型难以收敛、计算能力和存储能力要求极高等问题都是短文本生成任务所没有的。
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="intro t2">
                <div style="font-size: 20px;color: white;padding-top: 30px">
                    模型优势
                </div>
                <div style="display: flex;flex-direction: row;align-items: center;height: 100%;margin-top: 20px">
                    <div class="essay">
                        <i class="el-icon-search" style="font-size: 50px"></i>
                        <div class="details">
                            <div>
                                在 LRGAN
                                中，我们将判别器的训练转换成学习排序的优化问题，判别器不再反馈二值信号，而是输出一串排位信息。具体来说，判别器将根据生成样本与真实样本排位分数进行排位，生成样本的排位将低于真实样本。因此，生成器的目的就是混淆判别器，使得生成样本的排位能够高于真实样本。
                            </div>
                        </div>
                    </div>
                    <div class="essay">
                        <i class="el-icon-money" style="font-size: 50px"></i>
                        <div class="details">
                            <div>
                                特征共享、任务分层的思想引入模型。具体地说，判别器将提取到的语义特征传递给生成器，使得生成器有了文本语义层面的指导。在模型训练阶段，本文采用强化学习中的策略梯度方法，以解决GAN模型的不可微分问题。判别器将真实数据和生成数据进行排位，能够有效地分辨高质量的文本，从而指导生成器更好地进行优化。
                            </div>
                        </div>
                    </div>
                    <div class="essay">
                        <i class="el-icon-reading" style="font-size: 50px"></i>
                        <div class="details">
                            <div>
                                特征共享、任务分层的引入也使得判别器学习到的文本特征传递给了生成器，同样帮助生成器生成高质量文本。
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </el-card>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {
                banner: [
                    {
                        url: "background-image: url('" + require('../assets/back.jpg') + "')",
                        texts: '藏头诗',
                        path: 'headPoem'
                    },
                    {
                        url: "background-image: url('" + require('../assets/back2.jpg') + "')",
                        texts: '意境诗',
                        path: 'keywordPoem'
                    },
                    {
                        url: "background-image: url('" + require('../assets/back3.jpg') + "')",
                        texts: '文本生成',
                        path: 'textGen'
                    },
                ]
            }
        },
        methods: {
            _click(key) {
                this.$router.push(key);
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
    .shows {
        height: 450px;
        background-size: cover;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        padding-bottom: 24px;
        font-size: 48px;
        letter-spacing: 5px;
        color: white;
    }

    .front {
        border: 0;
    }

    .el-card__header {
        padding: 0;
    }

    .intro {
        background-size: cover;
        width: 90%;
        height: 400px;
        margin-top: 30px;
        display: flex;
        flex-direction: column;
        max-width: 1400px;
    }

    .t1 {
        background-image: url("../assets/intro.png");
    }

    .t2 {
        background-image: url("../assets/timg.jpg");
    }

    .essay {
        width: 100%;
        color: white;
        padding: 10px;
        height: 100%;
        display: flex;
        flex-direction: column;
    }

    .details {
        height: 100%;
        display: flex;
        align-items: center;
    }
</style>