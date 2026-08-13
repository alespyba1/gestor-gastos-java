import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gestor semanal de gastos");
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
}
