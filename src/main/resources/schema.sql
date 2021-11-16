DROP TABLE IF EXISTS users          CASCADE;
DROP TABLE IF EXISTS profiles       CASCADE;
DROP TABLE IF EXISTS jobposting    CASCADE;

DROP TABLE IF EXISTS product_order  CASCADE;
DROP TABLE IF EXISTS dog_walking    CASCADE;
DROP TABLE IF EXISTS dog_sitting    CASCADE;
DROP TABLE IF EXISTS dog_grooming   CASCADE;

DROP TABLE IF EXISTS OrderID        CASCADE;
DROP TABLE IF EXISTS AcceptedJobs   CASCADE;
DROP TABLE IF EXISTS DogParty       CASCADE;

create table users (
  id serial primary key,
  username varchar(20),
  password varchar(60),
  usertype varchar(20),
  uuid uuid
);

create table profiles (
  pid serial PRIMARY KEY,
  uid integer,
  bio varchar(500),
  pictureurl varchar(255), /*Most likely we'll do URL to make it simple*/
  address varchar(60),
  firstname varchar(60),
  lastname varchar(60),
  rating integer,
  FOREIGN KEY(uid) REFERENCES users(id)
);

create table jobposting (
  ownername varchar(60),
  jobdescp varchar(500),
  jobdate timestamp,
  jobdateholder varchar(30),
  joblocation varchar(60),
  offers integer, /*Talk with the team about this one*/
  PRIMARY KEY (jobDate,jobLocation)
);

 

 
/* Maybe need more unique stuff for each job, not sure yet */

create table product_order (
	reservationID serial 	primary key,
	userID        serial,
	providerID    serial,
	jobDescp      varchar(500),
	jobDate       timestamp,
	jobLocation   varchar(60),
	productID	    serial /* not sure how this should work, talk with team */
);

create table dog_walking (
	reservationID 	serial 	primary key,
	userID        	serial,
	providerID    	serial,
	jobDescp      	varchar(500),
	jobDate       	timestamp,
	jobLocation   	varchar(60),
	totalDistance 	integer
);

create table dog_sitting (
	reservationID 	serial 	primary key,
	userID        	serial,
	providerID   	  serial,
	jobDescp     	  varchar(500),
	jobDate      	  timestamp,
	jobLocation   	varchar(60),
	totalTime		    integer
);

create table dog_grooming (
	reservationID 	serial 	primary key,
	userID        	serial,
	providerID    	serial,
	jobDescp      	varchar(500),
	jobDate       	timestamp,
	jobLocation   	varchar(60),
	serviceLevel	  integer /* not sure how to rate different levels of services */
);

create table OrderID (
  orderNum integer,
  total integer,
  orderDate timestamp,
  status varchar(20),
  UID integer,
  PRIMARY KEY (orderNum),
  FOREIGN KEY (uid) REFERENCES users(ID)
);

create table AcceptedJobs (
  jobid serial,
  ownerID integer,
  walkerID integer,
  jobLocal boolean,
  PRIMARY KEY (jobid)
);

create table DogParty (
  partyDate timestamp,
  partyLocation varchar(25),
  RSVP integer,
  partyID integer,
  PRIMARY KEY (partyDate, partyLocation)
);

