create table clients (
    id bigserial primary key,
    first_name varchar(200) not null,
    last_name varchar(200) not null,
    age integer not null,
    phone_number varchar(20) not null unique,
    email varchar(200) not null unique,
    passport_number varchar(15) not null unique
);

create table administrators (
    id bigserial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(100) not null unique,
    phone_number varchar(20) not null unique
);

create table cars(
    id bigserial primary key,
    brand varchar(50) not null,
    model varchar(50) not null,
    year integer not null,
    price_per_day decimal(10,2) not null,
    plate_number varchar(20) not null unique
);

create table orders(
    id bigserial primary key,
    client_id bigserial not null references clients(id),
    car_id bigserial not null references cars(id),
    administrator_id bigserial not null references administrators(id),
    start_date varchar(40) not null,
    end_date varchar(40) not null,
    pick_up_location varchar(500) not null,
    drop_off_location varchar(500) not null,
    total_price decimal(10,2) not null,
    status varchar(300) not null,
    rejection_reason varchar(2000)
);

create table payments(
    id bigserial primary key,
    order_id bigserial not null references orders(id),
    amount decimal(10,2) not null,
    payment_date varchar(40) not null,
    status varchar(300) not null
);

create table return_acts(
    id bigserial primary key,
    order_id bigserial not null references orders (id),
    administrator_id bigserial not null references administrators (id),
    return_date varchar(40) not null,
    damages varchar(4000),
    has_damages boolean not null,
    repair_cost decimal(10,2)
)
