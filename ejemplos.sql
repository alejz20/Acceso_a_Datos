select*from emp ;

select ename from emp where lower(ename) like '%a%' 
and sal >3000;

select ename from emp where upper(ename) like '%A%' 
and sal >3000;

select*from emp where sal >3000 and 
upper(ename) like '%A%' or last_name like '%a%' ;

select count(*) as empleados from emp where deptno in(10,20);


select*from emp;
select e.first_name, e.salary, trun(e.salary/3,3) as salary_entre3 from emp e;
select e.first_name, e.salary, round(e.salary/3,3) as salary_entre3 from emp e;
select e.ename, e.sal, round(e.sal/3,3), e.hiredate as salary_entre3 from emp e
where hiredate='17/08/02';

-- te saca las fechas del mes de febrero
select e.ename, e.sal, round(e.sal/3,3), e.hiredate as salary_entre3 from emp e
where to_char( hiredate,'MM')=02;

-- te muestra las fechas que el dia sea menos o igual al 7
select e.ename, e.sal, round(e.sal/3,3), e.hiredate as salary_entre3 from emp e
where to_char( hiredate,'DD')<=7;
 
 select e.ename, e.sal, round(e.sal/3,3), e.hiredate - sysdate from emp e
where to_char( hiredate,'MM')=02;
















