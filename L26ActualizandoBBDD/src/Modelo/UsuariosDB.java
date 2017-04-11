package Modelo;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	//Método que permite buscar un usuario en la base de datos
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
			      //Cogera todos los usuarios que coincidan en nombre, pero solo devolverá el último encontrado
			      //porqué va reescribiendo u
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
		
	//Método que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
	//Busca los usuarios por el nombre y devuelve todos los que tienen el mismo nombre
	//Método sobrecargado
		public void buscarUsuario(String nombreBuscar,JComboBox jc){
			ResultSet rs;
			try{
				orden = conexion.createStatement();
				  /*Si quisiésemos que devolviese todos los usuarios de la BBDD en el COMBOX haríamos
				   * String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuarios";
				   * y eliminaríamos el input de nombreBuscar en el método
				   */
			      String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuario WHERE nombre='"+nombreBuscar+"'";
			      rs = orden.executeQuery(sql);
				//Cogemos los usuarios
				      while(rs.next()){
				    	  Usuario u=new Usuario(); //Se generará un usuario por cada coincidencia
				    	  u.setId(rs.getInt("id"));
					      u.setNombre(rs.getString("nombre"));
					      u.setApellido1(rs.getString("apellido1"));
					      u.setApellido2(rs.getString("apellido2"));
					      u.setEdad(rs.getInt("edad"));
					      //Añadimos el usuario encontrado al JComboBox
					      //El usuario no "será destruido" al salir del método porque se almacena en un objeto
					      //superior que lo guarda, que es el jc (un objeto ComboBox)
					      jc.addItem(u);
					      //Comprobación por monitor
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
		
		//Método que permite buscar actualizar un usuario en la base de datos usando la
		//sentencia SQL UPDATE
				public void actualizarUsuario(Usuario u){
					try{
					  orden = conexion.createStatement();
					  //Configuramos la sentencia sql para actualizar el usuario en la tabla usuario
					  //El usuario se busca por su clave primaria, que es única.
				      String sql = "UPDATE usuario " +
			                       "SET nombre = '"+u.getNombre()+"'"+
			                       ",apellido1 = '"+u.getApellido1()+"'"+
			                       ",apellido2 = '"+u.getApellido2()+"'"+
			                       ",edad = "+u.getEdad()+" "+
				    		       "WHERE id = "+u.getId();
				      
				      orden.executeUpdate(sql); //Ejecutamos la sentencia SQL de UPDATE
				      //Comprobación por monitor
				      System.out.println(sql+"\n");
				      System.out.println("Actualizado: "+u.toString()+"\n");
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
					        	 orden.close();
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

				//Método que permite buscar actualizar un usuario en la base de datos con un preparedStatement
				
				/* Es posible que haya sentencias SQL que tengamos que ejecutar varias veces durante la sesión,
				 *aunque sea con distintos parámetros.El mecanismo que preven las bases de datos para hacer más 
				 *eficiente este proceso es que le indiquemos, previamente, el tipo de sentencia que vamos a usar, 
				 *de forma que la base de datos la "precompila" y la guarda en condiciones de ser ejecutada cuantas
				 *veces se necesite pasándole en cada caso el valor de los parámetros señalados con una ?, y sin 
				 *necesidad de reescriber para cada caso particular la sentencia.
				 *
				 */
				public void actualizarUsuarioPreparada(Usuario u){
					try{
					  orden = conexion.createStatement();
					// create the java mysql update preparedstatement
					// Creamos la sentencia "tipo" que queremos ejecutar
				      String sql = "UPDATE usuario " +
			                       "SET nombre = ?"+
			                       ",apellido1 = ?"+
			                       ",apellido2 = ?"+
			                       ",edad = ? "+
				    		       "WHERE id = "+u.getId();
				      PreparedStatement preparedStmt = conexion.prepareStatement(sql);
				      
				      //Asignamos valores concretos a ?
				      preparedStmt.setString(1, u.getNombre());
				      preparedStmt.setString(2, u.getApellido1());
				      preparedStmt.setString(3, u.getApellido2());
				      preparedStmt.setInt(4, u.getEdad());
				 
				      // Se ejecuta la consulta y el update
				      
				      preparedStmt.executeUpdate();
				      
				      //Comprobación por monitor
				      System.out.println(sql+"\n");
				      System.out.println("Actualizado: "+u.toString()+"\n");
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
					        	 orden.close();
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
