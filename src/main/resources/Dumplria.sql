-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: lria
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airplanes`
--

DROP TABLE IF EXISTS `airplanes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplanes` (
  `idairplanes` int NOT NULL AUTO_INCREMENT,
  `airplane_name` varchar(45) NOT NULL,
  `equipment` varchar(45) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  `age` int NOT NULL,
  `first_class_seats` int NOT NULL,
  `business_class_seats` int NOT NULL,
  `economic_class_seats` int NOT NULL,
  PRIMARY KEY (`idairplanes`),
  UNIQUE KEY `airplane_name_UNIQUE` (`airplane_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplanes`
--

LOCK TABLES `airplanes` WRITE;
/*!40000 ALTER TABLE `airplanes` DISABLE KEYS */;
INSERT INTO `airplanes` VALUES (1,'W63655','320-NEO','Airbus',10,0,20,110),(2,'0B6102','737-800','Boeing',12,0,0,150),(3,'BA175','747-400','Boeing',16,16,48,280),(4,'BA27','A380-800','Airbus',8,20,54,240),(5,'EY20','787-9','Boeing',4,0,40,200);
/*!40000 ALTER TABLE `airplanes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `idclients` int NOT NULL AUTO_INCREMENT,
  `first_Name` varchar(45) NOT NULL,
  `last_Name` varchar(45) NOT NULL,
  `age` int NOT NULL,
  `flightId` int NOT NULL,
  `ticketId` int NOT NULL,
  `ticket_Price` float DEFAULT NULL,
  `seat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idclients`),
  KEY `ticket_type_idx` (`ticketId`),
  KEY `flight_id_idx` (`flightId`),
  CONSTRAINT `flight_id` FOREIGN KEY (`flightId`) REFERENCES `flights` (`idflights`),
  CONSTRAINT `ticket_type` FOREIGN KEY (`ticketId`) REFERENCES `ticket_type` (`idticket_type`)
) ENGINE=InnoDB AUTO_INCREMENT=692 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (2,'Eal','Minghetti',64,18,2,434.43,'1B'),(3,'Rosanna','Lowrie',60,116,3,36.98,'1C'),(4,'Bax','Ferrulli',98,138,2,431.6,'1B'),(6,'Zaria','Rosenblatt',82,81,2,87.47,'1B'),(7,'Lanae','Struys',78,128,3,174.84,'1C'),(9,'Nero','Wallhead',52,134,2,3048.44,'1B'),(10,'Genevieve','Smith',93,9,3,1223.31,'1C'),(11,'Kurt','Mould',55,49,1,4574.8,'1A'),(13,'Dolli','De Beauchemp',39,97,3,179.82,'1C'),(14,'Kayle','Fulle',95,53,3,175.46,'1C'),(15,'Margaretha','Neath',25,145,2,1501.55,'1B'),(17,'Dennison','Henrichsen',5,53,1,649.38,'1A'),(19,'Bertie','Shurrocks',9,147,3,179.56,'1C'),(20,'Cecilla','Studd',59,43,1,649.85,'1A'),(21,'Marissa','Joyson',20,135,3,602.82,'1C'),(22,'Celisse','Bulbrook',98,100,2,1502.02,'1B'),(24,'Shamus','Holborn',12,81,3,37.21,'1C'),(25,'Gavra','Howard - Gater',59,75,2,1502.43,'1B'),(26,'Nadia','Larvent',80,124,2,3048.53,'1B'),(28,'Domenico','Spini',9,41,3,37.71,'1C'),(30,'Urbain','Dodd',36,56,2,88,'1B'),(31,'Gaynor','McLae',54,14,3,1223.1,'1C'),(33,'Verna','Smithen',33,20,3,604.2,'1C'),(35,'Petronilla','Bessant',58,64,3,1222.05,'1C'),(36,'Tamarra','Canto',79,52,3,180.26,'1C'),(37,'Reynard','Renish',92,29,2,3050.65,'1B'),(39,'Harmonie','Mattson',22,25,2,1504.09,'1B'),(40,'Britta','L\'argent',75,40,3,603.7,'1C'),(42,'Brooke','MacCarroll',76,95,3,603.05,'1C'),(43,'Tiffie','Miners',44,136,2,86.8,'1B'),(45,'Johan','Rannald',24,78,1,648.52,'1A'),(47,'Charlton','Painten',43,9,1,4577.97,'1A'),(48,'Leanor','Beausang',48,116,3,36.98,'2C'),(49,'Demetrius','Blonfield',56,108,3,174.95,'1C'),(51,'Irita','Laker',24,19,2,3051.22,'1B'),(52,'Hyacinth','Casbourne',43,46,2,88.28,'1B'),(53,'Lyndsey','Kopisch',41,144,3,1221.5,'1C'),(54,'Skip','Benedtti',52,24,3,1222.78,'1C'),(56,'Corry','Zanolli',51,80,3,603.17,'1C'),(57,'Kay','Burrows',52,81,3,37.21,'2C'),(58,'Morey','Proschke',49,139,3,1221.52,'1C'),(59,'Tamiko','Swalough',69,26,3,38.02,'1C'),(60,'Madelina','Jenoure',25,104,3,1221.7,'1C'),(61,'Ola','Wittier',91,86,2,87.39,'1B'),(62,'Byrann','Quimby',45,13,1,652.18,'1A'),(63,'Raddie','Quadri',27,137,3,179.6,'1C'),(64,'Nye','Brannon',38,75,2,1502.43,'2B'),(65,'Mendel','Shakesby',19,110,2,1501.89,'1B'),(66,'Iain','Dallas',11,44,3,1222.33,'1C'),(67,'Khalil','Braxay',71,144,2,3048.35,'1B'),(68,'Alick','Strettell',98,130,3,602.84,'1C'),(69,'Ethelind','Sedge',18,28,3,175.93,'1C'),(70,'Karmen','Herculson',83,90,2,1502.17,'1B'),(71,'Efrem','Dingley',84,14,1,4577.35,'1A'),(72,'Oriana','Faux',41,103,2,431.96,'1B'),(73,'Star','Veld',6,21,3,38.15,'1C'),(74,'Guillaume','Moukes',75,125,3,602.87,'1C'),(75,'Fabio','Relfe',97,37,3,180.51,'1C'),(76,'Rahal','Guillon',17,19,3,1222.93,'1C'),(77,'Batholomew','Yakobowitz',67,61,2,87.87,'1B'),(78,'Kriste','Walter',90,136,2,86.8,'2B'),(79,'Horace','Conklin',40,95,3,603.05,'2C'),(80,'Alphonso','Darrigoe',89,14,2,3051.57,'1B'),(81,'Malissa','Bottomer',87,111,3,37,'1C'),(82,'Skippie','Hierro',68,68,2,432.55,'1B'),(83,'Tandi','Lyokhin',41,38,3,175.71,'1C'),(84,'Franni','Gittose',37,76,2,87.56,'1B'),(85,'Elbertina','Brantzen',77,35,2,1503.6,'1B'),(86,'Ingrim','Vasilic',92,65,3,603.32,'1C'),(87,'Alic','Bastick',68,50,2,1503.05,'1B'),(88,'Gnni','Dinneen',98,129,1,4572.73,'1A'),(89,'Mohandas','Menezes',93,113,2,431.84,'1B'),(90,'Silvano','Lanphere',91,96,2,87.24,'1B'),(91,'Starla','Ply',48,58,2,432.79,'1B'),(92,'Jasun','Elmar',76,136,2,86.8,'3B'),(93,'Daveen','Wigfield',97,85,3,603.12,'1C'),(94,'Rutter','Riseborough',72,75,3,603.22,'1C'),(95,'Ira','Meanwell',9,129,2,3048.49,'1B'),(96,'Dick','GiacobbiniJacob',95,40,2,1503.4,'1B'),(97,'Katharyn','Byforth',32,119,2,3048.59,'1B'),(98,'Tallie','Sasser',51,115,3,602.92,'1C'),(99,'Gussie','Mauger',72,13,1,652.18,'2A'),(100,'Henrik','Sobey',24,63,1,648.99,'1A'),(101,'Jemmie','Allbrook',30,125,3,602.87,'2C'),(102,'Rycca','Methley',41,16,2,89.66,'1B'),(103,'Violetta','Gerkens',68,110,3,602.95,'1C'),(104,'Dotti','Grzesiewicz',11,25,2,1504.09,'2B'),(105,'Fifi','Scatcher',19,7,3,181.41,'1C'),(106,'Flss','Shills',25,146,3,36.84,'1C'),(107,'Bud','Lethbridge',55,150,3,602.76,'1C'),(108,'Valina','Leal',88,37,3,180.51,'2C'),(109,'Mark','Niblett',91,79,2,3049.15,'1B'),(110,'Randal','Birtley',34,89,2,3048.98,'1B'),(111,'Vania','Hosburn',88,3,1,653.54,'1A'),(112,'Garnette','Hatton',47,137,3,179.6,'2C'),(113,'Sarette','Faireclough',74,103,3,174.98,'1C'),(114,'Florie','Boult',84,119,3,1221.61,'1C'),(115,'Mozes','Peatheyjohns',27,127,3,179.65,'1C'),(116,'Almeda','Whipple',65,62,3,180.13,'1C'),(117,'Barclay','Dinneges',33,49,1,4574.8,'2A'),(118,'Julie','Ronayne',5,9,2,3051.98,'1B'),(119,'Parry','Lorenzetto',44,103,3,174.98,'2C'),(120,'Anneliese','Skrine',44,110,2,1501.89,'2B'),(121,'Ingamar','Durston',99,38,3,175.71,'2C'),(122,'Robb','Greenhead',36,93,1,648.15,'1A'),(123,'Alonzo','Vousden',91,34,2,3050.42,'1B'),(124,'Marielle','Jankowski',55,91,3,37.13,'1C'),(125,'Giraldo','Fowlds',60,70,3,603.27,'2C'),(126,'Lannie','Palk',50,10,3,604.57,'1C'),(127,'Bev','Page',96,92,3,179.85,'1C'),(128,'Gilly','Hazeup',32,16,2,89.66,'2B'),(129,'Cozmo','Calverley',40,94,2,3048.9,'1B'),(130,'Creight','Hamlin',36,43,3,175.62,'1C'),(131,'Archaimbaud','Vereker',62,130,3,602.84,'2C'),(132,'Karly','Nolleau',48,91,2,87.31,'1B'),(133,'Eldridge','Furneaux',12,78,2,432.35,'1B'),(134,'Karlis','Grey',9,43,1,649.85,'2A'),(135,'Luisa','Ninnoli',82,43,3,175.62,'2C'),(136,'Donny','Goodhay',37,84,2,3049.06,'1B'),(137,'Raeann','Lightfoot',37,129,1,4572.73,'2A'),(138,'Angele','Ornillos',27,75,3,603.22,'2C'),(139,'Mannie','Tupie',56,8,3,176.6,'1C'),(140,'Joela','Skaife',30,8,1,652.8,'1A'),(141,'Stefania','Martinello',11,134,2,3048.44,'3B'),(142,'Rochelle','Delcastel',41,120,3,602.89,'2C'),(143,'Larina','Moohan',91,60,2,1502.77,'1B'),(144,'Dorine','Louth',83,51,3,37.55,'1C'),(145,'Gabbie','Catterick',76,80,3,603.17,'2C'),(146,'Pierson','Baitman',67,8,3,176.6,'2C'),(147,'Mendy','Antrobus',42,76,2,87.56,'2B'),(148,'Cheslie','Aslie',97,128,2,431.69,'1B'),(149,'Rex','Kinzett',26,135,2,1501.64,'1B'),(150,'Gusty','Brumbye',42,107,3,179.75,'1C'),(151,'Minne','Cornelissen',13,3,2,435.69,'1B'),(152,'Amara','Lum',79,70,3,603.27,'3C'),(153,'Donalt','McKenzie',85,14,2,3051.57,'2B'),(154,'Nanny','Jarvie',39,85,2,1502.25,'1B'),(155,'Benoite','Aronstam',59,58,2,432.79,'2B'),(156,'Candis','Pelcheur',86,76,2,87.56,'3B'),(157,'Armstrong','MacNally',94,83,1,648.39,'1A'),(158,'Carmelita','Masselin',34,50,3,603.53,'1C'),(159,'Christoforo','Januszewicz',5,49,3,1222.25,'1C'),(160,'Christina','O\'Lagen',92,63,1,648.99,'2A'),(161,'Nikolas','Polycote',29,148,3,174.76,'1C'),(162,'Lucretia','Cecely',72,36,3,37.8,'1C'),(163,'Abbi','Rackham',86,150,2,1501.51,'1B'),(164,'Verna','Linzee',26,108,1,647.85,'1A'),(165,'Mathe','Jerschke',89,148,1,647.28,'1A'),(166,'Margarethe','Pauli',21,143,2,431.56,'1B'),(167,'Cristie','Woollhead',79,47,3,180.34,'1C'),(168,'Farlay','Fasey',33,94,3,1221.77,'1C'),(169,'Felipe','MacMeanma',99,28,1,650.79,'1A'),(170,'Jilly','Iacomelli',5,91,2,87.31,'2B'),(171,'Darwin','Linnard',51,120,2,1501.78,'1B'),(172,'Athene','Sculpher',55,45,3,603.61,'1C'),(173,'Munroe','Alaway',15,100,2,1502.02,'2B'),(174,'Leo','Boadby',15,59,2,3049.58,'1B'),(175,'Lorrayne','Kenefick',46,145,3,602.78,'1C'),(176,'Odella','Saffle',99,92,3,179.85,'2C'),(177,'Duke','Gravenall',31,150,3,602.76,'2C'),(178,'Barth','Ahlin',40,123,2,431.74,'1B'),(179,'Gerald','Diviney',68,38,1,650.13,'1A'),(180,'Bowie','Philcock',87,90,2,1502.17,'2B'),(181,'Kyle','Elham',87,57,3,180.2,'1C'),(182,'Yale','Froggatt',90,59,1,4574.37,'2A'),(183,'Modestia','Grassick',20,100,2,1502.02,'3B'),(184,'Chryste','Tiley',70,155,3,602.74,'1C'),(185,'Richie','Gowanson',93,84,2,3049.06,'2B'),(186,'Annora','Benech',40,13,1,652.18,'3A'),(187,'Max','Labon',54,115,2,1501.84,'1B'),(188,'Darrell','Steutly',59,45,2,1503.21,'1B'),(189,'Grace','Hastelow',73,64,3,1222.05,'2C'),(190,'Betti','Gottelier',40,33,3,175.81,'1C'),(191,'Bone','Caesman',81,111,2,87.05,'1B'),(192,'Gay','Cumo',16,85,2,1502.25,'2B'),(193,'Bianca','Teape',68,115,3,602.92,'2C'),(194,'Imelda','Hadigate',13,98,2,432.03,'1B'),(195,'Misti','Epgrave',56,135,2,1501.64,'2B'),(196,'Kellina','Westgate',79,124,3,1221.59,'1C'),(197,'Orran','Stienham',66,144,1,4572.53,'1A'),(198,'Lolita','Burchatt',41,95,2,1502.09,'1B'),(199,'Pierce','Bourgour',59,71,3,37.31,'1C'),(200,'Jakob','Elliff',72,104,1,4573.14,'1A'),(201,'Benedick','Passler',62,154,1,4572.42,'1A'),(202,'Corella','Garrals',52,15,3,604.37,'1C'),(203,'Dynah','Garrioch',14,56,2,88,'3B'),(204,'Berti','Jeayes',53,108,2,431.9,'1B'),(205,'Enrika','MacAne',24,79,2,3049.15,'2B'),(206,'Brennan','Hellis',32,134,2,3048.44,'4B'),(207,'Vicki','Sprackling',67,114,2,3048.64,'1B'),(208,'Michale','Rangall',51,61,3,37.42,'1C'),(209,'Katleen','Keates',43,99,1,4573.24,'1A'),(210,'Martita','Bonar',33,155,2,1501.48,'1B'),(211,'Willow','Probin',87,143,3,174.78,'1C'),(212,'Hagen','Durrett',72,20,3,604.2,'2C'),(213,'Estelle','Billam',72,30,3,603.91,'1C'),(214,'Alwin','Thicking',48,113,1,647.77,'1A'),(215,'Hadria','Gurnay',5,154,2,3048.28,'1B'),(216,'Rianon','MacGlory',74,94,2,3048.9,'2B'),(217,'Jeni','Pippin',53,18,3,176.22,'1C'),(218,'Letty','Penna',38,116,2,86.99,'1B'),(219,'Anjanette','Eberlein',90,154,1,4572.42,'2A'),(220,'Consuelo','Jickells',70,142,3,179.58,'1C'),(221,'Gilli','Amaya',52,36,2,88.64,'1B'),(222,'Odey','MacKill',81,19,3,1222.93,'2C'),(223,'Mollie','Elbourne',94,103,2,431.96,'2B'),(224,'Rubi','McCloughlin',16,88,3,175.09,'2C'),(225,'Maurizio','Fendlow',26,88,1,648.27,'1A'),(226,'Nanni','Fardell',87,152,3,179.54,'1C'),(227,'Lynn','Choudhury',15,11,3,38.49,'1C'),(228,'Ozzy','Hundley',59,28,1,650.79,'2A'),(229,'Dyna','Yakebovich',41,109,2,3048.7,'1B'),(230,'Piper','Cassam',8,105,3,602.98,'1C'),(231,'Orion','Itshak',20,73,3,175.22,'1C'),(232,'Agace','Gradon',68,28,2,433.86,'1B'),(233,'Ophelie','Bowfin',26,34,3,1222.53,'1C'),(234,'Karina','McCrackem',33,69,1,4574.02,'1A'),(235,'Paulita','Shawel',37,94,3,1221.77,'2C'),(236,'Easter','Stobbes',27,129,1,4572.73,'3A'),(237,'Nady','Keward',98,18,2,434.43,'2B'),(238,'Miner','Bruford',94,49,3,1222.25,'2C'),(239,'Kristyn','Hendrix',17,81,2,87.47,'2B'),(240,'Laryssa','Loache',77,130,3,602.84,'3C'),(241,'Gawen','Hazelgrove',11,118,1,647.68,'1A'),(242,'Job','Winmill',72,37,3,180.51,'3C'),(243,'Dottie','Fullman',83,35,2,1503.6,'2B'),(244,'Maximilianus','Swyer-Sexey',28,59,2,3049.58,'2B'),(245,'Anny','Cannings',25,57,3,180.2,'2C'),(246,'Lewie','Darbyshire',47,89,1,4573.46,'1A'),(247,'Donielle','Eaken',55,44,1,4575.04,'1A'),(248,'Kerby','Goward',85,18,3,176.22,'2C'),(249,'Aime','Paragreen',7,39,1,4575.32,'1A'),(250,'Jeremiah','Nunan',70,39,2,3050.21,'1B'),(251,'Trish','Bartlomiej',39,83,3,175.13,'1C'),(252,'Wilburt','Balfe',48,98,1,648.05,'1A'),(253,'Gilles','Reford',25,33,2,433.63,'2B'),(254,'Leontine','Brach',25,65,3,603.32,'2C'),(255,'Victoir','Kleynen',40,126,2,86.89,'1B'),(256,'Pren','Dedden',10,29,1,4575.98,'1A'),(257,'Nissie','Gittose',26,115,3,602.92,'3C'),(258,'Clerissa','Baert',32,88,2,432.18,'1B'),(259,'Thorin','Knott',38,32,3,180.62,'1C'),(260,'Elia','Cisco',96,6,2,90.44,'1B'),(261,'Gaynor','Stonuary',88,155,3,602.74,'2C'),(262,'Binni','Kwietak',8,72,3,180.02,'1C'),(263,'Susan','Grimwade',32,89,3,1221.81,'1C'),(264,'Sidoney','Cumber',48,28,1,650.79,'3A'),(265,'Nikolaos','Lowres',22,133,2,431.64,'1B'),(266,'Dru','Puller',58,124,1,4572.8,'1A'),(267,'Estrellita','Hartigan',10,73,3,175.22,'2C'),(268,'Eilis','Adamsson',81,109,2,3048.7,'2B'),(269,'Ian','Meckiff',35,97,3,179.82,'2C'),(270,'Gwenore','Wright',20,99,3,1221.73,'1C'),(271,'Miles','Bere',13,24,2,3050.91,'1B'),(272,'Tamqrah','Enderle',5,123,1,647.61,'1A'),(273,'Sara','Imlen',87,108,3,174.95,'2C'),(274,'Jaimie','Mangion',63,138,1,647.4,'1A'),(275,'Dre','Boyan',65,145,2,1501.55,'2B'),(276,'Dawn','Huban',94,122,3,179.67,'1C'),(277,'Clevie','Malinowski',78,68,2,432.55,'2B'),(278,'Annabal','Ossipenko',5,80,3,603.17,'3C'),(279,'Mariann','Bridat',13,119,2,3048.59,'2B'),(280,'Sophey','Pulhoster',11,111,2,87.05,'2B'),(281,'Lyn','Ghidini',30,14,1,4577.35,'2A'),(282,'Townie','Finlry',16,126,2,86.89,'2B'),(283,'Briano','Ellingham',97,87,3,179.89,'1C'),(284,'Ronna','Chmiel',16,60,2,1502.77,'2B'),(285,'Fairfax','Scading',27,74,1,4573.86,'1A'),(286,'Will','Manklow',81,123,1,647.61,'2A'),(287,'Dougie','Vick',63,3,3,176.85,'1C'),(288,'Krissie','Munnion',31,100,2,1502.02,'4B'),(289,'Demeter','Franciotti',73,36,3,37.8,'2C'),(290,'Domenic','Walling',32,140,2,1501.59,'1B'),(291,'Kellyann','Matoshin',53,108,1,647.85,'2A'),(292,'Stephanie','Storres',41,29,1,4575.98,'2A'),(293,'Coleen','Schirak',59,134,2,3048.44,'5B'),(294,'Anthia','Osbaldstone',8,48,2,433.07,'1B'),(295,'Van','Mounfield',58,154,2,3048.28,'2B'),(296,'Anabal','Tanner',74,118,1,647.68,'2A'),(297,'Germain','Venmore',35,50,3,603.53,'2C'),(298,'Rodd','Jurkowski',6,10,3,604.58,'2C'),(299,'Giffer','Baine',52,124,2,3048.53,'2B'),(300,'Micheal','Chichgar',96,103,1,647.95,'2A'),(301,'Margette','Ballantyne',99,64,3,1222.05,'3C'),(302,'Sammy','Waye',20,6,2,90.44,'2B'),(303,'Constance','Fitzroy',83,51,3,37.55,'2C'),(304,'Demetri','Geleman',12,44,2,3050.03,'1B'),(305,'Mallory','Mathon',43,38,3,175.71,'3C'),(306,'Barr','Crum',81,139,2,3048.4,'1B'),(307,'Meyer','Addeycott',84,86,3,37.17,'1C'),(308,'Florian','Lampart',98,78,3,175.17,'1C'),(309,'Mariette','Roycroft',6,57,3,180.2,'3C'),(310,'Vitia','Baile',9,13,2,434.78,'1B'),(311,'Tiffani','Moorcroft',73,35,2,1503.6,'3B'),(312,'Russell','Bowditch',44,145,3,602.78,'2C'),(313,'Lockwood','Briance',49,108,1,647.85,'3A'),(314,'Darrell','Brannon',25,120,3,602.89,'3C'),(315,'Velvet','Pidgley',7,118,3,174.89,'1C'),(316,'Abbey','Cakebread',6,147,3,179.56,'2C'),(317,'Corrie','Krier',97,149,3,1221.48,'1C'),(318,'Mariellen','Gwynn',25,146,3,36.84,'2C'),(319,'See','Batt',90,148,2,431.52,'1B'),(320,'Lockwood','Treeby',92,76,2,87.56,'4B'),(321,'Auria','Cardwell',47,61,3,37.42,'2C'),(322,'Penn','Redmain',64,77,3,179.98,'1C'),(323,'Jerrilee','April',52,104,2,3048.76,'1B'),(324,'Zarah','Firpi',93,149,2,3048.32,'1B'),(325,'Antonetta','Preddle',65,83,1,648.39,'2A'),(326,'Barde','Cathrall',80,143,2,431.56,'2B'),(327,'Aila','Jaques',24,91,2,87.31,'3B'),(328,'Alfonse','Sokell',71,63,3,175.33,'1C'),(329,'Arney','Glisane',65,93,2,432.1,'1B'),(330,'Dru','Molineux',67,120,3,602.89,'4C'),(331,'Kristo','Korba',78,41,2,88.45,'1B'),(332,'Della','Ivashnikov',52,57,3,180.2,'4C'),(333,'Nanice','Sharper',25,71,2,87.65,'1B'),(334,'Micah','Codling',73,46,2,88.28,'2B'),(335,'Asia','Jaukovic',90,16,3,38.31,'1C'),(336,'Berton','Glasscock',87,61,3,37.42,'3C'),(337,'Lizette','Dutt',80,38,3,175.71,'4C'),(338,'Latashia','Smalles',51,106,3,37.03,'1C'),(339,'Erwin','Harewood',22,104,1,4573.14,'2A'),(340,'Karen','Grammer',34,152,3,179.54,'2C'),(341,'Franky','Wychard',12,53,1,649.38,'2A'),(342,'Hiram','Cotilard',12,115,2,1501.84,'2B'),(343,'Jennica','Berzon',25,144,3,1221.5,'2C'),(344,'Pearline','Talton',29,41,3,37.71,'2C'),(345,'Jenica','Grayer',39,107,3,179.75,'2C'),(346,'Adoree','Goldthorp',49,78,2,432.35,'2B'),(347,'Myrilla','Boyde',15,6,2,90.44,'3B'),(348,'Andres','Scuffham',65,119,1,4572.88,'1A'),(349,'Marguerite','Teanby',27,133,2,431.64,'2B'),(350,'Agosto','Crockford',53,119,3,1221.61,'2C'),(351,'Rockey','Embery',5,128,1,647.53,'1A'),(352,'Amye','Collard',96,44,3,1222.33,'2C'),(353,'Damaris','Roggieri',84,118,3,174.89,'2C'),(354,'Torrie','Saffran',28,78,3,175.17,'2C'),(355,'Grady','Charley',61,18,1,651.65,'1A'),(356,'Rozalie','Avramovitz',5,56,3,37.48,'1C'),(357,'Ame','Dickins',82,114,2,3048.64,'2B'),(358,'Nolly','Karpov',9,106,2,87.11,'1B'),(359,'Lisha','Dibbe',74,9,1,4577.97,'2A'),(360,'Hurley','Paynton',66,43,2,433.24,'2B'),(361,'Ronalda','Peabody',97,48,3,175.54,'1C'),(362,'Quentin','Gilmore',46,11,3,38.49,'2C'),(363,'Alfred','Bloschke',23,124,3,1221.59,'2C'),(364,'Sunny','Polgreen',32,57,3,180.2,'5C'),(365,'Kitty','Rontsch',14,91,2,87.31,'4B'),(366,'Rurik','Wade',36,4,1,4578.7,'2A'),(367,'Anjela','Pickthall',55,103,2,431.96,'4B'),(368,'Berty','McGaugey',21,28,1,650.79,'4A'),(369,'Berry','Beilby',64,153,1,647.22,'1A'),(370,'Roley','Coupe',30,155,3,602.74,'3C'),(371,'Karlotte','Fidgin',52,138,2,431.6,'2B'),(372,'Lizabeth','Sains',71,145,2,1501.55,'3B'),(373,'Seth','Jealous',76,55,2,1502.9,'1B'),(374,'Livvie','Glabach',85,146,2,86.72,'1B'),(375,'Rochette','Snar',99,38,2,433.42,'1B'),(376,'Cornelius','Bowdon',51,135,3,602.82,'2C'),(377,'Ricky','Farryn',71,30,2,1503.83,'1B'),(378,'Chelsey','Tommis',29,105,3,602.98,'2C'),(379,'Enrichetta','Borer',58,121,3,36.95,'1C'),(380,'Zorina','Garlic',78,43,1,649.85,'3A'),(381,'Jeniece','Tawton',15,65,3,603.32,'3C'),(382,'Kaspar','Upex',24,74,3,1221.94,'1C'),(383,'Jody','Fenty',22,134,2,3048.44,'6B'),(384,'Sterling','Hatherall',26,5,3,604.81,'1C'),(385,'Kissie','Arnoll',27,70,3,603.27,'4C'),(386,'Gan','Jachimiak',27,69,1,4574.02,'2A'),(387,'Cynthie','Hume',17,79,2,3049.15,'3B'),(388,'Bastien','Daymond',7,117,3,179.7,'1C'),(389,'Ricky','McEachern',84,48,3,175.54,'2C'),(390,'Harriot','Groven',51,121,2,86.94,'1B'),(391,'Monti','Allchorne',34,54,1,4574.57,'1A'),(392,'Joela','Banasiak',7,115,3,602.92,'4C'),(393,'Glenn','Ullrich',31,121,2,86.94,'2B'),(394,'Heall','Dufer',99,10,2,1505.14,'2B'),(395,'Emile','Grutchfield',22,19,3,1222.93,'3C'),(396,'Carly','Germann',84,91,3,37.13,'2C'),(397,'Fernandina','Labrone',30,12,3,181.2,'1C'),(398,'Freeland','Schimek',50,120,2,1501.78,'2B'),(399,'Timmy','Kearford',32,70,2,1502.54,'1B'),(400,'Catlee','Athow',97,53,1,649.38,'3A'),(401,'Flossy','Whiteson',51,109,2,3048.7,'3B'),(402,'Melessa','Eagers',96,40,3,603.7,'2C'),(403,'Kissiah','Bettison',40,30,2,1503.83,'2B'),(404,'Miner','Trahar',77,63,2,432.66,'1B'),(405,'Roana','Championnet',55,73,2,432.44,'1B'),(406,'Frederique','Marquet',89,144,2,3048.35,'2B'),(407,'Reta','Keeler',46,99,1,4573.24,'2A'),(408,'Georgeanna','Sillis',5,154,1,4572.42,'3A'),(409,'Marci','Bartolomeotti',36,108,3,174.95,'3C'),(410,'Gonzalo','Henri',31,11,2,90.02,'1B'),(411,'Fan','Mursell',89,85,2,1502.25,'3B'),(412,'Gearard','Rentenbeck',16,64,1,4574.19,'1A'),(413,'Giorgia','Vereker',88,46,2,88.28,'3B'),(414,'Gilberto','Currum',25,96,2,87.24,'2B'),(415,'Pedro','Shrubshall',6,11,3,38.49,'3C'),(416,'Jule','Trevethan',87,131,3,36.9,'1C'),(417,'Candida','Meenan',93,74,3,1221.94,'2C'),(418,'Ollie','Scales',56,86,2,87.39,'2B'),(419,'William','Rodwell',48,53,3,175.46,'2C'),(420,'Orion','Maggs',47,148,3,174.76,'2C'),(421,'Felice','Steeples',11,35,2,1503.6,'4B'),(422,'Ginger','Pond',34,148,1,647.28,'2A'),(423,'Glory','Mocher',14,110,3,602.95,'2C'),(424,'Ebenezer','Spink',39,106,2,87.11,'2B'),(425,'Cathie','Kolak',85,144,1,4572.53,'2A'),(426,'Paolina','Murrigans',56,73,2,432.44,'2B'),(427,'Llywellyn','Towey',20,107,3,179.75,'3C'),(428,'Brooks','McCready',77,56,3,37.48,'2C'),(429,'Raffarty','Tanner',80,124,1,4572.8,'2A'),(430,'Wendel','Di Maria',19,89,2,3048.98,'2B'),(431,'Fanchette','Freyne',15,78,2,432.35,'3B'),(432,'Osmond','Corsar',71,14,3,1223.1,'2C'),(433,'Teirtza','Ritchley',73,126,3,36.93,'1C'),(434,'Ronda','Laba',24,11,3,38.49,'4C'),(435,'Josephine','Pizer',41,34,3,1222.53,'2C'),(436,'Edee','Pering',64,126,3,36.93,'2C'),(437,'Tammy','McGarvey',56,39,3,1222.43,'1C'),(438,'Chilton','Ianitti',21,43,3,175.62,'3C'),(439,'Billy','Doding',47,115,3,602.92,'5C'),(440,'Benito','Baudet',74,79,1,4573.72,'1A'),(441,'Padraig','Crickmoor',30,44,3,1222.33,'3C'),(442,'Juieta','Andor',92,120,3,602.89,'5C'),(443,'Findlay','Ivakhin',94,118,2,431.79,'2B'),(444,'Amaleta','Bater',7,59,1,4574.37,'3A'),(445,'Crysta','Malby',24,9,1,4577.97,'3A'),(446,'Maridel','Norsister',57,141,2,86.76,'1B'),(447,'Farley','Parsons',81,146,3,36.84,'3C'),(448,'Lorrayne','Percy',57,110,3,602.95,'3C'),(449,'Reggy','Sirman',32,152,3,179.54,'3C'),(450,'Artie','Chantree',73,23,3,176.06,'1C'),(451,'Emmalynne','Broadnicke',24,58,3,175.39,'1C'),(452,'Germayne','Sinkings',56,118,1,647.68,'3A'),(453,'Sander','Monk',76,98,2,432.03,'2B'),(454,'Sid','Neachell',5,73,2,432.44,'3B'),(455,'Tom','Collison',38,139,1,4572.59,'1A'),(456,'Corbet','Sissot',19,153,3,174.74,'1C'),(457,'Aile','Sally',30,10,2,1505.14,'3B'),(458,'Starlene','Steinhammer',26,88,2,432.18,'2B'),(459,'Jenilee','Wolfendell',27,74,1,4573.86,'2A'),(460,'Kahaleel','Hailwood',42,84,3,1221.85,'1C'),(461,'Boothe','Palethorpe',14,82,3,179.93,'1C'),(462,'Nobie','Zohrer',60,100,3,603.01,'1C'),(463,'Lolly','Sighart',26,113,1,647.77,'2A'),(464,'Fabian','Beasley',64,9,1,4577.97,'4A'),(465,'Yvon','Casebourne',49,91,2,87.31,'5B'),(466,'Corry','West',14,121,3,36.95,'2C'),(467,'Alene','Poncet',60,93,2,432.1,'2B'),(468,'Laurena','Kohrding',15,66,2,87.76,'1B'),(469,'Sylas','Cunio',31,58,3,175.39,'2C'),(470,'Cymbre','Tims',48,91,2,87.31,'6B'),(471,'Adrianna','Dowse',57,79,2,3049.15,'4B'),(472,'Isobel','Deane',83,18,2,434.43,'3B'),(473,'Ainsley','Marikhin',8,4,3,1223.55,'1C'),(474,'Peggie','Bullene',90,114,3,1221.64,'1C'),(475,'Emmery','Playfair',89,144,2,3048.35,'3B'),(476,'Roxane','Le Claire',66,1,2,90.94,'1B'),(477,'Agata','Windridge',92,44,1,4575.04,'2A'),(478,'Fayth','Bentje',93,84,2,3049.06,'3B'),(479,'Thomasina','Coysh',86,130,3,602.84,'4C'),(480,'Robena','Killock',98,33,1,650.44,'1A'),(481,'Aggi','Toth',62,138,2,431.6,'3B'),(482,'Hedda','Stidworthy',27,124,2,3048.53,'3B'),(483,'Sophie','Hallstone',79,120,2,1501.78,'3B'),(484,'Ginni','Bullar',75,74,3,1221.94,'3C'),(485,'Gaston','Pulsford',19,23,1,651.19,'1A'),(486,'Nonah','Le Cornu',22,68,1,648.82,'1A'),(487,'Hamilton','Hatherill',18,109,3,1221.67,'1C'),(488,'Gibbie','Nenci',87,90,3,603.08,'1C'),(489,'Nora','Fouracre',42,13,3,176.39,'1C'),(490,'Tarra','Dries',12,155,3,602.74,'4C'),(491,'Karia','Isham',60,72,3,180.02,'2C'),(492,'Marve','Radmore',51,148,2,431.52,'2B'),(493,'Ingaberg','Morewood',83,94,2,3048.9,'3B'),(494,'Yvor','Pumphreys',50,143,3,174.78,'2C'),(495,'Starr','Alpes',96,125,2,1501.73,'1B'),(496,'Trudie','Bracknell',56,51,3,37.55,'3C'),(497,'Amery','Castaneda',45,129,1,4572.73,'4A'),(498,'Gisella','Grigson',47,97,3,179.82,'3C'),(499,'Deane','Huckle',69,88,3,175.09,'3C'),(500,'Helen','Sweet',87,90,3,603.08,'2C'),(501,'Debor','Mumbeson',58,4,3,1223.55,'2C'),(502,'Abdul','Dodson',13,22,3,180.87,'1C'),(503,'Karilynn','Nel',35,71,3,37.31,'2C'),(504,'Heda','Palomba',10,125,3,602.87,'3C'),(505,'Addie','Devaney',48,34,1,4575.63,'1A'),(506,'Claretta','Clementson',99,64,1,4574.19,'2A'),(507,'Jyoti','Sweedy',97,52,3,180.26,'2C'),(508,'Thomas','McNally',41,55,2,1502.9,'2B'),(509,'Melanie','Pottage',27,153,2,431.48,'1B'),(510,'Constantino','Martinez',8,140,2,1501.59,'2B'),(511,'Steward','Aldrick',75,33,1,650.44,'2A'),(512,'Dynah','Nason',72,116,2,86.99,'2B'),(513,'Jamie','Muriel',67,29,3,1222.65,'1C'),(514,'Joella','Bernuzzi',23,56,3,37.48,'3C'),(515,'Shae','Rickardsson',5,113,1,647.77,'3A'),(516,'Delia','Abelov',40,29,3,1222.65,'2C'),(517,'Lorie','Marciek',22,3,3,176.85,'2C'),(518,'Ross','Lindman',31,153,1,647.22,'2A'),(519,'Annelise','Beels',22,42,3,180.42,'2C'),(520,'Hinze','Brise',54,138,3,174.8,'2C'),(521,'Eileen','Meekings',27,4,2,3052.47,'1B'),(522,'Carleton','Burry',78,38,1,650.13,'2A'),(523,'Peyter','Rodda',38,115,3,602.92,'6C'),(524,'Myrtie','Costall',34,22,3,180.87,'2C'),(525,'Jayne','Pierton',67,18,2,434.43,'4B'),(526,'Jammie','Mathivon',95,149,3,1221.48,'2C'),(527,'Whitman','Goodbar',77,36,2,88.64,'2B'),(528,'Koren','Mattosoff',82,127,3,179.65,'2C'),(529,'Idelle','McLewd',89,141,2,86.76,'2B'),(530,'Wendall','McIllrick',19,88,2,432.18,'3B'),(531,'Florina','Dregan',12,79,1,4573.72,'2A'),(532,'Brooks','Eleshenar',13,59,3,1222.11,'1C'),(533,'Dennie','Vasilchikov',40,48,3,175.54,'3C'),(534,'Denna','Titherington',44,33,2,433.63,'3B'),(535,'Moreen','Firminger',26,113,2,431.84,'2B'),(536,'Wenona','Kilmister',35,64,3,1222.05,'4C'),(537,'Karin','Templeton',11,125,3,602.87,'4C'),(538,'Vin','Leggon',77,70,3,603.27,'5C'),(539,'Micheline','Dunnico',25,56,2,88,'4B'),(540,'Vilma','Yandle',20,149,3,1221.48,'3C'),(541,'Franzen','Marioneau',45,88,3,175.09,'4C'),(542,'Ezmeralda','Douberday',35,40,3,603.7,'3C'),(543,'Winonah','Renals',61,64,1,4574.19,'3A'),(544,'Cole','Crews',84,62,3,180.13,'2C'),(545,'Kalie','McIlvaney',36,89,3,1221.81,'2C'),(546,'Correy','Lukianov',55,63,3,175.33,'2C'),(547,'Deeyn','Sirr',6,98,2,432.03,'3B'),(548,'Doyle','MacCosty',33,80,3,603.17,'4C'),(549,'Rudolfo','Genny',12,119,3,1221.61,'3C'),(550,'Willette','Sedgemore',30,18,3,176.22,'3C'),(551,'Elva','Riseley',52,146,2,86.72,'2B'),(552,'Reider','Shenfish',82,57,3,180.2,'6C'),(553,'Joseito','Collingham',98,13,2,434.78,'2B'),(554,'Rowe','Whiley',10,29,1,4575.98,'3A'),(555,'Corny','Delacour',29,135,3,602.82,'3C'),(556,'Curr','Drayson',20,30,2,1503.83,'3B'),(557,'Quintina','Braden',9,141,3,36.86,'2C'),(558,'Madeleine','Ludlom',64,35,2,1503.6,'5B'),(559,'Cris','Vicary',7,78,2,432.35,'4B'),(560,'Lauralee','Keymar',28,136,2,86.8,'4B'),(561,'Annecorinne','Longhirst',91,46,2,88.28,'4B'),(562,'David','Phythien',91,153,2,431.48,'2B'),(563,'Elfrida','Measey',97,51,2,88.13,'1B'),(564,'Christos','Pinyon',58,58,1,649.18,'1A'),(565,'Jethro','Ucchino',19,73,1,648.67,'1A'),(566,'Kristen','Labin',90,131,3,36.9,'2C'),(567,'Arden','Von Der Empten',42,58,1,649.18,'2A'),(568,'Misha','Cordoba',17,124,1,4572.8,'3A'),(569,'Fawnia','Emby',75,149,2,3048.32,'2B'),(570,'Skye','Yonge',40,7,3,181.41,'2C'),(571,'Sascha','Moulding',11,61,2,87.87,'2B'),(572,'Helli','Bould',49,11,2,90.02,'2B'),(573,'Gayla','Hoggan',11,4,1,4578.7,'3A'),(574,'Janenna','Jacox',44,99,3,1221.73,'2C'),(575,'Paco','Drewett',58,1,3,38.95,'1C'),(576,'Ag','Simonyi',26,23,2,434.13,'1B'),(577,'Evvie','Dubique',22,124,3,1221.59,'3C'),(578,'Beryle','Spores',92,60,2,1502.77,'3B'),(579,'Jozef','Normavill',82,14,2,3051.57,'3B'),(580,'Yank','Lehon',65,49,2,3049.86,'1B'),(581,'Bel','Slaymaker',45,138,2,431.6,'4B'),(582,'Neysa','Ivanenkov',96,3,1,653.54,'2A'),(583,'Cullin','Tranckle',91,155,2,1501.48,'2B'),(584,'Sybille','Insall',5,139,1,4572.59,'2A'),(585,'Gayla','Howroyd',85,98,2,432.03,'4B'),(586,'Frazer','Boag',60,48,2,433.07,'2B'),(587,'Carlina','Penna',34,39,2,3050.21,'2B'),(588,'Carline','Abelov',65,77,3,179.98,'2C'),(589,'Valeda','Christophle',61,89,3,1221.81,'3C'),(590,'Lacey','Kliment',87,88,3,175.09,'5C'),(591,'Gilburt','Yeates',18,144,1,4572.53,'3A'),(592,'Janith','Botcherby',12,119,1,4572.88,'2A'),(593,'Ruthanne','Fores',35,64,1,4574.19,'4A'),(594,'Sergeant','Knock',80,34,3,1222.53,'3C'),(595,'Keary','Butte',63,65,3,603.32,'4C'),(596,'Friedrich','Mulvagh',36,88,1,648.27,'2A'),(597,'Shawn','Gaskill',87,134,2,3048.44,'7B'),(598,'Tiffanie','Gareisr',11,42,3,180.42,'3C'),(599,'Trstram','Sewall',63,121,2,86.94,'3B'),(600,'Ianthe','Daspar',91,138,1,647.4,'2A'),(601,'Verine','Sadat',80,153,1,647.22,'3A'),(602,'Charleen','Volk',61,108,2,431.9,'2B'),(603,'Alejandra','Elsie',57,113,1,647.77,'4A'),(604,'Lyon','Cleare',66,33,2,433.63,'4B'),(605,'Guillermo','Tooze',91,23,1,651.19,'2A'),(606,'Brenn','Burnham',96,69,1,4574.02,'3A'),(607,'Lemar','Eskriett',21,11,3,38.49,'5C'),(608,'Wilmer','Shelmerdine',61,7,3,181.41,'3C'),(609,'Tonye','Ivatts',81,120,2,1501.78,'4B'),(610,'Wynn','Peasey',21,18,2,434.43,'5B'),(611,'Henriette','Kettow',67,58,3,175.39,'3C'),(612,'Modestine','Kobke',22,80,2,1502.34,'1B'),(613,'Klemens','Hadlow',6,145,3,602.78,'3C'),(614,'Cammy','Tumulty',36,28,3,175.93,'2C'),(615,'Cynthy','Shrimpton',97,3,3,176.85,'3C'),(616,'Darby','Hursthouse',90,149,1,4572.47,'1A'),(617,'Rem','Jansema',97,139,3,1221.52,'2C'),(618,'Aland','Carnie',79,104,3,1221.7,'2C'),(619,'Pandora','Caras',18,111,2,87.05,'3B'),(620,'Conny','Collinwood',56,15,2,1504.74,'1B'),(621,'Sophie','Biggadyke',76,116,2,86.99,'3B'),(622,'Dunc','Beaford',55,29,1,4575.98,'4A'),(623,'Marti','Curran',96,84,2,3049.06,'4B'),(624,'Marni','Kidston',82,48,3,175.54,'4C'),(626,'Torrin','Teager',52,8,2,435.2,'1B'),(627,'Johna','Tayt',83,118,3,174.89,'3C'),(628,'Trixi','Chaman',11,102,3,179.78,'1C'),(630,'Estrellita','Brimmicombe',48,49,1,4574.8,'3A'),(631,'Gallard','Ghion',44,121,3,36.95,'3C'),(632,'Glenn','Kedie',21,150,3,602.76,'3C'),(634,'Dalton','Raitt',78,68,1,648.82,'2A'),(636,'Herbert','Murrell',82,40,2,1503.4,'2B'),(637,'Ramona','Mapes',32,118,2,431.79,'3B'),(639,'Sissy','Fagence',43,96,3,37.1,'1C'),(640,'Teodorico','Kenvin',77,120,3,602.89,'6C'),(641,'Terrel','Trengrouse',87,37,3,180.51,'4C'),(644,'Xena','Corkan',13,34,3,1222.53,'4C'),(645,'Sorcha','Coda',10,154,2,3048.28,'3B'),(648,'Valentin','Ovell',5,21,2,89.35,'1B'),(649,'Ivan','Harbin',25,40,3,603.7,'4C'),(650,'Marcille','Jaquest',91,81,2,87.47,'3B'),(652,'Charisse','Enos',81,115,3,602.92,'7C'),(653,'Raven','Royce',98,3,1,653.54,'3A'),(654,'Sheffy','Feldklein',96,90,3,603.08,'3C'),(656,'Kaleena','Burgen',36,59,3,1222.11,'2C'),(657,'Ranee','Edgin',61,43,1,649.85,'4A'),(658,'Shelby','Van der Hoven',5,133,3,174.82,'1C'),(659,'Alayne','Habron',36,103,3,174.98,'3C'),(660,'Roseann','Traise',72,50,3,603.53,'3C'),(661,'Tracey','Whitman',92,153,2,431.48,'3B'),(662,'Ddene','Manhood',22,15,3,604.37,'2C'),(663,'Ulick','Longhirst',94,147,3,179.56,'3C'),(664,'Norton','MacParland',65,30,2,1503.83,'4B'),(665,'Jerrine','Frankling',85,16,2,89.66,'3B'),(666,'Kristina','Yeardley',15,121,2,86.94,'5B'),(667,'Osborne','Kerton',57,47,3,180.34,'2C'),(668,'Bernita','Stollwerck',50,71,2,87.65,'2B'),(669,'Maryellen','Meeks',79,25,2,1504.09,'3B'),(670,'Gerrie','Eveling',93,4,1,4578.7,'4A'),(671,'Archibaldo','Emig',69,146,2,86.72,'3B'),(672,'Byran','Crabbe',51,133,2,431.64,'3B'),(673,'Willy','Element',66,54,1,4574.57,'2A'),(674,'Dmitri','Stoile',80,103,1,647.95,'1A'),(675,'Abagail','Mourgue',65,103,3,174.98,'4C'),(676,'Raimundo','Chew',51,19,2,3051.22,'2B'),(677,'Stoddard','Simmons',51,13,3,176.39,'2C'),(678,'Vonny','Gendrich',76,94,1,4573.35,'1A'),(679,'Lauretta','Tefft',50,94,1,4573.35,'2A'),(680,'Gill','Stairmond',42,73,2,432.44,'4B'),(681,'Tamra','Brigden',46,103,2,431.96,'5B'),(682,'Nils','Parkeson',59,140,3,602.8,'1C'),(683,'Jill','Steere',41,9,2,3051.98,'2B'),(684,'Morris','Frary',25,42,3,180.42,'4C'),(685,'Aurel','Goodbourn',25,79,1,4573.72,'3A'),(686,'Caprice','Joder',22,79,3,1221.89,'1C'),(687,'Collete','Wapples',94,51,2,88.13,'2B'),(688,'Elna','Brooker',98,98,1,648.05,'2A'),(689,'Crista','Busher',24,121,2,86.94,'6B');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crews`
--

DROP TABLE IF EXISTS `crews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crews` (
  `idcrews` int NOT NULL AUTO_INCREMENT,
  `pilot` varchar(45) NOT NULL,
  `copilot` varchar(45) NOT NULL,
  PRIMARY KEY (`idcrews`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crews`
--

LOCK TABLES `crews` WRITE;
/*!40000 ALTER TABLE `crews` DISABLE KEYS */;
INSERT INTO `crews` VALUES (1,'Nicole Lawson','Maya Stevens'),(2,'Cullen Peterson','Grace Everett'),(3,'Wallace Wise','Dale Brewer'),(4,'Marcia Herrera','Fay Moon'),(5,'Lucius Cantu','Raja Medina'),(6,'Dorian Henson','Graham Mercer'),(7,'Kennan Flynn','Sierra Bennett'),(8,'Kevin Haney','Flynn Harris'),(9,'Summer Durham','Aquila Stokes'),(10,'Kirsten Cohen','Aristotle Jackson'),(11,'Benjamin Booker','Serena Dennis'),(12,'Harding Pacheco','Penelope Preston'),(13,'Lee Carpenter','Maile Savage'),(14,'Darrel Bradshaw','Caleb Vinson'),(15,'Sonya Maxwell','Chloe Frye'),(16,'Austin Haley','Nehru Strong'),(17,'Barrett Cooke','Shaine Cantrell'),(18,'Hu Stein','Colton Rollins'),(19,'Graiden Atkins','Henry Nichols'),(20,'Tanek Haney','Neve Beck'),(21,'Ashely Dillard','Channing Reed'),(22,'Carson Gutierrez','Tatum Stewart'),(23,'Charles Bush','Fitzgerald Garza'),(24,'Wendy Sanders','Tamara Schultz'),(25,'Micah Wood','Illiana Perry'),(26,'Sigourney William','Eaton York'),(27,'Ross Rojas','Benjamin Cain'),(28,'Rhea Avery','Theodore Barnett'),(29,'Julian William','Melvin Bailey'),(30,'Macaulay Cantrell','Rebecca Randolph'),(31,'Rowan Santana','Kelly Moore'),(32,'Drew Zamora','Lamar Hopper'),(33,'Camden Mcconnell','Hamish Riddle'),(34,'Drew Joyce','Glenna Burke'),(35,'Keely Lang','Duncan Vaughn'),(36,'Sarah Olson','Ulric Maldonado'),(37,'Cody Pennington','Steven Delgado'),(38,'Darryl Patton','Hadassah Green'),(39,'Kiona Scott','Louis Sutton');
/*!40000 ALTER TABLE `crews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination` (
  `iddestination` int NOT NULL AUTO_INCREMENT,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `flying_time` time NOT NULL,
  `distance_to_fly` int NOT NULL,
  PRIMARY KEY (`iddestination`),
  UNIQUE KEY `city_UNIQUE` (`city`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (1,'bucharest','romania','00:55:00',326),(2,'barcelona','spain','03:30:00',2110),(3,'london','united kingdom','03:30:00',2050),(4,'sidney','australia','19:30:00',15134),(5,'new york','usa','10:15:00',7400),(6,'singapore','indonesia','11:00:00',8874);
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `idflights` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `departure_time` time NOT NULL,
  `destination_id` int NOT NULL,
  `airplane_id` int NOT NULL,
  `crew_id` int NOT NULL,
  `available_firstclass_seats` int DEFAULT NULL,
  `available_bussiness_seats` int DEFAULT NULL,
  `available_economy_seats` int DEFAULT NULL,
  PRIMARY KEY (`idflights`),
  KEY `airplane_idx` (`airplane_id`),
  KEY `crew_idx` (`crew_id`),
  KEY `destination_idx` (`destination_id`),
  CONSTRAINT `airplane` FOREIGN KEY (`airplane_id`) REFERENCES `airplanes` (`idairplanes`),
  CONSTRAINT `crew` FOREIGN KEY (`crew_id`) REFERENCES `crews` (`idcrews`),
  CONSTRAINT `destination_flights` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`iddestination`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'2021-05-01','06:00:00',1,1,1,0,19,109),(2,'2021-05-01','07:30:00',2,2,2,0,0,150),(3,'2021-05-01','08:15:00',3,3,3,13,47,277),(4,'2021-05-01','09:40:00',4,4,4,16,53,238),(5,'2021-05-01','11:00:00',5,5,5,0,40,199),(6,'2021-05-02','06:00:00',1,1,6,0,17,110),(7,'2021-05-02','07:30:00',2,2,7,0,0,147),(8,'2021-05-02','08:15:00',3,3,8,15,47,278),(9,'2021-05-02','09:40:00',4,4,9,16,52,239),(10,'2021-05-02','11:00:00',5,5,10,0,38,198),(11,'2021-05-03','06:00:00',1,1,11,0,18,104),(12,'2021-05-03','07:30:00',2,2,12,0,0,149),(13,'2021-05-03','08:15:00',3,3,13,13,46,278),(14,'2021-05-03','09:40:00',4,4,14,18,51,238),(15,'2021-05-03','11:00:00',5,5,15,0,39,198),(16,'2021-05-04','06:00:00',1,1,1,0,17,109),(17,'2021-05-04','07:30:00',2,2,2,0,0,150),(18,'2021-05-04','08:15:00',3,3,3,15,43,277),(19,'2021-05-04','09:40:00',4,4,4,20,52,237),(20,'2021-05-04','11:00:00',5,5,5,0,40,198),(21,'2021-05-05','06:00:00',1,1,6,0,19,109),(22,'2021-05-05','07:30:00',2,2,7,0,0,148),(23,'2021-05-05','08:15:00',3,3,8,14,47,279),(24,'2021-05-05','09:40:00',4,4,9,20,53,239),(25,'2021-05-05','11:00:00',5,5,10,0,37,200),(26,'2021-05-06','06:00:00',1,1,11,0,20,109),(27,'2021-05-06','07:30:00',2,2,12,0,0,150),(28,'2021-05-06','08:15:00',3,3,13,12,47,278),(29,'2021-05-06','09:40:00',4,4,14,16,53,238),(30,'2021-05-06','11:00:00',5,5,15,0,36,199),(31,'2021-05-07','06:00:00',1,1,1,0,20,110),(32,'2021-05-07','07:30:00',2,2,2,0,0,149),(33,'2021-05-07','08:15:00',3,3,3,14,44,279),(34,'2021-05-07','09:40:00',4,4,4,19,53,236),(35,'2021-05-07','11:00:00',5,5,5,0,35,200),(36,'2021-05-08','06:00:00',1,1,6,0,18,108),(37,'2021-05-08','07:30:00',2,2,7,0,0,146),(38,'2021-05-08','08:15:00',3,3,8,14,47,276),(39,'2021-05-08','09:40:00',4,4,9,19,52,239),(40,'2021-05-08','11:00:00',5,5,10,0,38,196),(41,'2021-05-09','06:00:00',1,1,11,0,19,108),(42,'2021-05-09','07:30:00',2,2,12,0,0,146),(43,'2021-05-09','08:15:00',3,3,13,12,46,277),(44,'2021-05-09','09:40:00',4,4,14,18,53,237),(45,'2021-05-09','11:00:00',5,5,15,0,39,199),(46,'2021-05-10','06:00:00',1,1,1,0,16,110),(47,'2021-05-10','07:30:00',2,2,2,0,0,148),(48,'2021-05-10','08:15:00',3,3,3,16,46,276),(49,'2021-05-10','09:40:00',4,4,4,17,53,238),(50,'2021-05-10','11:00:00',5,5,5,0,39,197),(51,'2021-05-11','06:00:00',1,1,6,0,18,107),(52,'2021-05-11','07:30:00',2,2,7,0,0,148),(53,'2021-05-11','08:15:00',3,3,8,13,48,278),(54,'2021-05-11','09:40:00',4,4,9,18,54,240),(55,'2021-05-11','11:00:00',5,5,10,0,37,200),(56,'2021-05-12','06:00:00',1,1,11,0,16,107),(57,'2021-05-12','07:30:00',2,2,12,0,0,144),(58,'2021-05-12','08:15:00',3,3,13,14,46,277),(59,'2021-05-12','09:40:00',4,4,14,17,52,238),(60,'2021-05-12','11:00:00',5,5,15,0,37,200),(61,'2021-05-13','06:00:00',1,1,1,0,18,107),(62,'2021-05-13','07:30:00',2,2,2,0,0,148),(63,'2021-05-13','08:15:00',3,3,3,14,47,278),(64,'2021-05-13','09:40:00',4,4,4,16,54,236),(65,'2021-05-13','11:00:00',5,5,5,0,39,196),(66,'2021-05-14','06:00:00',1,1,6,0,19,109),(67,'2021-05-14','07:30:00',2,2,7,0,0,150),(68,'2021-05-14','08:15:00',3,3,8,14,46,280),(69,'2021-05-14','09:40:00',4,4,9,17,54,240),(70,'2021-05-14','11:00:00',5,5,10,0,39,195),(71,'2021-05-15','06:00:00',1,1,11,0,18,108),(72,'2021-05-15','07:30:00',2,2,12,0,0,148),(73,'2021-05-15','08:15:00',3,3,13,15,44,278),(74,'2021-05-15','09:40:00',4,4,14,18,53,237),(75,'2021-05-15','11:00:00',5,5,15,0,38,198),(76,'2021-05-16','06:00:00',1,1,1,0,16,110),(77,'2021-05-16','07:30:00',2,2,2,0,0,148),(78,'2021-05-16','08:15:00',3,3,3,15,44,278),(79,'2021-05-16','09:40:00',4,4,4,17,50,239),(80,'2021-05-16','11:00:00',5,5,5,0,39,196),(81,'2021-05-17','06:00:00',1,1,6,0,17,108),(82,'2021-05-17','07:30:00',2,2,7,0,0,148),(83,'2021-05-17','08:15:00',3,3,8,14,48,278),(84,'2021-05-17','09:40:00',4,4,9,20,50,239),(85,'2021-05-17','11:00:00',5,5,10,0,37,199),(86,'2021-05-18','06:00:00',1,1,11,0,18,109),(87,'2021-05-18','07:30:00',2,2,12,0,0,149),(88,'2021-05-18','08:15:00',3,3,13,14,44,275),(89,'2021-05-18','09:40:00',4,4,14,19,52,237),(90,'2021-05-18','11:00:00',5,5,15,0,38,197),(91,'2021-05-19','06:00:00',1,1,1,0,14,108),(92,'2021-05-19','07:30:00',2,2,2,0,0,148),(93,'2021-05-19','08:15:00',3,3,3,15,46,280),(94,'2021-05-19','09:40:00',4,4,4,18,51,238),(95,'2021-05-19','11:00:00',5,5,5,0,39,198),(96,'2021-05-20','06:00:00',1,1,6,0,18,109),(97,'2021-05-20','07:30:00',2,2,7,0,0,147),(98,'2021-05-20','08:15:00',3,3,8,14,44,280),(99,'2021-05-20','09:40:00',4,4,9,18,53,238),(100,'2021-05-20','11:00:00',5,5,10,0,36,199),(101,'2021-05-21','06:00:00',1,1,11,0,20,110),(102,'2021-05-21','07:30:00',2,2,12,0,0,149),(103,'2021-05-21','08:15:00',3,3,13,14,44,276),(104,'2021-05-21','09:40:00',4,4,14,18,53,238),(105,'2021-05-21','11:00:00',5,5,15,0,40,198),(106,'2021-05-22','06:00:00',1,1,1,0,18,109),(107,'2021-05-22','07:30:00',2,2,2,0,0,147),(108,'2021-05-22','08:15:00',3,3,3,12,46,277),(109,'2021-05-22','09:40:00',4,4,4,20,51,238),(110,'2021-05-22','11:00:00',5,5,5,0,38,197),(111,'2021-05-23','06:00:00',1,1,6,0,17,109),(112,'2021-05-23','07:30:00',2,2,7,0,0,150),(113,'2021-05-23','08:15:00',3,3,8,12,46,280),(114,'2021-05-23','09:40:00',4,4,9,20,52,239),(115,'2021-05-23','11:00:00',5,5,10,0,38,193),(116,'2021-05-24','06:00:00',1,1,11,0,16,108),(117,'2021-05-24','07:30:00',2,2,12,0,0,149),(118,'2021-05-24','08:15:00',3,3,13,13,45,277),(119,'2021-05-24','09:40:00',4,4,14,17,52,237),(120,'2021-05-24','11:00:00',5,5,15,0,36,194),(121,'2021-05-25','06:00:00',1,1,1,0,14,107),(122,'2021-05-25','07:30:00',2,2,2,0,0,149),(123,'2021-05-25','08:15:00',3,3,3,14,47,280),(124,'2021-05-25','09:40:00',4,4,4,17,51,237),(125,'2021-05-25','11:00:00',5,5,5,0,39,196),(126,'2021-05-26','06:00:00',1,1,6,0,18,108),(127,'2021-05-26','07:30:00',2,2,7,0,0,148),(128,'2021-05-26','08:15:00',3,3,8,15,47,279),(129,'2021-05-26','09:40:00',4,4,9,16,53,240),(130,'2021-05-26','11:00:00',5,5,10,0,40,196),(131,'2021-05-27','06:00:00',1,1,11,0,20,108),(132,'2021-05-27','07:30:00',2,2,12,0,0,150),(133,'2021-05-27','08:15:00',3,3,13,16,45,279),(134,'2021-05-27','09:40:00',4,4,14,20,47,240),(135,'2021-05-27','11:00:00',5,5,15,0,38,197),(136,'2021-05-28','06:00:00',1,1,1,0,16,110),(137,'2021-05-28','07:30:00',2,2,2,0,0,148),(138,'2021-05-28','08:15:00',3,3,3,14,44,278),(139,'2021-05-28','09:40:00',4,4,4,18,53,238),(140,'2021-05-28','11:00:00',5,5,5,0,38,199),(141,'2021-05-29','06:00:00',1,1,6,0,18,108),(142,'2021-05-29','07:30:00',2,2,7,0,0,149),(143,'2021-05-29','08:15:00',3,3,8,16,46,278),(144,'2021-05-29','09:40:00',4,4,9,17,51,238),(145,'2021-05-29','11:00:00',5,5,10,0,37,197),(146,'2021-05-30','06:00:00',1,1,11,0,17,107),(147,'2021-05-30','07:30:00',2,2,12,0,0,147),(148,'2021-05-30','08:15:00',3,3,13,14,46,278),(149,'2021-05-30','09:40:00',4,4,14,19,52,237),(150,'2021-05-30','11:00:00',5,5,15,0,39,197),(151,'2021-05-31','06:00:00',1,1,1,0,20,110),(152,'2021-05-31','07:30:00',2,2,2,0,0,147),(153,'2021-05-31','08:15:00',3,3,3,13,45,279),(154,'2021-05-31','09:40:00',4,4,4,17,51,239),(155,'2021-05-31','11:00:00',5,5,5,0,38,196);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_type`
--

DROP TABLE IF EXISTS `ticket_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_type` (
  `idticket_type` int NOT NULL AUTO_INCREMENT,
  `ticket_class` varchar(45) NOT NULL,
  `meal_included` tinyint NOT NULL,
  `drink_included` tinyint NOT NULL,
  PRIMARY KEY (`idticket_type`),
  UNIQUE KEY `ticket_class_UNIQUE` (`ticket_class`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_type`
--

LOCK TABLES `ticket_type` WRITE;
/*!40000 ALTER TABLE `ticket_type` DISABLE KEYS */;
INSERT INTO `ticket_type` VALUES (1,'First Class',1,1),(2,'Bussiness Class',1,0),(3,'Economy Class',0,0);
/*!40000 ALTER TABLE `ticket_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketsavailable`
--

DROP TABLE IF EXISTS `ticketsavailable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketsavailable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `airplaneID` int DEFAULT NULL,
  `bussiness_class_initial` int GENERATED ALWAYS AS (_utf8mb4'SELECT bussiness_class_seats FROM airplanes WHERE id = \'airplaneId\'') VIRTUAL,
  PRIMARY KEY (`id`),
  KEY `airplaneId` (`airplaneID`),
  CONSTRAINT `airplaneId` FOREIGN KEY (`airplaneID`) REFERENCES `airplanes` (`idairplanes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketsavailable`
--

LOCK TABLES `ticketsavailable` WRITE;
/*!40000 ALTER TABLE `ticketsavailable` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticketsavailable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-20 20:02:00
