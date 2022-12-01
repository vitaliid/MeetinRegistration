create table if not exists field
(
    id   varchar(36) default gen_random_uuid() not null
        constraint field_pk
            primary key,
    name text                                  not null
);

alter table field
    owner to yqsgryvr;

create table if not exists address
(
    id       varchar(36) default gen_random_uuid() not null
        constraint address_pk
            primary key,
    city     text                                  not null,
    field_id varchar(36)
        constraint address_field_uuid_fk
            references field
);

alter table address
    owner to yqsgryvr;

create unique index if not exists field_name_uindex
    on field (name);

create table if not exists payment
(
    type text,
    id   varchar(36) default gen_random_uuid() not null
        constraint payment_pk
            primary key
);

alter table payment
    owner to yqsgryvr;

create table if not exists participant
(
    id         varchar(36) default gen_random_uuid() not null
        constraint participant_pk
            primary key,
    name       text                                  not null,
    email      text                                  not null,
    gender     text,
    address_id varchar(36)
        constraint user_address_uuid_fk
            references address,
    minister   text,
    payment_id varchar(36)
        constraint user_payment_uuid_fk
            references payment
);

alter table participant
    owner to yqsgryvr;

create unique index if not exists participant_name_uindex
    on participant (name);

create unique index if not exists participant_email_uindex
    on participant (email);

create table if not exists apartment
(
    id     varchar(36) default gen_random_uuid() not null
        constraint apartment_pk
            primary key,
    number text                                  not null,
    gender text                                  not null
);

alter table apartment
    owner to yqsgryvr;

create unique index if not exists apartment_number_uindex
    on apartment (number);

create table if not exists bed
(
    id             varchar(36) default gen_random_uuid() not null
        constraint bed_pk
            primary key,
    participant_id varchar(36)
        constraint bed_participant_id_fk
            references participant,
    apartment_id   varchar(36)                           not null
        constraint bed_apartment_id_fk
            references apartment,
    number         text                                  not null,
    level          integer     default 1                 not null,
    booking        integer     default 0                 not null
);

alter table bed
    owner to yqsgryvr;

create unique index if not exists bed_number_apartment_id_uindex
    on bed (number, apartment_id);

