-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2023 at 12:45 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pi_ag`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `gender_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `firstname`, `lastname`, `birthdate`, `gender_id`, `created_at`) VALUES
(37, 'fff', 'fff', '2023-11-27', 3, '2023-11-27 05:45:05'),
(38, 'kev', 'tsakai', '2000-12-14', 1, '2023-11-27 05:46:38'),
(39, 'fff', 'fff', '2023-11-27', 1, '2023-11-27 06:13:01'),
(51, 'rerer', 'rere', '2023-11-27', 1, '2023-11-27 17:03:51'),
(54, 'ddwdwq', 'dwqwd', '2023-11-27', 1, '2023-11-27 18:21:05'),
(55, 'fefe', 'fefe', '2023-11-28', 1, '2023-11-27 23:15:13'),
(57, 'klevis', 'tsa', '2222-02-02', 1, '2023-11-27 23:16:58'),
(58, 'dwdw', 'dwdw', '2023-11-28', 1, '2023-11-27 23:23:08'),
(65, 'fe', 'fe', '2023-11-28', 1, '2023-11-27 23:39:16'),
(66, 'rew', 'rwe', '2023-11-28', 1, '2023-11-27 23:40:41'),
(67, '', '', '2023-11-28', 1, '2023-11-28 00:02:45'),
(68, 'fef', 'fe', '2023-11-28', 1, '2023-11-28 00:02:55');

-- --------------------------------------------------------

--
-- Table structure for table `customer_subscription`
--

CREATE TABLE `customer_subscription` (
  `customer_id` int(11) NOT NULL,
  `subscription_id` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_subscription`
--

INSERT INTO `customer_subscription` (`customer_id`, `subscription_id`, `start_date`, `end_date`, `created_at`) VALUES
(37, 2, '2023-11-27', '2024-01-27', '2023-11-27 05:45:05'),
(38, 2, '2023-11-27', '2024-01-27', '2023-11-27 05:46:38'),
(39, 2, '2023-11-27', '2024-01-27', '2023-11-27 06:13:01'),
(51, 1, '2023-11-27', '2023-12-27', '2023-11-27 17:03:51'),
(54, 1, '2023-11-27', '2023-12-27', '2023-11-27 18:21:05'),
(55, 1, '2023-11-28', '2023-12-28', '2023-11-27 23:15:13'),
(57, 3, '2023-11-28', '2024-02-28', '2023-11-27 23:16:58'),
(58, 1, '2023-11-28', '2023-12-28', '2023-11-27 23:23:08'),
(65, 1, '2023-11-28', '2023-12-28', '2023-11-27 23:39:16'),
(66, 1, '2023-11-28', '2023-12-28', '2023-11-27 23:40:41'),
(67, 1, '2023-11-28', '2023-12-28', '2023-11-28 00:02:45'),
(68, 1, '2023-11-28', '2023-12-28', '2023-11-28 00:02:55');

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `name` varchar(127) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`id`, `name`, `created_at`) VALUES
(1, 'Male', '2023-11-05 10:43:30'),
(2, 'Female', '2023-11-05 10:43:42'),
(3, 'Unknown', '2023-11-05 10:43:48');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `customer_id`, `date`, `created_at`) VALUES
(55, 38, '2023-11-27 09:46:50', '2023-11-27 05:46:50'),
(64, 38, '2023-11-28 13:02:36', '2023-11-28 09:02:36'),
(66, 51, '2023-11-28 13:02:37', '2023-11-28 09:02:37'),
(75, 37, '2023-11-28 13:25:00', '2023-11-28 09:25:00'),
(79, 37, '2023-11-28 13:25:01', '2023-11-28 09:25:01'),
(81, 38, '2023-11-28 13:25:03', '2023-11-28 09:25:03'),
(82, 38, '2023-11-28 13:25:04', '2023-11-28 09:25:04'),
(83, 38, '2023-11-28 13:25:05', '2023-11-28 09:25:05'),
(88, 37, '2023-11-28 15:20:59', '2023-11-28 11:20:59');

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `id` int(11) NOT NULL,
  `plan_name` varchar(32) NOT NULL,
  `duration` int(11) NOT NULL,
  `cost` decimal(38,0) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscription`
--

INSERT INTO `subscription` (`id`, `plan_name`, `duration`, `cost`, `created_at`) VALUES
(1, '1 month', 1, 30, '2023-11-06 10:39:14'),
(2, '2 month', 2, 50, '2023-11-06 10:39:30'),
(3, '3 month', 3, 65, '2023-11-06 10:40:22'),
(4, '6 month', 6, 100, '2023-11-06 10:42:18'),
(5, '12 month', 12, 150, '2023-11-06 10:42:45');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password_hash` varchar(64) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `gender_id` int(11) NOT NULL,
  `validated` tinyint(4) DEFAULT 0,
  `created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password_hash`, `firstname`, `lastname`, `gender_id`, `validated`, `created_at`) VALUES
(77, 'kevikie', '$2a$10$ArUanlcGEtnvTzNP9ij8teCt0oj/geHWgt/Z/K1.Ds0T2Kswc.0eS', 'e', 'e', 1, NULL, '2023-11-28 02:22:49'),
(80, 'kevikie3', '$2a$10$ubenMC3pN.yZ9RHmfp5nXuHmbtx1JP4sX1.femBRHov.f0Fuca39.', 'e', 'e', 1, NULL, '2023-11-28 02:26:33'),
(83, 'kevikie32', '$2a$10$lSGpo62tUlkzg7LtdTlgve17CL6xJrDfLjIO.OZ62gBkV5zz1AWva', 'e', 'e', 1, NULL, '2023-11-28 02:29:23'),
(93, 'kevikie2', '$2a$10$wiDxR6wAeVDnYHuI8SoLP.XdGBwVcZy7gDVA6gioN7VRbpgaDcPfW', 'eee', '2', 1, NULL, '2023-11-28 07:28:02'),
(94, 'klevisTsak', '$2a$10$lNxHATBM3XRGqB.AX205b.OferSow8BrAOeuJnZJgjpVlfO4dUsF2', 'KLEV', 'tsak', 1, NULL, '2023-11-28 07:28:38'),
(95, '123', '$2a$10$k7rjfM/yevS3P/LUUsaNbefJLACbXxHY2HxkF56LKU90IMS5EpMM6', '12', '3', 1, NULL, '2023-11-28 07:28:54'),
(141, 'tsakKlev', '$2a$10$0MTPk9lfDThdjyFn.tM3jeJu.7s.lD53Kmb/3hvVBcKRDbL60tUnm', 'tsak', 'tsak', 3, NULL, '2023-11-28 07:56:23'),
(145, 'tsakKlev2', '$2a$10$AQbU64BVkLtY54m9Jtc1l.gzhJsW0XMP.HPkS0DmSqP/.Cdw9/aaO', '123', '123', 1, NULL, '2023-11-28 08:54:24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `a` (`firstname`,`lastname`),
  ADD KEY `gender_id` (`gender_id`);

--
-- Indexes for table `customer_subscription`
--
ALTER TABLE `customer_subscription`
  ADD PRIMARY KEY (`customer_id`),
  ADD KEY `subscription_id` (`subscription_id`);

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `date` (`date`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plan_name` (`plan_name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `gender_id` (`gender_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT for table `gender`
--
ALTER TABLE `gender`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=156;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`);

--
-- Constraints for table `customer_subscription`
--
ALTER TABLE `customer_subscription`
  ADD CONSTRAINT `customer_subscription_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `customer_subscription_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
