## Simple Spring app (without Boot)
In this app you can retrieve quote of some character.
In app there are 2 routes:
1) demo/ - description of our app
2) api/?hero={{some name of hero}} - by this route you fetch the quote of particular character.

### Prerequisites:
- run PostgreSQL
- create table with data, for example, you may use the below sql script:
```sql
CREATE TABLE IF NOT EXISTS heroes (
	id SERIAL PRIMARY KEY,
	name VARCHAR(15) NOT NULL,
	quote VARCHAR(15) NOT NULL
);

INSERT INTO heroes(name, quote) VALUES
('hero1', 'voice 1'),
('hero2', 'voice 2'),
('hero3', 'voice 3'),
('hero4', 'voice 4'),
('hero5', 'voice 5');
```
- change DB settings in `resources/application.properties`


### How to start:
1) git clone
2) build the maven project ```mvn package```
3) start app with the below cmd
```
cp {{PATH_TO_CLONED_APP}}/spring-demo/target/demo.war {{PATH_TO_TOMCAT}}/apache-tomcat-9.0.8/webapps 
&& {{PATH_TO_TOMCAT}}/apache-tomcat-9.0.8/bin/catalina.sh run 
```
             
To shutdown tomcat use below cmd:
```
{{PATH_TO_TOMCAT}}/apache-tomcat-9.0.8/bin/catalina.sh stop
```

[Useful link](http://www.mkyong.com/spring-mvc/spring-3-mvc-and-json-example/#!parentId=1044132)