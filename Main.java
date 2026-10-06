public class Main {

    public static void main(String[] args) {

        // Crear una pizza
        Pizza pizza = new Pizza();

        // Agregar ingredientes
        pizza.añadirIng(
            Masa.NORMAL,
            Salsa.NORMAL,
            Toppings.PEPPERONI
        );

        // Crear una orden
        Orden orden = new Orden();

        // Obtener número de orden
        int numero = orden.numeroOrden(pizza);

        System.out.println("Orden creada");
        System.out.println("Número de orden: " + numero);

        // Crear cocina
        Cocina cocina = new Cocina();

        // Entregar la orden
        boolean entregada = cocina.entregarOrden(orden);

        System.out.println("Orden entregada: " + entregada);
    }
}