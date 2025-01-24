package paquete;

public abstract class Conexion {
    Ciudad origen;
    Ciudad destino;

    public Conexion(Ciudad origen, Ciudad destino) {
        this.origen = origen;
        this.destino = destino;
    }

    abstract String obtenerDetalles();
}