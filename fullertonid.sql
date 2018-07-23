-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fullertonid
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balance` (
  `id` varchar(36) NOT NULL,
  `id_card` varchar(45) DEFAULT NULL,
  `last_topup` date DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `acc_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_acc_id_idx` (`acc_id`),
  CONSTRAINT `FK_acc_id` FOREIGN KEY (`acc_id`) REFERENCES `master_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `master_account`
--

DROP TABLE IF EXISTS `master_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `master_account` (
  `id` varchar(36) NOT NULL,
  `ref_id` varchar(45) DEFAULT NULL,
  `acc_type` varchar(45) NOT NULL,
  `acc_owner` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `pref_name` varchar(45) DEFAULT NULL,
  `dob` datetime NOT NULL,
  `country` varchar(45) NOT NULL,
  `address` longtext,
  `city` varchar(45) NOT NULL,
  `province` varchar(45) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `security_question` varchar(45) NOT NULL,
  `security_answer` varchar(45) NOT NULL,
  `confirm_security_answer` varchar(45) NOT NULL,
  `education` varchar(45) NOT NULL,
  `trading_experience` varchar(45) NOT NULL,
  `trading_frequency` varchar(45) NOT NULL,
  `purpose_of_trading` varchar(45) NOT NULL,
  `annual_gross_income` varchar(45) NOT NULL,
  `net_worth` varchar(45) NOT NULL,
  `income_source` varchar(45) NOT NULL,
  `is_muslim` varchar(45) DEFAULT NULL,
  `public_position` varchar(45) NOT NULL,
  `detail_public_position` varchar(45) DEFAULT NULL,
  `family_public_position` varchar(45) NOT NULL,
  `detail_family_public_position` varchar(45) DEFAULT NULL,
  `leverage` varchar(45) DEFAULT NULL,
  `pref_language` varchar(45) NOT NULL,
  `proof_of_identity` varchar(45) DEFAULT NULL,
  `proof_of_residence` varchar(45) DEFAULT NULL,
  `open_ib_account` varchar(45) DEFAULT NULL,
  `demo` tinyint(4) DEFAULT NULL,
  `live` tinyint(4) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `id_card` varchar(45) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `topup_history`
--

DROP TABLE IF EXISTS `topup_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topup_history` (
  `id` varchar(36) NOT NULL,
  `topup_value` double DEFAULT NULL,
  `topup_date` datetime DEFAULT NULL,
  `balance_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_balance_id_idx` (`balance_id`),
  CONSTRAINT `FK_balance_id` FOREIGN KEY (`balance_id`) REFERENCES `balance` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-23 11:51:47
