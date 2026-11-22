public class AlertaCalor extends AlertaClimatica {

    @Override
    public void emitirAdvertencia(double magnitudMedida) {

        System.out.println("===== ALERTA DE CALOR =====");

        if (magnitudMedida < 30) {

            System.out.println("Riesgo bajo.");

        } else if (magnitudMedida < 35) {

            System.out.println("Riesgo moderado. Mantengase hidratado.");

        } else if (magnitudMedida < 40) {

            System.out.println("Riesgo alto. Evite la exposicion al sol.");

        } else {

            System.out.println("RIESGO EXTREMO. Permanezca en lugares frescos.");
        }

        System.out.println("Temperatura: " + magnitudMedida + " grados Celsius");
    }
}