-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-11-2018 a las 05:00:00
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `contraseña` varchar(15) NOT NULL,
  `cod_cliente` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `usuario`, `contraseña`, `cod_cliente`) VALUES
('edwin', 'cuichan', 'egcuichan', 'giovanny12', 1),
('luis', 'cuichan', 'lgcuichan', 'giovanny11', 2),
('ana', 'reyes', 'alreyes', '123456', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE IF NOT EXISTS `pelicula` (
  `cod_pelicula` int(50) NOT NULL AUTO_INCREMENT,
  `nombre_pelicula` varchar(50) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  PRIMARY KEY (`cod_pelicula`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`cod_pelicula`, `nombre_pelicula`, `precio`) VALUES
(1, 'AQUAMAN', '5'),
(2, 'LA MONJA', '5'),
(3, 'VENOM', '5'),
(4, 'JURASSIC PARK', '5'),
(5, 'INCREIBLES II', '5'),
(6, 'THE MEG', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `cod_reserva` int(30) NOT NULL,
  `numero_asiento` int(30) NOT NULL,
  `cod_cliente` int(30) NOT NULL,
  `cod_pelicula` int(50) NOT NULL,
  PRIMARY KEY (`cod_reserva`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`cod_reserva`, `numero_asiento`, `cod_cliente`, `cod_pelicula`) VALUES
(1, 1, 1, 1),
(4, 15, 2, 1),
(3, 25, 2, 1),
(2, 10, 1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
