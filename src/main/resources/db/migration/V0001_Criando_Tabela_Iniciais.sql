create table tb_cozinha(
    id bigint not null auto_increment,
    nome_cozinha varchar(50),

    primary key(id)
) engine=InnoDB default charset=utf8;

create table tb_restaurante(
    id bigint not null auto_increment,
    nome_restaurante varchar(70),
    taxa_decimal decimal(5,2),
    cozinha_id bigint not null,

    primary key(id)
) engine=InnoDB default charset=utf8;

create table tb_estado(
    id bigint not null auto_increment,
    nome_estado varchar(70),

    primary key(id)
) engine=InnoDB default charset=utf8;

create table tb_cidade(
    id bigint not null auto_increment,
    nome_cidade varchar(70),
    estado_id bigint not null,

    primary key(id)
) engine=InnoDB default charset=utf8