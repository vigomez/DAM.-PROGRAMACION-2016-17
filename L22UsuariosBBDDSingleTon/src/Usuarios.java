import java.sql.Connection;

public class Usuarios {
	private static ConexionDB usuariosDB;
	private static ConexionDB usuariosDB2;
	private static boolean connected=false;
	private static Connection conexion;
	private static modeloUsuarios mUsuario;
	
	public static void main(String[] args) {

		
		//Generado el objeto usuariosDB que crear� una �nica instancia static de esta clase
		usuariosDB=ConexionDB.getInstance("localhost","usuarios","root","");
		usuariosDB2=ConexionDB.getInstance("localhost","usuarios","root","");
		
		if (usuariosDB2==usuariosDB)
		{System.out.println("Ya hay una instancia del objeto y no se crea otra diferente\n");}
		
		//Ejemplo para un host externo
		//usuariosDB=ConexionDB.getInstance("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
		
		//Establecemos la conexion
		connected=usuariosDB.connectDB();
		
		//Esta es la conexi�n
		conexion=usuariosDB.getConexion();

        //Comprobamos si hemos conectado y sacamos por consola los datos de la tabla
		if(connected) {
			System.out.println("CONECTADOS CON EXITO\n");
			System.out.println("LISTADO DE USUARIOS\n");
			mUsuario=new modeloUsuarios(conexion);
			mUsuario.getDatosUsuarios();
            
		}
		else System.out.println("ERROR EN LA CONEXION");
	    }
}
