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
-- Table structure for table `notice_board`
--

DROP TABLE IF EXISTS `notice_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice_board` (
  `no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(500) NOT NULL,
  `writer` varchar(45) NOT NULL,
  `views` int DEFAULT '0',
  `regtime` date NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_board`
--

LOCK TABLES `notice_board` WRITE;
/*!40000 ALTER TABLE `notice_board` DISABLE KEYS */;
INSERT INTO `notice_board` VALUES (1,'도로명 주소 관련 안내 ','https://www.juso.go.kr/openIndexPage.do','admin',1,'2020-11-26'),(2,'세종특별시 관련 문의 사항 답변','세종이 정말 살기 좋네요!','admin',0,'2020-11-26'),(3,'광주광역시 코로나 19관련 HappyHouse 방역조치','손발깨끗히 씻기!','admin',0,'2020-11-26'),(4,'대전 동구 홍도동 아파트 000관련 코로나 19 감염 사례 안내','조심하세요!','admin',2,'2020-11-26'),(5,'[봉사] 외국인을 위한 봉사활동 안내','영어잘하시는 분 손!','admin',3,'2020-11-26'),(6,'영등포구 코로나 19 감염대책 안내','영등포구 구청분께 여쭤봐주세요!','admin',1,'2020-11-26');
/*!40000 ALTER TABLE `notice_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26 21:45:24
