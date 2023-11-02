import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una tienda de dispositivos electronicos.
 */
public class Tienda {
    private List<DispositivoElectronico> dispositivos;

    /**
     * Constructor de la tienda que inicializa la lista de dispositivos.
     */
    public Tienda() {
        dispositivos = new ArrayList<>();
    }

    /**
     * Agrega un dispositivo a la lista despues de solicitar informacion al usuario.
     */
    public void agregarDispositivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tipo de dispositivo (Telefono/Computadora): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("Telefono")) {
            System.out.print("Marca del telefono: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo del telefono: ");
            String modelo = scanner.nextLine();
            Telefono telefono = new Telefono(modelo, marca);
            dispositivos.add(telefono);
        } else if (tipo.equalsIgnoreCase("Computadora")) {
            System.out.print("Marca de la computadora: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo de la computadora: ");
            String modelo = scanner.nextLine();
            Computadora computadora = new Computadora(modelo, marca);
            dispositivos.add(computadora);
        } else {
            System.out.println("Tipo de dispositivo no valido.");
        }
    }

    /**
     * Muestra informacion de todos los dispositivos en la tienda.
     */
    public void mostrarInformacion() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            System.out.println("Modelo: " + ((Dispositivo) dispositivo).getModelo());

            if (dispositivo instanceof Computadora) {
                System.out.println("Tipo: Computadora");
                System.out.println("Marca: " + ((Computadora) dispositivo).getMarca());
            } else if (dispositivo instanceof Telefono) {
                System.out.println("Tipo: Telefono");
                System.out.println("Marca: " + ((Telefono) dispositivo).getMarca());
            }

            System.out.println("Encendido: " + (dispositivo.estaEncendido() ? "Sí" : "No"));
            System.out.println("-----------------------------");
        }
    }

    /**
     * Devuelve una lista de dispositivos encendidos.
     *
     * @return Lista de dispositivos encendidos.
     */
    public List<DispositivoElectronico> dispositivosEncendidos() {
        List<DispositivoElectronico> encendidos = new ArrayList<>();
        for (DispositivoElectronico dispositivo : dispositivos) {
            if (dispositivo.estaEncendido()) {
                encendidos.add(dispositivo);
            }
        }
        return encendidos;
    }

    /**
     * Devuelve una lista de dispositivos apagados.
     *
     * @return Lista de dispositivos apagados.
     */
    public List<DispositivoElectronico> dispositivosApagados() {
        List<DispositivoElectronico> apagados = new ArrayList<>();
        for (DispositivoElectronico dispositivo : dispositivos) {
            if (!dispositivo.estaEncendido()) {
                apagados.add(dispositivo);
            }
        }
        return apagados;
    }

    /**
     * Guarda la informacion de los dispositivos en un archivo CSV.
     *
     * @param filename El nombre del archivo CSV donde se guardaran los dispositivos.
     */
    public void guardarDispositivos(String filename) {
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (DispositivoElectronico dispositivo : dispositivos) {
                String tipo;
                String modelo = ((Dispositivo) dispositivo).getModelo();
                String marca = "";

                if (dispositivo instanceof Computadora) {
                    tipo = "Computadora";
                    marca = ((Computadora) dispositivo).getMarca();
                } else if (dispositivo instanceof Telefono) {
                    tipo = "Telefono";
                    marca = ((Telefono) dispositivo).getMarca();
                } else {
                    tipo = "Desconocido";
                }

                String encendido = dispositivo.estaEncendido() ? "Encendido" : "Apagado";
                writer.println(tipo + "," + modelo + "," + marca + "," + encendido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos de dispositivos desde un archivo CSV.
     *
     * @param filename El nombre del archivo CSV desde el cual se cargaran los dispositivos.
     */
    public void cargarDispositivos(String filename) {
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String tipo = parts[0];
                String modelo = parts[1];
                String marca = parts[2];
                boolean encendido = parts[3].equals("Encendido");

                if (tipo.equals("Computadora")) {
                    Computadora computadora = new Computadora(modelo, marca);
                    if (encendido) {
                        computadora.encender();
                    }
                    dispositivos.add(computadora);
                } else if (tipo.equals("Telefono")) {
                    Telefono telefono = new Telefono(modelo, marca);
                    if (encendido) {
                        telefono.encender();
                    }
                    dispositivos.add(telefono);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo principal que sirve como menu para interactuar con la tienda y sus dispositivos.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de opciones:");
            System.out.println("1. Agregar dispositivo");
            System.out.println("2. Mostrar informacion de dispositivos");
            System.out.println("3. Validar dispositivos encendidos y apagados");
            System.out.println("4. Guardar datos");
            System.out.println("5. Cargar datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    tienda.agregarDispositivo();
                    break;
                case 2:
                    tienda.mostrarInformacion();
                    break;
                case 3:
                    System.out.println("Dispositivos encendidos:");
                    List<DispositivoElectronico> encendidos = tienda.dispositivosEncendidos();
                    for (DispositivoElectronico dispositivo : encendidos) {
                        System.out.println(((Dispositivo) dispositivo).getModelo());
                    }
                    System.out.println("Dispositivos apagados:");
                    List<DispositivoElectronico> apagados = tienda.dispositivosApagados();
                    for (DispositivoElectronico dispositivo : apagados) {
                        System.out.println(((Dispositivo) dispositivo).getModelo());
                    }
                    break;
                case 4:
                    System.out.print("Nombre del archivo CSV para guardar los datos: ");
                    String archivoGuardar = scanner.nextLine();
                    tienda.guardarDispositivos(archivoGuardar);
                    System.out.println("Dispositivos guardados en " + archivoGuardar);
                    break;
                case 5:
                    System.out.print("Nombre del archivo CSV para cargar los datos: ");
                    String archivoCargar = scanner.nextLine();
                    tienda.cargarDispositivos(archivoCargar);
                    System.out.println("Dispositivos cargados desde " + archivoCargar);
                    break;
                case 6:
                    System.out.println("Gracias por usar el programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}