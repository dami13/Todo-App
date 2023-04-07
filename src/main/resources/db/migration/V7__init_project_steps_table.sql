create table project_steps(
    id                  int primary key auto_increment,
    description         varchar(100) not null,
    days_to_deadline    int not null,
    created_on          datetime,
    updated_on          datetime
);

insert into project_steps(description, days_to_deadline) values ('test1', 2);
insert into project_steps(description, days_to_deadline) values ('test2', 5);