drop table message if exists;

create table message (
    id bigint generated by default as identity,
    text varchar(255),
    primary key (id)
);