public class Cocina {

    private Orden[] maxOrden;
    private Pizza pizza;

    public Cocina() {
        maxOrden = new Orden[5];
        pizza = new Pizza();
    }

    public boolean validarMaximo(Orden[] maxOrden, int numOrden) {
        return numOrden < maxOrden.length;
    }

    public boolean entregarOrden(Orden orden) {

        if (orden == null) {
            return false;
        }

        orden.colocarEstadoPizza(EstadoPizza.LISTA);
        return true;
    }
}