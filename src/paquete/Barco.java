package paquete;
import java.util.concurrent.ThreadLocalRandom;

public class Barco extends Conexion {
    String numeroBarco;

    public Barco(Ciudad origen, Ciudad destino) {
        super(origen, destino);
        this.numeroBarco = generarNumeroAleatorio(1000, 9999);
    }

    @Override
    String obtenerDetalles() {
        return "Coge el barco " + numeroBarco + " desde " + origen + " hasta " + destino + ".";
    }

    private String generarNumeroAleatorio(int min, int max) {
        return String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
    }
}