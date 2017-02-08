#AJAX
ajax(asynchronous javascript and xml),异步的js和xml
###ajax是什么？
是一种改善用户体验的技术，其实质是利用浏览器内置的一个对象（ajax对象）异步的向服务器发送请求，服务器返回部分数据。

###如何获取ajax对象（要区分浏览器）
    
    function getXhr(){
        var xhr = null;
        if(window.XMLHttpRequest){
            xhr = new XMLHttpRequest();
        }else{
            xhr = new ActiveXObject("MicroSoft.XMLHttp");
        }
        return xhr;
    }
    
###ajax重要的属性
1. onreadystatechange:绑定事件处理函数（处理readystatechange事件）<br/>
注：当ajax对象的readyState值发生改变，就会产生readystatechange事件
2. readyState：有五个值（0，1，2，3，4），表示ajax对象与服务器通信的状态。4表示ajax对象已经获取了服务器返回的所有对象。
3. responseText：服务器返回的文本数据
4. responseXML：服务器返回的xml数据
5. status：服务器返回的状态码

###步骤
+ 获取ajax对象。
+ 利用ajax发送请求
    1. 发送get请求: 
     `xhr.open('get','check_username.do?username=Tom',true);`
     `xhr.onreadystatechange=f1;`
     `xhr.send(null);`
     注：
        第一个参数：请求方式
        第二个参数：请求地址，如果是get请求，请求参数添加到请求地址后边。
        第三个参数：如果是true，表示异步。如果是false，表示同步（浏览器会锁定当前页面）。
    2. 发送post请求
        `xhr.open('post','check_uname.do',true);`
        `xhr.setRequestHeader('content-type','application');`
        `xhr.send('username=Tom');`
     注：
        - 请求参数放到send方法里
        - 阿法
+ 编写服务器端代码。

###ajax乱码问题
1. post请求
    - 出现原因：浏览器提供的ajax对象在发送post请求时，会对中文参数使用utf-8来编码，而服务器端默认的编码是iso-8859-1来解码
    - 解决办法：request.setCharacterEncoding("utf-8");
    
2. get请求
    - 出现原因：ie提供的ajax对象在发送get请求时，会对中文参数使用gbk来编码，而其他浏览器会使用utf-8。服务器端默认iso-8859-1来解码。
    - 解决办法：修改服务器端的配置，用指定的字符集来解码。
        1. 比如修改tomcat配置文件。但IE浏览器不支持。
        2. encodeURI(uri)。IE浏览器也支持
    
#JSON
###数据交换
###轻量级
相对于XML，json更轻量
###语法
1. 表示一个对象（属性名：属性值，属性名：属性值）
注意：
    + 属性名必须使用双引号
    + 属性值可以是string，number,boolean,object,null
    + 属性必须是String
2. 表示一个对象数组
[{},{}]

###如何将java对象转换为json字符串
通过使用json官方的工具（比如json-lib）。

#JQuery对ajax的支持
### $.ajax函数
用法：`$.ajax({});`
注：{}是一个描述选项参数的对象，常用的选项参数有以下这些：    

+ url：请求地址
+ data：请求参数，有两种格式：
    第一种格式是请求字符串的形式，比如`username=Tom&age=22`。
    第二种是对象的形式`{'username':'Tom','age':22}`。
+ type:请求方式
+ dataType:指定服务器返回的数据类型，常见的有text(文本),html(html文本),json,xml,javascript
+ success:是一个函数，用来处理服务器返回的数据
###load函数
用法:`$obj.load(url,[data]);`
注：$obj:要操作的节点
url:请求地址
data:请求参数 (格式同上)

    
