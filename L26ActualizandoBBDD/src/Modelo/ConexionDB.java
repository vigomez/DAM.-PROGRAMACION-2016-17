package Modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;

/*Clase para conectar a una BBDD*/

public class ConexionDB {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";
	
	//DATOS DE LA BBDD
	private String host; //host donde est� la base de datos
	private String bbdd; //nombre de la base de datos
	private String user; //nombre usuario para acceder base de datos
	private String pass; //password de usuario
	private String url;  //proporcionar� al m�todo DriverManager la direcci�n de conexi�n
	                     //en la forma adeduaca
	
	//Conexion
	private Connection conexion = null;// maneja la conexi�n
	
	
	//Constructor (le pasaremos los datos necesarios para la conexi�n)
	
	public ConexionDB(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
	}
	
	
	//M�todo para conectarse con la BBDD: true si ha conseguido conectarse
	public boolean connectDB(){
		try{
			//Lo primero es cargar el controlador MySQL el cual autom�ticamente se registra
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) //No encuentra la Base de Datos
		{
			excepcionSql.printStackTrace();
			return false;
        }
		catch( ClassNotFoundException noEncontroClase) //No encuentra el driver para la conexi�n
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Devuelve una instancia de la conexi�n
	public Connection getConexion(){
		return this.conexion;
	}

}
