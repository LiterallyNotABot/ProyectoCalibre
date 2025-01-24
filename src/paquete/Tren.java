package paquete;
import java.util.concurrent.ThreadLocalRandom;

public class Tren extends Conexion {
    String numeroTren;
    String numeroAsiento;

    public Tren(Ciudad origen, Ciudad destino) {
        super(origen, destino);
        this.numeroTren = generarNumeroAleatorio(1000, 9999);
        this.numeroAsiento = generarNumeroAleatorio(1, 100);
    }

    @Override
    String obtenerDetalles() {
        return "Coge el tren " + numeroTren + " con asiento " + numeroAsiento + " desde " + origen + " hasta " + destino + ".";
    }

    private String generarNumeroAleatorio(int min, int max) {
        return String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
    }
}