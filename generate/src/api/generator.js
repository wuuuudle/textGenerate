import http from './http'

export const getPoemByHeadWord = (keyword, length) => {
    return http.fetchPost('/api/headWord', {keyword, length});
};

export const getPoemByKeyWords = (keyword, length, style) => {
    return http.fetchPost('/api/keyWord', {keyword, length, style});
};

export const getParagraph = (theme) => {
    return http.fetchPost('/api/getParagraph', {theme});
};