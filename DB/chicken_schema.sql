CREATE DATABASE chicken_logs;

use chicken_logs;

CREATE TABLE chick_statistic(

  revenue_id INT NOT NULL AUTO_INCREMENT,
  chickenName VARCHAR (255) NOT NULL,
  payment INT NOT NULL,
  client INT NOT NULL,
  orderNum INT NOT NULL,
  dealingDate DATETIME NOT NULL,
  PRIMARY KEY(revenue_id)

);