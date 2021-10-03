DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS profile CASCADE;
DROP TABLE IF EXISTS job_posting CASCADE;

create table users (
  id serial primary key,
  firstname varchar(20),
  lastname varchar(20)
);

create table profile (
  pid serial PRIMARY KEY,
  uid integer,
  bio varchar(500),
  pictures integer, /*Placeholder need to talk with team about this*/
  address varchar(60),
  name varchar(60),
  raiting integer,
  review varchar(500), /*Also need to talk with the group about this one*/
  FOREIGN KEY(uid) REFERENCES users(id)
);

create table job_posting (
  ownerName varchar(60),
  jobDescp varchar(500),
  jobDate timestamp,
  jobLocation varchar(60),
  offers integer, /*Talk with the team about this one*/
  PRIMARY KEY (jobDate,jobLocation)
);
