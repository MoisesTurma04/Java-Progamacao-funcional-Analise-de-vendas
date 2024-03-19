# Implementação de Análise de Vendas em Java utilizando Programação Funcional e Expressões Lambda

 Está implementação em Java para realiza uma análise de vendas utilizando programação funcional e expressões lambda. O objetivo é ler um arquivo .csv contendo registros de vendas, realizar algumas análises específicas e apresentar os resultados. Este projeto é desenvolvido de acordo com os critérios e requisitos definidos.

## Requisitos do Projeto

- Ler um arquivo .csv contendo registros de venda.
- Instanciar uma lista de objetos do tipo Sale com base nos dados lidos.
- Aplicar programação funcional e expressões lambda para realizar as análises.
- Mostrar as seguintes análises:
  1. Cinco primeiras vendas de 2016 de maior preço médio, ordenadas decrescentemente por preço médio.
  2. Valor total vendido pelo vendedor Logan nos meses 1 e 7 de qualquer ano.

## Diagrama de classes
```mermaid
classDiagram
    class Sale {
        -Integer month
        -Integer year
        -String seller
        -Integer items
        -Double total
        +Double averagePrice()
    }

    class Program {
        +main(String[] args)
    }
    Sale -- Program : user
