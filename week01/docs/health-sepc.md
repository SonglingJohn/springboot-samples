# api/health接口开发规范

## 1.核心目标

- 开发出一个health接口，返回项目名称版本号、当前服务器时间、运行状态





## 2.业务规划

- 接口路径 ： GET/api/health
- 无需请求参数
- 返回JSON，包含code、msg、data 三个字段
- code固定为200，表示成功

- msg 固定为 “success"
- data 为Health 类的对象包含项目名称、版本号、当前服务器时间、运行状态



## 3.技术约束

- 使用 spring Boot 3.5.11
- 使用 Java 17
- 端口默认8080
- 返回类型使用统一包装类ResultVO

## 4.输入输出

### 4.1 输入

- 无请求体，无查询参数

### 4.2输出

- 成功示例：

  ```
  {
    "code": 200,          // 接口响应状态码（200 表示成功）
    "msg": "success",     // 接口响应提示信息
    "data": {             // Health 类对象的核心数据
      "projectName": "springboot-samples",  // 项目名称（自定义，和你的仓库/项目名一致）
      "version": "4.0.3",                   // 版本号（对应项目的版本，如 Spring Boot 版本/业务版本）
      "serverTime": "2026-03-05 15:30:25",  // 当前服务器时间（格式化的字符串，便于阅读）
      "status": "RUNNING"                   // 运行状态（枚举值，如 RUNNING/STOPPED/ERROR）
    }
  }
  ```

  

