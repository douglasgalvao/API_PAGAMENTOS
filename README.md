# API_PAGAMENTOS
### API de pagamentos com SpringBoot usando Postgresql e Supabase para Database

### Clonando o projeto
```shell
$ git clone https://github.com/douglasgalvao/API_PAGAMENTOS.git
```
## Tecnologias usadas no projeto:
###### Java
###### SpringBoot -- SpringSecurity
###### Postgresql -- Supabase
###### JPA -- Hibernate


## Endpoints
### Para criar um usuário
###### Method: POST 
###### URL: payment-api/users


#### Criar um usuário e uma conta vinculada com seu balance zerado
```json
  ** REQUEST **

{
  "login": "douglas",  @required
  "password": "321654987", @required
  "phoneNumber": "980267791",
  "cpf": "14513762608",
  "email": "douglasmachado@gmail.com",
}


  ** RESPONSE **
{
  "id": "797fc553-0553-47d1-a1c0-9a38a03ff6aa", @idUser
  "phoneNumber": "980267791",
  "cpf": "14513762608",
  "login": "douglas",
  "email": "douglasmachado@gmail.com",
  "accountID": "8c79e76b-5423-4012-bf9b-e81d2448585d" @idAccount
}
```
### Para autenticar e conseguir acessar outras rotas (adquirir o JWT)
###### Method: POST
###### URL: payment-api/login

#### Acessa o banco de dados e verifica as credenciais
###### Credenciais SUCCESS -> returns JWT
###### Credenciais UNSUCCESS -> returns 403 Forbidden Status
```json
  ** REQUEST **

{
  "login":"douglas",
  "password":"321654987"
}

  ** RESPONSE **

@Exemplo SUCCESS ( Jwt sempre retornará diferente a cada chamada )
{
  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyQmFua0RUTyhpZD1udWxsLCBwaG9uZU51bWJlcj05ODE1MjMyNDM1LCBjcGY9bnVsbCwgbG9naW49ZGdtYWNoYWRvLCBwYXNzd29yZD1udWxsLCBlbWFpbD1kb3VnbGFzbWFjaGFkb0BnbWFpbC5jb20sIGFjY291bnRJRD1udWxsKSIsImV4cCI6MTY2NTYyNjM2MH0.PcJMxzW7GTOxKbJ31XOd3SbMZobryeH7ey38yhZu5yUU7b5vDITxw_xg9adR_J-amNJ3Y0frhKXHRxS06fy7EQ
}
```



### Para pesquisar todos usuários do banco
###### Method: GET
###### URL: payment-api/users


#### Pesquisa todos usuários da tabela @requer Bearer Token (***Autenticada***)
```json
  ** REQUEST **
       {}

  ** RESPONSE **

@Array usuários
[
  {
    "id": "797fc553-0553-47d1-a1c0-9a38a03ff6aa",
    "phoneNumber": "980267791",
    "cpf": "14513762608",
    "login": "douglas",
    "email": "douglasmachado@gmail.com",
    "accountID": "8c79e76b-5423-4012-bf9b-e81d2448585d"
  }
]
```

### Para pesquisar um usuário do banco por id
###### Method: GET
###### URL: payment-api/users/{id}


#### Pesquisa usuário da tabela por id @requer Bearer Token (***Autenticada***)
```json
  ** REQUEST **
@Exemplo payment-api/users/797fc553-0553-47d1-a1c0-9a38a03ff6aa
       {} 

  ** RESPONSE **

{
  "id": "797fc553-0553-47d1-a1c0-9a38a03ff6aa",
  "phoneNumber": "980267791",
  "cpf": "14513762608",
  "login": "douglas",
  "email": "douglasmachado@gmail.com",
  "accountID": "8c79e76b-5423-4012-bf9b-e81d2448585d"
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
