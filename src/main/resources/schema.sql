DROP TABLE IF EXISTS users;

create table users (
  id serial primary key,
  firstname varchar(20),
  lastname varchar(20)
);