-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: auction_db
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.18.04.1

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
-- Table structure for table `auction`
--

DROP TABLE IF EXISTS `auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auction` (
  `auction_id` bigint(20) NOT NULL,
  `auction_date` date DEFAULT NULL,
  `auction_details` varchar(255) DEFAULT NULL,
  `auction_duration` bigint(20) DEFAULT NULL,
  `auction_name` varchar(255) DEFAULT NULL,
  `auction_time` time DEFAULT NULL,
  `seller_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`auction_id`),
  KEY `FKlgkat3vip0d6ydxtinrtsbdra` (`seller_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction`
--

LOCK TABLES `auction` WRITE;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` VALUES (42,'2018-06-23','First Auction',300,'Auction 1','00:01:00',41),(43,'2018-06-23','Second Auction',300,'Auction 2','01:01:00',41),(44,'2018-06-23','Third Auction',300,'Auction 3','02:01:00',41),(45,'2018-06-23','Fourth Auction',300,'Auction 4','03:01:00',41),(46,'2018-06-23','Fifth Auction',300,'Auction 5','04:01:00',41),(47,'2018-06-23','Sixth Auction',300,'Auction 5','05:01:00',41),(48,'2018-06-23','Seventh Auction',300,'Auction 7','06:01:00',41),(49,'2018-06-23','Eight Auction',300,'Auction 8','07:01:00',41),(50,'2018-06-23','Ninth Auction',300,'Auction 9','08:01:00',41),(51,'2018-06-23','Tenth Auction',300,'Auction 10','09:01:00',41),(52,'2018-06-23','Eleventh Auction',300,'Auction 11','10:01:00',41),(53,'2018-06-23','Twelvth Auction',300,'Auction 12','11:01:00',41),(54,'2018-06-23','Thirteenth Auction',300,'Auction 13','12:01:00',41),(55,'2018-06-23','Fourteenth Auction',300,'Auction 14','13:01:00',41),(56,'2018-06-23','Fifteenth Auction',300,'Auction 15','14:01:00',41),(57,'2018-06-23','Sixteenth Auction',300,'Auction 16','15:01:00',41),(58,'2018-06-23','Seventeeth Auction',300,'Auction 17','16:01:00',41),(59,'2018-06-23','Eighteenth Auction',300,'Auction 18','17:01:00',41),(60,'2018-06-23','Nineteenth Auction',300,'Auction 19','18:01:00',41),(61,'2018-06-23','Twentith Auction',300,'Auction 20','19:01:00',41),(62,'2018-06-23','21st Auction',300,'Auction 21','20:01:00',41),(63,'2018-06-23','22nd Auction',300,'Auction 22','21:01:00',41),(64,'2018-06-23','23rd Auction',300,'Auction 23','22:01:00',41),(65,'2018-06-23','24th Auction',300,'Auction 24','23:01:00',41),(66,'2018-06-23','25th Auction',300,'Auction 25','00:20:00',41),(67,'2018-06-24','26th Auction',300,'Auction 26','00:10:00',41),(68,'2018-06-24','27th Auction',300,'Auction 27','01:10:00',41),(69,'2018-06-24','28th Auction',300,'Auction 28','02:10:00',41),(70,'2018-06-24','29th Auction',300,'Auction 29','03:10:00',41),(71,'2018-06-24','30th Auction',300,'Auction 30','04:10:00',41);
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auction_bidders`
--

DROP TABLE IF EXISTS `auction_bidders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auction_bidders` (
  `auction_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`auction_id`,`user_id`),
  KEY `FKpskwx9in3q3is8qcwyn4g03pw` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction_bidders`
--

LOCK TABLES `auction_bidders` WRITE;
/*!40000 ALTER TABLE `auction_bidders` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction_bidders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bid`
--

DROP TABLE IF EXISTS `bid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bid` (
  `bid_id` bigint(20) NOT NULL,
  `bid_amount` double NOT NULL,
  `bid_date` date DEFAULT NULL,
  `bid_time` time DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `auction_auction_id` bigint(20) DEFAULT NULL,
  `bidder_user_id` bigint(20) DEFAULT NULL,
  `item_item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`bid_id`),
  KEY `FKmyoe5fh1y4iq63bdeadtfcdkf` (`auction_auction_id`),
  KEY `FKji8w4d9kp2qgvjst34b44va2a` (`bidder_user_id`),
  KEY `FKhxjes7enaoxpc6oa1pv4f7yxu` (`item_item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bid`
--

LOCK TABLES `bid` WRITE;
/*!40000 ALTER TABLE `bid` DISABLE KEYS */;
/*!40000 ALTER TABLE `bid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `UK_lroeo5fvfdeg4hpicn4lw7x9b` (`category_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (4,'Movie Prop'),(5,'Painting'),(6,'Antique'),(7,'Gadget'),(8,'Automobile'),(9,'Jewellery');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_items`
--

DROP TABLE IF EXISTS `category_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_items` (
  `category_category_id` bigint(20) NOT NULL,
  `items_item_id` bigint(20) NOT NULL,
  PRIMARY KEY (`category_category_id`,`items_item_id`),
  KEY `FKmn8qd210c8b3rtqcdtep3twqq` (`items_item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_items`
--

LOCK TABLES `category_items` WRITE;
/*!40000 ALTER TABLE `category_items` DISABLE KEYS */;
INSERT INTO `category_items` VALUES (4,72),(4,73),(4,74),(4,75),(4,76),(5,77),(5,78),(5,79),(5,80),(5,81),(6,82),(6,83),(6,84),(6,85),(6,86),(7,87),(7,88),(7,89),(7,90),(7,91),(8,92),(8,93),(8,94),(8,95),(8,96),(9,97),(9,98),(9,100),(9,101);
/*!40000 ALTER TABLE `category_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1032),(1032),(1032),(1032),(1032),(1032),(1032);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `item_description` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `starting_bid` double NOT NULL,
  `auction_auction_id` bigint(20) DEFAULT NULL,
  `item_state_state_id` int(11) DEFAULT NULL,
  `seller_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKq7ctwtoiifk4h8dy9fe7g4n20` (`auction_auction_id`),
  KEY `FK7i6wvqvqyqtngxh2nm8gn5d5b` (`item_state_state_id`),
  KEY `FKmgpbg0fc6xprn4yhao0f8ofwb` (`seller_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (72,'http://localhost:8080/downloadFile/movie1.jpg','Shield of Captain America','Shield',100,42,NULL,41),(73,'http://localhost:8080/downloadFile/movie2.jpg','Helmet of Mageneto','Helmet',100,43,NULL,41),(74,'http://localhost:8080/downloadFile/movie3.jpg','Totem of DeCaprio','Totem',100,44,NULL,41),(75,'http://localhost:8080/downloadFile/movie4.jpg','Dragon fly from Oblivion','Dragon fly',100,45,NULL,41),(76,'http://localhost:8080/downloadFile/movie5.jpg','Inf. Gauntlet : Thanos','Infinity gauntlet',100,46,NULL,41),(77,'http://localhost:8080/downloadFile/painting1.jpg','Painting of a girl','Girl',100,47,NULL,41),(78,'http://localhost:8080/downloadFile/painting2.jpg','Two trees','Tree',100,48,NULL,41),(79,'http://localhost:8080/downloadFile/painting3.jpg','Lake Painting','Lake',100,49,NULL,41),(80,'http://localhost:8080/downloadFile/painting4.jpg','Weird Painting','Weird',100,50,NULL,41),(81,'http://localhost:8080/downloadFile/painting5.jpg','Walking into the woods','Woods',100,51,NULL,41),(82,'http://localhost:8080/downloadFile/antique1.jpg','Old School Freezer Pepsi-Cola','Freezer',100,52,NULL,41),(83,'http://localhost:8080/downloadFile/antique2.jpg','Antique Radio','Radio',100,53,NULL,41),(84,'http://localhost:8080/downloadFile/antique3.JPG','Beautiful Kettle','Kettle',100,54,NULL,41),(85,'http://localhost:8080/downloadFile/antique4.jpg','Gold watch','Watch',100,55,NULL,41),(86,'http://localhost:8080/downloadFile/antique5.jpg','Telephone','Telephone',100,56,NULL,41),(87,'http://localhost:8080/downloadFile/gadget1.jpg','Fighting Gear of Deadpool','Deadpool Gear',100,57,NULL,41),(88,'http://localhost:8080/downloadFile/gadget2.jpg','DeLorean Car','DMC',100,58,NULL,41),(89,'http://localhost:8080/downloadFile/gadget3.jpg','Lightsaber from Star Wars','Sword',100,59,NULL,41),(90,'http://localhost:8080/downloadFile/gadget4.jpg','Smartphone enables gamepad','Gamepad',100,60,NULL,41),(91,'http://localhost:8080/downloadFile/gadget5.jpg','Mini Drone','Drone',100,61,NULL,41),(92,'http://localhost:8080/downloadFile/automobile1.jpg','Next Generation car\'s prototype','Prototype',100,62,NULL,41),(93,'http://localhost:8080/downloadFile/automobile2.jpg','Environment friendly car','Green Car',100,63,NULL,41),(94,'http://localhost:8080/downloadFile/automobile3.jpg','Early Car model','Antique Car',100,64,NULL,41),(95,'http://localhost:8080/downloadFile/automobile4.jpg','Car from Mr.Bean\'s Series','Three wheel car',100,65,NULL,41),(96,'http://localhost:8080/downloadFile/automobile5.jpeg','Mr. Bean\'s car','Mini',100,66,NULL,41),(97,'http://localhost:8080/downloadFile/jewellery1.jpg','Gold Jewellery','Bracelets',100,67,NULL,41),(98,'http://localhost:8080/downloadFile/jewellery2.jpg','Diamond ring','Ring',100,68,NULL,41),(99,'http://localhost:8080/downloadFile/jewellery3.jpeg','Platinum earrings','Earrings',100,69,NULL,41),(100,'http://localhost:8080/downloadFile/jewellery4.jpg','Crown of Nepalese kings','King\'s crown',100,70,NULL,41),(101,'http://localhost:8080/downloadFile/jewellery5.jpg','Gold Jewellery','Bangles',100,71,NULL,41);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_item_categories`
--

DROP TABLE IF EXISTS `item_item_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_item_categories` (
  `item_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`item_id`,`category_id`),
  KEY `FK9ggk5ga0cm2n8g63rid6m9f8y` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_item_categories`
--

LOCK TABLES `item_item_categories` WRITE;
/*!40000 ALTER TABLE `item_item_categories` DISABLE KEYS */;
INSERT INTO `item_item_categories` VALUES (72,4),(73,4),(74,4),(75,4),(76,4),(77,5),(78,5),(79,5),(80,5),(81,5),(82,6),(83,6),(84,6),(85,6),(86,6),(87,7),(88,7),(89,7),(90,7),(91,7),(91,9),(92,8),(93,8),(94,8),(95,8),(96,8),(97,9),(98,9),(99,9),(100,9);
/*!40000 ALTER TABLE `item_item_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (102,72,5,10),(103,73,3,10),(104,74,2,10),(105,75,3,10),(106,76,2,10),(107,77,4,10),(108,78,3,10),(109,79,1,10),(110,80,2,10),(111,81,3,10),(112,82,4,10),(113,83,4,10),(114,84,1,10),(115,85,2,10),(116,86,2,10),(117,87,2,10),(118,88,1,10),(119,89,5,10),(120,90,2,10),(121,91,1,10),(122,92,3,10),(123,93,2,10),(124,94,5,10),(125,95,2,10),(126,96,4,10),(127,97,2,10),(128,98,3,10),(129,99,3,10),(130,100,4,10),(131,101,3,10),(132,72,1,11),(133,73,5,11),(134,74,1,11),(135,75,1,11),(136,76,1,11),(137,77,2,11),(138,78,5,11),(139,79,4,11),(140,80,4,11),(141,81,5,11),(142,82,4,11),(143,83,5,11),(144,84,2,11),(145,85,5,11),(146,86,5,11),(147,87,1,11),(148,88,1,11),(149,89,4,11),(150,90,5,11),(151,91,2,11),(152,92,5,11),(153,93,3,11),(154,94,4,11),(155,95,1,11),(156,96,2,11),(157,97,2,11),(158,98,2,11),(159,99,3,11),(160,100,4,11),(161,101,2,11),(162,72,5,12),(163,73,5,12),(164,74,1,12),(165,75,5,12),(166,76,1,12),(167,77,3,12),(168,78,3,12),(169,79,2,12),(170,80,1,12),(171,81,2,12),(172,82,4,12),(173,83,2,12),(174,84,3,12),(175,85,3,12),(176,86,2,12),(177,87,5,12),(178,88,4,12),(179,89,3,12),(180,90,5,12),(181,91,4,12),(182,92,4,12),(183,93,3,12),(184,94,4,12),(185,95,2,12),(186,96,3,12),(187,97,1,12),(188,98,4,12),(189,99,5,12),(190,100,4,12),(191,101,5,12),(192,72,5,13),(193,73,1,13),(194,74,3,13),(195,75,5,13),(196,76,5,13),(197,77,4,13),(198,78,3,13),(199,79,4,13),(200,80,3,13),(201,81,4,13),(202,82,5,13),(203,83,1,13),(204,84,5,13),(205,85,2,13),(206,86,2,13),(207,87,1,13),(208,88,2,13),(209,89,1,13),(210,90,3,13),(211,91,3,13),(212,92,2,13),(213,93,5,13),(214,94,1,13),(215,95,3,13),(216,96,1,13),(217,97,2,13),(218,98,1,13),(219,99,2,13),(220,100,2,13),(221,101,5,13),(222,72,2,14),(223,73,3,14),(224,74,4,14),(225,75,1,14),(226,76,5,14),(227,77,3,14),(228,78,2,14),(229,79,1,14),(230,80,5,14),(231,81,1,14),(232,82,2,14),(233,83,1,14),(234,84,2,14),(235,85,4,14),(236,86,2,14),(237,87,2,14),(238,88,5,14),(239,89,4,14),(240,90,5,14),(241,91,3,14),(242,92,2,14),(243,93,3,14),(244,94,2,14),(245,95,5,14),(246,96,3,14),(247,97,3,14),(248,98,2,14),(249,99,4,14),(250,100,3,14),(251,101,1,14),(252,72,5,15),(253,73,1,15),(254,74,5,15),(255,75,5,15),(256,76,1,15),(257,77,5,15),(258,78,5,15),(259,79,3,15),(260,80,3,15),(261,81,2,15),(262,82,2,15),(263,83,4,15),(264,84,5,15),(265,85,5,15),(266,86,2,15),(267,87,1,15),(268,88,3,15),(269,89,1,15),(270,90,5,15),(271,91,1,15),(272,92,2,15),(273,93,1,15),(274,94,5,15),(275,95,5,15),(276,96,3,15),(277,97,4,15),(278,98,5,15),(279,99,5,15),(280,100,2,15),(281,101,4,15),(282,72,5,16),(283,73,2,16),(284,74,3,16),(285,75,1,16),(286,76,2,16),(287,77,3,16),(288,78,5,16),(289,79,1,16),(290,80,1,16),(291,81,5,16),(292,82,1,16),(293,83,5,16),(294,84,5,16),(295,85,5,16),(296,86,2,16),(297,87,2,16),(298,88,1,16),(299,89,4,16),(300,90,1,16),(301,91,1,16),(302,92,3,16),(303,93,2,16),(304,94,4,16),(305,95,4,16),(306,96,4,16),(307,97,3,16),(308,98,3,16),(309,99,5,16),(310,100,5,16),(311,101,3,16),(312,72,2,17),(313,73,2,17),(314,74,5,17),(315,75,3,17),(316,76,4,17),(317,77,3,17),(318,78,1,17),(319,79,5,17),(320,80,5,17),(321,81,1,17),(322,82,4,17),(323,83,1,17),(324,84,3,17),(325,85,3,17),(326,86,2,17),(327,87,2,17),(328,88,1,17),(329,89,5,17),(330,90,5,17),(331,91,5,17),(332,92,5,17),(333,93,5,17),(334,94,4,17),(335,95,4,17),(336,96,3,17),(337,97,3,17),(338,98,5,17),(339,99,4,17),(340,100,1,17),(341,101,3,17),(342,72,4,18),(343,73,1,18),(344,74,1,18),(345,75,3,18),(346,76,3,18),(347,77,4,18),(348,78,1,18),(349,79,2,18),(350,80,4,18),(351,81,5,18),(352,82,1,18),(353,83,5,18),(354,84,3,18),(355,85,4,18),(356,86,2,18),(357,87,3,18),(358,88,3,18),(359,89,1,18),(360,90,5,18),(361,91,5,18),(362,92,4,18),(363,93,1,18),(364,94,5,18),(365,95,5,18),(366,96,5,18),(367,97,3,18),(368,98,4,18),(369,99,2,18),(370,100,2,18),(371,101,4,18),(372,72,1,19),(373,73,4,19),(374,74,2,19),(375,75,1,19),(376,76,3,19),(377,77,1,19),(378,78,2,19),(379,79,3,19),(380,80,3,19),(381,81,4,19),(382,82,1,19),(383,83,1,19),(384,84,1,19),(385,85,3,19),(386,86,1,19),(387,87,5,19),(388,88,4,19),(389,89,4,19),(390,90,5,19),(391,91,3,19),(392,92,3,19),(393,93,5,19),(394,94,2,19),(395,95,5,19),(396,96,2,19),(397,97,2,19),(398,98,2,19),(399,99,2,19),(400,100,1,19),(401,101,2,19),(402,72,4,20),(403,73,3,20),(404,74,5,20),(405,75,2,20),(406,76,1,20),(407,77,2,20),(408,78,1,20),(409,79,5,20),(410,80,1,20),(411,81,4,20),(412,82,4,20),(413,83,1,20),(414,84,4,20),(415,85,5,20),(416,86,5,20),(417,87,4,20),(418,88,3,20),(419,89,2,20),(420,90,5,20),(421,91,4,20),(422,92,2,20),(423,93,1,20),(424,94,5,20),(425,95,2,20),(426,96,3,20),(427,97,2,20),(428,98,3,20),(429,99,4,20),(430,100,2,20),(431,101,1,20),(432,72,5,21),(433,73,4,21),(434,74,5,21),(435,75,4,21),(436,76,2,21),(437,77,3,21),(438,78,1,21),(439,79,2,21),(440,80,5,21),(441,81,4,21),(442,82,5,21),(443,83,4,21),(444,84,1,21),(445,85,1,21),(446,86,3,21),(447,87,4,21),(448,88,2,21),(449,89,5,21),(450,90,5,21),(451,91,4,21),(452,92,4,21),(453,93,5,21),(454,94,1,21),(455,95,5,21),(456,96,3,21),(457,97,1,21),(458,98,2,21),(459,99,1,21),(460,100,3,21),(461,101,2,21),(462,72,5,22),(463,73,5,22),(464,74,3,22),(465,75,5,22),(466,76,1,22),(467,77,1,22),(468,78,1,22),(469,79,2,22),(470,80,4,22),(471,81,4,22),(472,82,3,22),(473,83,4,22),(474,84,2,22),(475,85,2,22),(476,86,1,22),(477,87,1,22),(478,88,5,22),(479,89,4,22),(480,90,5,22),(481,91,4,22),(482,92,5,22),(483,93,4,22),(484,94,4,22),(485,95,1,22),(486,96,5,22),(487,97,1,22),(488,98,2,22),(489,99,4,22),(490,100,5,22),(491,101,2,22),(492,72,3,23),(493,73,3,23),(494,74,3,23),(495,75,3,23),(496,76,3,23),(497,77,3,23),(498,78,4,23),(499,79,5,23),(500,80,5,23),(501,81,1,23),(502,82,4,23),(503,83,1,23),(504,84,4,23),(505,85,5,23),(506,86,5,23),(507,87,5,23),(508,88,4,23),(509,89,2,23),(510,90,2,23),(511,91,4,23),(512,92,2,23),(513,93,3,23),(514,94,5,23),(515,95,2,23),(516,96,3,23),(517,97,4,23),(518,98,2,23),(519,99,4,23),(520,100,2,23),(521,101,3,23),(522,72,1,24),(523,73,2,24),(524,74,3,24),(525,75,5,24),(526,76,2,24),(527,77,1,24),(528,78,5,24),(529,79,1,24),(530,80,1,24),(531,81,3,24),(532,82,1,24),(533,83,4,24),(534,84,3,24),(535,85,1,24),(536,86,1,24),(537,87,5,24),(538,88,3,24),(539,89,5,24),(540,90,1,24),(541,91,5,24),(542,92,2,24),(543,93,4,24),(544,94,5,24),(545,95,3,24),(546,96,1,24),(547,97,5,24),(548,98,2,24),(549,99,3,24),(550,100,3,24),(551,101,5,24),(552,72,1,25),(553,73,1,25),(554,74,5,25),(555,75,3,25),(556,76,3,25),(557,77,1,25),(558,78,4,25),(559,79,5,25),(560,80,4,25),(561,81,4,25),(562,82,1,25),(563,83,1,25),(564,84,3,25),(565,85,1,25),(566,86,1,25),(567,87,3,25),(568,88,1,25),(569,89,5,25),(570,90,2,25),(571,91,5,25),(572,92,2,25),(573,93,5,25),(574,94,1,25),(575,95,1,25),(576,96,1,25),(577,97,2,25),(578,98,3,25),(579,99,2,25),(580,100,5,25),(581,101,2,25),(582,72,1,26),(583,73,3,26),(584,74,2,26),(585,75,2,26),(586,76,2,26),(587,77,1,26),(588,78,4,26),(589,79,2,26),(590,80,1,26),(591,81,4,26),(592,82,2,26),(593,83,3,26),(594,84,2,26),(595,85,2,26),(596,86,4,26),(597,87,2,26),(598,88,3,26),(599,89,2,26),(600,90,4,26),(601,91,4,26),(602,92,5,26),(603,93,1,26),(604,94,3,26),(605,95,1,26),(606,96,5,26),(607,97,3,26),(608,98,2,26),(609,99,1,26),(610,100,5,26),(611,101,1,26),(612,72,5,27),(613,73,1,27),(614,74,1,27),(615,75,5,27),(616,76,3,27),(617,77,3,27),(618,78,1,27),(619,79,1,27),(620,80,1,27),(621,81,5,27),(622,82,3,27),(623,83,4,27),(624,84,1,27),(625,85,3,27),(626,86,4,27),(627,87,1,27),(628,88,3,27),(629,89,1,27),(630,90,3,27),(631,91,3,27),(632,92,2,27),(633,93,2,27),(634,94,1,27),(635,95,1,27),(636,96,2,27),(637,97,3,27),(638,98,2,27),(639,99,4,27),(640,100,4,27),(641,101,3,27),(642,72,3,28),(643,73,3,28),(644,74,1,28),(645,75,5,28),(646,76,1,28),(647,77,4,28),(648,78,5,28),(649,79,1,28),(650,80,4,28),(651,81,5,28),(652,82,2,28),(653,83,1,28),(654,84,4,28),(655,85,1,28),(656,86,1,28),(657,87,2,28),(658,88,4,28),(659,89,3,28),(660,90,5,28),(661,91,3,28),(662,92,1,28),(663,93,3,28),(664,94,3,28),(665,95,2,28),(666,96,5,28),(667,97,5,28),(668,98,1,28),(669,99,5,28),(670,100,5,28),(671,101,4,28),(672,72,5,29),(673,73,2,29),(674,74,4,29),(675,75,5,29),(676,76,5,29),(677,77,4,29),(678,78,5,29),(679,79,3,29),(680,80,5,29),(681,81,2,29),(682,82,3,29),(683,83,4,29),(684,84,3,29),(685,85,3,29),(686,86,3,29),(687,87,1,29),(688,88,3,29),(689,89,3,29),(690,90,5,29),(691,91,1,29),(692,92,5,29),(693,93,1,29),(694,94,1,29),(695,95,2,29),(696,96,5,29),(697,97,1,29),(698,98,2,29),(699,99,3,29),(700,100,2,29),(701,101,3,29),(702,72,5,30),(703,73,3,30),(704,74,3,30),(705,75,3,30),(706,76,2,30),(707,77,4,30),(708,78,5,30),(709,79,1,30),(710,80,1,30),(711,81,2,30),(712,82,1,30),(713,83,1,30),(714,84,5,30),(715,85,2,30),(716,86,5,30),(717,87,3,30),(718,88,3,30),(719,89,1,30),(720,90,5,30),(721,91,5,30),(722,92,1,30),(723,93,5,30),(724,94,5,30),(725,95,3,30),(726,96,2,30),(727,97,5,30),(728,98,5,30),(729,99,3,30),(730,100,5,30),(731,101,1,30),(732,72,2,31),(733,73,5,31),(734,74,3,31),(735,75,2,31),(736,76,4,31),(737,77,4,31),(738,78,1,31),(739,79,1,31),(740,80,2,31),(741,81,1,31),(742,82,4,31),(743,83,5,31),(744,84,2,31),(745,85,3,31),(746,86,5,31),(747,87,3,31),(748,88,1,31),(749,89,5,31),(750,90,1,31),(751,91,3,31),(752,92,3,31),(753,93,1,31),(754,94,3,31),(755,95,5,31),(756,96,1,31),(757,97,3,31),(758,98,4,31),(759,99,1,31),(760,100,5,31),(761,101,1,31),(762,72,2,32),(763,73,4,32),(764,74,4,32),(765,75,2,32),(766,76,4,32),(767,77,2,32),(768,78,2,32),(769,79,5,32),(770,80,1,32),(771,81,3,32),(772,82,4,32),(773,83,1,32),(774,84,5,32),(775,85,1,32),(776,86,5,32),(777,87,2,32),(778,88,5,32),(779,89,2,32),(780,90,2,32),(781,91,2,32),(782,92,4,32),(783,93,4,32),(784,94,2,32),(785,95,1,32),(786,96,1,32),(787,97,5,32),(788,98,5,32),(789,99,1,32),(790,100,2,32),(791,101,1,32),(792,72,2,33),(793,73,1,33),(794,74,1,33),(795,75,1,33),(796,76,1,33),(797,77,2,33),(798,78,3,33),(799,79,4,33),(800,80,4,33),(801,81,2,33),(802,82,2,33),(803,83,2,33),(804,84,2,33),(805,85,1,33),(806,86,2,33),(807,87,3,33),(808,88,2,33),(809,89,3,33),(810,90,5,33),(811,91,4,33),(812,92,3,33),(813,93,4,33),(814,94,2,33),(815,95,1,33),(816,96,1,33),(817,97,3,33),(818,98,4,33),(819,99,1,33),(820,100,2,33),(821,101,1,33),(822,72,5,34),(823,73,4,34),(824,74,4,34),(825,75,1,34),(826,76,3,34),(827,77,2,34),(828,78,1,34),(829,79,5,34),(830,80,3,34),(831,81,3,34),(832,82,2,34),(833,83,3,34),(834,84,1,34),(835,85,5,34),(836,86,5,34),(837,87,5,34),(838,88,2,34),(839,89,1,34),(840,90,3,34),(841,91,2,34),(842,92,1,34),(843,93,4,34),(844,94,3,34),(845,95,4,34),(846,96,5,34),(847,97,4,34),(848,98,4,34),(849,99,2,34),(850,100,1,34),(851,101,1,34),(852,72,5,35),(853,73,5,35),(854,74,4,35),(855,75,4,35),(856,76,3,35),(857,77,5,35),(858,78,4,35),(859,79,3,35),(860,80,5,35),(861,81,1,35),(862,82,1,35),(863,83,4,35),(864,84,1,35),(865,85,2,35),(866,86,5,35),(867,87,2,35),(868,88,4,35),(869,89,1,35),(870,90,3,35),(871,91,1,35),(872,92,5,35),(873,93,1,35),(874,94,1,35),(875,95,3,35),(876,96,5,35),(877,97,1,35),(878,98,1,35),(879,99,1,35),(880,100,1,35),(881,101,4,35),(882,72,4,36),(883,73,4,36),(884,74,2,36),(885,75,1,36),(886,76,4,36),(887,77,2,36),(888,78,3,36),(889,79,2,36),(890,80,1,36),(891,81,3,36),(892,82,5,36),(893,83,5,36),(894,84,2,36),(895,85,4,36),(896,86,4,36),(897,87,3,36),(898,88,2,36),(899,89,5,36),(900,90,5,36),(901,91,4,36),(902,92,3,36),(903,93,4,36),(904,94,1,36),(905,95,4,36),(906,96,1,36),(907,97,4,36),(908,98,3,36),(909,99,2,36),(910,100,3,36),(911,101,4,36),(912,72,4,37),(913,73,4,37),(914,74,5,37),(915,75,1,37),(916,76,3,37),(917,77,2,37),(918,78,3,37),(919,79,3,37),(920,80,3,37),(921,81,5,37),(922,82,1,37),(923,83,5,37),(924,84,4,37),(925,85,3,37),(926,86,5,37),(927,87,4,37),(928,88,1,37),(929,89,1,37),(930,90,5,37),(931,91,3,37),(932,92,1,37),(933,93,2,37),(934,94,4,37),(935,95,5,37),(936,96,2,37),(937,97,1,37),(938,98,1,37),(939,99,1,37),(940,100,4,37),(941,101,3,37),(942,72,2,38),(943,73,3,38),(944,74,5,38),(945,75,2,38),(946,76,5,38),(947,77,3,38),(948,78,3,38),(949,79,2,38),(950,80,4,38),(951,81,4,38),(952,82,5,38),(953,83,1,38),(954,84,2,38),(955,85,3,38),(956,86,3,38),(957,87,4,38),(958,88,2,38),(959,89,2,38),(960,90,2,38),(961,91,1,38),(962,92,3,38),(963,93,5,38),(964,94,2,38),(965,95,5,38),(966,96,2,38),(967,97,4,38),(968,98,5,38),(969,99,5,38),(970,100,5,38),(971,101,2,38),(972,72,4,39),(973,73,3,39),(974,74,4,39),(975,75,1,39),(976,76,5,39),(977,77,1,39),(978,78,1,39),(979,79,3,39),(980,80,1,39),(981,81,2,39),(982,82,3,39),(983,83,4,39),(984,84,1,39),(985,85,4,39),(986,86,2,39),(987,87,2,39),(988,88,4,39),(989,89,2,39),(990,90,2,39),(991,91,4,39),(992,92,5,39),(993,93,2,39),(994,94,2,39),(995,95,3,39),(996,96,4,39),(997,97,3,39),(998,98,2,39),(999,99,5,39),(1000,100,1,39),(1001,101,4,39),(1002,72,4,40),(1003,73,1,40),(1004,74,4,40),(1005,75,2,40),(1006,76,3,40),(1007,77,4,40),(1008,78,1,40),(1009,79,4,40),(1010,80,5,40),(1011,81,4,40),(1012,82,1,40),(1013,83,4,40),(1014,84,3,40),(1015,85,1,40),(1016,86,5,40),(1017,87,2,40),(1018,88,5,40),(1019,89,5,40),(1020,90,3,40),(1021,91,3,40),(1022,92,2,40),(1023,93,1,40),(1024,94,4,40),(1025,95,2,40),(1026,96,1,40),(1027,97,5,40),(1028,98,3,40),(1029,99,4,40),(1030,100,5,40),(1031,101,1,40);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(255) NOT NULL,
  PRIMARY KEY (`state_id`),
  UNIQUE KEY `UK_qtjsbpmp2ejq0753ktldenyqo` (`state_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'LIVE'),(2,'READY'),(3,'SOLD');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_role` varchar(31) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_j09k2v8lxofv2vecxu2hde9so` (`user_email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('USER',10,NULL,'Keemar','hkeemar0@tinyurl.com','nkeemar0','$2a$10$TcMSj.Hx2qh97eG56EMXCeMhlecXeHW8GjhEGDHbfFmPmeCDrURye','4711065522'),('USER',11,NULL,'Wagen','wwagen1@furl.net','swagen1','$2a$10$N.f2TBECBCJWXVpaBF4lvO0GkFPKacI2wadofvG1ieFWGNG72G42.','2721167273'),('USER',12,NULL,'McWhan','mmcwhan2@dyndns.org','cmcwhan2','$2a$10$jSz.5v9E069XnMLL4bK9guI0x2DrdH0nmBDFdJRRNwOQrdgYOVyhm','7775342958'),('USER',13,NULL,'Minard','gminard3@last.fm','sminard3','$2a$10$f5CmMjS6b9T9ddZ42zW.LuxJbSXNduh73jftqmnWy63kNbDyn8vVO','6841452381'),('USER',14,NULL,'Hollow','dhollow4@nytimes.com','nhollow4','$2a$10$K7jbUoOJZAPoRl5JD5fUeeQNYIWDccM8n5FQ/mwNpp1cApl4/REVG','7143045279'),('USER',15,NULL,'Mungan','smungan5@taobao.com','bmungan5','$2a$10$cEkihcrVv2roXrri5k.03eK63lAo//pWq/Fj02GoLJ/imuSF2y4g2','8324159096'),('USER',16,NULL,'Deeman','ldeeman6@army.mil','wdeeman6','$2a$10$oR9ekr4xPIOgbuO24v8uAOg87UF8.KNENULmpDhlPP4jhntL2kMDq','5524908551'),('USER',17,NULL,'Heningam','cheningam7@psu.edu','bheningam7','$2a$10$1uiKBbZbptHD4uUfiSEjGOsDnIylMw/ZknPYDrK7FtbAi36aeieOu','8724024848'),('USER',18,NULL,'Strangward','cstrangward8@flavors.me','lstrangward8','$2a$10$rFcgZYsEbDeDA73GGcLv.OBSM9rONxvXoODgBqxzJtmuQZNY7zDDO','3291525092'),('USER',19,NULL,'Strangward','fgrisdale9@cmu.edu','mgrisdale9','$2a$10$/PJnX9U0GR8hOkij6PakUOzYqw6loDkX1ZMpyKf2chK/FNqRk2UZa','3664714558'),('USER',20,NULL,'Yurenin','byurenina@zdnet.com','tyurenina','$2a$10$b4yoQ5BeaI9OWRRuyMy/7OWM0MJVz8CuVkov/25HEMjskT1rM31Ci','6263903601'),('USER',21,NULL,'Waitland','cwaitlandb@drupal.org','rwaitlandb','$2a$10$6TkLzvAo8OdpYpPZ7dd/4eUtCvqFCqtrbaE0..I10LSswBlXkhP1m','2121562452'),('USER',22,NULL,'Brasted','gbrastedc@wired.com','tbrastedc','$2a$10$argVCQK.gGQXLeRQ8ZYklOQrD6LJTKlLelYtycYxoVvWqvBmxIyi6','2119552264'),('USER',23,NULL,'Ackwood','rackwoodd@salon.com','backwoodd','$2a$10$lSDJSZaoZHYDFzs9FwyvWOxarfYtXhcaHD.62SDZbp3PJWZcb88Jq','9447277255'),('USER',24,NULL,'Guwer','bguwere@jimdo.com','aguwere','$2a$10$cfDsMMxnXwPxJ9fIawYibuVkSG.tEV5i64ivObthcEtU19cDiZ8b.','7512439388'),('USER',25,NULL,'Pepperell','dpepperellf@rediff.com','epepperellf','$2a$10$RCE0p9H/UfdsRf6A/utBbejsk.W2/HVRlo8O0MCQ3U33.16bo7PZu','4438770804'),('USER',26,NULL,'Topham','ktophamg@gnu.org','atophamg','$2a$10$1IOpGqQcH4cjeYNiGDo21O60q9BjDWXlF3RPflZLt5AB4x87fMMWC','4133078522'),('USER',27,NULL,'Kinsley','ikinsleyh@macromedia.com','kkinsleyh','$2a$10$ApLVyGtP7uH8LTSWCL2ex.fQ2PWDcK65dQ57eqYQUsreScsaJvUlS','2437879462'),('USER',28,NULL,'Courage','acouragei@cargocollective.com','acouragei','$2a$10$VRMRKwmAq1U/OT0Ui6wgsOHy8kIlmI0WNCcGUUOOY4o0B04lGmeb6','5819207964'),('USER',29,NULL,'Raeburn','draeburnj@icq.com','draeburnj','$2a$10$Zc1PR55GDdeOQIDEYGeNnuhKq8wEX.MsUnXfSr/VhOT7O4qmhCR6m','1722032519'),('USER',30,NULL,'Hegg','rheggk@ustream.tv','sheggk','$2a$10$TzTRyLxlTULauyyNvpqHMuO5MW33crHTWdIsGV4KJT82ebR7jK1om','6131985214'),('USER',31,NULL,'Skittreal','rskittreall@quantcast.com','sskittreall','$2a$10$ohPeA/od2U5/01T7PvL1MuHbpAFhCTXIT.iY7L9n0OleJeXmvCCUK','7094859986'),('USER',32,NULL,'Leyland','fleylandm@cmu.edu','aleylandm','$2a$10$LF14HBUep6RlXTWnT55x7.xN9y0kZ23aeMmyeIOgI.Zu3hLV.oQ3i','5274051353'),('USER',33,NULL,'Skatcher','lskatchern@pcworld.com','askatchern','$2a$10$YpVHR9FlyFnZYsv47PZrZeEg9FuFEk2qAsXLTCNIzVFw3rWc4zuOS','5683393296'),('USER',34,NULL,'Locke','glockep@webnode.com','elockep','$2a$10$pvNzuLqiYmvNEyQrKg8EM.qDVsGTjsTJI2/nhV7XCb/nQok5mVeIe','1187773736'),('USER',35,NULL,'Morrall','mmorrallo@reddit.com','fmorrallo','$2a$10$RjNCj7msClXK2Lt1YeXDie2BHDBlE9X8l.huH66j943zGkeG5Mlrm','9839717424'),('USER',36,NULL,'Tennock','dtennockq@indiegogo.com','ttennockq','$2a$10$7n8V64mKm1NHPy8ubw5OveVu5w5oBcuHRHe8V0STy7G/fdHVivbYK','1748716681'),('USER',37,NULL,'Ktm','atosh502@gmail.com','atosh502','$2a$10$5VeqCqtQDDSxgNO3.gfIIuVYV.hatY.N7cRkg3TCXxGFB0RtDGOOq','9843599926'),('USER',38,NULL,'Pulchowk','admin@ioe.com','admin123','$2a$10$n.rEND8iEcwkhAtEHloM1OAlVefDBHpJcRNzc2qF/jpRudKiQCQ9m','6299953489'),('USER',39,NULL,'Lalitpur','foo@bar.com','foobar','$2a$10$h7prep1ANt03Mj2mQoym9uYh.mTtwrLiOxwXECAKj6a61qcC.B0/G','1234567891'),('USER',40,NULL,'Russia','snow@den.com','snowden','$2a$10$c5n09PVLJ7PvGSOCiwnTauzpxaSU80NcpDKpWmW4K4637FV.nTf3i','2345619209'),('USER',41,NULL,'Pokhara','seller@gmail.com','seller','$2a$10$xw2xY9YanA44PZ8EAtGSwegO95Q5JqGmzQ/u8nmc8a4.QO3UazTHS','123765490');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_auctions_participated`
--

DROP TABLE IF EXISTS `user_auctions_participated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_auctions_participated` (
  `user_user_id` bigint(20) NOT NULL,
  `auctions_participated_auction_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_user_id`,`auctions_participated_auction_id`),
  KEY `FKmg92kqcf90mkg1l2uyixphyml` (`auctions_participated_auction_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_auctions_participated`
--

LOCK TABLES `user_auctions_participated` WRITE;
/*!40000 ALTER TABLE `user_auctions_participated` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_auctions_participated` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-04 14:43:14
