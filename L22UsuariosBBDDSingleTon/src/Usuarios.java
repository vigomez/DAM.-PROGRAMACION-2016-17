import java.sql.Connection;

public class Usuarios {
	private static ConexionDB usuariosDB;
	private static boolean connected=false;
	private static Connection conexion;
	private static modeloUsuarios mUsuario;
	
	public static void main(String[] args) {

		
		//Generado el objeto
		//Generado el objeto
		usuariosDB=ConexionDB.getInstance("localhost","usuarios","root","");
		
		//Ejemplo para un host externo
		//usuariosDB=ConexionDB.getInstance("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
		
		//Establecemos la conexion
		connected=usuariosDB.connectDB();
		
		//Esta es la conexión
		conexion=usuariosDB.getConexion();

        //Comprobamos si hemos conectado y sacamos por consola los datos de la tabla
		if(connected) {
			System.out.println("CONECTADOS CON EXITO\n");
			mUsuario=new modeloUsuarios(conexion);
			mUsuario.getDatosCorredores();
            System.out.println("LISTADO DE CORRREDORES\n");
		}
		else System.out.println("ERROR EN LA CONEXION");
	    }
}
