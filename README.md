    # Práctica 1: Gestor de gastos de un estudiante

## Integrantes
* Estudiante A: Alejandro Spindola Bazaldua
* Estudiante B: Leonardo Montellano Martinez

## Responsabilidades de cada integrante
* **Alejandro (rama `registro-gastos`):** Se encargó de hacer el registro de los gastos, validar que los datos fueran correctos y mostrar la lista de los gastos.
* **Leonardo (rama `analisis-gastos`):** Se encargó de hacer las operaciones matemáticas (sumas, promedios), buscar el gasto mayor, armar el resumen de la semana y organizar el menú interactivo.

## Instrucciones para ejecutar el programa
1. Descargar o clonar este repositorio en tu computadora.
2. Abrir la carpeta en IntelliJ IDEA.
3. Abrir el archivo `Main.java` que está en la carpeta `src`.
4. Dar clic en el botón de "Play" (Run) y seguir las instrucciones del menú en la consola.

## Métodos implementados
* `mostrarMenu`: Muestra las opciones del 1 al 7.
* `registrarGasto`: Pide el nombre, categoría y cantidad de dinero del gasto.
* `mostrarGastos`: Imprime todos los gastos guardados.
* `calcularTotal`: Suma todo el dinero gastado.
* `obtenerPosicionGastoMayor`: Busca cuál fue el gasto más caro.
* `mostrarGastoMayor`: Muestra en pantalla el gasto más caro.
* `calcularTotalPorCategoria`: Suma los gastos de una sola categoría.
* `consultarGastosPorCategoria`: Pregunta una categoría y muestra su total.
* `mostrarResumen`: Muestra cuántos gastos hubo, el total, el promedio y el mayor.

## Conflicto encontrado y forma de resolverlo
**¿Qué pasó?** En la Fase 8, los dos modificamos al mismo tiempo la línea de código donde va el título del programa, cada quien en su propia rama. Al juntar las ramas en `main`, Git marcó un error (conflicto) porque no sabía qué título dejar.
**¿Cómo lo resolvimos?** Abrimos el archivo `Main.java`, borramos las marcas raras que dejó Git y escribimos a mano un solo título definitivo: "SISTEMA PERSONAL DE CONTROL DE GASTOS". Después, guardamos los cambios con un nuevo commit.

---

## Evidencia y Conclusión individual

### Respuestas de Alejandro Spindola Bazaldua
* **¿Qué diferencia encontró entre commit y push?** El commit es para comentarios relacionados con el codgigo y sus cambios, y el push es para mandar el codigo actualizado a la nube(github).
* **¿Por qué debe hacerse pull antes de modificar archivos?** Para que tanto tu como los colaboradores puedan accerder al codigo main antes de hacer cambios y de forma local puedan modificar cada quien el codigo si afectar al main. 
* **¿Para qué sirve trabajar en ramas?** Para que cada colaborador pueda modificar partes diferentes del codigo para al final poder unirlas al main, sin necesidad de hacer todo el codigo completos, se puede hacer por partes y unir ambas al main.
* **¿Qué ocasionó el conflicto?** Un cambio de nombre en la misma linea, ambos cambiamos ese nombre y por lo tanto esa linea se intento cambiar a la vez .
* **¿Cómo decidió qué código conservar?** se conservo como System.out.println("\nSISTEMA PERSONAL DE CONTROL DE GASTOS"); en base a lo que se acordo con el compañero de equipo.
* **¿Qué aportó personalmente al programa?** Hice la parte del estudiante A, no realice correcciones a mi compañero y finalice el codigo debido a que mi compañero por temas tecnicos no pude seguir aponyandome.

### Respuestas de Leonardo Montellano Martinez
* **¿Qué diferencia encontró entre commit y push?** Commit es para ir haciendo pequeños cambios y documentarlos conforme se van haciendo mientras que el push se utiliza para cuando ya esta verificado que funciona y pasarlo para que el resto del equipo de trabajo pueda analizarlo y aprobarlo.
* **¿Por qué debe hacerse pull antes de modificar archivos?** Porque el pull actualiza nuestro codigo local para que se sincronice con el projecto en la nube.
* **¿Para qué sirve trabajar en ramas?** Para poder hacer modificaciones en ciertas areas del probecto sin afectar a otras que ya funcionen.
* **¿Qué ocasionó el conflicto?** Que hubo discordancia con una parte del codigo que era compartida en ambos lados.
* **¿Cómo decidió qué código conservar?** Se llego a un acuerdo de como se deberia de quedar, y se quedo como SISTEMA PERSONAL DE CONTROL DE GASTOS.
* **¿Qué aportó personalmente al programa?** Aporte parte de los metodos para la logistica de los datos a la hora de querer revisarlos, asi como la parte de el estudiante b que me correspondia.