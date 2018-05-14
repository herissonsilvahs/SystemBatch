-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 14, 2018 at 10:49 AM
-- Server version: 5.7.22-0ubuntu18.04.1
-- PHP Version: 7.2.3-1ubuntu1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `BackTest_App`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_customer_account`
--

CREATE TABLE `tb_customer_account` (
  `id_customer` int(11) NOT NULL,
  `cpf_cnpj` varchar(45) NOT NULL,
  `nm_customer` varchar(45) NOT NULL,
  `is_active` int(1) NOT NULL,
  `val_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_customer_account`
--

INSERT INTO `tb_customer_account` (`id_customer`, `cpf_cnpj`, `nm_customer`, `is_active`, `val_total`) VALUES
(1, '661.454.885.86', 'Pablo Carvalho', 1, 1094),
(2, '835.916.803.94', 'Lucia Junior', 1, 1011),
(3, '123.901.298.45', 'Lucia Martins', 1, 1249),
(4, '736.299.805.32', 'Clarisse Carvalho', 1, 1746),
(5, '462.409.724.96', 'Pablo Guimaraes', 1, 930),
(6, '335.279.934.85', 'Pedro Souza', 1, 650),
(7, '598.510.333.41', 'Clarisse Guimaraes', 1, 1383),
(8, '855.910.596.12', 'Ana Nascimento', 1, 1413),
(9, '649.225.439.31', 'Pablo Souza', 1, 1377),
(10, '424.693.918.54', 'Joao Marques', 1, 1900),
(11, '747.275.840.85', 'Clarisse Nascimento', 1, 1661),
(12, '670.580.116.80', 'Julia Guimaraes', 1, 949),
(13, '137.280.617.13', 'Pedro Marques', 1, 905),
(14, '105.103.157.57', 'Andre Carvalho', 1, 1637),
(15, '656.550.242.93', 'Pablo Guimaraes', 1, 773),
(16, '121.471.765.56', 'Julia Junior', 1, 1040),
(17, '786.462.850.51', 'Carlos Guimaraes', 1, 708),
(18, '687.984.389.44', 'Carlos Guimaraes', 1, 747),
(19, '559.920.861.19', 'Julia Junior', 1, 1092),
(20, '804.552.250.82', 'Andre Marques', 1, 1392),
(21, '125.976.690.51', 'Julia Martins', 1, 1403),
(22, '879.731.703.34', 'Julia Nascimento', 1, 1977),
(23, '979.166.411.29', 'Ana Marques', 1, 596),
(24, '911.206.318.75', 'Julia Nascimento', 1, 598),
(25, '244.876.731.93', 'Pedro Souza', 1, 815),
(26, '339.767.600.64', 'Ana Martins', 1, 885),
(27, '301.628.399.53', 'Lucia Souza', 1, 1081),
(28, '134.347.843.53', 'Carlos Junior', 1, 1377),
(29, '126.434.673.54', 'Carlos Marques', 1, 1742),
(30, '470.626.838.81', 'Carlos Souza', 1, 1328),
(31, '818.958.733.55', 'Ana Carvalho', 1, 1236),
(1200, '129.298.695.49', 'Pedro Souza', 1, 1502),
(1700, '544.252.910.39', 'Andre Souza', 1, 952),
(2000, '783.131.470.83', 'Ana Marques', 1, 1219),
(2001, '900.293.190.54', 'Joao Souza', 1, 693),
(2200, '660.606.129.40', 'Julia Guimaraes', 1, 1705);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_customer_account`
--
ALTER TABLE `tb_customer_account`
  ADD PRIMARY KEY (`id_customer`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_customer_account`
--
ALTER TABLE `tb_customer_account`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
