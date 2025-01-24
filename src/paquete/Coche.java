package paquete;
import java.util.concurrent.ThreadLocalRandom;

public class Coche extends Conexion {
    String matricula;

    public Coche(Ciudad origen, Ciudad destino) {
        super(origen, destino);
        this.matricula = generarMatriculaAleatoria();
    }

    @Override
    String obtenerDetalles() {
        return "Conduce el coche con matrícula " + matricula + " desde " + origen + " hasta " + destino + ".";
    }

    private String generarMatriculaAleatoria() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder matricula = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            matricula.append(letras.charAt(ThreadLocalRandom.current().nextInt(letras.length())));
        }
        matricula.append("-").append(ThreadLocalRandom.current().nextInt(1000, 9999));
        return matricula.toString();
    }
}