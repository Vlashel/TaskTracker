-- Table 'users'
CREATE TABLE IF NOT EXISTS `users` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `registrationDate` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;

-- table 'userroles`
CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKUserRolesUserID` (`userId`),
  KEY `FKUserRolesRoleID` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- table `roles`
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS tasks (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description TEXT,
  title TEXT,
  type TEXT,
  createdDate DATETIME NOT NULL,
  finishedDate DATETIME,
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES USERS(ID)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;

-- table `roles`
INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- foreign keys `userroles`
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKUserRolesRoleID` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKUserRolesUserID` FOREIGN KEY (`userId`) REFERENCES `users` (`ID`) ON DELETE CASCADE;



