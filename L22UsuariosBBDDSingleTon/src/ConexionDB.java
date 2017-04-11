

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;

public class ConexionDB {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS DE LA BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	
	//Instancia unica
	private static ConexionDB instance = null;
	
	//Para implementar el patrón SingleTon el constructor de la clase se define como private
	private ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	//Implementar SingleTon: solo se crea un objeto de la clase si no hay otro creado y se define static
	//de manera que solo hay una copia del mismo y su valor es compartido por todos los objetos de la clase, por lo que
	//no se podrá crear un nuevo objeto ConexionDB.
	
	public static ConexionDB getInstance(String HOST,String BBDD,String USER,String PASS) {
	      if(instance == null) {
	         instance = new ConexionDB(HOST,BBDD,USER,PASS);
	         return instance;
	      }
	      return null;
	      //Si aquí hiciésemos return instance; se devolvería un objeto idéntico al creado anteriormente.
	   }
	
	//Conectamos con la BBDD
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch( ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Permite recoger la conexión establecida
	public Connection getConexion(){
		return this.conexion;
	}

}

