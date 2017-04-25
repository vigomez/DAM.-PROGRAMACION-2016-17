import java.sql.Connection;

public class Usuarios {
	private static ConexionDB usuariosDB1;
	private static ConexionDB usuariosDB2;
	private static boolean connected1=false;
	private static boolean connected2=false;
	private static Connection conexion1;
	private static Connection conexion2;
	private static modeloUsuarios mUsuario;
	
	public static void main(String[] args) {

		
		//Generado el objeto usuariosDB que creará una única instancia static de esta clase
		usuariosDB1=ConexionDB.getInstance("localhost","usuarios","root","");
		usuariosDB2=ConexionDB.getInstance("localhost","usuarios","root","");
		
		if (usuariosDB2==usuariosDB1)
		{System.out.println("Ya hay una instancia del objeto y no se crea otra diferente\n");}
		
		//Ejemplo para un host externo
		//usuariosDB=ConexionDB.getInstance("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
		
		//Establecemos la conexion
		connected1=usuariosDB1.connectDB();
		connected2=usuariosDB2.connectDB();
		
		//Esta es la conexión
		conexion1=usuariosDB1.getConexion();
		conexion2=usuariosDB2.getConexion();
		
		if (conexion1==conexion2)
		{System.out.println("Solo tengo una conexión\n");}

        //Comprobamos si hemos conectado y sacamos por consola los datos de la tabla
		if(connected1) {
			System.out.println("CONECTADOS CON EXITO\n");
			System.out.println("LISTADO DE USUARIOS\n");
			mUsuario=new modeloUsuarios(conexion1);
			mUsuario.getDatosUsuarios();
            
		}
		else System.out.println("ERROR EN LA CONEXION");
	    }
}
