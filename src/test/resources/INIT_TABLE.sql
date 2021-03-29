DROP TABLE IF EXISTS LOOK;
CREATE TABLE LOOK (
  ID int(11) NOT NULL,
  NAME varchar(100) DEFAULT NULL,
  SV int(3) not null,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS KEYWORD;
CREATE TABLE KEYWORD (
  id int(11) NOT NULL,
  name varchar(100) DEFAULT NULL,
  bid int(3) not null,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS USER;

create table USER (
    _ID varchar(40) not null,
    name varchar(40) not null,
    PRIMARY KEY (_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS PLAN;

create table PLAN (
    _ID varchar(40) not null,
    name varchar(40) not null,
    USER_ID varchar(40),
     primary key(_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS CLASSES;

create table CLASSES (
   ID         			varchar(40) not null ,
   NAME                 varchar(40) ,
   primary key (ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS STUDENT;

create table STUDENT (
   _ID         			varchar(40) not null ,
   NAME                 varchar(40) ,
   CLASSES_ID            	varchar(40) ,
   primary key (_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
