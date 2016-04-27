-- MySQL dump 10.13  Distrib 5.6.28, for Win64 (x86_64)
--
-- Host: localhost    Database: piscina
-- ------------------------------------------------------
-- Server version	5.6.28-log

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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `valor` decimal(6,2) NOT NULL,
  `codCliente` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_ClienteXAgenda` (`codCliente`),
  CONSTRAINT `FK_ClienteXAgenda` FOREIGN KEY (`codCliente`) REFERENCES `cliente` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agendaxdias`
--

DROP TABLE IF EXISTS `agendaxdias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendaxdias` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ano` varchar(6) DEFAULT NULL,
  `dia` varchar(2) DEFAULT NULL,
  `diaSemana` varchar(30) DEFAULT NULL,
  `mes` varchar(2) DEFAULT NULL,
  `codAgenda` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_DiasXAgenda` (`codAgenda`),
  CONSTRAINT `FK_DiasXAgenda` FOREIGN KEY (`codAgenda`) REFERENCES `agenda` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendaxdias`
--

LOCK TABLES `agendaxdias` WRITE;
/*!40000 ALTER TABLE `agendaxdias` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendaxdias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cge`
--

DROP TABLE IF EXISTS `cge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cge` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(50) NOT NULL,
  `celular` varchar(14) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `cidade` varchar(50) NOT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `numero` smallint(6) NOT NULL,
  `rua` varchar(100) NOT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cge`
--

LOCK TABLES `cge` WRITE;
/*!40000 ALTER TABLE `cge` DISABLE KEYS */;
INSERT INTO `cge` VALUES (1,'PIEDADE','(37)99994-6007','35680-398','ITAÚNA','CASA','ericfpsicinas@hotmail.com','ÉRIC.F LIMPEZA E MANUTENÇÃO DE PISCINAS',40,'TRAVESSA EUZIDES FERNANDES','(37)3241-6871'),(2,'CENTRO','(00)00000-0000','35680-000','ITAÚNA','CASA','','ADRIANO',115,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(3,'CENTRO','(00)00000-0000','35680-000','ITAÚNA','COMPLEMENTAR DEPOIS','','ALEX',0,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(4,'COMPLEMENTAR DEPOIS','(00)00000-0000','00000-000','ITAÚNA','COMPLEMENTAR DEPOIS','','ANDREIA',0,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(5,'COMPLEMENTAR DEPOIS','(00)00000-0000','00000-000','ITAÚNA','COMPLEMENTAR DEPOIS','','ANGELA',0,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(6,'COMPLEMENTAR DEPOIS','(00)00000-0000','35680-000','ITAÚNA','COMPLEMENTAR DEPOIS','','ARÍ',0,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(7,'COMPLEMENTAR DEPOIS','(00)00000-0000','35680-000','ITAÚNA','COMPLEMENTAR DEPOIS','','BERNADET',0,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(8,'COMPLEMENTAR DEPOIS','(00)00000-0000','35680-000','ITAÚNA','COMPLEMENTAR DEPOIS','','BRAULIO',0,'COMPLEMENTAR DEPOIS','(00)0000-0000'),(9,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','CARLA',0,'COMPLETAR','(37)0000-0000'),(10,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','CLAYTON',0,'COMPLETAR','(37)0000-0000'),(11,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','ELIANA',0,'COMPLETAR','(37)0000-0000'),(12,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','EURIDES',0,'COMPLETAR','(37)0000-0000'),(13,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','FABRICIO',0,'COMPLETAR','(37)0000-0000'),(14,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','FERNANDO SUCATA',0,'COMPLETAR','(37)0000-0000'),(15,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','FERNANDO',0,'COMPLETAR','(37)0000-0000'),(16,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','GESUS',0,'COMPLETAR','(37)0000-0000'),(17,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','ILDA',0,'COMPLETAR','(37)0000-0000'),(18,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','JERRY',0,'COMPLETAR','(37)0000-0000'),(19,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','JOSE ANGELO',0,'COMPLETAR','(37)0000-0000'),(20,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','JOSE NILO',0,'COMPLETAR','(37)0000-0000'),(21,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','JULIANA',0,'COMPLETAR','(37)0000-0000'),(22,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','JUNINHO D.CARS',0,'COMPLETAR','(37)0000-0000'),(23,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','LUCIA',0,'COMPLETAR','(37)0000-0000'),(24,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','MARCO',0,'COMPLETAR','(37)0000-0000'),(25,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','MAURICIO',0,'COMPLETAR','(37)0000-0000'),(26,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','NASSER',0,'COMPLETAR','(37)0000-0000'),(27,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','NIVALDO',0,'COMPLETAR','(37)0000-0000'),(28,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','OTAVIANO',0,'COMPLETAR','(37)0000-0000'),(29,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','PADRE EUSTÁQUIO',0,'COMPLETAR','(37)0000-0000'),(30,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','PAULINHO',0,'COMPLETAR','(37)0000-0000'),(31,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','RITA',0,'COMPLETAR','(37)0000-0000'),(32,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','ROBSON',0,'COMPLETAR','(37)0000-0000'),(33,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','TIM',0,'COMPLETAR','(37)0000-0000'),(34,'COMPLETAR','(37)00000-0000','35680-000','ITAÚNA','COMPLETAR','','PADRE EVERALDO',0,'COMPLETAR','(37)0000-0000');
/*!40000 ALTER TABLE `cge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `rg` varchar(12) DEFAULT NULL,
  `codCGE` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_CGEXCliente` (`codCGE`),
  CONSTRAINT `FK_CGEXCliente` FOREIGN KEY (`codCGE`) REFERENCES `cge` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'','000.000.000-00','00.000.000-0',2),(2,'','000.000.000-00','00.000.000-0',3),(3,'','000.000.000-00','00.000.000-0',4);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `cnpj` varchar(18) DEFAULT NULL,
  `contato` varchar(40) DEFAULT NULL,
  `inscEstadual` varchar(18) DEFAULT NULL,
  `nomeFantasia` varchar(100) DEFAULT NULL,
  `codCGE` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_CGEXEmpresa` (`codCGE`),
  CONSTRAINT `FK_CGEXEmpresa` FOREIGN KEY (`codCGE`) REFERENCES `cge` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'','00.000.000/0000-00','ÉRIC','000.000.000/0000','ÉRIC F. PISCINAS',1);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `tipo` char(1) NOT NULL,
  `codCGE` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'','adm','2612','A',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-27 10:17:43
