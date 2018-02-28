"# o.wafi-y.elbaza" 

## A Maven project containing
- JPA
- Hibernate
- Restful Webservice using JAX-RS
---

## Intellij IDEA
---

## How to ?
Before running this project, you must install dependencies for sure using **pom.xml** , then after it, start by creating a Mysql Database, called sir, or you can configure it on **persitence.xml**.<br>Once finished run the **jpaTest.java** for the java part.
Otherwise for the Rest/Servlet part, run tomcat7, you can do that by using maven console and running goal
- tomcat7:run
Then you will have access to the home page on 
- http://localhost:8080/
<br>Start by adding people using the form, once finished go to the Home form using the link at the top, you will be redirect to 
- http://localhost:8080/HomeInfo
---
## For the Rest Part 
You can try theese ones as an example for getting data :
> List all Homes :
- http://localhost:8080/rest/home/all
> List one home by providing an ID in the url like : 
- http://localhost:8080/rest/home/1

> List all People :
- http://localhost:8080/rest/person/all
> List one person by providing an ID in the url like : 
- http://localhost:8080/rest/person/1

To post data to the webservice, you can use the chrome Extension : Avanced Rest Client extension.
Post data to 
- http://localhost:8080/rest/home/save
- http://localhost:8080/rest/person/save

the request body must contains an object of course, for example to save a person :
the request body contains something like :
>    {<br>
>      "nom": "xxx",<br>
>     "prenom": "x1x1x1",<br>
>      "mail": "x1xxx1@gmail.com"<br>
>    }<br>
and the body content type would be **application/json**.
