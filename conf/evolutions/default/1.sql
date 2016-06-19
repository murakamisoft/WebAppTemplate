# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table mcar (
  car_id                    varchar(255) not null,
  car_name                  varchar(255),
  price                     bigint,
  color                     varchar(255),
  cc                        integer,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_mcar primary key (car_id))
;

create table muser (
  user_id                   varchar(255) not null,
  pass_word                 varchar(255),
  name                      varchar(255) not null,
  sex                       varchar(255),
  tel                       varchar(255),
  address                   varchar(255),
  mail_address              varchar(255),
  message                   varchar(255),
  money                     decimal(38),
  admin_flg                 varchar(255),
  group_id                  varchar(255),
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_muser primary key (user_id))
;

create table muser_group (
  group_id                  varchar(255) not null,
  group_name                varchar(255) not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_muser_group primary key (group_id))
;

create table tuser_car (
  user_id                   varchar(255) not null,
  car_id                    varchar(255) not null,
  daihyo_flg                varchar(255),
  create_date               timestamp not null,
  update_date               timestamp not null)
;

create sequence mcar_seq;

create sequence muser_seq;

create sequence muser_group_seq;

create sequence tuser_car_seq;

alter table muser add constraint fk_muser_userGroup_1 foreign key (group_id) references muser_group (group_id);
create index ix_muser_userGroup_1 on muser (group_id);
alter table tuser_car add constraint fk_tuser_car_user_2 foreign key (user_id) references muser (user_id);
create index ix_tuser_car_user_2 on tuser_car (user_id);
alter table tuser_car add constraint fk_tuser_car_car_3 foreign key (car_id) references mcar (car_id);
create index ix_tuser_car_car_3 on tuser_car (car_id);



# --- !Downs

drop table if exists mcar cascade;

drop table if exists muser cascade;

drop table if exists muser_group cascade;

drop table if exists tuser_car cascade;

drop sequence if exists mcar_seq;

drop sequence if exists muser_seq;

drop sequence if exists muser_group_seq;

drop sequence if exists tuser_car_seq;

