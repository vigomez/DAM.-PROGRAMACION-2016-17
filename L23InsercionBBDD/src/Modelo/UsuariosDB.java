package Modelo;


import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

//import com.mysql.jdbc.Connection;

/**
*
* Clase que nos permite interactuar con la tabla usuario, de la BBDD usuarios
* 
*/
public class UsuariosDB {
	//Campos de la tabla usuario
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String edad;
	
	//Conexion a la base de datos
	private Connection conexion;
	//Objeto para ejecutar una orden sobre la base de datos
	private Statement orden = null;
	
	//Constructor: recoge la conexión establecida para la base de datos
	public UsuariosDB(Connection c) {
		this.conexion=c;
	}
	
	//Método que permite insertar un usuario en la base de datos
	//La BBDD se llama usuarios, y la tabla correspondiente usuario
	public void insertarUsuario(String nombre,String apellido1,String apellido2,int edad){
		try{
			orden = conexion.createStatement();
		    String sql = "INSERT INTO usuario (nombre,apellido1,apellido2,edad) " +
		                   "VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+")";
		    orden.executeUpdate(sql);
		    System.out.println("Usuario registrado con exito");
		    
		   }catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
		   }catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
		   }finally{
			      //Cerramos los recursos
			      try{
			         if(orden!=null)
			        	 conexion.close();
			      }catch(SQLException se){
			    	  se.printStackTrace();
			      }
			      try{
			         if(conexion!=null)
			        	 conexion.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			}//end try
	}
}
