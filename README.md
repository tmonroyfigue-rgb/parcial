Daniel Antonio Monroy Figueroa  
26442

# Correcciones realizadas del UML al código

Al momento de pasar mi UML a Java tuve que hacer algunos cambios para que el programa funcionara correctamente.

## 1. Arreglo de órdenes

En mi UML puse `MaxOrden[5] : Orden` para representar que la cocina podía tener un máximo de 5 órdenes.

Al pasarlo a Java tuve que escribirlo de esta manera:

`Orden[] maxOrden`

También tuve que indicar que el arreglo tendría espacio para 5 órdenes:

`maxOrden = new Orden[5];`

---

## 2. Tipo del Array

En mi UML puse `Array MaxOrden` dentro del método `ValidarMaximo`, pero en Java tenía que indicar qué tipo de datos iba a guardar ese arreglo.

Como el arreglo guarda órdenes, lo cambié a:

`Orden[] maxOrden`

Entonces el método quedó recibiendo el arreglo de órdenes y el número de orden.

---

## 3. Inicialización del arreglo

En el UML indiqué que existía un arreglo con un máximo de 5 órdenes, pero no indiqué en qué momento se creaba.

Por eso, en el constructor de `Cocina` tuve que crear el arreglo de 5 espacios:

`maxOrden = new Orden[5];`

De esta forma, cuando se crea una cocina, también se crea el espacio necesario para guardar las 5 órdenes.

---

## 4. Método AñadirIng

En mi UML puse dos métodos `AñadirIng`. Uno recibe solamente la masa y la salsa, mientras que el otro también recibe un topping.

En Java pude mantener los dos métodos porque reciben diferentes cantidades de datos:

`añadirIng(Masa masa, Salsa salsa)`

`añadirIng(Masa masa, Salsa salsa, Toppings topping)`

De esta forma puedo agregar los ingredientes de una pizza con o sin topping.

---

## 5. Estado inicial de la orden

En mi UML puse que una orden tenía un `EstadoPizza`, pero no indiqué con qué estado debía comenzar.

Para que una orden nueva no se quedara sin estado, decidí que todas las órdenes comiencen como:

`EstadoPizza.PENDIENTE`

Después este estado se puede cambiar cuando la pizza pase a otro estado.

---

## 6. Número de orden

En mi UML puse el método:

`NumeroOrden(Pizza pizza) : int`

El problema fue que solamente indiqué que debía devolver un número, pero no indiqué cómo se iba a generar ese número.

Por eso, al pasarlo a Java tuve que agregar la lógica necesaria para que el método pudiera devolver un número de orden.

---

## 7. Máximo de 5 órdenes

En mi UML indiqué que `MaxOrden` tendría un máximo de 5 órdenes.

Al programarlo tuve que agregar una validación para comprobar que no se intentaran guardar más órdenes de las que caben en el arreglo.

El arreglo tiene 5 espacios:

`new Orden[5]`

El método `ValidarMaximo` se encarga de revisar este límite.

---

## 8. Creación del Main

En mi UML no agregué una clase `Main`, ya que solamente tenía las clases necesarias para la lógica del programa.

Al probar el programa me di cuenta de que necesitaba una forma de ingresar los datos de la pizza y de la orden.

Por eso agregué un `Main` y utilicé `Scanner`, que me permite ingresar datos desde la consola.

Desde el `Main` puedo seleccionar la masa, la salsa, el topping, el estado de la pizza y las demás opciones necesarias.

El `Main` solamente se utiliza para interactuar con el programa y no cambia la estructura de las clases que hice en el UML.