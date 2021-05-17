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


create table FighterStyle(
FighterID int,
Striking enum('Boxing', 'Karate', 'Kickboxing', 'MuayThai', 'Taekwondo'),
Grappling enum('BJJ', 'Judo', 'Sambo', 'Wrestling'),
Foreign Key(FighterID) References FighterInfo(FighterID)
);

select * from FighterStyle;
truncate table FighterStyle;
drop table FighterStyle;




