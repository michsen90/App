Drop Database if exists booking;
Create Database booking;

\c booking

drop table if exists clients;

CREATE TABLE public.clients
(
  id_client serial NOT NULL,
  firstname character varying(30),
  lastname character varying(30),
  email character varying(50),
  city character varying(30),
  street character varying(30),
  "number" character varying(10),
  phone character varying(12),
  CONSTRAINT clients_pkey PRIMARY KEY (id_client)
);

drop table if exists accounts;

CREATE TABLE public.accounts
(
  id_account serial NOT NULL,
  login character varying(20) NOT NULL,
  password character varying(20) NOT NULL,
  id_client integer NOT NULL,
  CONSTRAINT accounts_pkey PRIMARY KEY (id_account),
  CONSTRAINT clients_id_client_fkey FOREIGN KEY (id_client)
      REFERENCES public.clients (id_client) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE public.rooms
(
  id_room serial NOT NULL,
  room_type character varying(20) NOT NULL,
  balcone character varying(3) NOT NULL,
  floor character varying(10) NOT NULL,
  family_room character varying(3) NOT NULL,
  animals character varying(3) NOT NULL,
  CONSTRAINT rooms_pkey PRIMARY KEY (id_room)
);

drop table if exists prices;

CREATE TABLE public.prices
(
  id_price serial NOT NULL,
  id_room integer NOT NULL,
  price_per_day real NOT NULL,
  CONSTRAINT prices_pkey PRIMARY KEY (id_price),
  CONSTRAINT rooms_id_room_fkey FOREIGN KEY (id_room)
      REFERENCES public.rooms (id_room) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

drop table if exists reservations;

CREATE TABLE public.reservations
(
  id_reservation serial NOT NULL,
  start_date date NOT NULL,
  finish_date date NOT NULL,
  id_client integer NOT NULL,
  id_room integer NOT NULL,
  CONSTRAINT reservation_pkey PRIMARY KEY (id_reservation),
  CONSTRAINT clients_id_client_fkey FOREIGN KEY (id_client)
      REFERENCES public.clients (id_client) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT rooms_id_room_fkey FOREIGN KEY (id_room)
      REFERENCES public.rooms (id_room) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


insert into clients (firstname, lastname, email, city, street, number, phone)
values ('Michal', 'Senkowicz', 'michsen90@o2.pl', 'Krakow', 'Piltza', '48/77', '793382138');
insert into clients (firstname, lastname, email, city, street, number, phone)
values ('Andrzej', 'Kowalski', 'andkow@o2.pl', 'Krakow', 'Lubostron', '12/21', '696214555');
insert into clients (firstname, lastname, email, city, street, number, phone)
values ('Paweł', 'Stal', 'pawSta@o2.pl', 'Wieliczka', 'Krakowska', '12a', '988756124');
insert into clients (firstname, lastname, email, city, street, number, phone)
values ('Grzegorz', 'Bart', 'grzbar@o2.pl', 'Bochania', 'Tarnowska', '2', '505984123');
insert into clients (firstname, lastname, email, city, street, number, phone)
values ('Wlodzimierz', 'Kazmierczak', 'wlokaz@o2.pl', 'Krakow', 'Miłkowskiego', '12a/1', '655499841');
  
insert into accounts (login, password, id_client)
values ('michsen', 'gabrysia_1', 1);
insert into accounts (login, password, id_client)
values ('andkow', 'andrzej', 2);
insert into accounts (login, password, id_client)
values ('pawsta', 'pawel1', 3);
insert into accounts (login, password, id_client)
values ('grzbar', 'bartgrz', 4);
insert into accounts (login, password, id_client)
values ('wlokaz', 'wlodek', 5);

insert into rooms (room_type, balcone, floor, family_room, animals)
values ('czteroosobowy', 'NO', 'Parter', 'YES', 'YES');
insert into rooms (room_type, balcone, floor, family_room, animals)
values ('trzyosobowy', 'NO', 'Parter', 'YES', 'YES');
insert into rooms (room_type, balcone, floor, family_room, animals)
values ('trzyosobowy', 'YES', 'I Piętro', 'NO', 'NO');
insert into rooms (room_type, balcone, floor, family_room, animals)
values ('dwuosobowy', 'YES', 'I Piętro', 'NO', 'NO');
insert into rooms (room_type, balcone, floor, family_room, animals)
values ('jednoosobowy', 'YES', 'Parter', 'NO', 'NO');


insert into prices (id_room, price_per_day)
values ('1', '300');
insert into prices (id_room, price_per_day)
values ('2', '240');
insert into prices (id_room, price_per_day)
values ('3', '260');
insert into prices (id_room, price_per_day)
values ('4', '210');
insert into prices (id_room, price_per_day)
values ('5', '170');
  
insert into reservations (start_date, finish_date, id_client, id_room)
values ('10-05-2018', '20-05-2018', 1, 1);
insert into reservations (start_date, finish_date, id_client, id_room)
values ('16-05-2018', '22-05-2018', 2, 2);
insert into reservations (start_date, finish_date, id_client, id_room)
values ('25-05-2018', '31-05-2018', 3, 3);
insert into reservations (start_date, finish_date, id_client, id_room)
values ('31-05-2018', '10-06-2018', 4, 4);
insert into reservations (start_date, finish_date, id_client, id_room)
values ('19-05-2018', '29-05-2018', 5, 5);

Select * from clients;

Select * from accounts;

Select * from rooms;

Select * from prices;

Select * from reservations;  