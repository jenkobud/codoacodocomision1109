-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 18, 2022 at 06:46 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comision1109`
--

-- --------------------------------------------------------

--
-- Table structure for table `administradores`
--

CREATE TABLE `administradores` (
  `id` int(11) NOT NULL COMMENT 'id de uso interno de BD',
  `contrasena` varchar(30) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Contraseña de usuario.',
  `email` varchar(100) COLLATE latin1_spanish_ci NOT NULL COMMENT 'Utilizado para loggearse.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Tabla de administradores.';

--
-- Dumping data for table `administradores`
--

INSERT INTO `administradores` (`id`, `contrasena`, `email`) VALUES
(1, 'pass', 'email@email.com'),
(2, 'pass2', 'email2@email.com');

-- --------------------------------------------------------

--
-- Table structure for table `participantes`
--

CREATE TABLE `participantes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `edad` tinyint(2) NOT NULL,
  `fechaIngreso` timestamp NOT NULL DEFAULT current_timestamp(),
  `provincia` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `direccion` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `participantes`
--

INSERT INTO `participantes` (`id`, `nombre`, `apellido`, `edad`, `fechaIngreso`, `provincia`, `email`, `direccion`) VALUES
(2, 'Ana', 'Barrios', 23, '2021-11-03 12:54:18', 'CABA', 'anaBarrios@service.com', 'Av. Siempre Viva 101'),
(4, 'Jorge', 'Perez', 42, '2021-11-03 12:54:18', 'Catamarca', 'jorgePerez@service.com', 'Av. Siempre Viva 103'),
(6, 'Riky', 'Rawson', 78, '2022-01-07 03:00:00', 'San Juan', 'rickyRawson@email.com', 'Av. Nunca muelte 220'),
(7, 'Damian', 'Lichi', 65, '2022-01-15 03:00:00', 'Santa Cruz', 'damianLichi@gmail.com', 'Av. San Narnia 230');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `participantes`
--
ALTER TABLE `participantes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id de uso interno de BD', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `participantes`
--
ALTER TABLE `participantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
