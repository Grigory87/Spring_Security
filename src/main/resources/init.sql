insert into users (username, password, email)
values ('user', '$2y$04$2E7y5CJfHeV/TKmPHVBdvOz42PrWGVQBk.nvJugZ435XiOFyfFVn2', 'user@mail.ru'),
       ('admin', '$2y$04$2E7y5CJfHeV/TKmPHVBdvOz42PrWGVQBk.nvJugZ435XiOFyfFVn2', 'admin@mail.ru');

insert into roles (name)
values ('ROLE_USER'),('ROLE_ADMIN');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);