
# Elementary School Registration Project

Contributors to this document: Danish Kamaal

Regis University

MSSE 670: Object Oriented Software Construction

Professor: Ishmael Thomas

“Elementary School Registration” application is used to enroll students in elementary school grades (Kindergarten, First Grade, Second Grade, Third Grade, Fourth Grade and Fifth Grade). School Registrar will enter information in Registration Form based on paper application received from Students. School Registrar will assign one class section (A or B) to students. Each class section has specific teacher assigned. After successful enrollment registration information will be displayed. Once student enrollment is successfully done, School Registrar can update the registration or delete the registration. Only one registration application per Student is allowed.

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




# References

Thomas, I. (2013). E-Pedigree Design Document. Anderson College of Business & Computing, Regis University

Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University
