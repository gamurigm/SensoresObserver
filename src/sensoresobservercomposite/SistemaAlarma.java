package sensoresobservercomposite;

import java.util.ArrayList;
import java.util.List;

public class SistemaAlarma {
    private List<Observer> sensores;

    public SistemaAlarma() {
        this.sensores = new ArrayList<>();
    }

    public void agregarSensor(Observer sensor) {
        sensores.add(sensor);
    }

    public void notificarSensores() {
        for (Observer observador : sensores) {
            observador.update();
        }
    }
}
