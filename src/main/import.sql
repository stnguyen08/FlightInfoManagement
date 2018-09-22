CREATE DATABASE  IF NOT EXISTS `cs544` /*!40100 DEFAULT CHARACTER SET big5 */;
USE `cs544`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: cs544
-- ------------------------------------------------------
-- Server version	5.6.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Airline`
--

DROP TABLE IF EXISTS `Airline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Airline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Airline`
--

LOCK TABLES `Airline` WRITE;
/*!40000 ALTER TABLE `Airline` DISABLE KEYS */;
INSERT INTO `Airline` VALUES (1,'SkyTeam'),(2,'oneworld'),(3,'Star Alliance');
/*!40000 ALTER TABLE `Airline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Airplane`
--

DROP TABLE IF EXISTS `Airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Airplane` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `serialnr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Airplane`
--

LOCK TABLES `Airplane` WRITE;
/*!40000 ALTER TABLE `Airplane` DISABLE KEYS */;
INSERT INTO `Airplane` VALUES (1,519,'A380','12345'),(2,416,'747','54321'),(3,519,'A380','23451'),(4,416,'747','43215'),(5,519,'A380','34512'),(6,416,'747','32154');
/*!40000 ALTER TABLE `Airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Airport`
--

DROP TABLE IF EXISTS `Airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Airport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `airportcode` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Airport`
--

LOCK TABLES `Airport` WRITE;
/*!40000 ALTER TABLE `Airport` DISABLE KEYS */;
INSERT INTO `Airport` VALUES (1,'AMS','Amsterdam','The Netherlands','Schiphol'),(2,'DTW','Detroid','USA','Detroid City'),(3,'NRT','Tokyo','Japan','Narita International Airport'),(4,'SYD','Sydney','Australia','Kingsford Smith'),(5,'LAX','Los Angeles','USA','Los Angeles International'),(6,'FRA','Frankfurt','Germany','Frankfurt International Airport'),(7,'ORD','Chicago','USA','Chicago O\'hare International'),(8,'LHR','London','UK','London Heathrow'),(9,'JFK','New York','USA','John F. Kennedy International'),(10,'SIN','Singapore','Singapore','Changi Airport');
/*!40000 ALTER TABLE `Airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Flight`
--

DROP TABLE IF EXISTS `Flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrivalDate` date DEFAULT NULL,
  `arrivalTime` time DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `departureTime` time DEFAULT NULL,
  `flightnr` varchar(255) DEFAULT NULL,
  `airline_id` bigint(20) DEFAULT NULL,
  `airplane_id` bigint(20) DEFAULT NULL,
  `destination_id` bigint(20) DEFAULT NULL,
  `origin_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiovu1yeejovoyfdigekqm2poq` (`airline_id`),
  KEY `FKqj90onina6quhovb6tiduupea` (`airplane_id`),
  KEY `FK5dis6my7uigtlf3yplj9a8tf2` (`destination_id`),
  KEY `FKlnxosilekxmiqeqho86xox8pf` (`origin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flight`
--

LOCK TABLES `Flight` WRITE;
/*!40000 ALTER TABLE `Flight` DISABLE KEYS */;
INSERT INTO `Flight` VALUES (1,'2009-08-07','09:00:00','2009-08-06','19:10:00','NW 36',1,1,1,2),(2,'2009-08-07','13:45:00','2009-08-06','15:05:00','NW 96',1,2,2,3),(3,'2009-08-07','06:15:00','2009-08-05','22:30:00','QF 12',2,3,4,5),(4,'2009-08-07','06:55:00','2009-08-06','21:55:00','QF 21',2,4,3,4),(5,'2009-08-07','05:45:00','2009-08-06','14:30:00','UA 944',3,5,6,7),(6,'2009-08-07','07:30:00','2009-08-06','12:59:00','UA 934',3,6,8,5),(7,'2009-08-07','07:40:00','2009-08-07','07:15:00','NW 8445',1,1,8,1),(8,'2009-08-07','12:21:00','2009-08-07','12:05:00','NW 1689',1,2,7,2),(9,'2009-08-07','23:39:00','2009-08-07','15:00:00','QF 3101',2,3,9,5),(10,'2009-08-07','17:15:00','2009-08-07','11:05:00','QF 4022',2,4,10,3),(11,'2009-08-07','14:53:00','2009-08-07','12:45:00','UA 941',3,5,7,6),(12,'2009-08-07','10:38:00','2009-08-07','08:10:00','UA 4842',3,6,1,8);
/*!40000 ALTER TABLE `Flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-22 11:45:25
