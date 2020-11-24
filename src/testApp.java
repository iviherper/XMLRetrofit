import java.util.HashMap;

public class testApp implements PedirRetrofit.Actualizacion{
public static void main(String[] args) {
	HashMap<String,String> provincias=AccesoBD.getProvincias();
	if(provincias.size()==0) {
		PedirRetrofit.pedirDatos(new testApp());
	}else {
		String provincia = EntradaSalida.pedirOpcion(provincias);
	}
	
}
@Override
public void recuperarDatos(Provinciero p) {
	AccesoBD.insertarProv(p);
	HashMap<String,String> provincias=AccesoBD.getProvincias();
	String provincia = EntradaSalida.pedirOpcion(provincias);
	
}
}