
public class Usuarios {
	static ConexionDB usuariosDB;
	static modeloUsuarios mUsuario; //Para sacar lista de BBDD
	
	public static void main(String[] args) {

		
		//Generado el objeto
		usuariosDB=ConexionDB.getInstance("localhost","usuarios","root","");
		
		//Ejemplo para un host externo
		//corredoresDB=ConexionDB.getInstance("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
        //Comprobamos si hemos conseguido conectarnos

		if(usuariosDB.connectDB()==true) {
			System.out.println("CONECTADOS CON EXITO");
			mUsuario=new modeloUsuarios(usuariosDB.getConexion()); //Mostramos todos los elementos de la BBDD
			mUsuario.getDatosUsuarios();
			System.out.println("LISTADO DE USUARIOS");
		}
		else System.out.println("ERROR EN LA CONEXION");
	}

}
