


--// ./mysql -uroot

CREATE USER if not exists 'adminMG'@'localhost' IDENTIFIED BY 'maghsoud71';
GRANT ALL PRIVILEGES ON * . * TO 'adminMG'@'localhost';
--FLUSH PRIVILEGES;

CREATE DATABASE if not exists `tufan-g11`
COLLATE utf8mb3_general_ci;

-- // quit
