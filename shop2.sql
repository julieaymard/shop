-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 05 Mars 2018 à 15:19
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `shop`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `mail` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `mail`) VALUES
(1, 'mark@gmail.com'),
(2, 'sarah@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `date`
--

CREATE TABLE `date` (
  `id` int(11) NOT NULL,
  `day` varchar(28) CHARACTER SET latin1 NOT NULL,
  `open` varchar(120) CHARACTER SET latin1 NOT NULL,
  `close` varchar(120) CHARACTER SET latin1 NOT NULL,
  `farmer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- Contenu de la table `date`
--

INSERT INTO `date` (`id`, `day`, `open`, `close`, `farmer_id`) VALUES
(1, 'monday', '8:00  ', '12:00', 1),
(2, 'tuesday', '8:00', '12:00', 1),
(3, 'wednesday', '8:00', '12:00', 1),
(4, 'thursday', '8:00', '12:00', 1),
(5, 'friday', '8:00', '12:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `farmer`
--

CREATE TABLE `farmer` (
  `id` int(11) NOT NULL,
  `name` varchar(28) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `farmer`
--

INSERT INTO `farmer` (`id`, `name`) VALUES
(1, 'Roland');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(28) CHARACTER SET latin1 NOT NULL,
  `price` int(20) NOT NULL,
  `client_id` int(11) NOT NULL,
  `farmer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `client_id`, `farmer_id`) VALUES
(1, 'fruits', 10, 1, 1),
(2, 'meat', 20, 1, 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `date`
--
ALTER TABLE `date`
  ADD PRIMARY KEY (`id`),
  ADD KEY `farmer_id` (`farmer_id`);

--
-- Index pour la table `farmer`
--
ALTER TABLE `farmer`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `farmer_id` (`farmer_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `date`
--
ALTER TABLE `date`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `farmer`
--
ALTER TABLE `farmer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `date`
--
ALTER TABLE `date`
  ADD CONSTRAINT `date_ibfk_1` FOREIGN KEY (`farmer_id`) REFERENCES `farmer` (`id`);

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`farmer_id`) REFERENCES `farmer` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
