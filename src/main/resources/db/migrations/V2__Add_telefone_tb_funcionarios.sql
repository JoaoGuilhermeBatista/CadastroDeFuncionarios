-- Migration para adicionar a coluna de "telefone" na tabela de "funcionarios"

ALTER TABLE TB_FUNCIONARIOS
ADD COLUMN telefone VARCHAR(20);

ALTER TABLE TB_FUNCIONARIOS
ADD CONSTRAINT UK_FUNCIONARIOS_TELEFONE UNIQUE (telefone);