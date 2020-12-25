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

 3. TC003_TestNG
===============
Objetivo:
========
Uso de TestNG Annotations
Podemos controlar la secuencia y prioridad de los metodos que Java permite ejecutar "Antes" y "Despues" en un punto
Se utlizan el simbolo "@"

Secuencia de ejecución de las ANOTACIONES
@BeforeSuite			@AfterSuite
  @BeforeTest		      @AfterTest
    @BeforeClass            @AfterClass
      @BeforeMethod       @AfterMethod
                    @Test

 - Vamos a crear Test para esta funcionalidad
 - En la carpeta "src" crear nuevas clases para los test (Prueba01, etc.)
 - Dentro de la clase Prueba01 vamos creando los métodos y las anotaciones @Test
 - Ejecutamos para ver que se ejecutan con éxito
 - Ahora sobre lo creado creamos un @BeforeMethod

    @BeforeMethod
    void beforeMethod()
    {System.out.print("This will execute before every method");}

   @Test
    void test1()
    {System.out.print("This is test1...");}

    @Test
    void test2()
    {System.out.print("This is test2");}

 - Entonces lo que se tiene es que BeforeMethod se va a ejecutar antes de cada método

Resultado:
This will execute before every method
This is test1...

This will execute before every method
This is test2

 - Ahora agregamos @afterMethod
    @BeforeMethod
    void beforeMethod()
    {System.out.print("This will execute before every method");}

    @AfterMethod
    void afterMethod()
    {System.out.println("This will execute after every method");}

    @Test
    void test1()
    {System.out.print("This is test1...");}

    @Test
    void test2()
    {System.out.print("This is test2");}

RESULTADO
This will execute before every method
This is test1...
This will execute after every method

This will execute before every method
This is test2
This will execute after every method

 - Ahora agregamos @beforeClass() y  AfterClass()
    @BeforeClass
    void beforeClass()
    {System.out.println("This will execute before the class");}

    @AfterClass
    void afterClass()
    {System.out.println("This will execute after the class");}

    @BeforeMethod
    void beforeMethod()
    {System.out.print("This will execute before every method");}

    @AfterMethod
    void afterMethod()
    {System.out.println("This will execute after every method");}

    @Test
    void test1()
    {System.out.print("This is test1...");}

    @Test
    void test2()
    {System.out.print("This is test2");}

RESULTADO
This will execute before the class

This will execute before every method
This is test1...
This will execute after every method

This will execute before every method
This is test2
This will execute after every method

This will execute after the class

 - Ahora agregamos @BeforeTest y @AfterTest
 - Creamos otra clase Prueba02 que incluya los test3 y test4
 - Para hacer esto creamos otro archivo XML
 - Seleccionamos las clases Prueba01 y Prueba02 y hacemos click derecho
 - Click sobre Create testNG XML
 - Luego Code/Reformat Code y dejar solo el tag <suite></suite>

 - Creamos lo siguiente en el orden siguiente:
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="All Test Suite">
    <test name="annotationdemo">
        <classes>
            <class name="Prueba01">
                <methods>
                    <include name="test1"/>
                    <include name="test2"/>
                </methods>
            </class>
            <class name="Prueba02">
                <methods>
                    <include name="test3"/>
                    <include name="test4"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>

 - Ejecutamos desde el archivo testng.xml

RESULTADO
This will execute before the class

This will execute before every method
This is test1...
This will execute after every method

This will execute before every method
This is test2
This will execute after every method

This will execute after the class
_____________________________________________

This will execute before the class

This will execute before every method
This is test3...
This will execute after every method

This will execute before every method
This is test4
This will execute after every method

This will execute after the class

 - Agregamos @BeforeTest y AfterTest
    @BeforeClass
    void beforeClass()
    {System.out.println("This will execute before the class");}

    @AfterClass
    void afterClass()
    {System.out.println("This will execute after the class");}

    @BeforeMethod
    void beforeMethod()
    {System.out.print("This will execute before every method");}

    @AfterMethod
    void afterMethod()
    {System.out.println("This will execute after every method");}

    @Test
    void test1()
    {System.out.print("This is test1...");}

    @Test
    void test2()
    {System.out.print("This is test2");}

    @BeforeTest
    void beforeTest()
    {System.out.println("This will execute before the test");}
    @AfterTest
    void afterTest()
    {System.out.println("This will execute after the test");}

RESULTADO
This will execute before the test	<<<==============

This will execute before the class

This will execute before every method
This is test1...
This will execute after every method

This will execute before every method
This is test2
This will execute after every method


This will execute after the class

=========================================

This will execute before the class

This will execute before every method
This is test3...
This will execute after every method

This will execute before every method
This is test4
This will execute after every method

This will execute after the class


This will execute after the test	<<<==============

 - Agregamos @BeforeSuite y AfterSuite en la clase Prueba02

    @BeforeClass
    void beforeClass()
    {System.out.println("This will execute before the class");}

    @AfterClass
    void afterClass()
    {System.out.println("This will execute after the class");}

    @BeforeMethod
    void beforeMethod()
    {System.out.print("This will execute before every method");}

    @AfterMethod
    void afterMethod()
    {System.out.println("This will execute after every method");}

    @Test
    void test3()
    {System.out.print("This is test3...");}

    @Test
    void test4()
    {System.out.print("This is test4");}

    @BeforeSuite
    void beforeSuite()
    {System.out.println("This will execute before every suite");}
    @AfterSuite
    void afterSuite()
    {System.out.println("This will execute after every suite");}

RESULTADO
This will execute before every suite	<<<<<<<<<<

This will execute before the test

This will execute before the class

This will execute before every method
This is test1...
This will execute after every method

This will execute before every method
This is test2
This will execute after every method


This will execute after the class

=========================================

This will execute before the class


This will execute before every method
This is test3...
This will execute after every method

This will execute before every method
This is test4
This will execute after every method

This will execute after the class


This will execute after the test


This will execute after every suite	<<<<<<<<<<




4. TC004_TestNG
===============
Objetivo
Priorización de Tests
Disabling tests

 - Creamos una nueva clase a la que llamaremos TC004_TestNG
 - Dentro creamos 4 métodos y lo ejecutamos y veremos que se ejecutan en este orden
	This es Test_04
	This is Test_01
	This is Test_03
	This is Test_02
 - Se ejecutaron en orden alfabetico
 - Si queremos evitar esto debemos priorizar el orden de ejecución de cada método
 	    @Test(priority = 0)
    		void TestOne() {
        	System.out.println("This is Test_01");
 - Ejecutamos
	This is Test_01
	This is Test_02
	This is Test_03
	This is Test_04

 - Si queremos enabled una de los metodos hacemos lo siguiente:
 -     @Test(priority = 3,enabled = false)
    	void TestFour() {
        System.out.println("This is Test_04");
 - Vemos que al agregar el parametro enabled=false (no aparece el icono verde en la barra izquierda)
 - Ejecutamos la clase con COVERAGE
 - Podemos ver que el metodo 4 no se ha ejecutado

5. TC005_TestNG
===============
Objetivo
========
Dependency Tests in TestNG
AlwaysRun property

 - Creamos la clase TC005_TestNG
 - Creamos los métodos: startCar, driveCar, stopCar, parkCar
 - En la ejecución vemos que para conducir primero tenemos que arrancar el carro, también si quieres
   detener el carro se tiene que conducir o avanzar el carro.
 - Para agregar que una clase dependa de otra agregamos el parametro >>> dependsOnMethods = {"nombreDelMetodo} <<<
 - El código queda asi:
    @Test
    void startCar()
    {System.out.print("Car started");}

    @Test(dependsOnMethods = {"startCar"})
    void driveCar()
    {System.out.print("Car driving");}

    @Test(dependsOnMethods = {"driveCar"})
    void stopCar()
    {System.out.print("Car stopped");}

    @Test(dependsOnMethods = {"driveCar", "stopCar"})
    void parkCar()
    {System.out.print("Car parked");}

RESULTADO:
Car started
Car driving
Car stopped
Car parked

 - Agregamos un Assert.fail para el método con el que inicia la clase
 - Como se tiene una dependencia en cascada fallaría el resto
    @Test
    void startCar()
    {System.out.print("Car started");
        Assert.fail();}

RESULTADO
Car started
java.lang.AssertionError: null
Test ignored.
Test ignored.
Test ignored.

 - Se verifica que falla el resto

 - Pero si queremos que de todas maneras se ejecute el ultimo test entonces usamos
   >>> alwaysRun = true <<<

	 @Test(dependsOnMethods = {"driveCar", "stopCar"}, alwaysRun = true)
    	 void parkCar()

EJECUTAMOS
 Car started
 java.lang.AssertionError: null
 Test ignored.
 Test ignored.
 Car parked

 - Se verifica que aunque falló el primer caso, con alwaysRun se ejecute aunque falle la dependencia.







