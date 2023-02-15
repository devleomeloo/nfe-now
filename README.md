<h2>Invoice API</h2>
O objetivo do projeto 'Invoice API' é cadastrar, consultar, atualizar e deletar notas fiscais através do padrão de APIs REST.

<h3>Documentação:</h3>

* Há uma pasta na raiz do projeto chamada "postman-collection", contendo a chamada de todos os recursos via localhost.
* Para abrir o Swagger da API, se faz necessário rodar o projeto e acessar o seguinte link:

    http://localhost:8090/swagger-ui.html#/
    
<h3>Database</h3>

* Foi utilizado o mySql na versão 8.0 como servidor de banco de dados. Para criação das tabelas e suas respectivas colunas, foi utilizado o Spring JPA.
* Caso necessário, há uma pasta na raiz do projeto chamada 'sql_script' com o script para criação do banco de dados e tabela.

<h3>Regras</h3>

* Só é possível criar uma Nota Fiscal com um número de série único, caso já exista, será retornado um erro de Bad Request 400.
* Para consultar uma nota fiscal, é necessário informar o número da nota fiscal no path. Caso não exista, será retornado um erro de Not Found 404.
* Para atualizar uma nota fiscal, é necessário informar o número da nota fiscal no path. Caso não exista, será retornado um erro de Not Found 404.
* Para deletar uma nota fiscal, é necessário informar o número da nota fiscal no path. Caso não exista, será retornado um erro de Not Found 404.

<h3>Segurança</h3>

* Para acessar os endpoints da API, foi criado uma autenticação via Basic Authorization.
* Usúario: Beesby
* Senha: 2019