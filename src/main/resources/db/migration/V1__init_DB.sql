create table visit (
                     id  bigserial not null,
                     date timestamp,
                     page_id varchar(255),
                     user_id varchar(255),
                     primary key (id))
