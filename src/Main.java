import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("SISTEMA SEMANAL DE GASTOS");

        ArrayList<String> conceptos = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();
        ArrayList<Double> montos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int cantidad=0;

        System.out.print("Ingresa la cantidad de gastos a registrar: ");
        cantidad=scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < cantidad; i++) {
            System.out.println("Registro de gasto " + (i+1));
            registrarGasto(conceptos, categorias, montos, scanner);
            System.out.println();
        }
        mostrarGastos(conceptos, categorias, montos);
        scanner.close();
    }

    public static double calcularTotal(ArrayList<Double> montos){
        double total = 0;
        for(double monto: montos){
            total += monto;
        }
        return total;
    }

    public static int  obtenerPosicionGastoMayor(ArrayList<Double> montos){
        int index = 0;
        double mayor = 0;
        for(double monto: montos){
            if(monto>mayor){
                mayor = monto;
                index = montos.indexOf( mayor );
            }
        }
        return index;
    }

    public static double calcularTotalPorCategoria(ArrayList<String> categorias, ArrayList<Double> montos, String categoriaBuscada){
        double total = 0;
        for(String cat: categorias){
            if(cat.contentEquals(categoriaBuscada)){
                total += montos.get(categorias.indexOf(cat));
            }
        }
        return total;
    }

    public static void mostrarResumen(ArrayList<String> conceptos, ArrayList<String> categorias, ArrayList<Double> montos){
        System.out.println("RESUMEN SEMANAL \n\n");
        System.out.print("Numero de gastos: " + conceptos.size() + "\n");
        System.out.print("Gasto total: " + calcularTotal(montos) + "\n");
        System.out.print("Promedio por gasto: " + calcularTotal(montos)/conceptos.size() + "\n");
        System.out.print("Gasto Mayor: " + conceptos.get(obtenerPosicionGastoMayor(montos)) + " $" + montos.get(obtenerPosicionGastoMayor(montos)));
    }

    public static void registrarGasto(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos,
            Scanner scanner) {
        System.out.print("Concepto del Gasto: ");
        String concepto = scanner.nextLine();

        String categoria = "";
        boolean categoriaValida = false;

        while (!categoriaValida) {
            System.out.println("Las categorias disponibles son: Alimentos, Transporte, Materiales");
            System.out.print("Ingrese la categoria: ");
            categoria = scanner.nextLine();

            switch (categoria.toLowerCase()) {
                case "alimentos":
                case "transporte":
                case "materiales":
                    categoriaValida = true;
                    break;
                default:
                    System.out.println("Error: Categoria no valida. Intente nuevamente.\n");
                    break;
            }
        }

        {
            double monto=0;
            while(monto<=0){
                System.out.print("Ingresa el monto gastado: $");
                monto= scanner.nextDouble();

                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a cero.\n");
                }
            }

            scanner.nextLine();
            conceptos.add(concepto);
            categorias.add(categoria);
            montos.add(monto);


        }

        // Leer lo que escriba el usuario y guardarlo como el concepto
        // Imprimir las opciones (Alimentos, Transporte, Materiales)
        // Pedir la categoría y observar si esto es correcto
        // Leer la categoría escrita
        // Si no existe en las opciones, volver a preguntar
        // Pedir y validar el monto
        // Leer el monto
        // Si es 0 o menor, mostrar error y volver a preguntar
        // Guardar los datos
        // Añadir el concepto a la lista conceptos
        // Añadir la categoría a la lista categorias
        // Añadir el monto a la lista montos

    }

    public static void mostrarGastos(
            ArrayList<String> conceptos,
            ArrayList<String> categorias,
            ArrayList<Double> montos) {

        System.out.println("Gastos Guardados\n");

        for(int i=0; i< conceptos.size(); i++){
            System.out.printf("%d. %-10s | %-10s | $%.2f\n",(i+1),conceptos.get(i),categorias.get(i),montos.get(i));
        }


        // Hacer un ciclo 'for' para recorrer las listas (desde 0 hasta el tamaño de la lista)
        // Obtener el número de lista
        // Obtener el concepto, categoría y monto de esa posición
        // Imprimir
    }
}
