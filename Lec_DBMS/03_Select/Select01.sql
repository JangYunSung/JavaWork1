SELECT * FROM T_STUDENT;
-- dual 은 ROW 1개 짜리 dummy TABLE;
SELECT  'abcde' FROM dual;
SELECT  '안녕하세요' FROM dual;
SELECT  100 FROM dual;
SELECT  100 + 10  FROM dual;

-- * 은 모든 컬럼 

SELECT  *  FROM T_EMP;

-- 원하는 컬럼만 조회 
SELECT EMPNO  ,ENAME 
FROM T_EMP;

SELECT  * FROM  T_PROFESSOR ;
SELECT  NAME FROM  T_PROFESSOR ;
SELECT  BONUS FROM  T_PROFESSOR ;

SELECT '안녕하세요' FROM T_PROFESSOR;
SELECT NAME ,'교수님 사랑ㅎ' FROM T_PROFESSOR;


-- 컬럼 별명 (alias) 사용한 출력
SELECT STUDNO 학번, NAME 이름
FROM T_STUDENT ;

SELECT STUDNO "학번", NAME AS 이름
FROM T_STUDENT ;

SELECT STUDNO "학생 학번", NAME 이름
FROM T_STUDENT ;



SELECT EMPNO "사원번호", ENAME AS 사원명 , JOB 직업
FROM T_EMP 

SELECT DEPTNO "부서#", DNAME  "부서명" , LOC 위치
FROM  T_DEPT 


SELECT * FROM t_emp;
SELECT deptno FROM t_emp;
SELECT DISTINCT deptno FROM t_emp;

SELECT DISTINCT deptno1 FROM T_STUDENT;
SELECT DISTINCT job FROM T_EMP;


SELECT name POSITION FROM T_PROFESSOR ;
SELECT name || '-'  || POSITION "교수님명단" FROM T_PROFESSOR ;


SELECT NAME|| '의  키는' ||  HEIGHT || 'cm. 몸무게는 ' || WEIGHT || 'kg 입니다'
"학생의 키와 몸무게" FROM T_STUDENT ;


SELECT NAME|| '의  키는' ||  HEIGHT || 'cm. 몸무게는 ' || WEIGHT || 'kg 입니다'
"학생의 키와 몸무게" FROM T_STUDENT ;









