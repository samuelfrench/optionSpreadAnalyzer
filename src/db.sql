CREATE SCHEMA `repo` ;

CREATE TABLE `repo`.`nasdaq_ticker` (
  `nasdaq_ticker_id` INT NOT NULL AUTO_INCREMENT,
  `ticker` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`nasdaq_ticker_id`),
  UNIQUE INDEX `ticker_UNIQUE` (`ticker` ASC));
