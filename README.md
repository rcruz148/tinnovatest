##TINNOVA TEST

### Lista de Exercícios
    Os exercícios do 1 ao 4 foram disponibilizados dentro da package:
    'com.zurcnaor.tinnovatest.algorhitms'

    1 - ElectionCalculator.java e ElectionCalculatorTest.java
    2 - BubbleSort.java e BubbleSortTest.java
    3 - FactorialCalculator.java e FactorialCalculatorTest.java
    4 - MultipleByThreeOrFiveSum.java e MultipleByThreeOrFiveSumTest.java

### Exercício 5 - Cadastro de Veículos
Foram criadas duas aplicações para atender o exercício, Backend e Front. A seguir temos as tecnologias utilizadas:
    
    Backend:
        - Java 8
        - Spring boot
        - JPA
        - H2 database
        - Spring Validation
        - Liquibase migration
        - JUnit 4
        - Lombok

    Frontend:
        - Angular 8
        - Bootstrap
        - Igx Components
        - Material Icons
        - Reactive Forms

Duas APIs REST estão disponíveis pelo backend:

#### Recursos disponíveis da API de marcas

|Resource|Método|Descrição|
|---|---|---|
|/api/brands|GET|Retorna todas as marcas disponíveis|
|/api/brands/{ID}|GET|Retorna uma marca a partir do ID|
|/api/brands|POST|Cria uma nova marca|
|/api/brands/{ID}|PUT|Alterar uma marca a partir do ID|
|/api/brands/{ID}|DELETE|Remove uma marca a partir do ID|
|/api/brands/{ID}|PATCH|Atualiza parte de uma marca a partir do ID|

#### Recursos disponíveis da API de veículos

|Resource|Método|Descrição|
|---|---|---|
|/api/vehicles**|GET|Retorna todos veículos disponíveis|
|/api/vehicles/{ID}|GET|Retorna um veículo a partir do ID|
|/api/vehicles|POST|Cria um novo veículo|
|/api/vehicles/{ID}|PUT|Alterar um veículo a partir do ID|
|/api/vehicles/{ID}|DELETE|Remove um veículo a partir do ID|
|/api/vehicles/{ID}|PATCH|Atualiza parte de um veículo a partir do ID|

**Este endpoint além de listar todos os veículos, também permite filtrar/localizar os veículos usando os seguintes parametros opcionais:

    1 - 'q': A partir de uma string, os veículos serão retornados
             baseado na comparação da string com os campos 'name',
            'brand', 'description' e 'year' de cada veículo.
    2 - 'startDate': Os veiculos criados a partir da data informada
                     serão retornados. Formato esperado: yyyy-MM-dd
    3 - 'endDate': Os veiculos criados até a data informada
                     serão retornados. Formato esperado: yyyy-MM-dd

    Example:

        /api/vehicles?q=for&startDate=2021-01-24&endDate=2021-01-31

Uma coleção (importada do Postman) de requesições HTTP está disponível na pasta de resources do projeto.

### Melhorias Futuras

- Implementar testes unitários para as classes BrandService and BrandValidator.
- Implementar testes integrados das APIs (testando contratos e status codes)
- Separar a implementação do frontend em mais componentes, permitindo uma melhor separação de lista e cadastro
- Aplicar o Swagger para criar uma documentação simples e direta das APIs

### Execução das aplicações

Backend: `mvn spring-boot:run` na pasta `tinnovatest` do projeto. Aplicação ficará disponível na porta `8080`.

Frontend: `ng serve` na pasta `tinnovatest/frontend` do projeto. Aplicação ficará disponível na porta `4200`.