var path = require('path')
module.exports = {
    build:{
        index: path.resolve(__dirname,'../frontend/index.html'),
        assetsRoot: path.resolve(__dirname,'../frontend'),
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        productionSourceMap:  true
    },
  

}
