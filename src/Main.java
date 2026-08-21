import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarGasto(conceptos, categorias, montos, scanner); break;
                case 2: mostrarGastos(conceptos, categorias, montos); break;
                case 3: System.out.println("Total: $" + calcularTotal(montos)); break;
                case 4: mostrarGastoMayor(conceptos, categorias, montos); break;
                case 5: consultarGastosPorCategoria(categorias, montos, scanner); break;
                case 6: mostrarResumen(conceptos, categorias, montos); break;
                case 7: System.out.println("Programa terminado."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 7);
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nSISTEMA PERSONAL DE CONTROL DE GASTOS");
        System.out.println("1. Registrar gasto\n2. Mostrar todos los gastos\n3. Calcular gasto total");
        System.out.println("4. Mostrar gasto mayor\n5. Mostrar gastos por categoria\n6. Mostrar resumen semanal\n7. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public static void registrarGasto(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos, Scanner scanner) {
        System.out.print("\nConcepto: ");
        String concepto = scanner.nextLine();
        System.out.print("Categoria (Alimentos, Transporte, Materiales, Entretenimiento, Otros): ");
        String categoria = scanner.nextLine();
        System.out.print("Monto: $");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        conceptos.add(concepto);
        categorias.add(categoria);
        montos.add(monto);
        System.out.println("Gasto registrado.");
    }

    public static void mostrarGastos(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos) {
        for (int i = 0; i < conceptos.size(); i++) {
            System.out.printf("%d. %s | %s | $%.2f\n", (i + 1), conceptos.get(i), categorias.get(i), montos.get(i));
        }
    }

    public static double calcularTotal(ArrayList<Double> montos) {
        double total = 0;
        for (double monto : montos) total += monto;
        return total;
    }

    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos) {
        int index = 0; double mayor = 0;
        for (int i = 0; i < montos.size(); i++) {
            if (montos.get(i) > mayor) { mayor = montos.get(i); index = i; }
        }
        return index;
    }

    public static void mostrarGastoMayor(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos) {
        if (montos.isEmpty()) return;
        int i = obtenerPosicionGastoMayor(montos);
        System.out.println("Gasto Mayor: " + conceptos.get(i) + " ($" + montos.get(i) + ")");
    }

    public static double calcularTotalPorCategoria(ArrayList<String> categorias, ArrayList<Double> montos, String catBuscada) {
        double total = 0;
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).equalsIgnoreCase(catBuscada)) total += montos.get(i);
        }
        return total;
    }

    public static void consultarGastosPorCategoria(ArrayList<String> categorias, ArrayList<Double> montos, Scanner scanner) {
        System.out.print("\nCategoria a buscar: ");
        String cat = scanner.nextLine();
        System.out.println("Total en " + cat + ": $" + calcularTotalPorCategoria(categorias, montos, cat));
    }

    public static void mostrarResumen(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos) {
        if (conceptos.isEmpty()) return;
        System.out.println("\nNumero de gastos: " + conceptos.size());
        System.out.println("Gasto total: $" + calcularTotal(montos));
        int i = obtenerPosicionGastoMayor(montos);
        System.out.println("Gasto mayor: " + conceptos.get(i) + ", $" + montos.get(i));
    }

}