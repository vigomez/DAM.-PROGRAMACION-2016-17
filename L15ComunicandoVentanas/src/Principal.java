import Ventanas.Login;
import Ventanas.VentanaPrincipal;
//Importamos de nuestro paquete Ventanas las dos clases allí implementadas: Login, VentanaPrincipal
public class Principal {

	public static void main(String[] args) {
		//Todas las ventanas a utilizar
		VentanaPrincipal vPrincipal=new VentanaPrincipal();
		
		Login login=new Login(vPrincipal);
		login.setVisible(true); //Lanzamos la ventana login

	}

}