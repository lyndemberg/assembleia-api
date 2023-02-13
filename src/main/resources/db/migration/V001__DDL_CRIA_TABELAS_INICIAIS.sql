create table pauta
(
    id               bigserial
        primary key,
    data_atualizacao timestamp(6) with time zone,
    data_criacao     timestamp(6) with time zone not null,
    descricao        varchar(255)                not null,
    internal_id      varchar(255)                not null,
    titulo           varchar(255)                not null
);

alter table pauta
    owner to assembleia_usr;


create table sessao
(
    id           bigserial
        primary key,
    encerramento timestamp(6) not null,
    inicio       timestamp(6) not null,
    internal_id  varchar(255) not null,
    pauta_id     bigint       not null
        constraint fkbc3ehywka7s7yk4j1bb51hgnf
            references pauta
);

alter table sessao
    owner to assembleia_usr;

create table voto
(
    cpf        varchar(255)                not null,
    sessao_id  varchar(255)                not null,
    registrado timestamp(6) with time zone not null,
    valor      boolean                     not null,
    primary key (cpf, sessao_id)
);

alter table voto
    owner to assembleia_usr;
