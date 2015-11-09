INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 1');
INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 2');

INSERT INTO `mumscrum`.`role` ( `name`) VALUES ('Developer');
INSERT INTO `mumscrum`.`role` ( `name`) VALUES ('ScrumMaster');
INSERT INTO `mumscrum`.`role` ( `name`) VALUES ('Tester');
INSERT INTO `mumscrum`.`role` ( `name`) VALUES ('HRAdmin');

INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Walid', 'Sultan');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Binxing', 'Binxing');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Shukri', 'Abotteen');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`) VALUES ('Eyob', 'Mokria');

INSERT INTO `mumscrum`.`employee_role` (`Employee_id`, `roles_id`) VALUES ('1', '2');

INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-14', 'Sprint 1', '2015-12-1',1,1);
INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-28', 'Sprint 2', '2015-12-15',2,2);

INSERT INTO `mumscrum`.`userstory` (`DevEstimate`, `TesterEstimate`, `name`, `sprint_id`) VALUES ('12', '12', 'UserStory 1', '1');
INSERT INTO `mumscrum`.`userstory` (`DevEstimate`, `TesterEstimate`, `name`, `sprint_id`) VALUES ('5', '6', 'User Story 2', '2');
