使用前先修改 src/main/resources/application.yml 中的数据库登录信息

如果需要使用mybatis-generator插件，需要修改 src/main/resources/generatorConfig.xml 中的
1.classPathEntry属性  数据库驱动包
2.jdbcConnection属性  数据库连接信息
3.table属性 需要生成的数据库表，若不注释掉则会进行覆盖
