public class AlertaTormenta extends AlertaClimatica {

    @Override
    public void emitirAdvertencia(double magnitudMedida) {

        System.out.println("===== ALERTA DE TORMENTA =====");

        if (magnitudMedida < 40) {

            System.out.println("Riesgo bajo.");

        } else if (magnitudMedida < 70) {

            System.out.println("Riesgo moderado. Precaucion.");

        } else if (magnitudMedida < 100) {

            System.out.println("Riesgo alto. Evite salir.");

        } else {

            System.out.println("RIESGO EXTREMO. Busque refugio inmediatamente.");
        }

        System.out.println("Velocidad del viento: " + magnitudMedida + " km/h");
    }
}
