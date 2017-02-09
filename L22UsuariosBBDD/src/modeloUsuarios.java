
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;


public class modeloUsuarios {
	//DEVOLVER usuarios
	
	//Query para la base de datos. La tabla es usuario.
	private static String USUARIOS_LIST="SELECT * FROM usuario";
	
	private static String ID_COL="id";
	private static String NOMBRE_COL="nombre";
	private static String APELLIDO1_COL="apellido1";
	private static String APELLIDO2_COL="apellido2";
	private static String EDAD_COL="edad";
	
	private static String COLUMNAS[]={ID_COL,NOMBRE_COL,APELLIDO1_COL,APELLIDO2_COL,EDAD_COL};
	
	//Conexion
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	
	public modeloUsuarios(Connection conexion) {
		this.conexion=conexion;
	}
	
	public void getDatosUsuarios(){
		try{
			instruccion = this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery(USUARIOS_LIST);

			//Listaremos por pantalla los datos
			while( conjuntoResultados.next() ) {
				System.out.print(conjuntoResultados.getInt(ID_COL)+";");
				System.out.print(conjuntoResultados.getString(NOMBRE_COL)+";");
				System.out.print(conjuntoResultados.getString(APELLIDO1_COL)+";");
				System.out.print(conjuntoResultados.getString(APELLIDO2_COL)+";");
				System.out.print(conjuntoResultados.getInt(EDAD_COL)+";");
			}// fin de while
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
		}
		finally{
			try{
				conjuntoResultados.close();
				instruccion.close();
				conexion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
	
	

}
