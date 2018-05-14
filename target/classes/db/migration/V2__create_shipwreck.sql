CREATE TABLE shipwreck (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  description varchar(2000),
  condition varchar(255),
  depth double,
  latitude double,
  longitude double,
  yeardiscovered int,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;