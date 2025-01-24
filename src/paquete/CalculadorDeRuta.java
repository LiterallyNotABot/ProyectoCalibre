package paquete;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculadorDeRuta {
    private List<Conexion> conexiones;

    public CalculadorDeRuta(List<Conexion> conexiones) {
        this.conexiones = conexiones;
    }

    public void encontrarRuta(Ciudad origen, Ciudad destino) {
        Set<Ciudad> visitadas = new HashSet<>();
        List<Conexion> ruta = new ArrayList<>();

        if (buscarRuta(origen, destino, visitadas, ruta)) {
            for (Conexion conexion : ruta) {
                System.out.println(conexion.obtenerDetalles());
            }
            System.out.println("¡Felicidades, has llegado a tu destino!");
        } else {
            System.out.println("No existe una ruta válida entre las ciudades.");
        }
    }

    private boolean buscarRuta(Ciudad actual, Ciudad destino, Set<Ciudad> visitadas, List<Conexion> ruta) {
        if (actual.equals(destino)) {
            return true;
        }

        visitadas.add(actual);

        for (Conexion conexion : conexiones) {
            if (conexion.origen.equals(actual) && !visitadas.contains(conexion.destino)) {
                ruta.add(conexion);
                if (buscarRuta(conexion.destino, destino, visitadas, ruta)) {
                    return true;
                }
                ruta.remove(ruta.size() - 1);
            }
        }

        visitadas.remove(actual);
        return false;
    }
}