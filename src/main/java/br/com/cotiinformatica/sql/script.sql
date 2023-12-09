--carga na tabela de categorias
insert into tbl_categoria(id_pk, nome) values(gen_random_uuid(), 'Informática');
insert into tbl_categoria(id_pk, nome) values(gen_random_uuid(), 'Eletrônicos');
insert into tbl_categoria(id_pk, nome) values(gen_random_uuid(), 'Games');
insert into tbl_categoria(id_pk, nome) values(gen_random_uuid(), 'Papelaria');
insert into tbl_categoria(id_pk, nome) values(gen_random_uuid(), 'Outros');

select * from tbl_categoria;

--carga na tabela de fornecedores
insert into tbl_fornecedor(id_pk, nome, cnpj) values(gen_random_uuid(), 'Loja A', '72.940.151/0001-30');
insert into tbl_fornecedor(id_pk, nome, cnpj) values(gen_random_uuid(), 'Loja B', '24.631.310/0001-72');

select * from tbl_fornecedor;