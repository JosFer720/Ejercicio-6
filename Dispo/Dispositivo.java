/**
 * Clase abstracta que representa un Dispositivo Electrónico.
 */
public abstract class Dispositivo implements DispositivoElectronico {
    private String modelo;
    private boolean encendido;

    /**
     * Constructor de la clase Dispositivo.
     *
     * @param modelo El modelo del dispositivo.
     */
    public Dispositivo(String modelo) {
        this.modelo = modelo;
        this.encendido = false;
    }

    /**
     * Enciende el dispositivo electrónico.
     */
    @Override
    public void encender() {
        encendido = true;
    }

    /**
     * Apaga el dispositivo electrónico.
     */
    @Override
    public void apagar() {
        encendido = false;
    }

    /**
     * Verifica si el dispositivo está encendido.
     *
     * @return true si el dispositivo está encendido, false si está apagado.
     */
    @Override
    public boolean estaEncendido() {
        return encendido;
    }

    /**
     * Obtiene el modelo del dispositivo.
     *
     * @return El modelo del dispositivo.
     */
    public String getModelo() {
        return modelo;
    }
}