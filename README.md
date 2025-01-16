Audit Banking Operations API
Descripción
Este proyecto implementa una API para auditar operaciones bancarias. Permite registrar y consultar transacciones bancarias de tipo DEPOSIT y WITHDRAWAL. La aplicación está construida con Spring Boot y utiliza MongoDB como base de datos.

La API proporciona dos operaciones principales:

POST /api/audit/save: Para guardar transacciones.
GET /api/audit/transaction: Para obtener las transacciones de un cliente por su ID.
Características
Persistencia de datos: Utiliza MongoDB para almacenar transacciones bancarias.
Operaciones en tiempo real: Implementación con soporte para consultas en tiempo real usando Flux (Stream).
Generación automática de fechas: La fecha de la transacción se genera automáticamente en el servidor al momento de crear la transacción.
Tecnologías Utilizadas
Spring Boot: Framework principal para el desarrollo de la API.
MongoDB: Base de datos NoSQL para almacenar las transacciones.
Spring WebFlux: Soporte para programación reactiva, permitiendo un manejo eficiente de las peticiones.
Swagger: Documentación interactiva de la API.
Endpoints
1. POST /api/audit/save
Este endpoint permite guardar una transacción bancaria. La fecha de la transacción se genera automáticamente en el servidor.

Solicitud
json
Copiar
{
  "customerId": 12345,
  "transactionType": "DEPOSIT",
  "initialBalance": 1000.00,
  "amount": 200.00,
  "withdrawalType": "ATM"
}
customerId: ID del cliente que realiza la transacción.
transactionType: Tipo de transacción (DEPOSIT o WITHDRAWAL).
initialBalance: Balance inicial antes de la transacción.
amount: Monto de la transacción.
withdrawalType: Tipo de retiro (si aplica). Valores posibles: ATM, COUNTER, ONLINE.
Respuesta
Si la transacción se guarda correctamente, la respuesta será:

json
Copiar
{
  "transactionType": "DEPOSIT",
  "initialBalance": 1000.00,
  "finalBalance": 1200.00,
  "amount": 200.00,
  "localDateTime": "2025-01-16T12:00:00",
  "withdrawalType": null
}
transactionType: Tipo de transacción.
initialBalance: Balance inicial antes de la transacción.
finalBalance: Balance final después de la transacción.
amount: Monto de la transacción.
localDateTime: Fecha y hora de la transacción, generada automáticamente.
withdrawalType: Tipo de retiro (si aplica).
2. GET /api/audit/transaction
Este endpoint permite obtener las transacciones de un cliente según su customerId. Las transacciones se devuelven en tiempo real como un flujo (Flux).

Parámetros de consulta
id: ID del cliente para filtrar las transacciones.
Respuesta
json
Copiar
[
  {
    "transactionType": "DEPOSIT",
    "initialBalance": 1000.00,
    "finalBalance": 1200.00,
    "amount": 200.00,
    "localDateTime": "2025-01-16T12:00:00",
    "withdrawalType": null
  }
]
Estructura del Proyecto
css
Copiar
src/
├── main/
│   ├── java/
│   │   ├── bank/
│   │   │   ├── AuditBankingOperations/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── enums/
│   │   │   │   ├── mapper/
│   │   │   │   ├── model/
│   │   │   │   ├── repository/
│   │   │   │   ├── service/
│   │   │   │   └── config/
└── resources/
    ├── application.properties
    └── openapi.yaml
controller/: Contiene los controladores de la API.
dto/: Contiene los objetos de transferencia de datos (DTO).
enums/: Enumera los posibles tipos de transacciones y tipos de retiro.
mapper/: Contiene las clases para mapear entre DTO y entidades.
model/: Modelos de datos (entidades) utilizados por la base de datos.
repository/: Repositorios para interactuar con la base de datos MongoDB.
service/: Lógica de negocio para procesar las transacciones.
config/: Configuraciones de la API, como Swagger.
Documentación con Swagger
La API está documentada usando Swagger. Para acceder a la documentación interactiva, simplemente levanta el servidor y visita http://localhost:8080/swagger-ui.html.

Requisitos
JDK 11 o superior.
MongoDB (local o remoto).
Maven o Gradle para la construcción del proyecto.
