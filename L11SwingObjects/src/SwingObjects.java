public class SwingObjects{


	/**
	 * Launch the application: Programa de ventanas.
	 */
	public static void main(String[] args) {
	
			//Generamos un objeto ventana de la clase VentanaPrincipal
			System.out.println("Bienvenidos a mi programa de ventanas");
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.cambiarMsg("Es una prueba cambio mensaje");
			ventana.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public SwingObjects() {
	}

}
