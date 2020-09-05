  INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
	('vivek', '$2a$10$1/vM.QrzqG9qHG4OeeXTd.3x.CNDEwPTYlo.3nhM9AjyYrBNi1Rje', 'Vivek Garg', 'ROLE_ADMIN', 'US', 1),
	('prabhat', '$2a$10$eTkyV8sdFYHWIKt49LghReQf.QtHAm1P8R2q0idtvaTOgiZGqppLS', 'Prabhat Singh', 'ROLE_USER', 'India', 1); 

   INSERT INTO `topics` (`topic_id`, `title`, `category`) VALUES
	(1, 'Spring Rest Boot', 'Spring Boot'),
	(2, 'Spring Boot Security', 'Spring Boot'),
	(3, 'Spring MVC Framework', 'Spring Framework');