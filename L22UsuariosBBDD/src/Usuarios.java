
public class Usuarios {
	static ConexionDB corredoresDB;
	static modeloUsuarios mCorredor; //Para sacar lista de BBDD
	
	public static void main(String[] args) {

		
		//Generado el objeto
		corredoresDB=ConexionDB.getInstance("localhost","usuarios","root","");
		
		//Ejemplo para un host externo
		//corredoresDB=ConexionDB.getInstance("mysql.hostinger.es","u499092340_dam20","u499092340_dam20","12345");
		
        //Comprobamos si hemos conseguido conectarnos

		if(corredoresDB.connectDB()==true) {
			System.out.println("CONECTADOS CON EXITO");
			mCorredor=new modeloUsuarios(corredoresDB.getConexion());
			mCorredor.getDatosUsuarios();
			System.out.println("LISTADO DE USUARIOS");
		}
		else System.out.println("ERROR EN LA CONEXION");
	}

}
