public class AlertaViento extends AlertaClimatica {

    @Override
    public void emitirAdvertencia(double magnitudMedida) {

        System.out.println("===== ALERTA DE VIENTO ZONDA =====");

        if (magnitudMedida < 40) {

            System.out.println("Riesgo bajo.");

        } else if (magnitudMedida < 60) {

            System.out.println("Riesgo moderado. Asegure objetos sueltos.");

        } else if (magnitudMedida < 90) {

            System.out.println("Riesgo alto. Evite actividades al aire libre.");

        } else {

            System.out.println("RIESGO EXTREMO. Permanezca en un lugar seguro.");
        }

        System.out.println("Velocidad de las rafagas: " + magnitudMedida + " km/h");
    }
}