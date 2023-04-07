create table projects(
    id              int primary key auto_increment,
    description     varchar(100) not null,
    created_on      datetime,
    updated_on      datetime,
    project_step_id int references project_steps(id)
);

insert into projects(description) values ('test1');
insert into projects(description) values ('test2');