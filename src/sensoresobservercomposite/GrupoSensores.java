package sensoresobservercomposite;

import java.util.ArrayList;
import java.util.List;

public class GrupoSensores implements Observer {
    private String tipo;
    private List<Observer> sensores;

    public GrupoSensores(String tipo) {
        this.tipo = tipo;
        this.sensores = new ArrayList<>();
    }

    public void agregarSensor(Observer sensor) {
        sensores.add(sensor);
    }

    public void quitarSensor(Observer sensor) {
        sensores.remove(sensor);
    }

    @Override
    public void update() {
        double valorMedio = calcularValorMedio();

        for (Observer sensor : sensores) {
            if (sensor instanceof Sensor) {
                double umbralSensor = ((Sensor) sensor).getUmbral();
                if (valorMedio > umbralSensor) {
                    System.out.println("Alarma! Grupo de sensores " + tipo + " supera el umbral.");
                   
                    break; // Solo notificar al sistema de alarma una vez
                }
            }
        }
    }

    private double calcularValorMedio() {
        if (sensores.isEmpty()) {
            return 0;
        }

        double sumaMedidas = sensores.stream().mapToDouble(sensor -> ((Sensor) sensor).getMedida()).sum();
        return sumaMedidas / sensores.size();
    }
}
