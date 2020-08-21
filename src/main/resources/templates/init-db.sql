CREATE TABLE `grade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(60) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO grade (name, type, score, total) 
VALUES ('Lab1', 'Lab', 9.5, 10),('Quiz1', 'Quiz', 18, 20),
('Assessment1', 'Test', 8, 10),('Lab2', 'Lab', 8.5, 10) ;
