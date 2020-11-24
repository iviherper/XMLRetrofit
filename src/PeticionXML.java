import retrofit2.Call;
import retrofit2.http.GET;

public interface PeticionXML {
	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
	  Call<Provinciero> pedirProv();
}
