-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2021 at 11:30 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uts_progmob`
--

-- --------------------------------------------------------

--
-- Table structure for table `progmob_matkuls`
--

CREATE TABLE `progmob_matkuls` (
  `id` int(3) NOT NULL,
  `kode` char(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `hari` varchar(20) NOT NULL,
  `sesi` int(10) NOT NULL,
  `sks` int(10) NOT NULL,
  `nim_progmob` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progmob_matkuls`
--

INSERT INTO `progmob_matkuls` (`id`, `kode`, `nama`, `hari`, `sesi`, `sks`, `nim_progmob`) VALUES
(1, 'PR2413', 'PRAKTIKUM REKAYASA PERANGKAT LUNAK', 'Selasa', 4, 3, 72190289);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `progmob_matkuls`
--
ALTER TABLE `progmob_matkuls`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `progmob_matkuls`
--
ALTER TABLE `progmob_matkuls`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
