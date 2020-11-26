-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: happyhousefinal
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `userno` int NOT NULL,
  `userid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `userpwd` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `yy` varchar(45) NOT NULL,
  `mm` varchar(45) NOT NULL,
  `dd` varchar(45) NOT NULL,
  `interest_area` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `marriage_type` varchar(45) DEFAULT NULL,
  `no` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'admin','관리자','superuser@gmail.com','admin','서울','1993','8','27','서울','미혼',1),(0,'parkssafy','박싸피','parkssafy@naver.com','1234','서울특별시 종로구 사직로 161(세종로)','1995','01','05','대전 동구','미혼',2),(0,'kimssafy','김싸피','kimssafy@gmail.com','kimssafy','서울특별시 종로구 인사동10길 2(관훈동)','1998','07','25','광주 중구','미혼',3),(0,'choissafy','최싸피','choissafy@naver.com','choissafy','서울특별시 은평구 서오릉로10길','1993','06','15','서울 서대문구','기혼',4),(0,'hellossafy','김프로','hellossafy@ssafy.com','hellossafy','대전광역시 동구 홍도로 60(용전동, 새피앙아파트)','1985','02','21','서울 영등포구','기혼',5),(0,'tkddnsos','박상우','tkddnsos@naver.com','tkddnsos','서울특별시 서대문구 증가로20가길 73-3(북가좌동, 에덴빌라)','1993','08','27','서울 서대문구','미혼',6);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26 21:45:25
