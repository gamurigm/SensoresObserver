package sensoresobservercomposite;

public class GestorSensores {

    public static void main(String[] args) {
        SistemaAlarma sistema = new SistemaAlarma();

        Sensor sensorHumo1 = new Sensor("humo");
        Sensor sensorHumo2 = new Sensor("humo");
        Sensor sensorPresion = new Sensor("presion");
        Sensor sensorTemperatura = new Sensor("temperatura");

        GrupoSensores grupoSensoresHumo = new GrupoSensores("humo");
        GrupoSensores grupoSensoresTemperatura = new GrupoSensores("temperatura");

        grupoSensoresHumo.agregarSensor(sensorHumo1);
        grupoSensoresHumo.agregarSensor(sensorHumo2);

        grupoSensoresTemperatura.agregarSensor(sensorTemperatura);

        sistema.agregarSensor(sensorHumo1);
        sistema.agregarSensor(sensorHumo2);
        sistema.agregarSensor(sensorPresion);
        sistema.agregarSensor(sensorTemperatura);
        sistema.agregarSensor(grupoSensoresHumo);
        sistema.agregarSensor(grupoSensoresTemperatura);

        sensorHumo1.conectar();
        sensorHumo2.conectar();
        sensorPresion.conectar();
        sensorTemperatura.conectar();

        // Establecer umbrales después de conectar los sensores
        sensorHumo1.setUmbral(0.05);
        sensorHumo2.setUmbral(0.1);
        sensorPresion.setUmbral(9000.0);
        sensorTemperatura.setUmbral(300.0);

        // Actualizar medidas
        sensorHumo1.actualizarMedida(0.3);
        sensorHumo2.actualizarMedida(0.05);
        sensorPresion.actualizarMedida(100.0);
        sensorTemperatura.actualizarMedida(28.0);

        // Notificar al sistema de alarma
        sistema.notificarSensores();
    }
}
