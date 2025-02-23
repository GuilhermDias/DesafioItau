📌 Itaú Unibanco - Desafio de Programação

Este projeto consiste em um desafio de desenvolvimento e engenharia de software, no qual o objetivo é construir uma API capaz de processar transações financeiras e calcular estatísticas baseadas nessas transações.

🚀 Tecnologias Utilizadas

Java / Spring Boot

📌 Endpoints da API

1️⃣ Receber Transações

Método: POST /transacao

Descrição: Recebe uma transação contendo valor e data/hora do ocorrido.

Exemplo de Request:

{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}

Resposta Esperada: 201 Created (se a transação for válida)

2️⃣ Limpar Transações

Método: DELETE /transacao

Descrição: Remove todas as transações armazenadas.

Resposta Esperada: 200 OK (sem corpo de resposta)

3️⃣ Calcular Estatísticas

Método: GET /estatistica

Descrição: Retorna estatísticas das transações realizadas nos últimos 60 segundos.

Exemplo de Resposta:

{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}

Resposta Esperada: 200 OK

📄 Licença

Este projeto é apenas para fins educacionais e não possui uma licença específica
