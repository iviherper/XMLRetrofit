import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PedirRetrofit {
	static Provinciero p=null;
	public static Provinciero pedirDatos(Actualizacion a) {
	@SuppressWarnings("deprecation")
	Retrofit retrofit = new Retrofit.Builder()
	.baseUrl("http://ovc.catastro.meh.es/")
			.addConverterFactory(SimpleXmlConverterFactory.create()).build();

	PeticionXML servicio = retrofit.create(PeticionXML.class);
	Call<Provinciero> llamada= servicio.pedirProv();
	
	llamada.enqueue(new Callback<Provinciero>() {

		@Override
		public void onResponse(Call<Provinciero> call, Response<Provinciero> response) {
			p = response.body();
			a.recuperarDatos(p);
			
		}

		@Override
		public void onFailure(Call<Provinciero> call, Throwable t) {
			System.out.println(t.getLocalizedMessage());
			
		}
	});
	return p;

	}
	public interface Actualizacion
	{
		public void recuperarDatos(Provinciero p);
	}
}
