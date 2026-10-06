public class Pizza {

    private Masa tipoMasa;
    private Salsa tipoSalsa;
    private Toppings toppings;

    public Pizza() {
    }

    public void añadirIng(Masa masa, Salsa salsa) {
        this.tipoMasa = masa;
        this.tipoSalsa = salsa;
    }

    public void añadirIng(Masa masa, Salsa salsa, Toppings topping) {
        this.tipoMasa = masa;
        this.tipoSalsa = salsa;
        this.toppings = topping;
    }
}