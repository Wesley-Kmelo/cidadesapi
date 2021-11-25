# Api de Consulta e Cálculo com DB Postgres

Esta Api retorna o nome de todos os países do mundo e estados e cidades do Brasil. 

Foi desenvolvida baseado no curso 
**"API Rest de consulta de cidades do Brasil do zero até a produção"**, elaborado pelo prof. [André Gomes](https://github.com/andrelugomes) 
e disponibilizado na plataforma [DigitalInnovation One](https://digitalinnovation.one/) no bootcamp **TQI Java Developer**.

O código está todo comentado de forma a facilitar para pessoas que estão iniciando no mundo do JAVA. Por isso que também as convenções e variáveis
usadas também estão no idioma Português. 


Gostaria de agradecer ao colega [Chinnon Santos](https://github.com/chinnonsantos) por disponibilizar o banco de dados usado nessa API.

### Tecnologias utilizadas
* Linux Ubuntu 20.04 LTS
* Intellij IDEA Community Edition
* Java 8
* Docker versão 20.10.7
* Git
* Postgres SQL versão 14.1.1
* Heroku CLI
* SpringBoot versão 2.6.0 configurado como 
  - Java versão 8
  - Jar
  - Projeto Gradle
  - Dependências
    - Sprin Data JPA
    - Spring Web
    - PostGreSQL Driver
    
  ### Database   
  #### POSTGRESQL
   Por ser utilizado o Linux, facilita a utilização de containers. Nada impede que seja utilizado em outros sistemas, mas para isso é interessante
  buscar na Web algum material ou na própria plataforma da DIO.
  
Para criar um container no Linux 
```
docker run --name nomedocontainer-db -d -p 5432:5432 -e POSTGRES_USER=usuario -e POSTGRES_PASSWORD=senha -e POSTGRES_DB=nomedobancodedados postgres
```
Em seguida é necessário [baixar](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL) ou clonar os scripts SQL que irão popular os dados SQL....

Iniciar o container criado...

```
git clone https://github.com/chinnonsantos/sql-paises-estados-cidades.git

docker start cities-db
```
Para popular as tabelas é necessário estar no diretório onde os scripts sql foram baixados
```
cd sql-paises-estados-cidades/PostGreSql
```
Popular as tabelas

```
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube;
CREATE EXTENSION earthdistance;

```
Se você gostou pode entrar em contato . Pode dar um star tambem.



 
