alter table tb_grupo_permissao add constraint fk_grupo_permissao_permissao
foreign key (permissao_id) references tb_permissao(id);

alter table tb_grupo_permissao add constraint fk_grupo_permissao_grupo
foreign key (grupo_id) references tb_grupo(id);

alter table tb_produto add constraint fk_produto_restaurante
foreign key (restaurante_id) references tb_restaurante(id);

alter table tb_restaurante add constraint fk_restaurante_cozinha
foreign key (cozinha_id) references tb_cozinha(id);

alter table tb_restaurante add constraint fk_restaurante_cidade
foreign key (endereco_cidade_id) references tb_cidade(id);

alter table tb_restaurante_forma_pagamento add constraint fk_rest_forma_pagto_forma_pagto
foreign key (forma_pagamento_id) references tb_forma_pagamento(id);

alter table tb_restaurante_forma_pagamento add constraint fk_rest_forma_pagto_restaurante
foreign key (restaurante_id) references tb_restaurante(id);

alter table tb_usuario_grupo add constraint fk_usuario_grupo_grupo
foreign key(grupo_id) references tb_grupo(id);

alter table tb_usuario_grupo add constraint fk_usuario_grupo_usuario
foreign key(grupo_id) references tb_usuario(id);

alter table tb_cidade add constraint fk_cidade_estado
foreign key(estado_id) references tb_estado(id);