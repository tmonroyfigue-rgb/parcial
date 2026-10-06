public class Orden {

    private EstadoPizza estadoPizza;

    public Orden() {
        this.estadoPizza = EstadoPizza.PENDIENTE;
    }

    public EstadoPizza colocarEstadoPizza(EstadoPizza estadoPizza) {
        this.estadoPizza = estadoPizza;
        return this.estadoPizza;
    }

    public int numeroOrden(Pizza pizza) {
        return pizza.hashCode();
    }
}