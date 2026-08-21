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
            // Título resultante de la Fase 8
            System.out.println("\nSISTEMA PERSONAL DE CONTROL DE GASTOS");
            System.out.println("1. Registrar gasto");
            System.out.println("2. Mostrar todos los gastos");
            System.out.println("3. Calcular gasto total");
            System.out.println("4. Mostrar gasto mayor");
            System.out.println("5. Mostrar gastos por categoria");
            System.out.println("6. Mostrar resumen semanal");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarGasto(conceptos, categorias, montos, scanner);
                    break;
                case 2:
                    mostrarGastos(conceptos, categorias, montos);
                    break;
                case 3:
                    System.out.println("\nTotal gastado: $" + calcularTotal(montos));
                    break;
                case 4:
                    mostrarGastoMayor(conceptos, categorias, montos);
                    break;
                case 5:
                    System.out.print("\nIngrese la categoria a buscar: ");
                    String cat = scanner.nextLine();
                    System.out.println("Total en " + cat + ": $" + calcularTotalPorCategoria(categorias, montos, cat));
                    break;
                case 6:
                    mostrarResumen(conceptos, categorias, montos);
                    break;
                case 7:
                    System.out.println("\nPrograma terminado.");
                    break;
                default:
                    System.out.println("\nOpcion no valida.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    public static double calcularTotal(ArrayList<Double> montos){
        double total = 0;
        for(double monto: montos){
            total += monto;
        }
        return total;
    }

    public static int obtenerPosicionGastoMayor(ArrayList<Double> montos){
        if (montos.isEmpty()) return -1;
        int index = 0;
        double mayor = 0;
        for (int i = 0; i < montos.size(); i++) {
            if (montos.get(i) > mayor) {
                mayor = montos.get(i);
                index = i;
            }
        }
        return index;
    }

    public static void mostrarGastoMayor(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos) {
        int index = obtenerPosicionGastoMayor(montos);
        if (index != -1) {
            System.out.println("\nGasto Mayor: " + conceptos.get(index) + " ($" + montos.get(index) + ")");
        } else {
            System.out.println("\nNo hay gastos registrados.");
        }
    }

    public static double calcularTotalPorCategoria(ArrayList<String> categorias, ArrayList<Double> montos, String categoriaBuscada){
        double total = 0;
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).equalsIgnoreCase(categoriaBuscada)) {
                total += montos.get(i);
            }
        }
        return total;
    }

    public static void mostrarResumen(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos){
        if (conceptos.isEmpty()) {
            System.out.println("\nNo hay datos para mostrar.");
            return;
        }
        System.out.println("\nRESUMEN SEMANAL \n");
        System.out.println("Numero de gastos: " + conceptos.size());
        System.out.println("Gasto total: $" + calcularTotal(montos));
        System.out.println("Promedio por gasto: $" + (calcularTotal(montos) / conceptos.size()));

        int indexMayor = obtenerPosicionGastoMayor(montos);
        System.out.println("Gasto Mayor: " + conceptos.get(indexMayor) + ", $" + montos.get(indexMayor));
    }

    public static void registrarGasto(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos, Scanner scanner) {
        System.out.print("\nConcepto del Gasto: ");
        String concepto = scanner.nextLine();

        String categoria = "";
        boolean categoriaValida = false;

        while (!categoriaValida) {
            System.out.println("Categorias disponibles: Alimentos, Transporte, Materiales, Entretenimiento, Otros");
            System.out.print("Ingrese la categoria: ");
            categoria = scanner.nextLine();

            // Modificado para aceptar todas las categorías de la rúbrica
            switch (categoria.toLowerCase()) {
                case "alimentos":
                case "transporte":
                case "materiales":
                case "entretenimiento":
                case "otros":
                    categoriaValida = true;
                    break;
                default:
                    System.out.println("Error: Categoria no valida. Intente nuevamente.\n");
                    break;
            }
        }

        double monto = 0;
        while(monto <= 0){
            System.out.print("Ingresa el monto gastado: $");
            monto = scanner.nextDouble();

            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a cero.\n");
            }
        }

        scanner.nextLine(); // limpiar buffer
        conceptos.add(concepto);
        categorias.add(categoria);
        montos.add(monto);
        System.out.println("¡Gasto registrado con exito!");
    }

    public static void mostrarGastos(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos) {
        if (conceptos.isEmpty()) {
            System.out.println("\nNo hay gastos registrados.");
            return;
        }
        System.out.println("\nGASTOS REGISTRADOS\n");
        for(int i = 0; i < conceptos.size(); i++){
            System.out.printf("%d. %-15s | %-15s | $%.2f\n", (i+1), conceptos.get(i), categorias.get(i), montos.get(i));
        }
    }
}