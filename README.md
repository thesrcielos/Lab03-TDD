# Informe de Laboratorio 3 - TDD
## Integrantes:
* [Diego Macia](https://github.com/thesrcielos)
* [Miguel Motta](https://github.com/MIGUEL-MOTTA-U)

## DESCRIPCIÓN DEL PROYECTO

### Crear el proyecto
Comando ejecutado para crear el proyecto con las especificaciones dadas:

> ```
> mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
> ```
> ![image](./asset/maven-project-creation.png)

### Agregar dependencia JUnit5
Editando el archivo `pom.xml` con las siguientes lineas, podemos agregar las dependencias de JUnit 5 a nuestro proyecto:
> ```
> <dependencies>
>    <dependency>
>    <groupId>org.junit.jupiter</groupId>
>      <artifactId>junit-jupiter-api</artifactId>
>      <version>5.11.0</version>
>      <scope>test</scope>
>    </dependency>
>  </dependencies>
> ```
> ![image](./asset/pom-JUnit5-dependences.png)
### Agregar esqueleto del proyecto
Desde editor `InteliJ`:

![image](./asset/project-structure.png)

Desde la consola de comandos:

> `tree`

![image](./asset/tree-project-structure.png)

### Agregar clases
Comprobación de clases en el proyecto ejecutando `mvn package`:

![image](./asset/mvn-package.png)

## PRUEBAS UNITARIAS Y TDD
### Crear Clase de Prueba
Se creo la clase `LibraryTest` y a partir de ahí se hizo el desarrollo de los métodos y pruebas de `addBook, loanBook y returnLoan`.
#### Método addBook
Se hizo el primero commmit para crear la prueba antes que la implementación (debe fallar) [commit.](https://github.com/thesrcielos/Lab03-TDD/commit/1653f876bf8cdb5f31608b786cc7f1693b194f71)

>```
> public void addBookTest(){
>        Book book = new Book("example title","pepe","1717263847194");
>        Library library = new Library();
>        assertTrue(library.addBook(book));
>    }
>```
![image](./asset/test-addBook-failed.png)

Luego se implementa el método [addBook()](https://github.com/thesrcielos/Lab03-TDD/commit/b07206a2619a9114e205046cc8f1b60ad98d8a96):

![image](./asset/test-addBook-passed.png)

#### Método loanBook
Se hizo el primero commmit para crear la prueba antes que la implementación (debe fallar) [commit.](https://github.com/thesrcielos/Lab03-TDD/commit/0a8c3c8a4ec56426c56ba535c6b748cc294afa4c)

>```
>    @Test
>    public void loanABookTest(){
>        String userId = "1";
>        String isbn = "1717263847194";
>        Library library = createExampleLibrary(userId, isbn);
>        assertNotNull(library.loanABook(userId,isbn));
>    }
>```
![image](./asset/pruebaLoanBookFalla.png)

Luego se implementa el método haciendo la primera `pull request` de [loanBook](https://github.com/thesrcielos/Lab03-TDD/commit/4ea5e6601980f0404c8307a40b721bd75ae4ae2f):

![image](./asset/pruebaLoanABookPasa.png)

#### Método returnLoan
Se crea la prueba de [`returnLoan`](https://github.com/thesrcielos/Lab03-TDD/commit/479ec866ad49f14526a5c34e080551aba9b0f95d) fallida:
>```
>    @Test
>    public void returnLoanTest(){
>        String userId = "1";
>        String isbn = "1717263847194";
>        Library library = createExampleLibrary(userId,isbn);
>        Loan loan = addLoanToLibrary(library);
>        assertNotNull(library.returnLoan(loan));
>    }
>```

![image](./asset/pruebaLoanBookFalla.png)

Luego se implementa el método [`returnLoan`](https://github.com/thesrcielos/Lab03-TDD/commit/e87328c453309d895866942f0a1b521748202c13):
![image](./asset/pruebaLoanABookPasa.png)

### Cobertura

### SonarQube

