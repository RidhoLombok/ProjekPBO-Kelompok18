-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Des 2023 pada 10.48
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
-- Struktur dari tabel `profil`
--

CREATE TABLE `profil` (
  `id` int(11) NOT NULL,
  `rlevel` int(5) NOT NULL DEFAULT 0,
  `jmain` int(5) NOT NULL DEFAULT 0,
  `jmenang` int(5) NOT NULL DEFAULT 0,
  `jkalah` int(5) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `profil`
--

INSERT INTO `profil` (`id`, `rlevel`, `jmain`, `jmenang`, `jkalah`) VALUES
(10001, 1, 9, 4, 5),
(10002, 1, 4, 3, 1),
(10003, 1, 6, 4, 2),
(10004, 1, 8, 6, 2),
(10005, 1, 5, 5, 0),
(10006, 1, 12, 7, 5),
(10007, 1, 5, 3, 2),
(10008, 1, 4, 4, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `record`
--

CREATE TABLE `record` (
  `id` int(11) NOT NULL,
  `jenislevel` varchar(20) NOT NULL,
  `putaran` int(5) NOT NULL,
  `waktu` double NOT NULL,
  `ppipa` int(5) NOT NULL,
  `nilai` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `record`
--

INSERT INTO `record` (`id`, `jenislevel`, `putaran`, `waktu`, `ppipa`, `nilai`) VALUES
(10001, 'Level 1', 6, 3.4, 13, 12480),
(10001, 'Level 1', 9, 4.3, 13, 12135),
(10001, 'Randomizer', 14, 5.9, 15, 12055),
(10002, 'Randomizer', 40, 17.5, 15, 8875),
(10002, 'Level 1', 8, 10, 13, 11950),
(10002, 'Randomizer', 17, 9.2, 15, 11590),
(10003, 'Level 1', 10, 3.9, 13, 12055),
(10003, 'Randomizer', 18, 5.5, 15, 11675),
(10003, 'Randomizer', 29, 11.1, 15, 10295),
(10003, 'Level 1', 7, 2.1, 13, 12445),
(10004, 'Level 1', 7, 2.9, 13, 12405),
(10004, 'Level 1', 11, 3.1, 13, 11995),
(10004, 'Randomizer', 69, 27.9, 23, 7455),
(10004, 'Level 1', 7, 2.6, 13, 12420),
(10004, 'Randomizer', 15, 5.1, 13, 11495),
(10004, 'Randomizer', 14, 5.4, 13, 11580),
(10005, 'Randomizer', 43, 15.3, 15, 8685),
(10005, 'Level 1', 8, 2.8, 13, 12310),
(10005, 'Randomizer', 41, 17.5, 25, 11275),
(10005, 'Randomizer', 21, 9, 15, 11200),
(10005, 'Level 1', 10, 3.4, 13, 12080),
(10006, 'Level 1', 6, 2.1, 13, 12545),
(10006, 'Randomizer', 13, 5.5, 15, 12175),
(10007, 'Level 1', 15, 4.5, 13, 11525),
(10007, 'Level 1', 5, 2.1, 13, 12645),
(10007, 'Randomizer', 27, 9.9, 23, 12555),
(10008, 'Level 1', 11, 3.2, 13, 11990),
(10008, 'Randomizer', 17, 5.5, 15, 11775),
(10008, 'Level 1', 7, 2.1, 13, 12445),
(10008, 'Randomizer', 28, 10.6, 19, 11420),
(10006, 'Level 1', 8, 2.6, 13, 12320),
(10006, 'Level 1', 7, 2.9, 13, 12405),
(10006, 'Randomizer', 43, 15.7, 21, 10165),
(10006, 'Randomizer', 23, 7, 17, 11600),
(10006, 'Level 1', 7, 5.8, 13, 12260),
(10001, 'Level 1', 6, 10, 13, 12150);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(10001, 'Furina', 'Macaroni'),
(10002, 'Budiman', '12345'),
(10003, 'Celine', '54321'),
(10004, 'Gamer01', '67890'),
(10005, 'IndoLover96', '09876'),
(10006, 'Alif', 'aliff'),
(10007, '(OwO)//hi', 'qwert'),
(10008, ':) :D :o :O :P', 'trewq');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10009;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
