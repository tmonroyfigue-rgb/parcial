import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== PIZZA CHEF =====");



        System.out.println("\nSeleccione el tipo de masa:");
        System.out.println("1. INGLESA");
        System.out.println("2. NORMAL");
        System.out.print("Opcion: ");

        int opcionMasa = scanner.nextInt();

        Masa masa;

        if (opcionMasa == 1) {
            masa = Masa.INGLESA;
        } else {
            masa = Masa.NORMAL;
        }




        System.out.println("\nSeleccione el tipo de salsa:");
        System.out.println("1. NORMAL");
        System.out.println("2. PICANTE");
        System.out.print("Opcion: ");

        int opcionSalsa = scanner.nextInt();

        Salsa salsa;

        if (opcionSalsa == 1) {
            salsa = Salsa.NORMAL;
        } else {
            salsa = Salsa.PICANTE;
        }




        System.out.println("\nDesea agregar topping?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Opcion: ");

        int deseaTopping = scanner.nextInt();



        Pizza pizza = new Pizza();


        if (deseaTopping == 1) {

            System.out.println("\nSeleccione un topping:");
            System.out.println("1. JAMON");
            System.out.println("2. PEPPERONI");
            System.out.println("3. CHILE_PIMIENTO");
            System.out.print("Opcion: ");

            int opcionTopping = scanner.nextInt();

            Toppings topping;

            if (opcionTopping == 1) {

                topping = Toppings.JAMON;

            } else if (opcionTopping == 2) {

                topping = Toppings.PEPPERONI;

            } else {

                topping = Toppings.CHILE_PIMIENTO;
            }


            pizza.añadirIng(masa, salsa, topping);

        } else {

            pizza.añadirIng(masa, salsa);
        }




        Orden orden = new Orden();

        int numeroOrden = orden.numeroOrden(pizza);



        Cocina cocina = new Cocina();


        System.out.println("ORDEN CREADA");

        System.out.println("Numero de orden: " + numeroOrden);

        System.out.println("\nLa pizza fue creada correctamente.");


        System.out.println("\nSeleccione el estado de la pizza:");
        System.out.println("1. PENDIENTE");
        System.out.println("2. EN_PROCESO");
        System.out.println("3. LISTA");
        System.out.print("Opcion: ");

        int opcionEstado = scanner.nextInt();

        EstadoPizza estado;

        if (opcionEstado == 1) {

            estado = EstadoPizza.PENDIENTE;

        } else if (opcionEstado == 2) {

            estado = EstadoPizza.EN_PROCESO;

        } else {

            estado = EstadoPizza.LISTA;
        }


        orden.colocarEstadoPizza(estado);


        System.out.println("\nDesea entregar la orden?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Opcion: ");

        int entregar = scanner.nextInt();


        if (entregar == 1) {

            boolean resultado =
                    cocina.entregarOrden(orden);

            if (resultado) {
                System.out.println("\nOrden entregada correctamente.");
            } else {
                System.out.println("\nNo se pudo entregar la orden.");
            }

        } else {

            System.out.println("\nLa orden no fue entregada.");
        }


        System.out.println("\n===== FIN =====");

        scanner.close();
    }
}