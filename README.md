# LeiloesTDSat

Aplicação desktop desenvolvida em Java para apoiar o controle de leilões. O sistema permite cadastrar produtos e consultar/listar os itens, seus valores e a situação de venda.

## Tecnologias

- Java (projeto NetBeans/Ant; compilação configurada para Java 18)
- MySQL
- JDBC (MySQL Connector/J)
- Swing (interface gráfica)

## Banco de dados

O arquivo [`database/uc11.sql`](database/uc11.sql) contém o dump do banco `uc11` e a tabela `produtos`. Crie o banco no MySQL/MariaDB e importe o arquivo SQL antes de executar a aplicação. Por padrão, a conexão usa `jdbc:mysql://localhost/uc11`, usuário `root` e senha vazia. Se seu ambiente usar outros dados, configure `LEILOES_DB_URL`, `LEILOES_DB_USER` e `LEILOES_DB_PASSWORD` como variáveis de ambiente.

## Abrir o projeto

Abra a pasta do projeto no Apache NetBeans. O projeto usa Ant (`build.xml`) e mantém as dependências JDBC em `lib/`.

Ao executar o projeto pelo NetBeans ou pelo Ant, a tela `cadastroVIEW` é aberta primeiro.
