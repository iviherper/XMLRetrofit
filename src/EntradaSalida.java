import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EntradaSalida {

	public static String pedirOpcion(HashMap<String, String> provincias) {
		Scanner in = new Scanner(System.in);
		mostrarMenu(provincias);
		String opcion = in.nextLine();
		return opcion;
	}

	private static void mostrarMenu(HashMap<String, String> provincias) {
		System.out.println("Escribe el codigo de provincia que desea consultar:");
		System.out.println("Codigo --- Provincia");
		provincias.forEach((k,v) -> System.out.println("  "+ k + "   ---   " + v));		
	}

	public static void mostrarMunis(List<String> municipios, String provincia) {
		System.out.println("Los municipios de "+provincia+" son:");
		for (String string : municipios) {
			System.out.println(string);
		}
	}
	
	
}
