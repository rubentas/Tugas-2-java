-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 08, 2024 at 02:38 PM
-- Server version: 8.0.30
-- PHP Version: 8.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2210010485`
--

-- --------------------------------------------------------

--
-- Table structure for table `biaya_pakan`
--

CREATE TABLE `biaya_pakan` (
  `id_biaya` int NOT NULL,
  `jumlah_pakan` varchar(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `biaya_pakan`
--

INSERT INTO `biaya_pakan` (`id_biaya`, `jumlah_pakan`, `tanggal`) VALUES
(15, '2', 'senin'),
(122, '122', '122');

-- --------------------------------------------------------

--
-- Table structure for table `master_pakan`
--

CREATE TABLE `master_pakan` (
  `id_pakan` int NOT NULL,
  `nama_pakan` varchar(100) NOT NULL,
  `jenis_pakan` varchar(100) NOT NULL,
  `berat_kemasan` varchar(100) NOT NULL,
  `lemak` varchar(100) NOT NULL,
  `protein` varchar(100) NOT NULL,
  `energi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `master_pakan`
--

INSERT INTO `master_pakan` (`id_pakan`, `nama_pakan`, `jenis_pakan`, `berat_kemasan`, `lemak`, `protein`, `energi`) VALUES
(1, 'r', 'a', 'a', 'a', 'aa', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `panen`
--

CREATE TABLE `panen` (
  `noDO` int NOT NULL,
  `tanggal_panen` varchar(50) NOT NULL,
  `jumlah_panen` int NOT NULL,
  `berat_kg` int NOT NULL,
  `harga_jual` int NOT NULL,
  `penjualan_kotor` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `panen`
--

INSERT INTO `panen` (`noDO`, `tanggal_panen`, `jumlah_panen`, `berat_kg`, `harga_jual`, `penjualan_kotor`) VALUES
(12, 'selasa', 13, 1, 12, 12);

-- --------------------------------------------------------

--
-- Table structure for table `produksi`
--

CREATE TABLE `produksi` (
  `id_produksi` int NOT NULL,
  `tanggal_produksi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biaya_pakan`
--
ALTER TABLE `biaya_pakan`
  ADD PRIMARY KEY (`id_biaya`);

--
-- Indexes for table `master_pakan`
--
ALTER TABLE `master_pakan`
  ADD PRIMARY KEY (`id_pakan`);

--
-- Indexes for table `panen`
--
ALTER TABLE `panen`
  ADD PRIMARY KEY (`noDO`);

--
-- Indexes for table `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`id_produksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `biaya_pakan`
--
ALTER TABLE `biaya_pakan`
  MODIFY `id_biaya` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT for table `master_pakan`
--
ALTER TABLE `master_pakan`
  MODIFY `id_pakan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `panen`
--
ALTER TABLE `panen`
  MODIFY `noDO` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `produksi`
--
ALTER TABLE `produksi`
  MODIFY `id_produksi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
