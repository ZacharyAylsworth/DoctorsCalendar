BEGIN TRANSACTION;

DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS appointments;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE doctors (
  doctor_id int primary key,
  doctor_first_name varchar(20)
  doctor_last_name varchar(20)
  );

CREATE TABLE appointments (
   appointment_id int primary key,
   patient_first_name varchar(20)
   patient_last_name varchar(20)
   date_time timestamp
   kind bit
   );


CREATE TABLE users (
    user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


INSERT INTO appointments (appointment_id, patient_first_name, patient_last_name, date_time, kind) VALUES (1, 'zachary', 'aylsworth', 6/17/2022 4:27, 1); -- 0 new patient, 1 follow-up


COMMIT TRANSACTION;