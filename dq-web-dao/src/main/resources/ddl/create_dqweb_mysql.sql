CREATE TABLE `web_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(256) NOT NULL,
  `firstname` varchar(256) NOT NULL,
  `surname` varchar(256) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `web_role` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`role` varchar(50) NOT NULL,   
	`description` varchar(256) NOT NULL,   
    `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
    UNIQUE KEY `role_unique` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `web_user_role` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int(11) NOT NULL,   
	`username` varchar(20) NOT NULL,   
	`role` varchar(50) NOT NULL,	
    `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
    UNIQUE KEY `user_role_unique` (`user_id`,`username`,`role`),
    CONSTRAINT `fk_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `web_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_user_role_username` FOREIGN KEY (`username`) REFERENCES `web_user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_user_role_role` FOREIGN KEY (`role`) REFERENCES `web_role` (`role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;