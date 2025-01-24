package paquete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeRutas {
		   	
	public void run() {
	      
			Scanner scanner = new Scanner(System.in);

	        System.out.println("Introduce las ciudades existentes, separadas por comas:");
	        String[] ciudadesInput = scanner.nextLine().split(",");
	        List<Ciudad> ciudades = new ArrayList<>();
	        for (String nombreCiudad : ciudadesInput) {
	            ciudades.add(new Ciudad(nombreCiudad.trim()));
	        }

	        List<Conexion> conexiones = new ArrayList<>();
	        System.out.println("Introduce las conexiones:");
	        
	        boolean seguir = true;

	        while (seguir) {
	            System.out.println("Introduce una ciudad de origen (o escribe 'fin' para terminar):");
	            String origenNombre = scanner.nextLine().trim();
	            
	            if (origenNombre.equalsIgnoreCase("fin")) {
	                seguir = false; 
	            } else {
	                System.out.println("Introduce una ciudad de destino:");
	                String destinoNombre = scanner.nextLine().trim();

	                Ciudad origen = ciudades.stream().filter(c -> c.getNombre().equalsIgnoreCase(origenNombre)).findFirst().orElse(null);
	                Ciudad destino = ciudades.stream().filter(c -> c.getNombre().equalsIgnoreCase(destinoNombre)).findFirst().orElse(null);

	                if (origen == null || destino == null) {
	                    System.out.println("Ciudad de origen o destino no encontrada. Por favor, verifica.");
	                } else if (origen.equals(destino)) {
	                    System.out.println("El origen debe ser distinto al destino.");
	                } else {
	                    System.out.println("Introduce el tipo de vehículo (tren, avion, coche, barco):");
	                    String tipoVehiculo = scanner.nextLine().trim().toLowerCase();

	                    if (tipoVehiculo.equals("tren")) {
	                        conexiones.add(new Tren(origen, destino));
	                    } else if (tipoVehiculo.equals("avion")) {
	                        conexiones.add(new Avion(origen, destino));
	                    } else if (tipoVehiculo.equals("coche")) {
	                        conexiones.add(new Coche(origen, destino));
	                    } else if (tipoVehiculo.equals("barco")) {
	                        conexiones.add(new Barco(origen, destino));
	                    } else {
	                        System.out.println("Tipo de vehículo no válido.");
	                    }
	                }
	            }
	        }
	       
	        /*
	        while (true) {
	            System.out.println("Introduce una ciudad de origen (o escribe 'fin' para terminar):");
	            String origenNombre = scanner.nextLine().trim();
	            if (origenNombre.equalsIgnoreCase("fin")) {
	                break;
	            }

	            System.out.println("Introduce una ciudad de destino:");
	            String destinoNombre = scanner.nextLine().trim();

	            Ciudad origen = ciudades.stream().filter(c -> c.getNombre().equalsIgnoreCase(origenNombre)).findFirst().orElse(null);
	            Ciudad destino = ciudades.stream().filter(c -> c.getNombre().equalsIgnoreCase(destinoNombre)).findFirst().orElse(null);
	            

	            	
	            if (origen == null || destino == null) {
	                System.out.println("Ciudad de origen o destino no encontrada. Por favor, verifica.");
	                continue;
	            }
	            
            	
            if (origen.equals(destino)) {
                System.out.println("El origen debe ser distinto al destino");
                continue;
            }

	            System.out.println("Introduce el tipo de vehículo (tren, avion, coche, barco):");
	            String tipoVehiculo = scanner.nextLine().trim().toLowerCase();

	            switch (tipoVehiculo) {
	                case "tren":
	                    conexiones.add(new Tren(origen, destino));
	                    break;
	                case "avion":
	                    conexiones.add(new Avion(origen, destino));
	                    break;
	                case "coche":
	                    conexiones.add(new Coche(origen, destino));
	                    break;
	                case "barco":
	                    conexiones.add(new Barco(origen, destino));
	                    break;
	                default:
	                    System.out.println("Tipo de vehículo no válido.");
	            }
	        }
	        
	        */

	        System.out.println("Introduce la ciudad de origen:");
	        String ciudadOrigenNombre = scanner.nextLine().trim();
	        Ciudad ciudadOrigen = ciudades.stream().filter(c -> c.getNombre().equalsIgnoreCase(ciudadOrigenNombre)).findFirst().orElse(null);

	        System.out.println("Introduce la ciudad de destino:");
	        String ciudadDestinoNombre = scanner.nextLine().trim();
	        Ciudad ciudadDestino = ciudades.stream().filter(c -> c.getNombre().equalsIgnoreCase(ciudadDestinoNombre)).findFirst().orElse(null);

	        if (ciudadOrigen == null || ciudadDestino == null) {
	            System.out.println("La ciudad de origen o destino no es válida.");
	            return;
	        }

	        CalculadorDeRuta calculador = new CalculadorDeRuta(conexiones);
	        calculador.encontrarRuta(ciudadOrigen, ciudadDestino);
	    
	  }
	}