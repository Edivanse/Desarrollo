-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: catalogo
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `imparte`
--

DROP TABLE IF EXISTS `imparte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imparte` (
  `idProfesor` int(11) NOT NULL,
  `idUnidadAprendizaje` int(11) NOT NULL,
  PRIMARY KEY (`idProfesor`,`idUnidadAprendizaje`),
  KEY `unidadFK_idx` (`idUnidadAprendizaje`),
  KEY `profesorFk_idx` (`idProfesor`),
  CONSTRAINT `profesorFk` FOREIGN KEY (`idProfesor`) REFERENCES `profesor` (`idprofesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `unidadFK` FOREIGN KEY (`idUnidadAprendizaje`) REFERENCES `unidad_aprendizaje` (`idunidad_aprendizaje`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imparte`
--

LOCK TABLES `imparte` WRITE;
/*!40000 ALTER TABLE `imparte` DISABLE KEYS */;
INSERT INTO `imparte` VALUES (1,11),(3,11),(1,12),(2,12),(3,13);
/*!40000 ALTER TABLE `imparte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `idprofesor` int(11) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `apellidoPaterno` varchar(25) DEFAULT NULL,
  `apellidoMaterno` varchar(25) DEFAULT NULL,
  `rfc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idprofesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Wendy','Caro','Alcaraz','CAR985437ALC8'),(2,'Angela','Armenta','Rivera','ARM010765RIV4'),(3,'Ivan','Sandoval','De La Cerda','SAN874536DEL4');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_aprendizaje`
--

DROP TABLE IF EXISTS `unidad_aprendizaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_aprendizaje` (
  `idunidad_aprendizaje` int(11) NOT NULL,
  `nombreUnidad` varchar(25) DEFAULT NULL,
  `horasClase` int(11) DEFAULT NULL,
  `horasTaller` int(11) DEFAULT NULL,
  `horasLaboratorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idunidad_aprendizaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_aprendizaje`
--

LOCK TABLES `unidad_aprendizaje` WRITE;
/*!40000 ALTER TABLE `unidad_aprendizaje` DISABLE KEYS */;
INSERT INTO `unidad_aprendizaje` VALUES (11,'Matematicas',4,2,2),(12,'Español',5,2,2),(13,'Programacion',6,2,2);
/*!40000 ALTER TABLE `unidad_aprendizaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-04 20:38:44
