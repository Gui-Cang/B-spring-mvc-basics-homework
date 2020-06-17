# Spring MVC Basics Homework

Homework for Spring MVC Basics

## 作业描述

用Spring MVC实现一个简单的注册登录功能，不用引入数据库，在内存中保存数据即可。
其中用户包含如下属性：ID、用户名、密码、邮箱

### 注册
注册接口：`POST http://localhost:8080/register`

要求：
- 注册时不传ID，由后台自动生成
- 用户名要求:长度为5到12位
- 密码要求:必须由字母，数字下划线组成，并且长度为5到12位
- 邮箱也要符合邮箱的格式

若注册时用户名不符合要求，则返回：
```json
{
  "code": 400,
  "message": "用户名不合法"
}
```
其中响应码与code字段一致，密码或邮箱不合法时同理

若注册时用户名已经存在，则返回：
```json
{
  "code": 400,
  "message": "用户已存在"
}
```

若注册成功则返回201,无响应体

### 登录
登录接口：`GET http://localhost:8080/login`

要求：
- 将用户名和密码作为请求参数(其实真实场景是放在请求体中)
- 用户名要求:长度为5到12位(同注册)
- 密码要求:必须由字母，数字下划线组成，并且长度为5到12位(同注册)

若登录时用户名不符合要求，则返回：
```json
{
  "code": 400,
  "message": "用户名不合法"
}
```
密码不合法时同理

若登录时，用户不存在或密码不正确，则返回
```json
{
  "code": 400,
  "message": "用户名或密码错误"
}
```

若登录成功则返回200，以及所有用户信息

## 作业要求

请同时提交各种报错情况和请求成功的截图