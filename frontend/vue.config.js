module.exports = {
    lintOnSave: false,
    devServer: {
        proxy: {
            '/api': {
                target: 'http://172.19.241.36:8080',
                pathRewrite: { '^/api': '' }
            },
            '/test': {
                target: 'http://127.0.0.1:5000/ ',
                pathRewrite: { '^/test': '' }
            }
        }
    }
}