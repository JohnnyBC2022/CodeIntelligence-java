# CRUD de Entidades en archivos csv con java

Incluye:

- CRUD de Usuarios
- carpeta de department
- carpeta de group
- carpeta de role
- carpeta de permission

## Resumen del programa

Este programa está desarrollado, de momento y por falta de tiempo, en el paquete de la entidad user. El funcionamiento de este CRUD de la entidad user en el archivo csv, se puede extrapolar al resto de entidades (department, group, permission & role).
En el resto de entidades, están generadas las diferentes clases para el desarrollo del código del CRUD específico de cada entidad, pero no está implementado el código. Se ha dejado así para mostrar el entendimiento de las diferentes capas de este tipo de aplicación: controlador, servicio y repositorio, con también una carpeta model, con sus entidades Entity y Dto, para realizar el transporte de archivos desde el consumidor de la aplicación hasta el archivo csv.

## Cómo funciona

En el archivo `CSVHandler.java`, cambiar el String de la constante `path` por la ruta hasta el archivo `resources/users.csv` de tu equipo. Una vez hecho esto, se ejecuta, permitiendo la lectura de los usuarios, la creación de uno nuevo, el borrado de uno existente y la actualización de uno existente.
