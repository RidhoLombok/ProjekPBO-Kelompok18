-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Des 2023 pada 03.23
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pipegame`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `record`
--

CREATE TABLE `record` (
  `record_id` int(11) NOT NULL,
  `jenislevel` varchar(20) NOT NULL,
  `putaran` int(5) NOT NULL,
  `waktu` double NOT NULL,
  `ppipa` int(5) NOT NULL,
  `nilai` int(8) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `record`
--

INSERT INTO `record` (`record_id`, `jenislevel`, `putaran`, `waktu`, `ppipa`, `nilai`, `user_id`) VALUES
(1, 'Level 1', 6, 3.4, 13, 12480, 1),
(2, 'Level 1', 9, 4.3, 13, 12135, 1),
(3, 'Randomizer', 14, 5.9, 15, 12055, 1),
(4, 'Randomizer', 40, 17.5, 15, 8875, 2),
(5, 'Level 1', 8, 10, 13, 11950, 2),
(6, 'Randomizer', 17, 9.2, 15, 11590, 2),
(7, 'Level 1', 10, 3.9, 13, 12055, 3),
(8, 'Randomizer', 18, 5.5, 15, 11675, 3),
(9, 'Randomizer', 29, 11.1, 15, 10295, 3),
(10, 'Level 1', 7, 2.1, 13, 12445, 3),
(11, 'Level 1', 7, 2.9, 13, 12405, 4),
(12, 'Level 1', 11, 3.1, 13, 11995, 4),
(13, 'Randomizer', 69, 27.9, 23, 7455, 4),
(14, 'Level 1', 7, 2.6, 13, 12420, 4),
(15, 'Randomizer', 15, 5.1, 13, 11495, 4),
(16, 'Randomizer', 14, 5.4, 13, 11580, 4),
(17, 'Randomizer', 43, 15.3, 15, 8685, 5),
(18, 'Level 1', 8, 2.8, 13, 12310, 5),
(19, 'Randomizer', 41, 17.5, 25, 11275, 5),
(20, 'Randomizer', 21, 9, 15, 11200, 5),
(21, 'Level 1', 10, 3.4, 13, 12080, 5),
(22, 'Level 1', 6, 2.1, 13, 12545, 6),
(23, 'Randomizer', 13, 5.5, 15, 12175, 6),
(24, 'Level 1', 15, 4.5, 13, 11525, 7),
(25, 'Level 1', 5, 2.1, 13, 12645, 7),
(26, 'Randomizer', 27, 9.9, 23, 12555, 7),
(27, 'Level 1', 11, 3.2, 13, 11990, 8),
(28, 'Randomizer', 17, 5.5, 15, 11775, 8),
(29, 'Level 1', 7, 2.1, 13, 12445, 8),
(30, 'Randomizer', 28, 10.6, 19, 11420, 8),
(31, 'Level 1', 8, 2.6, 13, 12320, 6),
(32, 'Level 1', 7, 2.9, 13, 12405, 6),
(33, 'Randomizer', 43, 15.7, 21, 10165, 6),
(34, 'Randomizer', 23, 7, 17, 11600, 6),
(35, 'Level 1', 7, 5.8, 13, 12260, 6),
(36, 'Level 1', 6, 10, 13, 12150, 1),
(37, 'Level 1', 7, 3.2, 13, 12390, 6),
(38, 'Randomizer', 16, 4.8, 13, 11410, 6),
(39, 'Randomizer', 29, 10.1, 23, 12345, 9),
(40, 'Level 1', 9, 3.6, 13, 12170, 10),
(41, 'Level 1', 7, 2.6, 13, 12420, 10),
(42, 'Randomizer', 18, 8, 17, 12050, 10),
(43, 'Randomizer', 8, 3.7, 15, 12765, 10),
(44, 'Level 1', 6, 2.4, 13, 12530, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rlevel` int(2) NOT NULL DEFAULT 0,
  `jmain` int(5) NOT NULL DEFAULT 0,
  `jmenang` int(5) NOT NULL DEFAULT 0,
  `jkalah` int(5) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `rlevel`, `jmain`, `jmenang`, `jkalah`) VALUES
(1, 'Ridho', 'ridho', 1, 9, 4, 5),
(2, 'Budiman', '12345', 1, 4, 3, 1),
(3, 'Celine', '54321', 1, 6, 4, 2),
(4, 'Gamer01', '67890', 1, 8, 6, 2),
(5, 'IndoLover96', '09876', 1, 5, 5, 0),
(6, 'Alif', 'aliff', 1, 15, 9, 6),
(7, '(OwO)//hi', 'qwert', 1, 5, 3, 2),
(8, ':) :D :o :O :P', 'trewq', 1, 4, 4, 0),
(9, 'Furina', 'Macaroni', 0, 2, 1, 1),
(10, 'Nahida', 'radish', 1, 6, 5, 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`record_id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `record`
--
ALTER TABLE `record`
  MODIFY `record_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
