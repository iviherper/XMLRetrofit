import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AccesoBD {
	public static Connection crearConexion() {
		Connection conexion= null;
		try
		{
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conexion = DriverManager.getConnection ("jdbc:mysql://localhost/test?serverTimezone=UTC","root", "");
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		return conexion;
	}
//	public static boolean comprobarBD() {
//		Statement sm;
//		boolean exist=false;
//		try {
//			sm = crearConexion().createStatement();
//			ResultSet rs = sm.executeQuery("Select * from provincias");
//			if(rs.next())
//				exist=true;
//			crearConexion().close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return exist;
//	}
	public static void insertarProv(Provinciero p) {
		Statement sm;
		try {
			sm = crearConexion().createStatement();
			for (Prov pr : p.getProvincias()) {
				sm.executeUpdate("Insert into provincias (cpine,np) values ('"+pr.getCpine()+"','"+pr.getNp()+"')");
			}
						
			crearConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static HashMap<String, String> getProvincias() {
		Statement sm;
		HashMap<String, String> provs = new HashMap();
		try {
			sm = crearConexion().createStatement();
			ResultSet rs = sm.executeQuery("Select * from provincias");
			while(rs.next()) {
				provs.put(rs.getString(1), rs.getString(2));
			}
			crearConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provs;
	}
	public static List<String> getMunicipios(String provincia) {
		Statement sm;
		List<String> munis = new ArrayList();
		try {
			sm = crearConexion().createStatement();
			ResultSet rs = sm.executeQuery("Select * from municipios where provincia='"+provincia+"'");
			while(rs.next()) {
				munis.add(rs.getString(1));
			}
			crearConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return munis;
	}
	public static void insertarMunis(Municipiero m, String provincia) {
		Statement sm;
		try {
			sm = crearConexion().createStatement();
			if(m.getMuni()==null) {
				System.out.println("m es nul");
			}else {
			for (Muni mu : m.getMuni()) {
				sm.executeUpdate("Insert into municipios (muni,provincia) values ('"+mu.getNm()+"','"+provincia+"')");
			}
			}		
			crearConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
