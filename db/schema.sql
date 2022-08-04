CREATE TABLE accidents (
  id serial primary key;
  name varchar(2000),
  text varchar(2000),
  address varchar(2000)
);

CREATE TABLE accident_types (
  id serial primary key;
  name varchar(2000)
);

CREATE TABLE rules (
  id serial primary key;
  name varchar(2000)
);