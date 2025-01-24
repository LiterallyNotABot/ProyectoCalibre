package paquete;
import java.util.concurrent.ThreadLocalRandom;

public class Avion extends Conexion {
    String numeroVuelo;
    String numeroAsiento;

    public Avion(Ciudad origen, Ciudad destino) {
        super(origen, destino);
        this.numeroVuelo = generarNumeroAleatorio(1000, 9999);
        this.numeroAsiento = generarNumeroAleatorio(1, 200);
    }

    @Override
    String obtenerDetalles() {
        return "Coge el avión " + numeroVuelo + " con asiento " + numeroAsiento + " desde " + origen + " hasta " + destino + ".";
    }

    private String generarNumeroAleatorio(int min, int max) {
        return String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
    }
}