/**
 * Interfaz que define las operaciones basicas que puede realizar un Dispositivo Electronico.
 */
public interface DispositivoElectronico {
    /**
     * Enciende el dispositivo electronico.
     */
    void encender();

    /**
     * Apaga el dispositivo electronico.
     */
    void apagar();

    /**
     * Verifica si el dispositivo esta encendido.
     *
     * @return true si el dispositivo esta encendido, false si esta apagado.
     */
    boolean estaEncendido();
}