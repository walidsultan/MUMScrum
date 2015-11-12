INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 1');
INSERT INTO `mumscrum`.`scrumrelease` ( `name`) VALUES ('Release 2');

INSERT INTO `mumscrum`.`role` (`id`, `name`) VALUES (1,'Developer');
INSERT INTO `mumscrum`.`role` (`id`,  `name`) VALUES (2,'ScrumMaster');
INSERT INTO `mumscrum`.`role` (`id`,  `name`) VALUES (3,'Tester');
INSERT INTO `mumscrum`.`role` ( `id`, `name`) VALUES (4,'HRAdmin');

INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Walid', 'Sultan','1984-07-28','walid@gmail.com','scrummaster','1234');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Binxing', 'Binxing','1984-07-28','binxing@gmail.com','developer','1234');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Shukri', 'Abotteen','1984-07-28','shukri@gmail.com','tester','1234');
INSERT INTO `mumscrum`.`employee` (`FirstName`, `LastName`,`dateOfBirth`,`email`,`username`,`password`) VALUES ('Eyob', 'Mokria','1984-07-28','eyob@gmail.com','hradmin','1234');

INSERT INTO `mumscrum`.`employee_role` (`Employee_id`, `roles_id`) VALUES ('1', '2');
INSERT INTO `mumscrum`.`employee_role` (`Employee_id`, `roles_id`) VALUES ('2', '1');
INSERT INTO `mumscrum`.`employee_role` (`Employee_id`, `roles_id`) VALUES ('3', '3');
INSERT INTO `mumscrum`.`employee_role` (`Employee_id`, `roles_id`) VALUES ('4', '4');


INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-14', 'Sprint 1', '2015-12-1',1,1);
INSERT INTO `mumscrum`.`sprint` (`endDate`, `name`, `startDate`,`scrumRelease_id`,`scrumMaster_id`) VALUES ('2015-12-28', 'Sprint 2', '2015-12-15',2,2);

INSERT INTO `mumscrum`.`userstory` (`DevEstimate`, `TesterEstimate`, `name`, `sprint_id`) VALUES ('12', '12', 'UserStory 1', '1');
INSERT INTO `mumscrum`.`userstory` (`DevEstimate`, `TesterEstimate`, `name`, `sprint_id`) VALUES ('5', '6', 'User Story 2', '1');


/*Burn Down Chart*/
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('0', '40', '1', '1', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('0', '30', '1', '1', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('10', '40', '2', '1', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('7', '30', '2', '1', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('20', '40', '3', '1', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('14', '30', '3', '1', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('30', '40', '4', '1', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('21', '30', '4', '1', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('30', '40', '5', '1', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('21', '30', '5', '1', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('40', '40', '6', '1', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('28', '30', '6', '1', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('30', '30', '7', '1', '2');



INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('0', '40', '1', '2', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('0', '50', '1', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('10', '40', '2', '2', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('7', '50', '2', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('20', '40', '3', '2', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('14', '50', '3', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('30', '40', '4', '2', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('21', '50', '4', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('30', '40', '5', '2', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('21', '50', '5', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('40', '40', '6', '2', '1');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('28', '50', '6', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('30', '50', '7', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('37', '50', '8', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('43', '50', '9', '2', '2');
INSERT INTO `mumscrum`.`worklog` (`ActualHours`, `OriginalEstimate`, `sprintDay`, `sprint_id`, `userStory_id`) VALUES ('50', '50', '10', '2', '2');

