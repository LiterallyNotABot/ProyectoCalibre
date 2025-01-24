package paquete;


import java.util.*;

public class CalculadorDeRuta {
    private List<Conexion> conexiones;

    public CalculadorDeRuta(List<Conexion> conexiones) {
        this.conexiones = conexiones;
    }

    public void encontrarRutas(Ciudad origen, Ciudad destino) {
        List<List<Conexion>> todasLasRutas = buscarRutas(origen, destino);

        if (todasLasRutas.isEmpty()) {
            System.out.println("No existe una ruta válida entre las ciudades.");
        } else {
            todasLasRutas.sort(Comparator.comparingInt(List::size));

            int contador = 1;
            for (List<Conexion> ruta : todasLasRutas) {
                System.out.println("Ruta " + contador + " (" + ruta.size() + " escala(s)):");
                for (Conexion conexion : ruta) {
                    System.out.println("  " + conexion.obtenerDetalles());
                }
                System.out.println();
                contador++;
            }
        }
    }

    private List<List<Conexion>> buscarRutas(Ciudad origen, Ciudad destino) {
        List<List<Conexion>> rutasEncontradas = new ArrayList<>();
        Queue<Nodo> cola = new LinkedList<>();

        cola.add(new Nodo(origen, new ArrayList<>(), new HashSet<>()));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();

            if (actual.ciudad.equals(destino)) {
                rutasEncontradas.add(new ArrayList<>(actual.ruta));
                continue;
            }

            for (Conexion conexion : conexiones) {
                if (conexion.origen.equals(actual.ciudad) && !actual.visitadas.contains(conexion.destino)) {
                    List<Conexion> nuevaRuta = new ArrayList<>(actual.ruta);
                    nuevaRuta.add(conexion);

                    Set<Ciudad> nuevasVisitadas = new HashSet<>(actual.visitadas);
                    nuevasVisitadas.add(conexion.destino);

                    cola.add(new Nodo(conexion.destino, nuevaRuta, nuevasVisitadas));
                }
            }
        }

        return rutasEncontradas;
    }

    private static class Nodo {
        Ciudad ciudad;
        List<Conexion> ruta;
        Set<Ciudad> visitadas;

        public Nodo(Ciudad ciudad, List<Conexion> ruta, Set<Ciudad> visitadas) {
            this.ciudad = ciudad;
            this.ruta = ruta;
            this.visitadas = visitadas;
        }
    }
}

