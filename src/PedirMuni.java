import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PedirMuni {
	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio")
	  Call<Municipiero> pedirMuni(@Query("Provincia") String provincia,@Query("Municipio") String n);
}
