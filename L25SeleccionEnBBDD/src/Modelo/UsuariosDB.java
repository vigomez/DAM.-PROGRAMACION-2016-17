package Modelo;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import java.sql.Connection;
import java.sql.ResultSet;

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
	
	//Constructor: recoge la conexi�n establecida para la base de datos
	public UsuariosDB(Connection c) {
		this.conexion=c;
	}
	
	//M�todo que permite insertar un usuario en la base de datos
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
	
	//M�todo que permite buscar un usuario en la base de datos
		public Usuario buscarUsuario(String nombreBuscar){
			ResultSet rs;
			Usuario u=new Usuario();
			try{
			  orden = conexion.createStatement();
		      String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuario WHERE nombre='"+nombreBuscar+"'";
		      rs = orden.executeQuery(sql);
		      //Cogemos los usuarios y recorremos la BBDD mientras haya datos
		      while(rs.next()){
		    	  u.setId(rs.getInt("id"));
			      u.setNombre(rs.getString("nombre"));
			      u.setApellido1(rs.getString("apellido1"));
			      u.setApellido2(rs.getString("apellido2"));
			      u.setEdad(rs.getInt("edad"));
			      //Cogera todos los usuarios que coincidan en nombre, pero solo devolver� el �ltimo encontrado
			      //porqu� va reescribiendo u
			      System.out.println(u.getId()+" "+u.getNombre()+" "+u.getApellido1()+" "+u.getApellido2()+" "+u.getEdad()+"\n");
		      }
		      //Debemos cerrar la conexion
		      rs.close();
		      return u;
			}catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
				      return u;
			}catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
				      return u;
			}finally{
			      //Cerramos los recursos
			      try{
			         if(orden!=null)
			        	 conexion.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(conexion!=null)
			        	 conexion.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      	 }//end finally try
			}
	}
		
	//M�todo que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
	//Busca los usuarios por el nombre y devuelve todos los que tienen el mismo nombre
	//M�todo sobrecargado
		public void buscarUsuario(String nombreBuscar,JComboBox jc){
			ResultSet rs;
			try{
				orden = conexion.createStatement();
				  /*Si quisi�semos que devolviese todos los usuarios de la BBDD en el COMBOX har�amos
				   * String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuarios";
				   * y eliminar�amos el input de nombreBuscar en el m�todo
				   */
			      String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuario WHERE nombre='"+nombreBuscar+"'";
			      rs = orden.executeQuery(sql);
				//Cogemos los usuarios
				      while(rs.next()){
				    	  Usuario u=new Usuario(); //Se generar� un usuario por cada coincidencia
				    	  u.setId(rs.getInt("id"));
					      u.setNombre(rs.getString("nombre"));
					      u.setApellido1(rs.getString("apellido1"));
					      u.setApellido2(rs.getString("apellido2"));
					      u.setEdad(rs.getInt("edad"));
					      //A�adimos el usuario encontrado al JComboBox
					      //El usuario no "ser� destruido" al salir del m�todo porque se almacena en un objeto
					      //superior que lo guarda, que es el jc (un objeto ComboBox)
					      jc.addItem(u);
					      //Comprobaci�n por monitor
					      System.out.println("Coincidencias: "+u.toString()+"\n");
				      }
				    //Debemos cerrar la conexion
				      rs.close();
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
					      }
					      try{
					         if(conexion!=null)
					        	 conexion.close();
					      	 }catch(SQLException se){
					         se.printStackTrace();
					      	 }//end finally try
					}
		}		
}
