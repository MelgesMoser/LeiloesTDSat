# LeiloesTDSat

Aplicação desktop desenvolvida em Java para apoiar o controle de leilões. O sistema permite cadastrar produtos e consultar/listar os itens, seus valores e a situação de venda.

## Tecnologias

- Java (projeto NetBeans/Ant; compilação configurada para Java 18)
- MySQL
- JDBC (MySQL Connector/J)
- Swing (interface gráfica)

## Banco de dados

O arquivo [`database/uc11.sql`](database/uc11.sql) contém o dump do banco `uc11` e a tabela `produtos`. Crie o banco no MySQL/MariaDB e importe o arquivo SQL antes de executar a aplicação. A conexão configurada em `src/conectaDAO.java` utiliza `localhost`, usuário `root` e senha vazia; ajuste a configuração de acordo com seu ambiente.

## Abrir o projeto

Abra a pasta do projeto no Apache NetBeans. O projeto usa Ant (`build.xml`) e mantém as dependências JDBC em `lib/`.

Ao executar o projeto pelo NetBeans ou pelo Ant, a tela `cadastroVIEW` é aberta primeiro.
