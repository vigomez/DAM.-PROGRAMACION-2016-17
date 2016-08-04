public class UsandoArrays_2 {

	public static void main(String[] args) {
		//array 1: un array de 5 elementos de números enteros
		int[] metodo1=new int[5];
		//array 2:un array de 7 enteros que se inicializa directamente con los valores
		int[] metodo2={3,4,5,0,6,5,4};
		
		//Rellenamos el array metodo1
		metodo1[0]=3;
		metodo1[1]=3;
		metodo1[2]=4;
		metodo1[3]=9;
		metodo1[4]=6;
		
		//Recorrer el array 2
		for(int i=0;i<metodo2.length;i++){
			System.out.println(metodo2[i]);
		}

	}

}