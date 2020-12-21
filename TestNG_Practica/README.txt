Paso a paso por TestCase

1. TC001_TestNG
===============
 - Se descargó de mvnrepository el jar de testng para incluir como libreria externa TestNG


 - @Test es un comando de TestNG que hace de la clase un test
 - para priorizar los casos se usa priority=x (donde "x" es el orden de ejecución)
 - 

 
 - 


2. TC002_TestNG
 - Debemos descargar de File\Settings\plugins --> Create testNG xml (Instalar) y reiniciar el IDE
 - Nos ubicamos en la raiz del proyecto (ejm. TestNG_Practica) - Click derecho\Create TestNG XML - OK
 - Se visualiza en el árbol de archivos que se ha creado un archivo con nombre: "testng.xml"
 - Abrimos el archivo testng.xml y se visualiza sin formato
 - Para darle formato se hace: Code\Reformat Code -- y veremos que se formatea el codigo
 - Borramos <classes/> para colocar en su lugar los TestCase que vamos a ejecutar
 - Se crea el tag <classes>  </classes>
 - Y dentro --> <class name="Nombre de la clase que contiene el TestCase"/>
 - <class name="TC001_TestNG"/>

 - Se pueden agregar mas clases que contienen otros TestCases en el archivo testng.xml

 - En el segundo test podemos configurar otro flujo diferente al primero y con otras prioridades
 - Agregamos este segundo caso al archivo xml
 - <class name="TC002_TestNG"/>

 - Para ejecutar este archivo podemos hacer click derecho dentro de la ventana de testng.xml y buscar
   Run..../testng.xml
 - o ubicar en el árbol de archivos y ubicarnos en el archivo testng.xml y ejecutar Run/.../testng.xml

TESTNG REPORTS
==============

