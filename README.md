# Prueba-tecnica-accenture
Tecnologías utilizadas

Java 21

Spring Boot 3

Spring Web

Spring Data JPA

MySQL

Lombok

Docker & Docker Compose

Maven

Hibernate

🛠️ Cómo instalar y ejecutar el proyecto en entorno local
✔️ 1. Clonar el repositorio
git clone https://github.com/tu_usuario/tu_repositorio.git
cd tu_repositorio

2. Configurar la base de datos (MySQL)

Crea una base de datos local:

CREATE DATABASE franquicias_db;


Configura tu archivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/franquicias_db
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

✔️ 3. Instalar dependencias

(Maven lo hace automáticamente al correr el proyecto)

mvn clean install

✔️ 4. Ejecutar el proyecto
mvn spring-boot:run

La API quedará disponible en:
👉 http://localhost:8080

🐳 Ejecución con Docker (opcional)

Este proyecto incluye:

Dockerfile

docker-compose.yml

✔️ 1. Construir imagen Docker
docker build -t franquicias-app .

✔️ 2. Levantar servicios con docker-compose

El docker-compose.yml incluye:

Contenedor Spring Boot

Contenedor MySQL

Ejecutar:

docker-compose up -d


La API quedará disponible en:
👉 http://localhost:8080

Estructura del Proyecto
src/
 └── main/
     ├── java/com.prueba_tecnica_accenture/
     │     ├── Controller/
     │     ├── Service/
     │     ├── Repository/
     │     └── Model/Entity/
     └── resources/
           ├── application.properties
           └── data.sql (si aplica) 


           🔥 Endpoints principales
🧱 Franquicias
Método	Endpoint	Descripción
POST	/franquicias	Crear una franquicia
GET	/franquicias	Listar franquicias
PUT	/franquicias/{id}	Actualizar nombre de la franquicia
DELETE	/franquicias/{id}	Eliminar  

🏬 Sucursales
Método	Endpoint	Descripción
POST	/sucursales	Crear sucursal (recibe ID de franquicia)
GET	/sucursales/franquicia/{id}	Listar sucursales de una franquicia
PUT	/sucursales/{id}	Actualizar nombre de sucursal
📦 Productos
Método	Endpoint	Descripción
POST	/productos	Crear producto en sucursal
GET	/productos/sucursal/{id}	Listar productos de sucursal
PUT	/productos/{id}	Actualizar nombre del producto
⭐ Endpoint avanzado solicitado en la prueba
✔️ Producto con mayor stock por sucursal dentro de una franquicia
GET /productos/mayor-stock/franquicia/{id}


Retorna:

Sucursal

Producto

Cantidad disponible  

🧪 Pruebas

Puedes probar todos los endpoints en Postman o Thunder Client.
Se incluye colección de ejemplo (si la agregas al repo).

🌐 Despliegue

El proyecto puede desplegarse:

En EC2 (subiendo el JAR)

En EC2 con Docker (subiendo compose e imagen)

En Elastic Beanstalk (solo JAR)

En AWS RDS o MySQL en contenedor (para base de datos)

📄 Notas importantes solicitadas por la prueba

✔ Flujo de trabajo con Git
✔ Proyecto en repositorio público
✔ Documentación clara para desplegar localmente
✔ Dockerfile incluido
✔ docker-compose incluido
✔ Endpoints extra de actualización incluidos

🙌 Autor

Proyecto desarrollado por Leo Moises Nisperuza Amaya como parte de la prueba técnica.   


