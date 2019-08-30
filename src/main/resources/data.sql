DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  salary INT DEFAULT NULL
);
 
INSERT INTO employee (id, name, salary) VALUES
  (701,'Aliko', 5000),
  (801,'Bill', 15000),
  (901,'Folrunsho', 2000);