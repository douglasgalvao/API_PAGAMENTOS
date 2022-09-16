# ToolsChallanger
## API de pagamentos com SpringBoot usando H2(dados em memória) e priorizando uma Arquitetura limpa


### Clonando o projeto
```shell
$ git clone https://github.com/douglasgalvao/ToolsChallanger.git
```

## Endpoints

### POST /accounts
#### Criar uma conta com um balance
```json
REQUEST

{
    "balance": 560500.00, // "exemplo balanceAccount"
    "name": "Douglas"  // "exemplo nameAccount"
}

RESPONSE

{
    "balance": 560500.0,
    "name": "Douglas",
    "id": 2                // idAccount gerado
}

```
### POST /transactions
#### Efetuar uma transação 
```json
REQUEST

{
    "cartao": "Mastercard",
    "account":{
        "id": 1          // Necessário um idAccount existente
    },
    "description": {
        "valor": "1600.00",
        "estabelecimento": "Empresa do Douglas",
        "nsu": "123",
        "status": "AUTORIZADO",
        "codigoAutorizacao":"321654987"
    },
    "paymentMethod": {
        "tipo": "PARCELADO_LOJA",
        "parcelas": "12"
    }
} 

RESPONSE

{
    "cartao": "Mastercard",
    "id": 1,
    "account": {
        "balance": 558900.0,
        "name": "Douglas",
        "id": 1
    },
    "description": {
        "id": 1,
        "valor": "1600.00",
        "dataHora": "2022-09-16T12:32:22.682996214",
        "estabelecimento": "Empresa do Douglas",
        "codigoAutorizacao": "321654987",
        "nsu": "123",
        "status": "AUTORIZADO"        // caso account>balance seja maior que description>valor retornará AUTORIZADO
    },
    "paymentMethod": {
        "id": 1,
        "parcelas": "12",
        "tipo": "PARCELADO_LOJA",
        "transaction": null
    }
}

{
    "cartao": "Mastercard",
    "id": 1,
    "account": {
        "balance": 689.00,
        "name": "Douglas",
        "id": 1
    },
    "description": {
        "id": 1,
        "valor": "1400.00",
        "dataHora": "2022-09-16T12:32:22.682996214",
        "estabelecimento": "Empresa do Douglas",
        "codigoAutorizacao": "321654987",
        "nsu": "123",
        "status": "CANCELADO"        // caso account>balance seja menor que description>valor retornará CANCELADO
    },
    "paymentMethod": {
        "id": 1,
        "parcelas": "12",
        "tipo": "PARCELADO_LOJA",
        "transaction": null
    }
}

```


#### Consultar todas accounts
### GET /accounts
```json
REQUEST
{}

RESPONSE
#Example
[
    {
        "balance": 558900.0,
        "name": "Rafael Andrade",
        "id": 1
    },
    {
        "balance": 12132.0,
        "name": "Douglas",
        "id": 2
    },
    {
        "balance": 870.0,
        "name": "Anna Costa",
        "id": 3
    },
    {
        "balance": 23670.0,
        "name": "Marcelo andrade",
        "id": 4
    }
]

```


#### Consultar account por ID
### /accounts/{id}
```json
REQUEST
example /accounts/1
{}
RESPONSE
{
    "balance": 558900.0,
    "name": "Rafael",
    "id": 1
}

```



#### Consultar todas transações de uma accountID
### /transactions/{id}
```json
REQUEST
# Example id = 1

RESPONSE

[
    {
        "cartao": "Mastercard",
        "id": 1,
        "account": {
            "balance": 557300.0,
            "name": "Rafael",
            "id": 1
        },
        "description": {
            "id": 1,
            "valor": "1600.00",
            "dataHora": "2022-09-16T12:32:22.682996",
            "estabelecimento": "Empresa do Douglas",
            "codigoAutorizacao": "321654987",
            "nsu": "123",
            "status": "AUTORIZADO"
        },
        "paymentMethod": {
            "id": 1,
            "parcelas": "12",
            "tipo": "PARCELADO_LOJA",
            "transaction": null
        }
    }
 ]
```
