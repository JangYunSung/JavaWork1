
/* Drop Tables */

DROP TABLE classname CASCADE CONSTRAINTS;
DROP TABLE lecture CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE dept CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE classname
(
	stuno number NOT NULL,
	lecno number NOT NULL
);


CREATE TABLE dept
(
	deptno number NOT NULL,
	phonenum varchar2(11),
	oproom varchar2(10),
	name varchar2(10) NOT NULL,
	PRIMARY KEY (deptno)
);


CREATE TABLE lecture
(
	lecno number NOT NULL,
	lecname varchar2(20) NOT NULL,
	lecpoint number NOT NULL,
	letennum number,
	lecclass varchar2(10),
	year date,
	profno number NOT NULL,
	PRIMARY KEY (lecno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	jumin varchar2(13) NOT NULL UNIQUE,
	addr varchar2(150),
	name varchar2(10) NOT NULL,
	position varchar2(10),
	phonenum varchar2(11),
	year date,
	deptno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE student
(
	stuno number NOT NULL,
	jumin varchar2(13) NOT NULL UNIQUE,
	name urowid(10) NOT NULL,
	grade number,
	phonenum varchar2(11),
	addr varchar2(150),
	deptno number NOT NULL,
	PRIMARY KEY (stuno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES dept (deptno)
;


ALTER TABLE classname
	ADD FOREIGN KEY (lecno)
	REFERENCES lecture (lecno)
;


ALTER TABLE lecture
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE classname
	ADD FOREIGN KEY (stuno)
	REFERENCES student (stuno)
;



