INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 1');
INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 2');

INSERT INTO `mumscrum`.`role` (`id`, `name`) VALUES (1,'Developer');
INSERT INTO `mumscrum`.`role` (`id`,  `name`) VALUES (2,'ScrumMaster');
INSERT INTO `mumscrum`.`role` (`id`,  `name`) VALUES (3,'Tester');
INSERT INTO `mumscrum`.`role` ( `id`, `name`) VALUES (4,'HRAdmin');

INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Walid', 'Sultan','1984-07-28','walid@gmail.com','walid','1234');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Binxing', 'Binxing','1984-07-28','binxing@gmail.com','binxing','1234');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Shukri', 'Abotteen','1984-07-28','shukri@gmail.com','shukri','1234');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Eyob', 'Mokria','1984-07-28','eyob@gmail.com','eyob','1234');

INSERT INTO `mumscrum`.`employee_role` (`Employee_id`, `roles_id`) VALUES ('1', '2');

INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-14', 'Sprint 1', '2015-12-1',1,1);
INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-28', 'Sprint 2', '2015-12-15',2,2);

INSERT INTO `mumscrum`.`userstory` (`DevEstimate`, `TesterEstimate`, `name`, `sprint_id`) VALUES ('12', '12', 'UserStory 1', '1');
INSERT INTO `mumscrum`.`userstory` (`DevEstimate`, `TesterEstimate`, `name`, `sprint_id`) VALUES ('5', '6', 'User Story 2', '2');
