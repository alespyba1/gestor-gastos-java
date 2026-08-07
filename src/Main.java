import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gestor semanal de gastos");
    }

    public static double calcularTotal(ArrayList<Double> montos){
        double total = 0;
        for(double monto: montos){
            total += monto;
        };
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
}
