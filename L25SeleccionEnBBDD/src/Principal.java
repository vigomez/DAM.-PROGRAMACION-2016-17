
import Vista.BuscaBDjCBox;
import Vista.BuscaEnBBDD;


/**
* Lanza la Aplicacion
*/
public class Principal {

	public static void main(String[] args) {
		BuscaEnBBDD frame = new BuscaEnBBDD(); //B�squeda
		BuscaBDjCBox frame2= new BuscaBDjCBox(); //B�squeda asociada a un ComboBox
		frame.setVisible(true);	
		frame2.setVisible(true);
	}

}
