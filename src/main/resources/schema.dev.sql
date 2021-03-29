

drop table if exists KEYWORD;

drop table if exists USER;

drop table if exists PLAN;

drop table if exists CLASSES;

drop table if exists STUDENT;

drop table if exists LOOK;


create table LOOK (
    id int(11) not null,
    name varchar(40) not null,
    sv int(3) not null,
    primary key(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table PLAN (
    _id varchar(40) not null,
    name varchar(40) not null,
    USER_ID varchar(40),
     primary key(_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table USER (
    _id varchar(40) not null,
    name varchar(40) not null,
     primary key(_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table KEYWORD (
    id int(11) not null,
    name varchar(40) not null,
    bid int(3) not null,
    primary key(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table CLASSES
(
   ID         			varchar(40) not null ,
   NAME                 varchar(40) ,
   primary key (ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table STUDENT
(
   _ID         			varchar(40) not null ,
   NAME                 varchar(40) ,
   CLASSES_ID            	varchar(40) ,
   primary key (_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
