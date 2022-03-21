drop table if exists stores;
create table stores (
    id smallint NOT NULL UNIQUE PRIMARY KEY,
    location varchar NOT NULL,
    address varchar NOT NULL UNIQUE,
    manager varchar NOT NULL UNIQUE
);

drop table if exists employees;
create table employees (
    memberId varchar NOT NULL UNIQUE PRIMARY KEY,
    memberName varchar NOT NULL,
    startDate date NOT NULL,
    employmentLoc int NOT NULL REFERENCES stores(id),
    empRole varchar NOT NULL
);

drop table if exists warehouse;
create table warehouse (
    barcode bigint NOT NULL UNIQUE PRIMARY KEY,
    name varchar NOT NULL,
    brand varchar NOT NULL,
    quantity int NOT NULL,
    on_order boolean NOT NULL
);

drop table if exists inventory212;
create table inventory212 (
    barcode bigint NOT NULL UNIQUE PRIMARY KEY,
    name varchar NOT NULL,
    brand varchar NOT NULL,
    price decimal NOT NULL,
    stock int NOT NULL,
    needRestock boolean NOT NULL,
    sale boolean NOT NULL,
    discountAmt int
);


