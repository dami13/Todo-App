drop table if exists tasks;
create table tasks(
    id          int primary key auto_increment,
    description varchar(100) not null,
    done        bit
);

insert into tasks (description, done) values ('test', true);
insert into tasks (description, done) values ('test 1', true);
insert into tasks (description, done) values ('test 2', false);