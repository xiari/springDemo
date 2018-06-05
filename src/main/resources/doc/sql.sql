DROP SCHEMA `student_manager` IF EXISTS ;
CREATE SCHEMA `student_manager` ;

DROP TABLE `student_manager`.`student_tbl` IF EXISTS ;
CREATE TABLE `student_manager`.`student_tbl` (
  `student_id` INT NOT NULL AUTO_INCREMENT,
  `student_name` VARCHAR(45) NULL,
  `student_sex` TINYINT(1) NULL,
  `STUDENT_SEQNO` VARCHAR(45) NULL,
  `STUDENT_BIRTHDAY` DATETIME NULL,
  `timeOfEnrollment` DATETIME NULL,
  `dateOFGraduation` DATETIME NULL,
  PRIMARY KEY (`student_id`));


## 权限设计相关表格 ##
# 用户表
DROP TABLE `student_manager`.`end_user` IF EXISTS ;
CREATE TABLE end_user
(
  end_user_id       INT AUTO_INCREMENT
    PRIMARY KEY,
  end_user_name     VARCHAR(45)     NULL,
  end_user_password VARCHAR(50)     NULL,
  create_time       DATETIME        NULL,
  is_deleted        INT DEFAULT '0' NOT NULL
);


# 角色表
DROP TABLE `student_manager`.`role` IF EXISTS ;
CREATE TABLE `student_manager`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `is_deleted` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`role_id`));

# 菜单权限表
DROP TABLE `student_manager`.`menu` IF EXISTS ;
CREATE TABLE `student_manager`.`menu` (
  `menu_id` INT NOT NULL AUTO_INCREMENT,
  `menu_name` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `is_deleted` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`menu_id`));

# 子表1：用户-角色表
CREATE TABLE `student_manager`.`end_user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `end_user_id` INT NOT NULL,
  `role_id` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `is_deleted` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

# 子表2：角色-权限(菜单)表
CREATE TABLE `student_manager`.`role_menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_id` INT NOT NULL,
  `menu_id` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `is_deleted` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));

# 数据初始化

INSERT INTO end_user ( end_user_name, end_user_password, create_time, is_deleted)
VALUES ('zhanggang','zhang123',now(),0);

INSERT INTO end_user ( end_user_name, end_user_password, create_time, is_deleted)
VALUES ('zhanggang1','zhang123',now(),0);

INSERT INTO end_user ( end_user_name, end_user_password, create_time, is_deleted)
VALUES ('zhanggang2','zhang123',now(),0);
