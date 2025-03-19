/*
 Navicat Premium Data Transfer

 Source Server         : 阿巴阿巴
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : spdrug

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 09/01/2024 19:34:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for druginfo
-- ----------------------------
DROP TABLE IF EXISTS `druginfo`;
CREATE TABLE `druginfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `producttime` datetime(0) NULL DEFAULT NULL COMMENT '生产日期',
  `warrenty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保质期(月)',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `price` float(20, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of druginfo
-- ----------------------------
INSERT INTO `druginfo` VALUES (1, '感冒灵', '哈药六厂', '2024-01-05 16:00:00', '12', '1001', 15.58, 99);
INSERT INTO `druginfo` VALUES (5, '柴胡口服液', '哈药六厂', '2024-01-05 16:00:00', '24', '1002', 10.50, 100);
INSERT INTO `druginfo` VALUES (6, '莲花清瘟胶囊', '哈药六厂', '2024-01-05 16:00:00', '24', '1003', 11.50, 100);
INSERT INTO `druginfo` VALUES (7, '阿莫西林胶囊', '哈药六厂', '2024-01-05 16:00:00', '24', '1004', 13.00, 100);
INSERT INTO `druginfo` VALUES (8, '板兰根', '哈药六厂', '2024-01-05 16:00:00', '24', '1005', 15.00, 100);
INSERT INTO `druginfo` VALUES (9, '三九感冒灵', '哈药六厂', '2024-01-05 16:00:00', '24', '1006', 16.00, 100);
INSERT INTO `druginfo` VALUES (10, '三黄片', '哈药六厂', '2024-01-05 16:00:00', '24', '1007', 17.00, 100);
INSERT INTO `druginfo` VALUES (11, '清火片', '哈药六厂', '2024-01-05 16:00:00', '24', '1008', 19.00, 100);
INSERT INTO `druginfo` VALUES (12, '云南白药喷雾', '云南白药', '2024-01-05 16:00:00', '24', '1009', 22.00, 200);
INSERT INTO `druginfo` VALUES (13, '云南白药贴', '云南白药', '2024-01-05 16:00:00', '24', '1010', 100.00, 100);
INSERT INTO `druginfo` VALUES (14, '消炎镇痛贴', '哈药六厂', '2024-01-05 16:00:00', '24', '1011', 24.00, 100);
INSERT INTO `druginfo` VALUES (15, '跌打损伤膏药', '云南白药', '2024-01-05 16:00:00', '12', '1012', 120.00, 100);

-- ----------------------------
-- Table structure for owinfo
-- ----------------------------
DROP TABLE IF EXISTS `owinfo`;
CREATE TABLE `owinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库/入库',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of owinfo
-- ----------------------------
INSERT INTO `owinfo` VALUES (2, '感冒灵', '入库', 11, '赵顺', '2024-01-05 09:27:38');
INSERT INTO `owinfo` VALUES (7, '三九感冒灵', '入库', 10, '张立飞', '2024-01-05 01:41:10');
INSERT INTO `owinfo` VALUES (8, '柴胡口服液', '出库', 10, '赵顺', '2024-01-06 08:49:23');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dcount` int(0) NULL DEFAULT NULL COMMENT '问题药品数量',
  `dprice` float(20, 2) NULL DEFAULT NULL COMMENT '药品单价',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题原因',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '问题药品' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (1, '三九感冒灵', 11, 40.00, '有破包现象', '2024-01-05 06:46:45');
INSERT INTO `problem` VALUES (4, '感冒灵', 10, 30.00, '药品露药', '2024-01-06 08:48:28');
INSERT INTO `problem` VALUES (5, '感冒灵', 25, 2.50, '包治百病', '2024-01-07 07:10:00');

-- ----------------------------
-- Table structure for returngoods
-- ----------------------------
DROP TABLE IF EXISTS `returngoods`;
CREATE TABLE `returngoods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货药品名称',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收到退货' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of returngoods
-- ----------------------------
INSERT INTO `returngoods` VALUES (2, '柴胡口服液', 10, '42.0420', 10.00, '2024-01-08 16:00:00');

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编号',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '金额',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operatetime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of saleinfo
-- ----------------------------
INSERT INTO `saleinfo` VALUES (1, '感冒灵', '1001', 1, 30.00, '赵顺', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (11, '柴胡口服液', '1002', 10, 300.00, '王一兵', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (12, '莲花清瘟胶囊', '1003', 30, 400.00, '张立飞', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (13, '阿莫西林胶囊', '1004', 20, 13.00, '黄晓雨', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (14, '感冒灵', '1005', 10, 15.00, '简向奎', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (15, '三九感冒灵', '1006', 20, 16.00, '毕树鸿', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (16, '三黄片', '1007', 20, 16.00, '赵顺', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (17, '清火片', '1008', 10, 19.00, '王一兵', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (18, '云南白药喷雾', '1009', 30, 19.00, '简向奎', '2024-01-05 16:00:00');
INSERT INTO `saleinfo` VALUES (21, '感冒灵', '1010', 10, 10.00, '张立飞', '2024-01-08 16:00:00');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商描述',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '哈药六厂', '东北很知名的企业之儿', '2024-01-05 16:18:07');
INSERT INTO `supplier` VALUES (3, '云南白药', '云南白药是云南著名的中成药，由云南民间医生曲焕章于1902年研制成功。对跌打损伤、创伤出血有很好的疗效。云南白药由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。', '2024-01-05 10:20:30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123');
INSERT INTO `user` VALUES (2, 'zhangsan', '123');

SET FOREIGN_KEY_CHECKS = 1;
