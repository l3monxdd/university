
Look the results below.

* Database backup located in folder named "beckup"
* Import postman Collection which located in folder named "postmanRequest"

The app should implement such commands:
1. Who is head of department {department_name}
Answer: Head of {department_name} department is
{head_of_department_name}
2. Show {department_name} statistic.
Answer: assistans - {assistams_count}.
associate professors - {associate_professors_count}
professors -{professors_count}
3. Show the average salary for department {department_name}.
Answer: The average salary of {department_name} is
{average_salary}
4. Show count of employee for {department_name}.
Answer: {employee_count}
5. Global search by {template}.
Example: Global search by van
Answer: Ivan Petrenko, Petro Ivanov


1. Name of request :    findHeadOfDepartmentByDepartmentName
http://localhost:8080/department/depName?departmentName=department_name

2. Name of request :    getStatistic    
http://localhost:8080/department/statistic?name=mathematics

3. Name of request : findAVGSalaryByDepName
http://localhost:8080/department/avgSalary?name=history

4. Name of request :  findCountEmployeeOnDep
http://localhost:8080/department/count?name=mathematics

5. Name of request :  findAllLectorsWhereNameLike?orLastNameLike?
http://localhost:8080/lector/find?like=van
 