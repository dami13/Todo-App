alter table task_groups add column project_id int null;
alter table task_groups add foreign key (project_id) references projects(id);