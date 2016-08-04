import visual.*; //importamos las clases que hemos puesto en nuestro package visual

public class Principal {
	static Ventana1 v1;
	static Ventana2 v2;
	public static void main(String[] args) {
		v1=new Ventana1();
		v1.setVisible(true);
		
		v2=new Ventana2();
		v2.setVisible(true); 
	}
	

}
