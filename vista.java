import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class vista {

    private static Pizza pizza = new Pizza();
    private static Masa masaSeleccionada;
    private static Salsa salsaSeleccionada;
    private static Toppings toppingSeleccionado;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana());
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Haz una orden de tu pizza favorita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 430);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("ARMA TU PIZZA");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel resultado = new JLabel("Selecciona la masa, la salsa y el topping");
        resultado.setAlignmentX(Component.CENTER_ALIGNMENT);

        // -------------------- MASA --------------------
        JLabel etiquetaMasa = new JLabel("Elige el tipo de masa:");
        etiquetaMasa.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelMasas = new JPanel(new FlowLayout());
        JButton inglesa = new JButton("Inglesa");
        JButton normal = new JButton("Normal");

        panelMasas.add(inglesa);
        panelMasas.add(normal);

        inglesa.addActionListener(e -> {
            masaSeleccionada = Masa.INGLESA;
            actualizarPizza();
            mostrarSeleccion(resultado);
        });

        normal.addActionListener(e -> {
            masaSeleccionada = Masa.NORMAL;
            actualizarPizza();
            mostrarSeleccion(resultado);
        });

        // -------------------- SALSA --------------------
        JLabel etiquetaSalsa = new JLabel("Elige el tipo de salsa:");
        etiquetaSalsa.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelSalsas = new JPanel(new FlowLayout());
        JButton salsaNormal = new JButton("Normal");
        JButton salsaPicante = new JButton("Picante");

        panelSalsas.add(salsaNormal);
        panelSalsas.add(salsaPicante);

        salsaNormal.addActionListener(e -> {
            salsaSeleccionada = Salsa.NORMAL;
            actualizarPizza();
            mostrarSeleccion(resultado);
        });

        salsaPicante.addActionListener(e -> {
            salsaSeleccionada = Salsa.PICANTE;
            actualizarPizza();
            mostrarSeleccion(resultado);
        });

        // -------------------- TOPPING --------------------
        JLabel etiquetaTopping = new JLabel("Elige el topping de la pizza:");
        etiquetaTopping.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelToppings = new JPanel(new FlowLayout());
        JButton jamon = new JButton("Jamón");
        JButton pepperoni = new JButton("Pepperoni");
        JButton chilePimiento = new JButton("Chile pimiento");

        panelToppings.add(jamon);
        panelToppings.add(pepperoni);
        panelToppings.add(chilePimiento);

        jamon.addActionListener(e -> {
            toppingSeleccionado = Toppings.JAMON;
            actualizarPizza();
            mostrarSeleccion(resultado);
            System.out.println("La pizza es de jamón");
        });

        pepperoni.addActionListener(e -> {
            toppingSeleccionado = Toppings.PEPPERONI;
            actualizarPizza();
            mostrarSeleccion(resultado);
            System.out.println("La pizza es de pepperoni");
        });

        chilePimiento.addActionListener(e -> {
            toppingSeleccionado = Toppings.CHILE_PIMIENTO;
            actualizarPizza();
            mostrarSeleccion(resultado);
            System.out.println("La pizza es de chile pimiento");
        });

        // -------------------- CREAR ORDEN --------------------
        JButton crearOrden = new JButton("Crear orden");
        crearOrden.setAlignmentX(Component.CENTER_ALIGNMENT);

        crearOrden.addActionListener(e -> {
            if (masaSeleccionada == null || salsaSeleccionada == null) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Debes seleccionar una masa y una salsa.",
                        "Faltan datos",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            actualizarPizza();

            Orden orden = new Orden();
            int numeroOrden = orden.numeroOrden(pizza);

            String mensaje = "Orden creada correctamente.\n"
                    + "Número de orden: " + numeroOrden + "\n"
                    + descripcionPizza();

            JOptionPane.showMessageDialog(
                    frame,
                    mensaje,
                    "Orden creada",
                    JOptionPane.INFORMATION_MESSAGE
            );

            resultado.setText(descripcionPizza());
            System.out.println(mensaje);
        });

        // Agregar los componentes al panel principal, de arriba hacia abajo.
        panelPrincipal.add(titulo);
        panelPrincipal.add(Box.createVerticalStrut(15));
        panelPrincipal.add(etiquetaMasa);
        panelPrincipal.add(panelMasas);
        panelPrincipal.add(etiquetaSalsa);
        panelPrincipal.add(panelSalsas);
        panelPrincipal.add(etiquetaTopping);
        panelPrincipal.add(panelToppings);
        panelPrincipal.add(Box.createVerticalStrut(10));
        panelPrincipal.add(resultado);
        panelPrincipal.add(Box.createVerticalStrut(15));
        panelPrincipal.add(crearOrden);

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

    private static void actualizarPizza() {
        if (masaSeleccionada == null || salsaSeleccionada == null) {
            return;
        }

        pizza = new Pizza();

        if (toppingSeleccionado == null) {
            pizza.añadirIng(masaSeleccionada, salsaSeleccionada);
        } else {
            pizza.añadirIng(masaSeleccionada, salsaSeleccionada, toppingSeleccionado);
        }
    }

    private static void mostrarSeleccion(JLabel resultado) {
        if (masaSeleccionada != null
                && salsaSeleccionada != null
                && toppingSeleccionado != null) {
            resultado.setText(descripcionPizza());
        } else {
            String masa = masaSeleccionada == null
                    ? "sin seleccionar"
                    : masaSeleccionada.toString().toLowerCase();

            String salsa = salsaSeleccionada == null
                    ? "sin seleccionar"
                    : salsaSeleccionada.toString().toLowerCase();

            String topping = toppingSeleccionado == null
                    ? "sin seleccionar"
                    : nombreTopping(toppingSeleccionado);

            resultado.setText(
                    "Masa: " + masa + " | Salsa: " + salsa + " | Topping: " + topping
            );
        }
    }

    private static String descripcionPizza() {
        String topping = toppingSeleccionado == null
                ? "sin topping"
                : "de " + nombreTopping(toppingSeleccionado);

        return "Pizza " + topping
                + ", con masa " + masaSeleccionada.toString().toLowerCase()
                + " y salsa " + salsaSeleccionada.toString().toLowerCase() + ".";
    }

    private static String nombreTopping(Toppings topping) {
        if (topping == Toppings.CHILE_PIMIENTO) {
            return "chile pimiento";
        }

        return topping.toString().toLowerCase();
    }
}
