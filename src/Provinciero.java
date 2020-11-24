import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="consulta_provinciero", strict=false)
public class Provinciero {
	@ElementList(name="provinciero")
	List<Prov> provincias;

	public List<Prov> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Prov> provincias) {
		this.provincias = provincias;
	}

	@Override
	public String toString() {
		return "Provinciero [provincias=" + provincias + "]";
	}
	
	
	
}
