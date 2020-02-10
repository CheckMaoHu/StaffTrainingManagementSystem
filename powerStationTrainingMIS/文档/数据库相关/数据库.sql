-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: powermanagerdb
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `Username` varchar(1000) NOT NULL,
  `Password` varchar(1000) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Admin','21232f297a57a5a743894a0e4a801fc3'),(2,'Admin999','00ba7ceab606427071d5d755ea99e976'),(8,'任涛','06fe4992a4bb5945c3796a984e0e4755'),(9,'admin000','1eea36fbd4f4919251e3192dce2da380'),(10,'admin111','bbad8d72c1fac1d081727158807a8798'),(11,'aaa000','6829b4940c8c717af0b4e746055a492f');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `depart`
--

DROP TABLE IF EXISTS `depart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `depart` (
  `departId` int(11) NOT NULL AUTO_INCREMENT,
  `departName` varchar(45) DEFAULT NULL,
  `departNumber` varchar(45) DEFAULT NULL,
  `departRemark` varchar(45) DEFAULT NULL,
  `highDepartName` varchar(45) DEFAULT NULL,
  `departTelephone` varchar(45) DEFAULT NULL,
  `highDepartNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`departId`),
  KEY `highDepartName_idx` (`highDepartName`),
  KEY `highDepartNumber_idx` (`highDepartNumber`),
  KEY `departNumber_idx` (`departNumber`),
  CONSTRAINT `highDepartNumber` FOREIGN KEY (`highDepartNumber`) REFERENCES `highdepart` (`highdepartnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depart`
--

LOCK TABLES `depart` WRITE;
/*!40000 ALTER TABLE `depart` DISABLE KEYS */;
INSERT INTO `depart` VALUES (47,'发二2班','002002','无','发电二部','152','002'),(50,'发一4班','001004','无','发电一部','152','001');
/*!40000 ALTER TABLE `depart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_t`
--

DROP TABLE IF EXISTS `employee_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_t` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(45) DEFAULT NULL,
  `employeeSex` varchar(45) DEFAULT NULL,
  `employeeCardId` varchar(45) DEFAULT NULL,
  `employeeBirthday` date DEFAULT NULL,
  `departNumber` varchar(45) DEFAULT NULL,
  `employeeDuty` varchar(45) DEFAULT NULL,
  `employeePost` varchar(45) DEFAULT NULL,
  `employeeNativePlace` varchar(45) DEFAULT NULL,
  `employeeTelephone` varchar(45) DEFAULT NULL,
  `employeeNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `departNumber_idx` (`departNumber`),
  CONSTRAINT `departNumber` FOREIGN KEY (`departNumber`) REFERENCES `depart` (`departnumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_t`
--

LOCK TABLES `employee_t` WRITE;
/*!40000 ALTER TABLE `employee_t` DISABLE KEYS */;
INSERT INTO `employee_t` VALUES (32,'周星驰','男','123457','2018-11-12','002002','无','无','重庆','152','002001001'),(49,'huhu','男','313131331313131342','1998-04-16','001004','313','313','ha','1313','13131');
/*!40000 ALTER TABLE `employee_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight` (
  `Id` int(100) NOT NULL AUTO_INCREMENT COMMENT '航班ID',
  `StartTime` varchar(100) NOT NULL COMMENT '起飞时间',
  `ArrivalTime` varchar(100) NOT NULL COMMENT '到达时间',
  `StartCity` varchar(100) NOT NULL COMMENT '起飞城市',
  `ArrivalCity` varchar(100) NOT NULL COMMENT '到达城市',
  `DepartureDate` varchar(100) NOT NULL COMMENT '起飞日期',
  `Price` float NOT NULL COMMENT '机票价格',
  `CurrentPassengers` int(100) NOT NULL COMMENT '机票当前预订人数',
  `SeatCapacity` int(100) NOT NULL COMMENT '机票容量',
  `FlightStatus` varchar(50) NOT NULL DEFAULT 'UNPUBLISHED' COMMENT '航班状态',
  `PassengerId` varchar(1000) NOT NULL COMMENT '乘客Id',
  `FlightName` varchar(100) NOT NULL COMMENT '航班名字（代替pdf中的航班ID）',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'2017-05-17-19-00-00','2017-05-17-23-00-29','上海','北京','2017-05-02',900,3,200,'TERMINATE','1;2;3;','CZ89271'),(2,'2017-05-02-19-20-00','2017-05-02-22-20-29','天津','北京','2017-05-02',899.4,0,200,'TERMINATE','','CZ83211'),(3,'2017-05-29-19-00-00','2017-05-29-22-00-00','北京','上海','2017-05-29',900.1,0,400,'AVAILABLE','','XZ98521'),(4,'2017-05-18-19-44-00','2017-05-19-02-00-00','北京','上海','2017-05-29',900,0,200,'TERMINATE','','XZ98345'),(5,'2017-05-18-19-44-00','2017-05-18-22-44-00','重庆','上海','2017-05-18-22-44-00',2000,0,200,'TERMINATE','','XZ98346'),(6,'2017-05-23-00-00-00','2017-05-23-04-00-00','沈阳','呼和浩特','2017-05-23-04-00-00',900,0,100,'AVAILABLE','','XE99021'),(7,'2017-05-23-00-00-00','2017-05-23-04-00-00','太原','郑州','2017-05-23-04-00-00',1000,0,300,'UNPUBLISHED','','RE100000'),(8,'2017-05-22-12-00-00','2017-05-22-16-00-00','昆明','拉萨','2017-05-22-16-00-00',1000,0,5,'AVAILABLE','','RE200000'),(9,'2017-05-21-14-00-00','2017-05-21-19-00-00','沈阳','天津','2017-05-21-19-00-00',2000,0,200,'TERMINATE','','ZX23413'),(10,'2017-05-21-14-00-00','2017-05-21-16-10-00','上海','天津','2017-05-21-16-10-00',1000,0,200,'TERMINATE','','CE90000'),(11,'2017-05-21-15-00-00','2017-05-21-18-00-00','沈阳','成都','2017-05-21-18-00-00',1100,0,30,'TERMINATE','','VE90000'),(12,'2017-05-21-12-00-00','2017-05-21-15-00-00','武汉','北京','2017-05-21-15-00-00',2000,0,100,'TERMINATE','','VB900002'),(13,'2017-05-21-19-00-00','2017-05-21-22-00-00','重庆','哈尔滨','2017-05-21-22-00-00',2000,0,200,'TERMINATE','','DD109002'),(14,'2017-05-21-19-00-00','2017-05-21-22-00-00','杭州','成都','2017-05-21-22-00-00',1050,0,200,'TERMINATE','','RE300000'),(15,'2017-05-22-19-00-00','2017-05-22-22-00-00','重庆','上海','2017-05-22-22-00-00',1322,0,200,'AVAILABLE','','RE400000'),(16,'2017-05-22-19-00-00','2017-05-22-22-00-00','太原','上海','2017-05-22-22-00-00',1302,0,222,'AVAILABLE','','RE50000'),(17,'2017-05-22-19-00-00','2017-05-22-23-00-00','长春','北京','2017-05-22-23-00-00',1111,0,111,'AVAILABLE','','RE111111'),(18,'2017-05-22-15-00-00','2017-05-22-19-00-00','天津','沈阳','2017-05-22-19-00-00',999,0,111,'AVAILABLE','','QE11111'),(19,'2017-05-22-14-00-00','2017-05-22-19-00-00','哈尔滨','长春','2017-05-22-19-00-00',1231,0,111,'AVAILABLE','','RE321311'),(20,'2017-05-23-12-00-00','2017-05-23-19-00-00','天津','北京','2017-05-23-19-00-00',1001,0,122,'AVAILABLE','','TR112111'),(21,'2017-05-23-12-00-00','2017-05-23-19-00-00','沈阳','北京','2017-05-23-19-00-00',2311,0,121,'AVAILABLE','','TR123123'),(22,'2017-05-23-12-00-00','2017-05-23-19-00-00','哈尔滨','南京','2017-05-23-19-00-00',1211,0,100,'AVAILABLE','','WE212311'),(23,'2017-05-23-12-00-00','2017-05-23-15-00-00','重庆','成都','2017-05-23-15-00-00',1231,0,100,'AVAILABLE','','TO112131');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `highdepart`
--

DROP TABLE IF EXISTS `highdepart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `highdepart` (
  `highDepartId` int(11) NOT NULL AUTO_INCREMENT,
  `highDepartName` varchar(45) DEFAULT NULL,
  `highDepartNumber` varchar(45) NOT NULL,
  PRIMARY KEY (`highDepartId`),
  UNIQUE KEY `highDepartName_UNIQUE` (`highDepartName`),
  KEY `highDepartNumber_Idx` (`highDepartNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `highdepart`
--

LOCK TABLES `highdepart` WRITE;
/*!40000 ALTER TABLE `highdepart` DISABLE KEYS */;
INSERT INTO `highdepart` VALUES (1,'发电一部','001'),(2,'发电二部','002'),(3,'车间','003'),(4,'锅炉车间','004'),(5,'燃料车间','005');
/*!40000 ALTER TABLE `highdepart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `Id` int(100) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `PassengerId` int(100) NOT NULL COMMENT '乘客Id',
  `Seat` int(100) NOT NULL COMMENT '座位号',
  `FlightId` int(100) NOT NULL COMMENT '航班Id',
  `CreateDate` varchar(100) NOT NULL COMMENT '预订日期',
  `Status` varchar(100) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,1,1,'2016-03-04-05-20-01','PAID'),(2,2,2,1,'2017-04-20-00-23-11','PAID'),(6,3,3,1,'2017-05-02-00-00-56','PAID'),(7,11,18,20,'2017-05-21-17-59-11','PAID'),(8,11,40,21,'2017-05-21-17-59-25','PAID'),(9,11,46,17,'2017-05-21-17-59-33','CANCEL'),(10,11,73,15,'2017-05-21-18-02-42','PAID'),(11,11,98,19,'2017-05-21-18-22-20','PAID'),(12,11,40,3,'2017-05-21-18-22-35','PAID'),(13,11,8,3,'2017-05-21-18-22-49','CANCEL');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `p_login_t`
--

DROP TABLE IF EXISTS `p_login_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `p_login_t` (
  `ID` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `passWord` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_login_t`
--

LOCK TABLES `p_login_t` WRITE;
/*!40000 ALTER TABLE `p_login_t` DISABLE KEYS */;
INSERT INTO `p_login_t` VALUES ('d4673173-3d2a-41e0-90f1-8522a6f97f93','ad','ddd'),('3001','admin','123456'),('851e6968-e964-4bfe-a18f-99f729441222','hu','123'),('8fdac7c0-a680-4131-b2a7-3168aa309165','mayun','123'),('bc4c7df3-cdbb-495e-8fad-9646bfdb948d','ssd','12002122'),('980cc310-712e-4639-8479-d83956d1ec65','tdt','123'),('db3bbff6-b513-4a45-807c-aa9dd53da2cb','ter','123'),('3002','test','123'),('3ea24149-03f8-4e70-8226-24279a5cfc6b','tsdt','123'),('aa09c36f-4989-41f6-8e2f-e3b015ea3eec','TY','123');
/*!40000 ALTER TABLE `p_login_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `passenger` (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `RealName` varchar(50) NOT NULL,
  `IdentityId` varchar(30) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `OrderList` varchar(1000) NOT NULL COMMENT '航班Id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'任涛','410504199703042819','4fd952b7a28daf93be5457b4318554a1','1;'),(2,'程思斌','411603199804051234','4fd952b7a28daf93be5457b4318554a1','1;'),(3,'孙玺','411603199724054321','4fd952b7a28daf93be5457b4318554a1','1;'),(4,'AndrewNg','411603199724059987','4fd952b7a28daf93be5457b4318554a1',''),(5,'A13','410502198403027431','9982b2a7fceaaee2c8444b5086aee008',''),(6,'A14','410503586749358242','9982b2a7fceaaee2c8444b5086aee008',''),(7,'王五','411603199804051236','0ebce60f091d1dfc0f309101728b054f',''),(8,'李四','411603199804051234','9982b2a7fceaaee2c8444b5086aee008',''),(9,'lion','411603199804051223','52c69e3a57331081823331c4e69d3f2e',''),(10,'七六','411603199804051555','fbd7939d674997cdb4692d34de8633c4',''),(11,'源氏','4444444444444444444','7e9a4efc9e71f476fe7a4598c8db4762','');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_plan_basic_info_t`
--

DROP TABLE IF EXISTS `train_plan_basic_info_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `train_plan_basic_info_t` (
  `planId` int(11) NOT NULL AUTO_INCREMENT,
  `planName` varchar(45) NOT NULL,
  `planStartTime` date DEFAULT NULL,
  `planEndTime` date DEFAULT NULL,
  `planCreateTime` date DEFAULT NULL,
  `trainPlanType` varchar(45) DEFAULT NULL,
  `planYear` varchar(45) DEFAULT NULL,
  `planPerformance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`planId`),
  KEY `isFinish_idx` (`planPerformance`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_plan_basic_info_t`
--

LOCK TABLES `train_plan_basic_info_t` WRITE;
/*!40000 ALTER TABLE `train_plan_basic_info_t` DISABLE KEYS */;
INSERT INTO `train_plan_basic_info_t` VALUES (85,'中层管理人员培训','2017-11-23','2017-12-29','2018-11-27',NULL,'2017','已培训'),(86,'新员工入场培训','2018-10-15','2018-11-08','2018-11-27',NULL,'2018','已培训'),(88,'新员工入场培训','2018-07-16','2019-01-16','2018-11-28',NULL,'2016','已培训'),(89,'班组长培训','2018-08-14','2019-01-15','2018-11-28',NULL,'2018','已培训'),(90,'新员工入场培训','2018-11-12','2018-12-06','2018-11-28',NULL,'2018','未培训'),(91,'班组长培训','2018-11-20','2019-01-31','2018-11-28',NULL,'2017','未培训'),(92,'班组长培训','2018-11-20','2019-01-31','2018-11-28',NULL,'2017','未培训'),(93,'班组长培训','2018-11-20','2019-01-31','2018-11-28',NULL,'2017','未培训'),(94,'班组长培训','2018-11-20','2019-01-31','2018-11-28',NULL,'2017','未培训'),(95,'班组长培训','2018-11-20','2019-01-31','2018-11-28',NULL,'2017','未培训'),(96,'班组长培训','2018-11-20','2019-01-31','2018-11-28',NULL,'2017','未培训'),(97,'新员工入场培训','2018-12-12','2018-12-28','2019-11-22',NULL,'2018','未培训');
/*!40000 ALTER TABLE `train_plan_basic_info_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_plan_detail_info_t`
--

DROP TABLE IF EXISTS `train_plan_detail_info_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `train_plan_detail_info_t` (
  `planId` int(11) NOT NULL,
  `detailMajorName` varchar(45) DEFAULT NULL,
  `detailId` int(11) NOT NULL AUTO_INCREMENT,
  `planGoal` varchar(45) DEFAULT NULL,
  `planConcent` varchar(45) DEFAULT NULL,
  `planClassHour` varchar(45) DEFAULT NULL,
  `planTeacher` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`detailId`),
  KEY `planId_idx` (`planId`),
  KEY `planId` (`planId`),
  CONSTRAINT `planId` FOREIGN KEY (`planId`) REFERENCES `train_plan_basic_info_t` (`planid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_plan_detail_info_t`
--

LOCK TABLES `train_plan_detail_info_t` WRITE;
/*!40000 ALTER TABLE `train_plan_detail_info_t` DISABLE KEYS */;
INSERT INTO `train_plan_detail_info_t` VALUES (85,'电气',3070,'js','js','20','wang'),(85,'化水',3071,'css','css','25','wang'),(85,'燃运',3072,'html','html','30','wang'),(86,'汽机',3073,'math','math','20','qing'),(86,'锅炉',3074,'history','history','25','qing'),(86,'化水',3075,'politics','politics','30','qing'),(88,'汽机',3079,'dev++','dev++','20','ki'),(88,'电气',3080,'vs','vs','25','ki'),(88,'锅炉',3081,'eclipse','eclipse','30','ki'),(89,'电气',3082,'c++','c++','25','hu'),(89,'汽机',3083,'java','java','30','hu'),(89,'锅炉',3084,'py','py','35','hu'),(90,'电气',3085,'h\'n','hn','20','lo'),(91,'电气',3086,'制造班组长','电气自动化','9','周周'),(91,'电气',3087,'请输入培手动训目的','请输入培训内是容','请输入是培训课时','d教师'),(91,'电气',3088,'制造班组长','电气自动化','9','周周'),(91,'电气',3089,'请输入培手动训目的','请输入培训内是容','请输入是培训课时','d教师'),(91,'电气',3090,'制造班组长','电气自动化','9','周周'),(91,'电气',3091,'请输入培手动训目的','请输入培训内是容','请输入是培训课时','d教师'),(91,'电气',3092,'制造班组长','电气自动化','9','周周'),(91,'电气',3093,'请输入培手动训目的','请输入培训内是容','请输入是培训课时','d教师'),(91,'汽机',3094,'请输入培手动训目的','请输入培手动训目的','请输入培手动训目的','请输入培手动训目的'),(91,'锅炉',3095,'制造班组长','电气自动化','9','周周'),(91,'电气',3096,'请输入培手动训目的','请输入培训内是容','请输入是培训课时','d教师'),(91,'汽机',3097,'请输入培手动训目的','请输入培手动训目的','请输入培手动训目的','请输入培手动训目的'),(91,'电气',3098,'请输入培训目的0','请输入培训内容0','请输入培训课时0','请输入培训教师0'),(91,'汽机',3099,'s\'da','s\'da\'d','s\'d','d\'s\'d'),(97,'锅炉',3100,'dd','dd','12','ff1');
/*!40000 ALTER TABLE `train_plan_detail_info_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_plan_manager`
--

DROP TABLE IF EXISTS `train_plan_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `train_plan_manager` (
  `plan_manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `detailDepartId` int(11) DEFAULT NULL,
  `employeeId` int(11) DEFAULT NULL,
  `trainPlanId` int(11) DEFAULT NULL,
  `trainScore` int(11) DEFAULT NULL,
  `isFinish` varchar(45) DEFAULT NULL,
  `trainTurnOut` int(11) DEFAULT NULL,
  `turnOutScore` int(11) DEFAULT NULL,
  `examScore` int(11) DEFAULT NULL,
  `totalScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`plan_manager_id`),
  KEY `trainPlanId_idx` (`trainPlanId`),
  KEY `detailDepartId_idx` (`detailDepartId`),
  KEY `employeeId_idx` (`employeeId`),
  KEY `isFinish_idx` (`isFinish`),
  CONSTRAINT `detailDepartId` FOREIGN KEY (`detailDepartId`) REFERENCES `train_plan_detail_info_t` (`detailid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employeeId` FOREIGN KEY (`employeeId`) REFERENCES `employee_t` (`employeeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trainPlanId` FOREIGN KEY (`trainPlanId`) REFERENCES `train_plan_basic_info_t` (`planid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_plan_manager`
--

LOCK TABLES `train_plan_manager` WRITE;
/*!40000 ALTER TABLE `train_plan_manager` DISABLE KEYS */;
INSERT INTO `train_plan_manager` VALUES (30,3073,32,86,NULL,NULL,10,95,75,95),(38,3080,32,88,NULL,NULL,8,85,75,85),(42,3083,32,89,NULL,NULL,10,100,80,100),(46,3071,32,85,NULL,NULL,22,44,22,44),(51,3070,49,85,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `train_plan_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weichuncai_table`
--

DROP TABLE IF EXISTS `weichuncai_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `weichuncai_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL DEFAULT '',
  `value` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weichuncai_table`
--

LOCK TABLES `weichuncai_table` WRITE;
/*!40000 ALTER TABLE `weichuncai_table` DISABLE KEYS */;
INSERT INTO `weichuncai_table` VALUES (1,'','a:10:{s:6:\"notice\";s:123:\"ä½ å¥½ï¼Œæˆ‘æ˜¯çœ‹æ¿å¨˜rakutoriï¼Œæ¬¢è¿Žè®¿é—®ï¼Œè¯·å¤šæŒ‡æ•™ã€‚\r\næœ‰ä»€ä¹ˆä¸ä¼šçš„å¯ä»¥é—®æˆ‘ï¼Œåæ­£æˆ‘ä¹Ÿä¸ç´«é“\r\n\";s:9:\"adminname\";s:6:\"ä¸»äºº\";s:8:\"isnotice\";N;s:4:\"ques\";a:5:{i:0;s:9:\"æ—©ä¸Šå¥½\";i:1;s:9:\"ä¸­åˆå¥½\";i:2;s:9:\"ä¸‹åˆå¥½\";i:3;s:9:\"æ™šä¸Šå¥½\";i:4;s:6:\"æ™šå®‰\";}s:3:\"ans\";a:5:{i:0;s:12:\"æ—©ä¸Šå¥½ï½ž\";i:1;s:12:\"ä¸­åˆå¥½ï½ž\";i:2;s:12:\"ä¸‹åˆå¥½ï½ž\";i:3;s:12:\"æ™šä¸Šå¥½ï½ž\";i:4;s:9:\"æ™šå®‰ï½ž\";}s:8:\"lifetime\";a:3:{s:8:\"rakutori\";i:1467543602;s:4:\"neko\";i:1467543602;s:11:\"chinese_moe\";i:1467543602;}s:3:\"ccs\";a:3:{i:0;s:8:\"rakutori\";i:1;s:4:\"neko\";i:2;s:11:\"chinese_moe\";}s:10:\"defaultccs\";s:8:\"rakutori\";s:5:\"foods\";a:2:{i:0;s:9:\"é‡‘å·åžƒ\";i:1;s:9:\"å’¸æ¢…å¹²\";}s:6:\"eatsay\";a:2:{i:0;s:45:\"åƒäº†é‡‘å·åžƒï¼Œä¸€åˆ€èƒ½ç§’ä¸€ä¸‡å…«ï½žï¼\";i:1;s:42:\"åƒå’¸æ¢…å¹²ï¼Œå˜è¶…äººï¼å“¦è€¶ï½žï½žï½ž\";}}');
/*!40000 ALTER TABLE `weichuncai_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-10 13:59:01
