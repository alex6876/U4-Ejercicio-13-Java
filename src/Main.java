public class Main {

    public static void main(String[] args) {

        SistemaMonitoreo sistema = new SistemaMonitoreo();

        AlertaClimatica tormenta = new AlertaTormenta();

        AlertaClimatica calor = new AlertaCalor();

        AlertaClimatica viento = new AlertaViento();


        sistema.generarAlerta(tormenta, 85);

        sistema.generarAlerta(calor, 38);

        sistema.generarAlerta(viento, 95);
    }
}