# 🏥 医院药品管理系统

## 📌 项目简介
本项目是一个 **医院药品管理系统**，用于管理药品库存、销售记录、问题药品及保质期检查等功能。系统采用 **Spring Boot** 作为后端，**MyBatis Plus** 进行数据库操作，前端使用 **Layui** 进行界面交互。

## 🚀 功能模块
- **药品库存管理** 🏷️：登记出入库信息，管理药品库存
- **药品销售管理** 💰：记录药品销售信息，支持退货管理
- **问题药品管理** ⚠️：跟踪问题药品，防止使用不合格药品
- **药品保质期检查** ⏳：自动检查药品保质期，提醒即将过期药品

## 🛠️ 技术栈
- **后端**：Spring Boot + MyBatis Plus + Spring MVC
- **前端**：Layui + Thymeleaf
- **数据库**：MySQL
- **其他**：Shiro（用户权限管理）、Lombok、Maven

## 📦 快速启动
```bash
克隆项目
配置 application.yml 数据库信息
运行 Application.java
访问 http://localhost:8080
数据库脚本 spdrug.sql
