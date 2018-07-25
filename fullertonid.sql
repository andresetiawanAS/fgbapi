-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 25, 2018 at 04:38 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fullertonid`
--

-- --------------------------------------------------------

--
-- Table structure for table `balance`
--

CREATE TABLE `balance` (
  `id` varchar(36) NOT NULL,
  `id_card` varchar(45) DEFAULT NULL,
  `last_topup` date DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `acc_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `master_account`
--

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
  `refresh_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_account`
--

INSERT INTO `master_account` (`id`, `ref_id`, `acc_type`, `acc_owner`, `first_name`, `last_name`, `pref_name`, `dob`, `country`, `address`, `city`, `province`, `zip_code`, `phone`, `email`, `password`, `security_question`, `security_answer`, `confirm_security_answer`, `education`, `trading_experience`, `trading_frequency`, `purpose_of_trading`, `annual_gross_income`, `net_worth`, `income_source`, `is_muslim`, `public_position`, `detail_public_position`, `family_public_position`, `detail_family_public_position`, `leverage`, `pref_language`, `proof_of_identity`, `proof_of_residence`, `open_ib_account`, `demo`, `live`, `date_created`, `date_updated`, `id_card`, `gender`, `refresh_token`) VALUES
('1', NULL, 'Fullerton Markets | Variable Spread | USD', 'Personal', 'Martin', 'Lim', 'Martin', '1997-10-03 00:00:00', 'Indonesia', 'Jl. Jalan', 'Tangerang', 'Jawa Barat', '14405', '085894090909', 'martin.lim@gmail.com', '$2a$10$6kj6.1MfK9wwdRAjFXSTyuViiCcMHm4UbzenAC2lmBDWCuOlfSxZm', 'What is your mtoher\'s maiden name?', 'marta', 'marta', 'Bachelors Degree', 'None', 'Less than 5 trades', 'Speculation', 'Less than $25,000', 'Less than $100,000', 'Self Employed', 'Not Applicable', 'No', NULL, 'No', NULL, '1:10', 'English', NULL, NULL, 'No', NULL, 1, '2018-07-24 00:00:00', '2018-07-24 00:00:00', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `topup_history`
--

CREATE TABLE `topup_history` (
  `id` varchar(36) NOT NULL,
  `topup_value` double DEFAULT NULL,
  `topup_date` datetime DEFAULT NULL,
  `balance_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `balance`
--
ALTER TABLE `balance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_acc_id_idx` (`acc_id`);

--
-- Indexes for table `master_account`
--
ALTER TABLE `master_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `topup_history`
--
ALTER TABLE `topup_history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_balance_id_idx` (`balance_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `balance`
--
ALTER TABLE `balance`
  ADD CONSTRAINT `FK_acc_id` FOREIGN KEY (`acc_id`) REFERENCES `master_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `topup_history`
--
ALTER TABLE `topup_history`
  ADD CONSTRAINT `FK_balance_id` FOREIGN KEY (`balance_id`) REFERENCES `balance` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
