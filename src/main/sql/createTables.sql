create table books(
    "BookId" int NOT NULL  PRIMARY KEY ,
    "FirstName"varchar(20) not null ,
    "LastName"varchar(20) not null ,
    "Age"varchar(20) not null );

create table authors(
      "AuthorId" int NOT NULL  PRIMARY KEY ,
      "BookName"varchar(20) not null ,
      "PublishedYear"int  not null ,
         "Age"int  not null
    );
create table authorbook(
    "AuthorId"int not null primary key ,
    "BookId" int not null);




