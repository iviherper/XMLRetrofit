import java.util.HashMap;
import java.util.List;

public class testApp implements PedirRetrofit.Actualizacion, PedirRetrofitMuni.ActualizacionB{
public static void main(String[] args) {
	HashMap<String,String> provincias=AccesoBD.getProvincias();
	if(provincias.size()==0) {
		PedirRetrofit.pedirDatos(new testApp());
	}else {
		String codpro = EntradaSalida.pedirOpcion(provincias);
		String provincia=provincias.get(codpro);
		List <String> municipios=AccesoBD.getMunicipios(provincia);
		if(municipios.isEmpty()) {
			PedirRetrofitMuni.pedirMunis(new testApp(),provincia);
		}else {
			EntradaSalida.mostrarMunis(municipios,provincia);
		}
	}
	
}
@Override
public void recuperarDatos(Provinciero p) {
	AccesoBD.insertarProv(p);
	HashMap<String,String> provincias=AccesoBD.getProvincias();
	String codpro = EntradaSalida.pedirOpcion(provincias);
	String provincia=provincias.get(codpro);
	List <String> municipios=AccesoBD.getMunicipios(provincia);
	if(municipios.size()==0) {
		PedirRetrofitMuni.pedirMunis(new testApp(),provincia);
	}else {
		EntradaSalida.mostrarMunis(municipios,provincia);
	}
	
}
@Override
public void recuperarMunis(Municipiero m, String provincia) {
	AccesoBD.insertarMunis(m, provincia);
	List <String> municipios=AccesoBD.getMunicipios(provincia);
	EntradaSalida.mostrarMunis(municipios,provincia);
}


}