# api/hello接口开发规范

## 1.核心目标

- ```javascript
  开发一个 Hello 接口，返回统一格式的欢迎信息，用于验证 Spring Boot 项目的基本配置是否正确。
  ```

## 2.业务规划

- 接口路径 ： GET   /api/hello

- 无需请求参数

- 返回JSON，包含code、msg、data三个字段

- code 固定为 200 ，表示成功

- msg  固定为 “success"

- data 为欢迎语字符串 例如”Hello , SpringBoot“

  ## 

## 3.技术约束

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
    "data": "Hello Spring Boot"
  }
  ```

  