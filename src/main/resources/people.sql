-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2024 at 03:06 PM
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
-- Database: `jemployees`
--

-- --------------------------------------------------------

--
-- Table structure for table `people`
--

CREATE TABLE `people` (
  `nume` varchar(200) NOT NULL,
  `prenume` varchar(200) NOT NULL,
  `cnp` varchar(200) NOT NULL,
  `loc_nastere` varchar(200) NOT NULL,
  `stare_civila` varchar(200) NOT NULL,
  `nationalitate` varchar(200) NOT NULL,
  `departament` varchar(200) NOT NULL,
  `functie` varchar(200) NOT NULL,
  `numar_telefon` varchar(200) NOT NULL,
  `adresa` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `salariu` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `people`
--

INSERT INTO `people` (`nume`, `prenume`, `cnp`, `loc_nastere`, `stare_civila`, `nationalitate`, `departament`, `functie`, `numar_telefon`, `adresa`, `email`, `marca`, `salariu`) VALUES
('John', 'Rares', '1234567890123', 'Arad', 'Necasatorit', 'Roman', 'IT', 'Analist', '0740888888', 'Kogalniceanu', 'rares@gmail.com', '334', 3000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`cnp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
