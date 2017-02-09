
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConexionDB {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS DE LA BBDD
	private String host; //host donde está la base de datos
	private String bbdd; //nombre de la base de datos
	private String user; //nombre usuario para acceder base de datos
	private String pass; //password de usuario
	private String url;  //proporcionará al método DriverManager la dirección de conexión
	                     //en la forma adeduaca
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	
	//Instancia unica: debemos garantizar que se genera una única conexión, una única instancia
	//de conexión con un único punto de acceso a ella. Esto se denomina patrón SingleTon:
	//restringir la creación de objetos pertenecientes a una clase o el valor de un tipo a un único objeto.
	private static ConexionDB instance = null;
	
	//Constructor (le pasaremos los datos necesarios para la conexión)
	
	private ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	//Implementar SingleTon
	public static ConexionDB getInstance(String HOST,String BBDD,String USER,String PASS) {
	      if(instance == null) {
	         instance = new ConexionDB(HOST,BBDD,USER,PASS);
	      }
	      return instance;
	   }
	
	//Método para conectarse con la BBDD: true si ha conseguido conectarse
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual automáticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) //No encuentra la Base de Datos
		{
			excepcionSql.printStackTrace();
			return false;
        }
		catch( ClassNotFoundException noEncontroClase) //No encuentra el driver para la conexión
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Devuelve una instancia de la conexión
	public Connection getConexion(){
		return this.conexion;
	}

}
