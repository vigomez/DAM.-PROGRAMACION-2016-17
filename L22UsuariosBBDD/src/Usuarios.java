import java.sql.Connection;

public class Usuarios {
	private static ConexionDB usuariosDB;
	private static boolean connected=false;
	
	public static void main(String[] args) {

		
		//Generado el objeto
		usuariosDB=new ConexionDB("localhost","usuarios","root","");
		
		//Ejemplo para un host externo
		//corredoresDB=ConexionDB.getInstance("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
		
		//Establecemos la conexion
		connected=usuariosDB.connectDB();

        //Comprobamos si hemos conectado
		if(connected) {
			System.out.println("CONECTADOS CON EXITO");
		}
		else System.out.println("ERROR EN LA CONEXION");
	    }
}
