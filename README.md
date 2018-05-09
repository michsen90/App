# App

Database:
CREATE TABLE public.accounts
(
  id_account integer NOT NULL DEFAULT nextval('accounts_id_account_seq'::regclass),
  login character varying(20) NOT NULL,
  password character varying(20) NOT NULL,
  id_client integer NOT NULL,
  CONSTRAINT accounts_pkey PRIMARY KEY (id_account),
  CONSTRAINT clients_id_client_fkey FOREIGN KEY (id_client)
      REFERENCES public.clients (id_client) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)

CREATE TABLE public.clients
(
  id_client integer NOT NULL DEFAULT nextval('clients_id_client_seq'::regclass),
  firstname character varying(30),
  lastname character varying(30),
  email character varying(50),
  city character varying(30),
  street character varying(30),
  "number" character varying(10),
  phone character varying(12),
  CONSTRAINT clients_pkey PRIMARY KEY (id_client)
)

CREATE TABLE public.prices
(
  id_price integer NOT NULL DEFAULT nextval('prices_id_price_seq'::regclass),
  id_room integer NOT NULL,
  price_per_day real NOT NULL,
  CONSTRAINT prices_pkey PRIMARY KEY (id_price),
  CONSTRAINT rooms_id_room_fkey FOREIGN KEY (id_room)
      REFERENCES public.rooms (id_room) MATCH FULL
      ON UPDATE RESTRICT ON DELETE RESTRICT
)

CREATE TABLE public.reservations
(
  id_reservation integer NOT NULL DEFAULT nextval('reservations_id_reservation_seq'::regclass),
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
)

CREATE TABLE public.rooms
(
  id_room integer NOT NULL DEFAULT nextval('rooms_id_room_seq'::regclass),
  room_type character varying(20) NOT NULL,
  balcone character varying(3) NOT NULL,
  floor character varying(10) NOT NULL,
  family_room character varying(3) NOT NULL,
  animals character varying(3) NOT NULL,
  CONSTRAINT rooms_pkey PRIMARY KEY (id_room)
)
