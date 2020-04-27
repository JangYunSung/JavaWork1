INSERT INTO T_STUDENT 
;




SELECT NAME , pay FROM T_PROFESSOR WHERE pay > 5000;



SELECT   s.name AS 학생이름 , d.dname  AS 학과명 
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno 
	AND s.deptno1 = (SELECT deptno1 FROM t_student WHERE name = '이윤나');
	
--name || '-'  || POSITION "교수님명단"


SELECT p.NAME "교수님 이름 " , d.DNAME "소속 학과명" 
FROM T_PROFESSOR p , T_DEPARTMENT d 
;


CREATE OR REPLACE VIEW v_stud_info (sname , dname , pname)
AS
SELECT s.NAME "학생이름" , d.DNAME "학생학과명" , p.NAME "담당교수님 이름"
FROM T_STUDENT s ,T_DEPARTMENT d , T_PROFESSOR p
WHERE s.DEPTNO = d.DEPTNO AND p.p 


--CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
--AS
--SELECT profno, name, email, hpage
--FROM t_professor
--;

CREATE OR REPLACE VIEW v_stud_info (sname , dname , pname)
AS
SELECT s.NAME , d.DNAME , p.NAME
FROM T_STUDENT s ,T_DEPARTMENT d , T_PROFESSOR p 
WHERE s.DEPTNO = d.DEPTNO
AND p.PROFNO =d.profno;
