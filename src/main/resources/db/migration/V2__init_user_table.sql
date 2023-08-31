-- drop table users;

CREATE TABLE users(
                      user_id SERIAL PRIMARY KEY,
                      email varchar(30) unique not null,
                      name varchar(30) not null,
                      password char(64) not null,
                      created_time TIMESTAMP with time zone not null,
                      updated_time TIMESTAMP WITH TIME ZONE NOT NULL
);