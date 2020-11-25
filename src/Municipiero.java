import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
@Root(name="consulta_municipiero", strict=false)
public class Municipiero {
	@ElementList (name = "municipiero")
	List<Muni> muni;

	public List<Muni> getMuni() {
		return muni;
	}

	public void setMuni(List<Muni> muni) {
		this.muni = muni;
	}

	@Override
	public String toString() {
		return "Municipiero [muni=" + muni + "]";
	}
	
	
}
