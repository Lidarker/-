module.exports = {
    lintOnSave: false,
    devServer: {
        proxy: {
            '/api': {
                target: 'http://172.19.241.36:8080',
                pathRewrite: { '^/api': '' }
            },
            '/temp': {
                target: 'https://jsonplaceholder.typicode.com',
                pathRewrite: { '^/temp': '' }
            }
        }
    }
}