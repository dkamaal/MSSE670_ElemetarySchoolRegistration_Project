
# Elementary School Registration Project

Contributors to this document: Danish Kamaal

Regis University

MSSE 670: Object Oriented Software Construction

Professor: Ishmael Thomas

“Elementary School Registration” application is used to enroll students in elementary school grades (Kindergarten, First Grade, Second Grade, Third Grade, Fourth Grade and Fifth Grade). School Registrar will enter information in Registration Form based on paper application received from Students. School Registrar will assign one class section (A or B) to students from Grade Information Table. Each class section has specific teacher assigned and teacher information will be displayed in Teacher Information Table. After successful enrollment registration information will be displayed in Student Registration Table. Once student enrollment is successfully done, School Registrar can update the registration or delete the registration. Only one registration application per Student is allowed. School Name will display on top of application. 

# Database Setup

**Create MySQL Database School**

```
CREATE DATABASE school;

```

**Create Table student**
 
```
CREATE TABLE student (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sfirstname VARCHAR(128) NOT NULL,
    slastname VARCHAR(128) NOT NULL,
    age VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    mobile VARCHAR(128) NOT NULL,
    sgrade VARCHAR(128) NOT NULL
);

```

**Create Table grade**

```
CREATE TABLE grade (
    gid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gradesection VARCHAR(128) NOT NULL
);
```

**Insert below Data in to grade Table**

```
INSERT INTO grade (gradesection) VALUES( 'KINDERGARTEN-A');
INSERT INTO grade (gradesection) VALUES( 'KINDERGARTEN-B');
INSERT INTO grade (gradesection) VALUES( 'FIRST-A');
INSERT INTO grade (gradesection) VALUES( 'FIRST-B');
INSERT INTO grade (gradesection) VALUES( 'SECOND-A');
INSERT INTO grade (gradesection) VALUES( 'SECOND-B');
INSERT INTO grade (gradesection) VALUES( 'THIRD-A');
INSERT INTO grade (gradesection) VALUES( 'THIRD-B');
INSERT INTO grade (gradesection) VALUES( 'FOURTH-A');
INSERT INTO grade (gradesection) VALUES( 'FOURTH-B');
INSERT INTO grade (gradesection) VALUES( 'FIFTH-A');
INSERT INTO grade (gradesection) VALUES( 'FIFTH-B');
```

**Create Table teacher**

```
CREATE TABLE teacher (
    tfirstname VARCHAR(128) NOT NULL,
    tlastname VARCHAR(128) NOT NULL,
    teachergrade INT NOT NULL,
    teacherexp INT NOT NULL,
    FOREIGN KEY (teachergrade) REFERENCES grade (gid)
);
```

**Insert below data in to teacher Table**

```
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName1', 'TestLastName1', '1', '1');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName2', 'TestLastName2', '2', '2');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName3', 'TestLastName3', '3', '3');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName4', 'TestLastName4', '4', '4');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName5', 'TestLastName5', '5', '5');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName6', 'TestLastName6', '6', '6');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName7', 'TestLastName7', '7', '7');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName8', 'TestLastName8', '8', '8');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName9', 'TestLastName9', '9', '9');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName10', 'TestLastName10', '10', '10');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName11', 'TestLastName11', '11', '11');
INSERT INTO teacher (tfirstname, tlastname, teachergrade, teacherexp) VALUES('TestFirstName12', 'TestLastName12', '12', '12');
```

**Create Table schoolnamelabel**

```
CREATE TABLE schoolnamelabel (
    elementaryschoolname VARCHAR(128) NOT NULL
);
```
**Insert below data in to schoolnamelabel Table**

```
INSERT into schoolnamelabel (elementaryschoolname) VALUES ('MSSE-670 Elementary School Registration Project');
```

**System Requirements**
```
Minimum JRE requirement is Version 1.8

MySQL Connector J 8.0.27 is used to connect to MySQL Database. File Name (mysql-connector-java-8.0.27.jar)

```
**Configuration**

```
"application.properties" file located at com.elementaryschool.config has all services. In case if any service is not required it can be removed from file.

"database.properties" file located at com.elementaryschool.config has database credentials. JAR file sent separately (Folder Name: executable_jar_file) has Cloud Database Credentials and should work without any local database configuration.But if local MySQL database is used "database.properties" file credentials are required to be updated accordingly.

Note: GitHub was sending warning alerts regarding MySQL database URL, so removed it from GitHub repository.

```

# References

Thomas, I. (2013). E-Pedigree Design Document. Anderson College of Business & Computing, Regis University

Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

Edureka (2018). MySQL Workbench Tutorial . Retrieved from https://www.youtube.com/watch?v=uKwR9fWsZJ4

Java Guides (2020). Java Swing Registration Form with MySQL Database in Eclipse. Retrieved from https://www.youtube.com/watch?v=Gwwfetb5CJs

LUV2CODE (2014). JAVA JDBC TUTORIAL. Retrieved from https://www.youtube.com/watch?v=-LrmzNDPVx8

AHMAD, J (2020). Allow Only numbes in JTextfield in Java Desktop Applications using Netbeans IDE. Retrieved from https://www.youtube.com/watch?v=1HyMztaV4ME

stackoverflow (2010). How can I change the font of JTable Header. Retrieved from https://stackoverflow.com/questions/4408644/how-can-i-change-the-font-of-a-jtables-header

Helpdesk Objects (2009). How to limit number of characters in JTextField. Retrieved from http://helpdesk.objects.com.au/java/how-to-limit-number-of-characters-in-jtextfield

stackoverflow (2016). Check if record exists in database with resultset. Retrieved from https://stackoverflow.com/questions/35083680/check-if-record-exists-in-database-with-resultset

Clever Cloud (2021). Cloud MySQL Database. Retrieved from https://www.clever-cloud.com/

