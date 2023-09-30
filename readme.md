Despliegue de Prueba Técnica en WildFly

1. Descargar el repositorio.
2. Compilar el Codigo usando maven preferiblemente versión 3.9. Ejecutando el comando mvn clean package.
3. Tomar el archivo .war. Este archivo se generará en la carpeta target y su nombre será tech-test-0.0.1.war.
4. Cargarlo a WildFly. El despliegue no deberia tener inconvenientes ya que previamente se ha validado.
5. La ruta dentro del server es {URL_WILDFLY_SERVER}:8080/app-demo.
