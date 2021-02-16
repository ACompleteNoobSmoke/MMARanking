create database FighterRank;
use FighterRank;

create table FighterInfo(
FighterID int Primary Key,
FirstName varchar(255),
LastName varchar(255),
NickName varchar(255),
Age int
);

select * from FighterInfo;
truncate table FighterInfo;
drop table FighterInfo;

insert into FighterInfo (FighterID, FirstName, 
LastName, NickName, Age) values ('1700', 'Amanda', 'Nunes', 'Lionness', '38');
Delete from FighterInfo where FighterID = '1700';

create table FighterBody(
FighterID int,
Gender varchar(8),
Height varchar(8),
Weight float,
WeightClass enum('Heavyweight', 'LightHeavyweight', 'Middleweight', 'Welterweight', 
'Lightweight', 'Featherweight','Bantamweight', 'Flyweight','Strawweight'),
Foreign Key(FighterID) References FighterInfo(FighterID)
);

select * from FighterBody;
truncate table FighterBody;
drop table FighterBody;

insert into FighterBody(FighterID, Gender, Height, Weight, WeightClass) values ('1700', 'Female', '58', '135', 'Bantamweight');
Delete from FighterBody where FighterID = '1700';

create table FighterRecord(
FighterID int,
Wins int,
Losses int,
Draws int,
NoContent int,
Foreign Key(FighterID) References FighterInfo(FighterID)
);

select * from FighterRecord;
truncate table FighterRecord;
drop table FighterRecord;
insert into FighterRecord(FighterID, Wins, Losses, Draws, NoContent) values ( '1603', '20', '2', '2', '1');
Delete from FighterRecord where FighterID = '1700';

create table FighterStyle(
FighterID int,
Striking enum('Boxing', 'Karate', 'Kickboxing', 'MuayThai', 'Taekwondo'),
Grappling enum('BJJ', 'Judo', 'Sambo', 'Wrestling'),
Foreign Key(FighterID) References FighterInfo(FighterID)
);

select * from FighterStyle;
truncate table FighterStyle;
drop table FighterStyle;
insert into FighterStyle(FighterID, Striking, Grappling) values ('1603','Karate', 'BJJ');
Delete from FighterStyle where FighterID = '1700';



