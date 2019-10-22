# Ejemplo Spring Batch

Ejemplo práctico del uso de la herramienta Spring Batch.
El proceso es:
- Leer un archivo CSV
- Creacion de una tabla en memoria
- Lectura de los registros en el CSV e importacion a la tabla según las columnas
- Insercion de los regisros en la tabla


## Nota: 
- En el proceso, cada fila debe ser convertida a mayúsculas.

### Tecnologías usadas:
- SpringBoot
- SpringBatch
- Lombok
- Java 8
- HSQLDB (dase de datos en memoria)