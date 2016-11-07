# teac
Maven多模块SpringMVC+MyBatis

###comm模块：
基础的工具类

###master模块：
用户端的entity，dao，service

###organization模块
后台的entity，dao，service

###web模块
控制层和显示层

###未来
加入微信端和APP端

###依赖传递关系
comm -> master
comm -> organization
master -> organization
master -> web
organization -> web
