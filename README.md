El proyecto fue creado con Springboot mediante el asistente de Intellij IDEA (initializer).
El manejo de dependencias se gestiona mediante gradle, importando de antemano dependencias básicas para la creación del proyecto (en el asistente)
Las dependencias posteriores están comentadas en el archivo build.gradle

El código está hecho en base a alineamientos de buenas prácticas definido por herramientas como SonarCube. Es por ello que se hace uso estricto de llaves para métodos y condiciones aún cuando no sean estrictamente necesarias (una sola línea de código por ejemplo)

El proyecto por defecto utiliza servidor tomcat (springboot) y levanta el puerto 8080 de la máquina local. A partir de allí, se expone el requestMapping para el proyecto REST y para los preblemas matemáticos:

http://localhost:8080/digitali/colaboradores

http://localhost:8080/digitali/problemas

Se exponen 8 endpoints en total:

1- Ingresar Colaborador (con RequestBody)
---------------------------------------------------------------------------

POST -> http://localhost:8080/digitali/colaboradores
Request body de ejemplo (Json):

{
    "rut": "177998893",
    "primerNombre": "Fernando",
    "segundoNombre": "Andrés",
    "apellidoPaterno": "Torres",
    "apellidoMaterno": "Acuña",
    "fechaNacimiento": "1991-05-13",
    "direccion": "Los Clarines 3139"
}

2- Obtener Colaborador por RUT (con RequestParam)
---------------------------------------------------------------------------

GET -> http://localhost:8080/digitali/colaboradores?rut=177998893

3- Actualizar dirección de colaborador (con PathVariable y Body)
---------------------------------------------------------------------------

UPDATE -> http://localhost:8080/digitali/colaboradores/177998893
Request body de ejemplo (Json):
{
    "direccion": "Los Clarines 3139"
}

4- Eliminar colaborador (con PathVariable)
---------------------------------------------------------------------------

DELETE -> http://localhost:8080/digitali/colaboradores/177998893

5- Obtener solo fecha de nacimiento de colaborador (con RequestParam)
---------------------------------------------------------------------------

GET -> http://localhost:8080/digitali/colaboradores/getFechaNacimiento?rut=177998893

6- Obtener todo (no se pidió, pero es útil)
---------------------------------------------------------------------------

GET -> http://localhost:8080/digitali/colaboradores/getAll

7- Problema matemático 1, múltiples de 3 o 5 (con RequestParam)
---------------------------------------------------------------------------

GET -> http://localhost:8080/digitali/problemas/getMultiplos?value=1000

8- Problema matemático 2, mayor factor primo (con RequestParam)
---------------------------------------------------------------------------

GET -> http://localhost:8080/digitali/problemas/getFactorPrimo?value=13195

BASE DE DATOS
---------------------------------------------------------------------------

Se utilizó una base de datos PostgreSQL con asistente pgAdmin. Se creó un servidor "Digitali" con base de datos "postgres" y un nuevo esquema para el ejercicio:

CREATE SCHEMA IF NOT EXISTS digitali
    AUTHORIZATION postgres;

Posteriormente, la tabla se creó con la siguiente query:

CREATE TABLE IF NOT EXISTS digitali.colaborador
(
    id SERIAL PRIMARY KEY,
    rut text COLLATE pg_catalog."default" NOT NULL,
    primer_nombre text COLLATE pg_catalog."default" NOT NULL,
    segundo_nombre text COLLATE pg_catalog."default",
    apellido_paterno text COLLATE pg_catalog."default" NOT NULL,
    apellido_materno text COLLATE pg_catalog."default",
    fecha_nacimiento date NOT NULL,
    direccion text COLLATE pg_catalog."default" NOT NULL
);



La conexión a la base de datos está definida en el application.properties del aplicativo.
