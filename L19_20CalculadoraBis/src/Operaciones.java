
public class Operaciones {
	
	//Los atributos de la clase se definen como privados
	
	//Ultima operacion realizada
	private int ultimaOp=0;
	
	//Etiqueta para mi LOG
	private static String _NOMBRE="OPERACIONES";
	
	//Los métodos de la clase se definen públicos
	
	//Constructor de Operaciones
	public Operaciones() {
		System.out.println("Entro en "+_NOMBRE);
	}
	
	//Metodos de entrada salida
	
	//Suma de dos números enteros
	public int suma(int op1,int op2){
		ultimaOp=op1+op2;
		return (int)ultimaOp;
	}
	
	//Ejemplo de método sobrecargado: suma acumulativa 
	public int suma(int op1){
		ultimaOp=op1+ultimaOp;
		return (int)ultimaOp;
	}
	
	//Resta dos números enteros
	public int resta(int op1,int op2){
		ultimaOp=op1-op2;
		return (int)ultimaOp;
	}
	
	//multiplicación de dos números enteros
	public int multiplica(int op1,int op2){
		ultimaOp=op1*op2;
		return (int)ultimaOp;
	}
	
	//Division de dos numeros enteros
	public int divide(int op1,int op2){
		ultimaOp= (int) op1/op2;
		return (int) ultimaOp;
	}
	
	//Ejemplo de método con salida pero sin entrada
	//Método devolver última operación
	public int ultimaOp(){
		return ultimaOp;
	}
}
