# Spring Credit Microservice

#### 1. [8080]spring-credit-adduser

| Endpoint      | Method   | Consumes           |
| ------------- | -------- | ------------------ |
| `/users`      | `GET`    | -                  |
| `/users/{id}` | `GET`    | -                  |
| `/users`      | `POST`   | `application/json` |
| `/users/{id}` | `DELETE` | -                  |
| `/users/{id}` | `PUT`    | `application/json` |

#### 2. [8081]spring-credit-purchasehandler

| Endpoint                                   | Method   | Consumes           |
| ------------------------------------------ | -------- | ------------------ |
| `/users/{id}/addpurchase`                  | `POST`   | `application/json` |
| `/users/{id}/deletepurchase/{purchase_id}` | `DELETE` | -                  |

#### 3. [8082]spring-credit-billgenerator

| Endpoint              | Method | Consumes |
| --------------------- | ------ | -------- |
| `/users/{id}/getbill` | `GET`  | -        |
| `/users/getbills`     | `GET`  | -        |

#### 4. [8083]spring-credit-limitfine

| Endpoint          | Method | Consumes |
| ----------------- | ------ | -------- |
| `/applylimitfine` | `PUT`  | -        |

#### 5. [8084]spring-credit-pendingusers

| Endpoint        | Method | Consumes |
| --------------- | ------ | -------- |
| `/notpaidusers` | `GET`  | -        |

####  6. [8085]spring-credit-notpaidfine

| Endpoint            | Method | Consumes |
| ------------------- | ------ | -------- |
| `/applynotpaidfine` | `PUT`  | -        |

