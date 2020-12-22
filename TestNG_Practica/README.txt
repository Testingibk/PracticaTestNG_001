Paso a paso por TestCase

1. TC001_TestNG
===============
Objetivo
========
Crear un proyecto en Java con TestNG dependencies
Crear el primer test con TestNG
Ejecutar el primer test

 - Creamos un proyecto nuevo solo Java y le asignamos un nombre
 - Se descargó de mvnrepository el jar de testng para incluir como libreria externa TestNG
 - El jar lo ubicamos en una carpeta para llamarlo desde IntelliJ
 - File/Project Structure/Modules/Pestaña "dependencies"
 - Hacemos click en el boton "+" para añadir el jar de TestNG (jar in directories) 
 - Buscamos el archivo, lo seleccionamos y le damos Ok
 - Hecho eso le damos check en el recuadro del jar y le damos a la opcion "compile"
 - Apply y OK
 - Entonces vamos a ver que se ha añadido en EXTERNAL LIBRARIES

PRIMER CASO DE PRUEBA
---------------------
Tener en cuenta la comparación
TestSuite --> Test Cases --> Test Steps
Package   --> Classes    --> Methods     (TestNG)
 - Creamos una clase con su respectivo nombre
 - Se debe importar automaticamente testng.annotations
 - @Test es un comando de TestNG que hace de la clase un test
 - La estructura básica para crear una prueba es:
	public class PrimerTest {
	@Test
	void nombreDelMetodo()
	{
	   Instrucciones para ejecutar el test
	}
 - Los métodos se ejecutan en orden alfabetico
 - Para priorizar los casos se usa priority=x (donde "x" es el orden de ejecución)
   Ejm: @Test(priority=1) significa que este test se va a ejecutar primero. 


2. TC002_TestNG
===============
Objetivo:
========
Crear TestNG XML
Ejecutar pruebas con el archivo XML
Crear TestNG Reports

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

CREAR TESTNG REPORTES
=====================
 - Nos ubicamos en la raiz del Proyecto (TestNG_Practica)
 - Abrimos: Run/Edit Configurations
   Dentro se observa el archivo xml y los TestCases
 - Seleccionamos el archivo XML y abrimos la pestaña LISTENERS
 - Presionamos el boton "+" y en la caja de busqueda hacemos EMAILREPORTER seleccionamos para añadirlo
   Una vez mas presionamos el boton "+" para añadir el reporte de FALLAS --> FAILEDREPORTER, seleccionamos
 - Presionamos APPLY y OK
 - Vemos en el árbol que se ha creado la carpeta test-output y dentro contiene emailable-report,html y
   el archivo tetng-failed.xml
 - Nos ubicamos dentro del archivo testng.xml y lo ejecutamos
 - Para visualizar los resultados en el Browser nos ubicamos en el archivo: emailable-report.html y damos
   click derecho/Open in Browser/y elegimos el navegadro en el que queremos ver los resultados.

Para utilizar el archivo testng-failed.xml
 - Hacemos un assert y colocamos el valor esperado diferente al valor obtenido. 
   Assert.assertEquals(1,2);  obtenido-esperado
 - Ejecutamos y vamos a ver en la consola del IDE que hay un error
 - Hacemos lo mismo que el paso anterior para visualizarlo en el Browser y se observa que ahora hay fallas.
 - Abrimos el archivo testng.xml y vemos información sobre la falla obtenida
 - Podemos ir a la clase en donde hicimos el assert y corregirlo y correr la prueba donde falló desde el 
   archivo testng-failed.xml y podemos observar que se obtiene una prueba de ejecución con éxito.
 - En este punto si volvemos a abrir el reporte en el browser desde emailable-report.html todavía vamos a observar
   que se tiene el error. Para que desaparezca el error tenemos que volver a ejecutar desde testng.xml
 - Nuevamente volvemos a abrir el archivo emailable-report vamos a ver que todas las pruebas pasaron.

 
 
