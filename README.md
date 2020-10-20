# peruJconf

Para ejecutar la Aplicación:
#Requerimientos:
1. node 10 o superiror.
2. maven
3. jdk 1.8 o superior.
4. Intenert para conectarse a la Base de Datos On-line Mysql.



## Running the Application
There are two ways to run the application:  
 1. Abra la carpeta del proyecto en VSCode.
 2. Ejecute "mvn install" en la linea de conmandos.
 3. Instale los compomentes adicionales : npm install --save @polymer/paper-toggle-button  y npm install --save @polymer/paper-toggle-button
 4. Ejecute "mvn spring-boot:run" y abra el browser en "localhost:8585"
 



## Project structure

- `MainView.java` in `src/main/java` contains the navigation setup. It uses [App Layout](https://vaadin.com/components/vaadin-app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/src/` contains the client-side JavaScript views of your application.

