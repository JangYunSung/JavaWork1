
/* Drop Tables */

DROP TABLE register CASCADE CONSTRAINTS;
DROP TABLE studnet CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE professor
(
	profno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	PRIMARY KEY (profno)
);


CREATE TABLE register
(
	studno number NOT NULL,
	subjno number NOT NULL
);


CREATE TABLE studnet
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	profno number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subjno number NOT NULL,
	name varchar2(10) NOT NULL,
	profno number NOT NULL,
	PRIMARY KEY (subjno)
);



/* Create Foreign Keys */

ALTER TABLE studnet
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE subject
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE register
	ADD FOREIGN KEY (studno)
	REFERENCES studnet (studno)
;


ALTER TABLE register
	ADD FOREIGN KEY (subjno)
	REFERENCES subject (subjno)
;



