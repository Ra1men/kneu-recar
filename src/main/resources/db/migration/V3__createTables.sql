create table users
(
    id bigint generated always as identity primary key not null,
    username varchar(100),
    password varchar(100),
    role varchar(60)
);

