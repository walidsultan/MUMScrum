INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 1');
INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 2');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Walid', 'Sultan');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Binxing', 'Binxing');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Shukri', 'Abotteen');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Eyob', 'Mokria');

INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-14', 'Sprint 1', '2015-12-1',1,1);
INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-28', 'Sprint 2', '2015-12-15',2,2);


