import axios from 'axios'
import qs from 'querystring'

axios.defaults.baseURL = "/text/";
// axios.defaults.baseURL = "http://localhost:8088/";
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charse=UTF-8';

export default {
    fetchGet(url, params = {}) {
        return new Promise((resolve, reject) => {
            axios.get(url, params).then(res => {
                resolve(res)
            }).catch(error => {
                reject(error)
            })
        })
    },
    fetchPost(url, params = {}) {
        return new Promise((resolve, reject) => {
            axios.post(url, qs.stringify(params)).then(res => {
                resolve(res)
            }).catch(error => {
                reject(error)
            })
        })
    },
}