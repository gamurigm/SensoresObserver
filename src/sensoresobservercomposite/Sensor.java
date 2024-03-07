package sensoresobservercomposite;

public class Sensor implements Observer {
    private String tipo;
    private String estado;
    private double medida;
    private double umbral;

    public Sensor(String tipo) {
        this.tipo = tipo;
        this.estado = "desconectado";
        this.medida = 0;
        this.umbral = 0;
    }

    public void conectar() {
        this.estado = "conectado";
    }

    public void desconectar() {
        this.estado = "desconectado";
    }

    public void actualizarMedida(double nuevoValor) {
        this.medida = nuevoValor;
        notificar();
    }

    public double getMedida() {
        return medida;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void update() {
        if (getMedida() > umbral) {
            System.out.println("Alarma! Sensor " + tipo + " supera el umbral. Medida: " + getMedida() + ", Umbral: " + umbral);
        }
    }


    private void notificar() {
        update();
    }

    double getUmbral() {
        return umbral;
    }
}
