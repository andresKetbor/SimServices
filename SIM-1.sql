-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-08-2015 a las 21:23:25
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `SIM`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Accion`
--

CREATE TABLE IF NOT EXISTS `Accion` (
`idAccion` int(11) NOT NULL,
  `Accion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `AdministracionMedicamento`
--

CREATE TABLE IF NOT EXISTS `AdministracionMedicamento` (
`idAdminMedic` int(11) NOT NULL,
  `idLibroReport` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Dosis` varchar(20) NOT NULL,
  `Medicamento` varchar(50) NOT NULL,
  `Administracion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alerta`
--

CREATE TABLE IF NOT EXISTS `Alerta` (
`idAlerta` int(11) NOT NULL,
  `Criticidad` varchar(25) NOT NULL,
  `Fecha` date NOT NULL,
  `idLibroReport` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ECG`
--

CREATE TABLE IF NOT EXISTS `ECG` (
`idECG` int(11) NOT NULL,
  `idLibroReport` int(11) NOT NULL,
  `Estado` varchar(25) NOT NULL,
  `Fecha` date NOT NULL,
  `Captura` varchar(100) DEFAULT NULL,
  `PPM` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `FreceunciaRespiratoria`
--

CREATE TABLE IF NOT EXISTS `FreceunciaRespiratoria` (
  `idMedicion` int(11) NOT NULL,
  `FreceunciaRespiratoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LibroReport`
--

CREATE TABLE IF NOT EXISTS `LibroReport` (
`idLibroReport` int(11) NOT NULL,
  `fechaAlta` date NOT NULL,
  `fechaBaja` date DEFAULT NULL,
  `Estado` varchar(20) NOT NULL,
  `idPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
`idLog` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idAccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Medicion`
--

CREATE TABLE IF NOT EXISTS `Medicion` (
  `idMedicion` int(11) NOT NULL,
  `idLibroReport` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Mensaje`
--

CREATE TABLE IF NOT EXISTS `Mensaje` (
`idMensaje` int(11) NOT NULL,
  `Texto` varchar(500) NOT NULL,
  `idUsuarioRemitente` int(11) NOT NULL,
  `idUsuaruiDestinatario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `NivelGlucosa`
--

CREATE TABLE IF NOT EXISTS `NivelGlucosa` (
  `idMedicion` int(11) NOT NULL,
  `Glucosa` varchar(20) NOT NULL,
  `Dosis` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Nota`
--

CREATE TABLE IF NOT EXISTS `Nota` (
`idNota` int(11) NOT NULL,
  `idLibroReport` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Texto` varchar(500) NOT NULL,
  `Adjunto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Paciente`
--

CREATE TABLE IF NOT EXISTS `Paciente` (
`idPaciente` int(11) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Altura` float NOT NULL,
  `Peso` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Permiso`
--

CREATE TABLE IF NOT EXISTS `Permiso` (
`idPermiso` int(11) NOT NULL,
  `Accion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rol`
--

CREATE TABLE IF NOT EXISTS `Rol` (
`idRol` int(11) NOT NULL,
  `NombreRol` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RolAccion`
--

CREATE TABLE IF NOT EXISTS `RolAccion` (
`idRolAccion` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `idAccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Saturometria`
--

CREATE TABLE IF NOT EXISTS `Saturometria` (
  `idMedicion` int(11) NOT NULL,
  `OxigenoEnSangre` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Temperatura`
--

CREATE TABLE IF NOT EXISTS `Temperatura` (
  `idMedicion` int(11) NOT NULL,
  `Temperatura` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TensionArterial`
--

CREATE TABLE IF NOT EXISTS `TensionArterial` (
  `idMedicion` int(11) NOT NULL,
  `TensionArterial` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE IF NOT EXISTS `Usuario` (
`idUsuario` int(11) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Nombre` int(11) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Visita`
--

CREATE TABLE IF NOT EXISTS `Visita` (
`idVisita` int(11) NOT NULL,
  `FechaVisita` date NOT NULL,
  `Frecuencia` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Accion`
--
ALTER TABLE `Accion`
 ADD PRIMARY KEY (`idAccion`);

--
-- Indices de la tabla `AdministracionMedicamento`
--
ALTER TABLE `AdministracionMedicamento`
 ADD PRIMARY KEY (`idAdminMedic`), ADD KEY `idLibroReport` (`idLibroReport`);

--
-- Indices de la tabla `Alerta`
--
ALTER TABLE `Alerta`
 ADD PRIMARY KEY (`idAlerta`), ADD KEY `idLibroReport` (`idLibroReport`);

--
-- Indices de la tabla `ECG`
--
ALTER TABLE `ECG`
 ADD PRIMARY KEY (`idECG`), ADD KEY `idLibroReport` (`idLibroReport`);

--
-- Indices de la tabla `LibroReport`
--
ALTER TABLE `LibroReport`
 ADD PRIMARY KEY (`idLibroReport`), ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `Log`
--
ALTER TABLE `Log`
 ADD PRIMARY KEY (`idLog`);

--
-- Indices de la tabla `Medicion`
--
ALTER TABLE `Medicion`
 ADD PRIMARY KEY (`idMedicion`), ADD KEY `idLibroReport` (`idLibroReport`);

--
-- Indices de la tabla `Mensaje`
--
ALTER TABLE `Mensaje`
 ADD PRIMARY KEY (`idMensaje`), ADD KEY `idUsuarioRemitente` (`idUsuarioRemitente`), ADD KEY `idUsuaruiDestinatario` (`idUsuaruiDestinatario`);

--
-- Indices de la tabla `NivelGlucosa`
--
ALTER TABLE `NivelGlucosa`
 ADD PRIMARY KEY (`idMedicion`);

--
-- Indices de la tabla `Nota`
--
ALTER TABLE `Nota`
 ADD PRIMARY KEY (`idNota`), ADD KEY `idLibroReport` (`idLibroReport`);

--
-- Indices de la tabla `Paciente`
--
ALTER TABLE `Paciente`
 ADD PRIMARY KEY (`idPaciente`), ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `Permiso`
--
ALTER TABLE `Permiso`
 ADD PRIMARY KEY (`idPermiso`);

--
-- Indices de la tabla `Rol`
--
ALTER TABLE `Rol`
 ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `RolAccion`
--
ALTER TABLE `RolAccion`
 ADD PRIMARY KEY (`idRolAccion`), ADD UNIQUE KEY `idRol` (`idRol`,`idAccion`), ADD UNIQUE KEY `idRol_2` (`idRol`,`idAccion`), ADD UNIQUE KEY `idRol_3` (`idRol`,`idAccion`), ADD KEY `idAccion` (`idAccion`);

--
-- Indices de la tabla `Saturometria`
--
ALTER TABLE `Saturometria`
 ADD PRIMARY KEY (`idMedicion`);

--
-- Indices de la tabla `Temperatura`
--
ALTER TABLE `Temperatura`
 ADD PRIMARY KEY (`idMedicion`);

--
-- Indices de la tabla `TensionArterial`
--
ALTER TABLE `TensionArterial`
 ADD PRIMARY KEY (`idMedicion`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
 ADD PRIMARY KEY (`idUsuario`), ADD KEY `idRol` (`idRol`);

--
-- Indices de la tabla `Visita`
--
ALTER TABLE `Visita`
 ADD PRIMARY KEY (`idVisita`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Accion`
--
ALTER TABLE `Accion`
MODIFY `idAccion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `AdministracionMedicamento`
--
ALTER TABLE `AdministracionMedicamento`
MODIFY `idAdminMedic` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Alerta`
--
ALTER TABLE `Alerta`
MODIFY `idAlerta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ECG`
--
ALTER TABLE `ECG`
MODIFY `idECG` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `LibroReport`
--
ALTER TABLE `LibroReport`
MODIFY `idLibroReport` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Log`
--
ALTER TABLE `Log`
MODIFY `idLog` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Mensaje`
--
ALTER TABLE `Mensaje`
MODIFY `idMensaje` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Nota`
--
ALTER TABLE `Nota`
MODIFY `idNota` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Paciente`
--
ALTER TABLE `Paciente`
MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Permiso`
--
ALTER TABLE `Permiso`
MODIFY `idPermiso` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Rol`
--
ALTER TABLE `Rol`
MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `RolAccion`
--
ALTER TABLE `RolAccion`
MODIFY `idRolAccion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Visita`
--
ALTER TABLE `Visita`
MODIFY `idVisita` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `AdministracionMedicamento`
--
ALTER TABLE `AdministracionMedicamento`
ADD CONSTRAINT `AdministracionMedicamento_ibfk_LibroReport` FOREIGN KEY (`idLibroReport`) REFERENCES `LibroReport` (`idLibroReport`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Alerta`
--
ALTER TABLE `Alerta`
ADD CONSTRAINT `Alerta_ibfk_1` FOREIGN KEY (`idLibroReport`) REFERENCES `LibroReport` (`idLibroReport`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ECG`
--
ALTER TABLE `ECG`
ADD CONSTRAINT `ECG_ibfk_LibroReport` FOREIGN KEY (`idLibroReport`) REFERENCES `LibroReport` (`idLibroReport`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `LibroReport`
--
ALTER TABLE `LibroReport`
ADD CONSTRAINT `LibroReport_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `Paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `LibroReport_ibfk_2` FOREIGN KEY (`idLibroReport`) REFERENCES `Paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Medicion`
--
ALTER TABLE `Medicion`
ADD CONSTRAINT `Medicion_ibfk_libroReport` FOREIGN KEY (`idLibroReport`) REFERENCES `LibroReport` (`idLibroReport`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Mensaje`
--
ALTER TABLE `Mensaje`
ADD CONSTRAINT `Mensaje_ibfk_Alerta` FOREIGN KEY (`idMensaje`) REFERENCES `Alerta` (`idAlerta`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `Mensaje_ibfk_UsuarioDestinatario` FOREIGN KEY (`idUsuaruiDestinatario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `Mensaje_ibfk_UsuarioRemitente` FOREIGN KEY (`idUsuarioRemitente`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Nota`
--
ALTER TABLE `Nota`
ADD CONSTRAINT `Nota_ibfk_LibroReport` FOREIGN KEY (`idLibroReport`) REFERENCES `LibroReport` (`idLibroReport`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `RolAccion`
--
ALTER TABLE `RolAccion`
ADD CONSTRAINT `RolAccion_ibfk_Accion` FOREIGN KEY (`idAccion`) REFERENCES `Accion` (`idAccion`) ON UPDATE CASCADE,
ADD CONSTRAINT `RolAccion_ibfk_Rol` FOREIGN KEY (`idRol`) REFERENCES `Rol` (`idRol`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `Usuario`
--
ALTER TABLE `Usuario`
ADD CONSTRAINT `FK_Usuario_Rol` FOREIGN KEY (`idRol`) REFERENCES `Rol` (`idRol`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
