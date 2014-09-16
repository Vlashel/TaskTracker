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
  `userId` bigint(20) NOT NULL,
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
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users(ID) ON DELETE CASCADE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;

-- table `roles`
INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- foreign keys `userroles`
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKUserRolesRoleID` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKUserRolesUserID` FOREIGN KEY (`userId`) REFERENCES `users` (`ID`) ON DELETE CASCADE;


create table customers (

  id int(8) not null auto_increment,
  first_name varchar(255) not null,
  last_name varchar(255) not null,
  primary key (id)

);

create table orders (
  id int(8) not null auto_increment,
  item varchar(255) not null,
  customer_id int (8) not null,
  primary key (id),
  constraint customer_fk foreign key (customer_id) references customers(id) on delete CASCADE
);

insert into customers (first_name, last_name) values ('Nik', 'Davis');
insert into orders (customer_id, item) values (3, 'pen');


 select customers.first_name, orders.item
 from customers, orders
 where customers.id = orders.customer_id;

select customers.first_name, orders.id
from customers
  join orders
  on customers.id = orders.customer_id;


select customers.first_name, orders.id
from customers
 left join orders
    on customers.id = orders.customer_id;



select customers.first_name, orders.item
    from customers
    full outer join orders
    on customers.id = orders.customer_id
    order by customers.first_name;



