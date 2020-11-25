import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PedirRetrofitMuni {
	static Municipiero m=null;
	public static Municipiero pedirMunis(ActualizacionB a, String provincia) {
	@SuppressWarnings("deprecation")
	Retrofit retrofit = new Retrofit.Builder()
	.baseUrl("http://ovc.catastro.meh.es/")
			.addConverterFactory(SimpleXmlConverterFactory.create()).build();

	PedirMuni servicio = retrofit.create(PedirMuni.class);
	Call<Municipiero> llamada= servicio.pedirMuni(provincia,"");
	
	llamada.enqueue(new Callback<Municipiero>() {

		@Override
		public void onResponse(Call<Municipiero> call, Response<Municipiero> response) {
			m = response.body();
			a.recuperarMunis(m, provincia);
			
		}

		@Override
		public void onFailure(Call<Municipiero> call, Throwable t) {
			System.out.println(t.getLocalizedMessage());
			
		}
	});
	return m;

	}
	public interface ActualizacionB
	{
		public void recuperarMunis(Municipiero m, String provincia);
	}
}
