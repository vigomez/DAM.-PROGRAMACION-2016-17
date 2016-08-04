public class UsandoArrays_1 {

	public static void main(String[] args) {
		
		/*Una forma poco eficaz de por ejemplo calcular una media de notas
		//Las calificaciones
		flota media;
		int nota1=0,nota2=4,nota3=6,nota4=9;
		media=(nota1+nota2+nota3+nota4)/4;
		*/
		
		//lo mismo usando Arrays
		//tipo[] nombreArray=new tipo[numero de elementos]
		
		//Creamos un Array de números enteros con 10 elementos
		int[] calificacion=new int[10];
		float media;
		
		
		//Rellenamos los elementos del array
		calificacion[0]=0;
		calificacion[1]=4;
		calificacion[2]=6;
		calificacion[3]=7;
		calificacion[4]=8;
		calificacion[9]=4;
		calificacion[8]=5;
		calificacion[7]=5;
		calificacion[6]=5;
		calificacion[5]=9;
		
		//Calcular la media de un array de calificaciones
		//nombrearray.legnth, devuelve el número de elemtos del array
		
		media=0;
		for(int pos=0;pos<calificacion.length;pos++){
			media=media+calificacion[pos];
			System.out.println("media: "+media);
		}
		
		media=media/calificacion.length;
		System.out.println("media: "+media);
	}
		

}
