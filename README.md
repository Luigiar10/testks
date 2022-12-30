# Komet Sales Test - Api RestFul

Endpoints de apis

* Post list of flowers
  <br>
  https://localhost:8080/flowers
  <br>  
  Example
```
[
    {
        "id": 1,
        "name": "Rosa",
        "price": 25
    },
    {
        "id": 2,
        "name": "Ortencia",
        "price": 150
    },
    {
        "id": 3,
        "name": "Pompom",
        "price": 100
    },
    {
        "id": 4,
        "name": "Cusy",
        "price": 350
    }
]
```

* Get All Flowers
<br>
https://localhost:8080/flowers

* Get price filter Flowers
  <br>
  https://localhost:8080/flowers?price=20

* Delete flower by id
  <br>
  https://localhost:8080/flowers/{id}

* Get All Flowers by name
  <br>
  https://localhost:8080/flowers?name=Rosa