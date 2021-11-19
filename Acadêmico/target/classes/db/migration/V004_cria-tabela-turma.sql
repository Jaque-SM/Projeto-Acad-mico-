create table turma (
 id int not null primary key auto_increment,
 turno varchar (20),
 dataInicio varchar (20),
 dataFim varchar (20),
 horario varchar (20),
 qtdVagas int not null, 
 aluno_id bigint not null
);
alter table turma add constraint fk_turma_aluno
foreign key (aluno_id) references aluno (id);  



 