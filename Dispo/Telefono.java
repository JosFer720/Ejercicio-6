/**
 * Clase que representa un Telefono, que es un tipo de Dispositivo Electronico.
 */
public class Telefono extends Dispositivo {
    private String marca;

    /**
     * Constructor de la clase Telefono.
     *
     * @param modelo El modelo del telefono.
     * @param marca  La marca del telefono.
     */
    public Telefono(String modelo, String marca) {
        super(modelo);
        this.marca = marca;
    }

    /**
     * Obtiene la marca del telefono.
     *
     * @return La marca del telefono.
     */
    public String getMarca() {
        return marca;
    }
}