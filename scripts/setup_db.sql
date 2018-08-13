CREATE TABLE test_profile
(
  profile_id SERIAL PRIMARY KEY,
  email_address varchar(255),
  first_name varchar(255),
  last_name varchar(255)
);

INSERT INTO test_profile
(first_name, last_name, email_address)
values ('daya', 'airody', 'daya@pt.com');

INSERT INTO test_profile
(first_name, last_name, email_address)
values ('vara', 'allamaraju', 'vara@pt.com');

INSERT INTO test_profile
(first_name, last_name, email_address)
values ('jordan', 'king', 'jordan@pt.com');

