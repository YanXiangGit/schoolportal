/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : xjtmgcxy

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-12-03 17:31:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_jsdy
-- ----------------------------
DROP TABLE IF EXISTS `base_jsdy`;
CREATE TABLE `base_jsdy` (
  `jsbh` varchar(255) NOT NULL,
  `jsmc` varchar(255) DEFAULT NULL,
  `gxsj` date DEFAULT NULL,
  `gxr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jsbh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of base_jsdy
-- ----------------------------
INSERT INTO `base_jsdy` VALUES ('1001', '系统管理员', '2018-12-03', '系统管理员');

-- ----------------------------
-- Table structure for base_jsgn
-- ----------------------------
DROP TABLE IF EXISTS `base_jsgn`;
CREATE TABLE `base_jsgn` (
  `jsbh` varchar(255) DEFAULT NULL,
  `gnxbh` varchar(255) DEFAULT NULL,
  `gxsj` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of base_jsgn
-- ----------------------------
INSERT INTO `base_jsgn` VALUES ('1001', 'XTGL', '2018-12-03');
INSERT INTO `base_jsgn` VALUES ('1001', 'XTGL01', '2018-12-03');
INSERT INTO `base_jsgn` VALUES ('1001', 'XTGL02', '2018-12-03');

-- ----------------------------
-- Table structure for base_xtgn
-- ----------------------------
DROP TABLE IF EXISTS `base_xtgn`;
CREATE TABLE `base_xtgn` (
  `gnxbh` varchar(255) NOT NULL,
  `gnxmc` varchar(255) DEFAULT NULL,
  `px` int(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sjgnbh` varchar(255) DEFAULT NULL,
  `cdjb` varchar(255) DEFAULT NULL,
  `tp` varchar(255) DEFAULT NULL,
  `zt` varchar(1) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  `gxsj` date DEFAULT NULL,
  PRIMARY KEY (`gnxbh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of base_xtgn
-- ----------------------------
INSERT INTO `base_xtgn` VALUES ('XTGL', '系统管理', '1', ' ', null, '1', null, '1', null, '2018-12-03');
INSERT INTO `base_xtgn` VALUES ('XTGL01', '用户管理', '1', ' ', 'XTGL', '2', null, '1', null, '2018-12-03');
INSERT INTO `base_xtgn` VALUES ('XTGL02', '用户管理', '2', ' ', 'XTGL', '2', '', '1', '', '2018-12-03');

-- ----------------------------
-- Table structure for base_yh
-- ----------------------------
DROP TABLE IF EXISTS `base_yh`;
CREATE TABLE `base_yh` (
  `yhbh` varchar(32) NOT NULL COMMENT '用户ID',
  `dlmc` varchar(255) NOT NULL COMMENT '登录名称',
  `yhmc` varchar(255) NOT NULL COMMENT '用户名称',
  `yhlx` varchar(255) NOT NULL COMMENT '用户类型',
  `mm` varchar(255) NOT NULL COMMENT '密码',
  `bmbm` varchar(255) NOT NULL COMMENT '部门编码',
  `bmmc` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `sfzmhm` varchar(255) DEFAULT NULL COMMENT '身份证明号码',
  `sjhm` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `lxdh` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `dzyx` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `yhzt` varchar(1) DEFAULT NULL COMMENT '用户状态',
  `bz` varchar(255) DEFAULT NULL COMMENT '备注',
  `gxsj` date DEFAULT NULL COMMENT '更新时间',
  `gxr` varchar(255) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`yhbh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of base_yh
-- ----------------------------
INSERT INTO `base_yh` VALUES ('1001', 'admin', '管理员', '1', 'admin', '00', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_yhqx
-- ----------------------------
DROP TABLE IF EXISTS `base_yhqx`;
CREATE TABLE `base_yhqx` (
  `yhbh` varchar(255) DEFAULT NULL,
  `jsbh` varchar(255) DEFAULT NULL,
  `gxsj` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_yhqx
-- ----------------------------
INSERT INTO `base_yhqx` VALUES ('1001', '1001', '2018-12-03');
