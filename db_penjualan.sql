-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2022 at 09:34 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `jnsbrg_id` int(11) DEFAULT NULL,
  `nama_barang` varchar(30) DEFAULT NULL,
  `harga_barang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `jnsbrg_id`, `nama_barang`, `harga_barang`) VALUES
(6, 1, 'rtrtr', 987),
(10, 2, 'JJJJJ', 99999),
(99, 1, 'hsdf', 98675);

-- --------------------------------------------------------

--
-- Table structure for table `bio_pembeli`
--

CREATE TABLE `bio_pembeli` (
  `id_pembeli` int(11) NOT NULL,
  `nama_pembeli` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `notelp_pembeli` varchar(15) NOT NULL,
  `alamat_pembeli` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bio_pembeli`
--

INSERT INTO `bio_pembeli` (`id_pembeli`, `nama_pembeli`, `password`, `notelp_pembeli`, `alamat_pembeli`) VALUES
(1, 'admin', 'admin', '08123456789', 'sidoarjo, jawa timur'),
(2, 'tes', '1', 'p', 'dimnasaja');

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail` int(11) NOT NULL,
  `transaksi_id` int(11) DEFAULT NULL,
  `barang_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail`, `transaksi_id`, `barang_id`) VALUES
(1, 1, 10),
(2, 2, 6),
(3, 3, 6),
(4, 4, 6),
(5, 5, 6),
(6, 6, 6),
(7, 7, 6),
(8, 8, 6);

-- --------------------------------------------------------

--
-- Table structure for table `jnsbrg`
--

CREATE TABLE `jnsbrg` (
  `id_jnsbrg` int(11) NOT NULL,
  `nama_jnsbrg` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jnsbrg`
--

INSERT INTO `jnsbrg` (`id_jnsbrg`, `nama_jnsbrg`) VALUES
(1, 'makanan'),
(2, 'Minuman');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `pembeli_id` int(11) DEFAULT NULL,
  `tgl_transaksi` datetime DEFAULT NULL,
  `status` varchar(30) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `pembeli_id`, `tgl_transaksi`, `status`, `total`) VALUES
(1, 2, '2022-06-07 23:47:50', '0', 100000),
(2, 2, '2022-06-09 05:58:30', '0', 8883),
(3, 2, '2022-06-09 06:27:49', '0', 2222),
(4, 2, '2022-06-15 04:38:35', '0', 1974),
(5, 2, '2022-06-15 04:49:20', '0', 2222),
(6, 2, '2022-06-15 04:50:07', '0', 5555),
(7, 2, '2022-06-15 05:03:07', '1', 728),
(8, 2, '2022-06-16 22:56:39', '1', 3333);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `fk_jnsbrg` (`jnsbrg_id`);

--
-- Indexes for table `bio_pembeli`
--
ALTER TABLE `bio_pembeli`
  ADD PRIMARY KEY (`id_pembeli`),
  ADD UNIQUE KEY `unique_nama` (`nama_pembeli`) USING BTREE;

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `fk_barang` (`barang_id`),
  ADD KEY `fk_transaksi` (`transaksi_id`);

--
-- Indexes for table `jnsbrg`
--
ALTER TABLE `jnsbrg`
  ADD PRIMARY KEY (`id_jnsbrg`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_pembeli` (`pembeli_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bio_pembeli`
--
ALTER TABLE `bio_pembeli`
  MODIFY `id_pembeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `fk_jnsbrg` FOREIGN KEY (`jnsbrg_id`) REFERENCES `jnsbrg` (`id_jnsbrg`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `fk_barang` FOREIGN KEY (`barang_id`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `fk_transaksi` FOREIGN KEY (`transaksi_id`) REFERENCES `transaksi` (`id_transaksi`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_pembeli` FOREIGN KEY (`pembeli_id`) REFERENCES `bio_pembeli` (`id_pembeli`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
