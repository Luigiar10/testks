<h3 align="center">Komet Sales Test - Api</h3>

  <p align="center">
    Prueba Técnica para dev
  </p>

<!-- ABOUT THE PROJECT -->
## Acerca del proyecto

Prueba técnica para backend developer enfocado en Java y Spring boot

Requisitos:
* Java
* Spring Boot
* En 24 horas

El proyecto se compone de dos ramas (main y list), en la rama list el proyecto no usa base de datos, se usa una lista estática para consumir y modificar el api, en la rama main se usa mysql como base de datos y jpa.

Leer `HELP.md` para conocer mas acerca de Spring Boot.

### Construido con

El proyecto fue construido con Java, Spring Boot, MySql

* [![Next][Java]][Java-url]
* [![React][Spring]][Spring-url]

## Endpoints
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

<!-- CONTACT -->
## Contacto

Luigi Arrieta - [@luigiarrieta](https://www.linkedin.com/in/luigi-arrieta/)

Blog: [https://blog.luigiarrieta.com](https://blog.luigiarrieta.com)

<!-- MARKDOWN LINKS & IMAGES -->
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/Java-20232A
[Java-url]: https://www.java.com/es/
[Spring]: https://img.shields.io/badge/SpringBoot-20232A
[Spring-url]: https://spring.io/

#### Nota:
No quede del todo seguro si el requisito en la parte de la lista si fue desarrollado acorde a lo que se esperaba (me imagino que solicitaban una lista para no ser necesario ninguna BD), se crearon dos ramas por esa razón. Se podría mejorar con paginación a los resultados, autenticación y autorización.