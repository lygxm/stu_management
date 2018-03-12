CREATE TABLE student
(id INT PRIMARY KEY AUTO_INCREMENT
  ,name VARCHAR(50)
  ,age INT
  ,gender VARCHAR(20)
  ,telephone VARCHAR(20)
  ,email VARCHAR(50)
  ,classid INT
);

CREATE TABLE classes
(id INT PRIMARY KEY AUTO_INCREMENT
,name VARCHAR(50)
);

ALTER TABLE student
    ADD CONSTRAINT fk_classid
FOREIGN KEY (classid) REFERENCES classes(id);


INSERT INTO classes(name) VALUES ('y2134');
INSERT INTO classes(name) VALUES ('s2188');
INSERT INTO classes(name) VALUES ('s2192');

INSERT INTO student(name, age, gender, telephone, email, classid)
VALUES('dhh', 20, 'M', '13910101010', 'hdd@accp.com', 1);

INSERT INTO student(name, age, gender, telephone, email, classid)
VALUES('abc', 20, 'M', '13910101010', 'hdd@accp.com', 1);


create table users(
	username varchar(50) not null primary key,
	password varchar(64) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users(username, password, enabled) VALUES ('user', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', true);
INSERT INTO users(username, password, enabled) VALUES ('tom', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', false);
INSERT INTO users(username, password, enabled) VALUES ('admin', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', true);

INSERT INTO authorities(username, authority) VALUES('user', 'USER');
INSERT INTO authorities(username, authority) VALUES('tom', 'USER');
INSERT INTO authorities(username, authority) VALUES('admin', 'ADMIN');