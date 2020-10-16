--Step 1 Query
select count(*) from employees

--Step 2 Query
select count(ReportsTo) from employees

--Step 3 Query
select distinct title from employees

--Step 4 Query
select count(distinct title) from employees

--Step 5 Query
select * from employees where title="IT Staff"

--Step 6 Query
select * from employees where title="IT Staff" AND City="Lethbridge" and PostalCode="T1H 1Y8"

--Step 7 Query
select Count(*) from employees where HireDate >= "2003-10-17"

--Step 8 Query
select Count(*) from employees where HireDate > "2002-01-10" and HireDate < "2003-01-01"

--Step 9 Query
select  FirstName, LastName, MAX(BirthDate) from employees

--Step 10 Query
select  FirstName, LastName, Min(HireDate) from employees

--Step 11 Query
select FirstName, LastName from employees where substr(FirstName,1,1) = substr(LastName, 1,1)

--Step 12 Query
select * from employees where City="Calgary" and State="AB"

--Step 13 Query
select * from employees where Phone like '%(403)%';

--Step 14 Query
SELECT FirstName, Phone, COUNT(*) FROM employees GROUP BY Phone HAVING COUNT(*) > 1

--Step 15 Query
Select * from employees where ReportsTo="6"

--Step 16 Query
Select FirstName, LastName, Length(LastName) from employees 

--Step 17 Query
Select FirstName, LastName, Length(LastName) from employees order by FirstName desc

--Step 18 Query
select * from employees where City="Edmonton" OR City="Lethbridge"

--Step 19 Query
select avg((julianday('now') - julianday(birthdate))/365.25) as "Average Age of an Employee" from employees;

--Step 20 Query
select * from employees where Title="Sales Support Agent" limit 2

--PART 2--------------
----------------------
----------------------

--Step 1 Query
select Title, Name from albums inner join artists on artists.ArtistID = albums.ArtistID Order by name;

--Step 2 Query
select name,title from artists left join albums using (ArtistId) order by name

--Step 3 Query
select name from artists left join albums using(ArtistID) where Title isnull

--Step 4 Query
select distinct FirstName, LastName, City from employees e1 inner join employees e2 on e2.city=e1.city AND (e1.FirstName <> e2.FirstName AND e1.Lastname <> e2.LastName) order by e1.city

--PART 3--------------
----------------------
----------------------

--Step 1 Query
SELECT customerid, firstname, lastname,
CASE  
WHEN country ='USA' THEN 'Domestic' 
ELSE 'Foreign' 
END CustomerGroup
FROM customers 
ORDER BY LastName, FirstName;

--Step 2 Query
select TrackID,
case
when milliseconds < 60000 then "Short"
when milliseconds >= 60000 AND milliseconds < 300000 then "Medium"
else "Long"
end as "Song Length"
from Tracks

--PART 4--------------
----------------------
----------------------

--Step 1 Query
insert into artists (ArtistID, Name)
values (1337,"ChuckyCheese");


--Step 2 Query
insert into artists (ArtistID, Name)
values (1338,"Raymundo Fine"),
(1339,"Ray 'bob' Billy"),
(1340,"Billy 'bob' Rae Jr.");

--Step 3 Query
update employees
set LastName = "Smith"
where EmployeeID = 3;

--Step 4 Query
update employees
set city = "Toronto", State="ON", PostalCode = "M5P 2N7"
where EmployeeID = 4;

--Step 5 Query
update employees
set email = Firstname || "." || LastName ||"@chinookcorp.com"

--Step 6 Query
delete from artists
where name="Azymuth"

--PART 5--------------
----------------------
----------------------

--Step 1 Query
begin transaction ;
INSERT INTO artists (name) VALUES('Bud Powell');
insert into albums(Title, ArtistId) values ('Silk Route', (select artistid from artists where name ='Bud Powell' ));
update artists set name = 'Bud Powell Jr.' where name = 'Bud Powell';
commit transaction;

--Step 2 Query
--We couldn't get anything to commit














