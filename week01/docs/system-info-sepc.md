# api/system/info接口开发规范

## 1.核心目标

- ```javascript
  开发一个 system/info 接口，返回应用信息
  ```

## 2.业务规划

- 接口路径 ： GET   api/system/info
- 无需请求参数
- 返回JSON，包含code、msg、data三个字段
- code 固定为 200 ，表示成功
- msg  固定为 “success"
- data 应用信息

## 3.接口概述

- 使用 spring Boot 3.5.11
- 使用 Java 17
- 端口默认8080
- 返回类型使用统一包装类ResultVO<String>

## 4.输入输出

### 4.1输入

- 无请求体，无查询参数

### 4.2输出

- 成功示例：

  ```
  {
    "code": 200,
    "msg": "success",
    "data": {
      "projectName": "hello-sample",
      "version": "0.0.1-SNAPSHOT",
      "serverTime": "2026-03-05 22:35:10",
      "status": "RUNNING",
      "javaVersion": "17.0.17",
      "springBootVersion": "3.5.11",
      "environment": "default"
    }
  }
  ```

  
