create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      numeric(8, 2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price)
values ('Milk', 100.20),
       ('Bread', 80.20),
       ('Cheese', 90.20),
       ('Cheese2', 90.00),
       ('Cheese3', 90.00),
       ('Cheese4', 90.00),
       ('Cheese5', 90.00),
       ('Cheese6', 90.00),
       ('Cheese7', 90.00),
       ('Cheese8', 90.00),
       ('Cheese9', 90.00);

create table orders
(
    id          bigserial primary key,
    username    varchar(255)  not null,
    total_price numeric(8, 2)  not null,
    address     varchar(255),
    phone       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product numeric(8, 2)    not null,
    price             numeric(8, 2)    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

alter table orders add column status varchar(255)  not null;
alter table orders add column postal_code int not null;


--insert into orders (username, total_price, address, phone, status)
--values ('bob', 200.00, 'address', '12345', 'NEW');

--insert into order_items (product_id, order_id, quantity, price_per_product, price)
--values (1, 1, 2, 100.00, 200.00);

create table countries (
    id           bigserial primary key,
    name         varchar(255)  not null,
    code         varchar(5)  not null
);

create table cities (
    id           bigserial primary key,
    name         varchar(255)  not null,
    country_id   bigint not null references countries (id)
);

alter table orders add column city_id bigint not null references cities (id);

insert into countries (id, name, code)
values
(1, 'Russia', 'RU'),
(2, 'Austria', 'AT'),
(3, 'Italy', 'ITA');

insert into cities (id, name, country_id)
values
(1, 'Moscow', 1),
(2, 'Ivanovo', 1),
(3, 'Roma', 3);







