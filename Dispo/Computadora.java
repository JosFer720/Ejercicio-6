/**
 * Clase que representa una Computadora, la cual es un tipo de Dispositivo Electronico.
 */
public class Computadora extends Dispositivo {
    private String marca;

    /**
     * Constructor de la clase Computadora.
     *
     * @param modelo El modelo de la computadora.
     * @param marca  La marca de la computadora.
     */
    public Computadora(String modelo, String marca) {
        super(modelo);
        this.marca = marca;
    }

    /**
     * Obtiene la marca de la computadora.
     *
     * @return La marca de la computadora.
     */
    public String getMarca() {
        return marca;
    }
}