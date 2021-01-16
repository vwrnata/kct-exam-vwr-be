drop table tFavorites cascade constraints;

/*==============================================================*/
/* Table: tFavorites                                            */
/*==============================================================*/
create table tFavorites  (
   id                   VARCHAR2(20)                    not null,
   name                 VARCHAR2(200)                   not null,
   description          VARCHAR2(2000),
   origin               VARCHAR2(200),
   width                NUMBER(6),
   height               NUMBER(6),
   url                  VARCHAR2(2000),
   constraint PK_TFAVORITES primary key (id)
);

drop package CONSTANTS
/

/*==============================================================*/
/* Database package: CONSTANTS                                  */
/*==============================================================*/
create or replace package CONSTANTS as
   TYPE_ID_ALL constant NUMBER(1) :=-1;
end CONSTANTS;
/

create or replace package body CONSTANTS as
   
end CONSTANTS;
/

drop package pFavorites
/
/*==============================================================*/
/* Database package: pFavorites                                 */
/*==============================================================*/
create or replace package pFavorites as
   procedure setFavorite (a_id varchar,a_name varchar,a_description varchar,a_origin varchar,a_width integer,a_height integer,a_url varchar);
   procedure delFavorite (a_id varchar);
end pFavorites;
/

create or replace package body pFavorites as
   procedure setFavorite (a_id varchar,a_name varchar,a_description varchar,a_origin varchar,a_width integer,a_height integer,a_url varchar) as
   idCount number :=0;
   begin
     select count(*) into idCount from tFavorites where id = a_Id;
     if idCount  > 0 then
       update tFavorites set name=a_name, description=a_description, origin=a_origin, width=a_width, height=a_height, url=a_url where id=a_id;
     else
       insert into tFavorites (id, name, description, origin, width, height, url) values (a_id, a_name, a_description, a_origin, a_width, a_height, a_url);
     end if;
   end;
   procedure delFavorite (a_id varchar) as
   begin
     if(a_id='')then
         return;
     end if;
     
     delete tFavorites where id=a_id;
   end;
end pFavorites;
/