drop table if exists authorities;
drop table if exists users;

create table users
(
    username varchar(20) not null primary key,
    password varchar(60) not null,
    enabled  boolean not null
);

create table authorities
(
    username  varchar(20) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username,authority);

-- Password = password
insert into users(username, password, enabled) values('admin','$2a$12$2JEtsGvBzEPV67mwOS3i8OTDSw0nFbxN9RZ.ohSYjkvG3sR.vYAYW',true);
insert into authorities(username, authority)
values ('admin', 'ROLE_ADMIN');

-- Password = password
insert into users(username, password, enabled) values('user','$2a$12$2JEtsGvBzEPV67mwOS3i8OTDSw0nFbxN9RZ.ohSYjkvG3sR.vYAYW',true);
insert into authorities(username, authority)
values ('user', 'ROLE_USER');