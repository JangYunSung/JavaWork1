-- 산술연산자
SELECT ENAME , SAL , sal * 1.1 --급여 10% 인상 분
FROM T_EMP ;


SELECT ENAME ,SAL ,COMM 
FROM T_EMP ;


SELECT ENAME , sal, COMM  ,sal+COMM
FROM T_EMP 



-- WHERE 조건절  
--SELECT [컬럼명 또는 표현식] FROM [테이블명, 뷰명]  WHERE [조건절] ;



SELECT * FROM t_emp ;
SELECT * FROM t_emp WHERE job = 'SALESMAN';

SELECT ename, sal, deptno
FROM t_emp
WHERE deptno = 10;

SELECT ename, sal
FROM t_emp
WHERE sal > 2000;

SELECT ename, empno, sal
FROM t_emp
WHERE ename = 'SCOTT';


SELECT NAME  , GRADE 
FROM T_STUDENT 
WHERE grade = 2 OR GRADE = 3;



SELECT NAME  , GRADE 
FROM T_STUDENT 
WHERE grade IN (2,3);

SELECT NAME  , GRADE 
FROM T_STUDENT 
WHERE grade >1 AND GRADE <4;

SELECT name , grade
FROM T_STUDENT
WHERE GRADE  NOT IN  (1,4);

SELECT name , grade
FROM T_STUDENT
WHERE GRADE  BETWEEN 2 AND 3; 


SELECT NAME , PAY  , POSITION
FROM T_PROFESSOR 
WHERE PAY > 300 AND  POSITION IN ('정교수');

SELECT NAME , POSITION
FROM T_PROFESSOR 
WHERE BONUS  is null;


SELECT name FROM T_PROFESSOR WHERE NAME LIKE '김%';

SELECT ENAME FROM T_EMP WHERE ENAME LIKE '%NE%';

SELECT ENAME FROM T_EMP WHERE ENAME LIKE '_A%';

SELECT ename
FROM T_EMP
WHERE ename LIKE '%L%'
ORDER BY ename DESC ;


SELECT ename, job, sal
FROM t_emp
ORDER BY job DESC, sal ASC;

SELECT  name , grade , HEIGHT
FROM T_STUDENT 
ORDER BY GRADE ASC , HEIGHT DESC ;







