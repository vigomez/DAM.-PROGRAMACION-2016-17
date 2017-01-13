
public class Operaciones {
	
	//Los atributos de la clase se definen como privados
	
	//Ultima operacion realizada
	private int ultimaOp=0;
	
	//Etiqueta para mi LOG
	private static String _NOMBRE="OPERACIONES";
	
	//Los m�todos de la clase se definen p�blicos
	
	//Constructor de Operaciones
	public Operaciones() {
		System.out.println("Entro en "+_NOMBRE);
	}
	
	//Metodos de entrada salida
	
	//Suma de dos n�meros enteros
	public int suma(int op1,int op2){
		ultimaOp=op1+op2;
		return (int)ultimaOp;
	}
	
	//Ejemplo de m�todo sobrecargado: suma acumulativa 
	public int suma(int op1){
		ultimaOp=op1+ultimaOp;
		return (int)ultimaOp;
	}
	
	//Resta dos n�meros enteros
	public int resta(int op1,int op2){
		ultimaOp=op1-op2;
		return (int)ultimaOp;
	}
	
	//multiplicaci�n de dos n�meros enteros
	public int multiplica(int op1,int op2){
		ultimaOp=op1*op2;
		return (int)ultimaOp;
	}
	
	//Division de dos numeros enteros
	public int divide(int op1,int op2){
		ultimaOp= (int) op1/op2;
		return (int) ultimaOp;
	}
	
	//Ejemplo de m�todo con salida pero sin entrada
	//M�todo devolver �ltima operaci�n
	public int ultimaOp(){
		return ultimaOp;
	}
}
