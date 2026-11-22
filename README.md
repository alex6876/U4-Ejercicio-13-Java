# Simulación de Sistema de Monitoreo y Alertas Climáticas (Clases Abstractas y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema meteorológico de alerta temprana, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos fenómenos climáticos (tormentas, olas de calor y viento Zonda) con umbrales de severidad y recomendaciones operativas especializadas según la magnitud medida. Pone en práctica conceptos fundamentales de la Programación Orientada a Objetos (POO) como la definición de contratos obligatorios mediante clases abstractas (`abstract`), la sobrescritura polimórfica de comportamiento (`@Override`), la inyección de dependencias por parámetros y el procesamiento centralizado en memoria sin persistencia en base de datos.

---

## Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas por fenómeno meteorológico, un componente de monitoreo y un punto de ejecución:

* **`AlertaClimatica` (Clase Abstracta)**: Define el contrato genérico para cualquier tipo de advertencia meteorológica dentro del sistema.
* **Método abstracto**: `abstract void emitirAdvertencia(double magnitudMedida)`: Obliga a cada clase hija a implementar su propia escala de evaluación de riesgo y formato de reporte según la magnitud recibida.


* **`AlertaTormenta`**: Extiende de `AlertaClimatica` para modelar advertencias asociadas a tormentas severas medidas en velocidad de viento (`km/h`).
* **Sobrescritura (`@Override`)**:
* `emitirAdvertencia(double magnitudMedida)`: Evalúa cuatro niveles de severidad (`less than 40`, `less than 70`, `less than 100` y `100` o superior), emite las instrucciones preventivas correspondientes e informa la velocidad del viento registrada.




* **`AlertaCalor`**: Extiende de `AlertaClimatica` para modelar alertas térmicas medidas en grados Celsius (`°C`).
* **Sobrescritura (`@Override`)**:
* `emitirAdvertencia(double magnitudMedida)`: Clasifica el impacto térmico en riesgo bajo (`less than 30`), moderado (`less than 35`), alto (`less than 40`) o extremo (`40` o superior), mostrando recomendaciones de hidratación y resguardo junto con la temperatura medida.




* **`AlertaViento`**: Extiende de `AlertaClimatica` para modelar alertas por ráfagas intensas de viento Zonda medidas en `km/h`.
* **Sobrescritura (`@Override`)**:
* `emitirAdvertencia(double magnitudMedida)`: Determina el nivel de riesgo (`less than 40`, `less than 60`, `less than 90` y `90` o superior), despliega las medidas de precaución correspondientes e indica la velocidad de las ráfagas.




* **`SistemaMonitoreo`**: Componente controlador encargado de centralizar la emisión de alertas.
* **Método operativo**: `generarAlerta(AlertaClimatica alerta, double magnitudMedida)`: Recibe polimórficamente cualquier tipo de alerta climática, invoca dinámicamente `emitirAdvertencia(magnitudMedida)` e imprime un separador visual al final de cada reporte.


* **`Main`**: Punto de entrada del programa. Instancia el `SistemaMonitoreo` y las tres alertas climáticas (`AlertaTormenta`, `AlertaCalor` y `AlertaViento`), y ejecuta `generarAlerta(...)` con distintas magnitudes de prueba para exhibir por consola la resolución polimórfica de cada advertencia.

---

## Reglas de Negocio y Control de Validación

1. **Contrato Estricto de Advertencia:** Mediante `AlertaClimatica`, toda nueva alerta meteorológica (por ejemplo, granizo, nevada o crecida) debe implementar obligatoriamente `emitirAdvertencia(double magnitudMedida)`.
2. **Escalas y Umbrales Independientes:** Cada fenómeno define sus propios rangos numéricos y mensajes preventivos, evitando condicionales monolíticos centralizados y manteniendo cada regla encapsulada en su clase correspondiente.
3. **Desacoplamiento mediante Polimorfismo:** `SistemaMonitoreo` trabaja únicamente contra la abstracción `AlertaClimatica`, delegando la lógica específica de clasificación al objeto concreto recibido en tiempo de ejecución.

---

## Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== ALERTA DE TORMENTA =====
Riesgo alto. Evite salir.
Velocidad del viento: 85.0 km/h
------------------------------
===== ALERTA DE CALOR =====
Riesgo alto. Evite la exposicion al sol.
Temperatura: 38.0 grados Celsius
------------------------------
===== ALERTA DE VIENTO ZONDA =====
RIESGO EXTREMO. Permanezca en un lugar seguro.
Velocidad de las rafagas: 95.0 km/h
------------------------------

```

---

## Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo:** Uso de una clase abstracta y sobrescritura de métodos (`@Override`) para emitir advertencias especializadas a través de una interfaz común.
* **Principio Abierto/Cerrado (OCP):** Posibilidad de agregar nuevos tipos de alertas climáticas extendiendo `AlertaClimatica` sin modificar `SistemaMonitoreo`.
* **Separación de Responsabilidades:** División clara entre la lógica de evaluación de cada fenómeno climático, la orquestación en `SistemaMonitoreo` y la ejecución de escenarios de prueba en `Main`.
