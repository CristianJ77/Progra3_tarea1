package progra3_busqueda_binaria_y_ordenamiento_seleccion;

import java.util.Arrays;
import java.util.Scanner;

public class Clase_principal {
	
    public static void main(String[] args) {
    	
    	//llamada al método 
    	array();	    	
    
    }
    	//método array
    	public static void array() {
    	String datos[] = new String[50];
    	int edades[] = new int [50];
    	int dpi[] = new int [50];
        Scanner read = new Scanner(System.in);
        
        //creación del array (nombre, edad y DPI)
        for (int i = 0; i < 50; i++) {
            System.out.println("Ingrese nombre (persona no." +(i+1)+")");
            datos[i]= read.next();
            System.out.println("Ingrese edad: ");
            edades[i]= read.nextInt();
            System.out.println("Ingrese dpi: ");
            dpi[i]= read.nextInt();
            
            System.out.println("¿Desea ingresar datos de otra persona? ");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int decision = read.nextInt();
            
            switch(decision) {
            case 1:
            	//continúa el array
            	i = i++;
            	break;
            	
            case 2:
            	i=1;
            	//Asignar variables para mostrar
                int dpis[] = new int[i];
                int edad[] = new int[i];
                String nombre[] = new String[i];

                //Recorrer el array para agregar valor a las variables
                for (int j = 0; j<i; j++){
                    nombre[j] = datos[j];
                    edad[j]= edades[j];
                    dpis[j] = dpi[j];
                }
                
                //llamada al metodo de ordenamiento por selección
                ordenamientoSeleccion(dpis,edad,nombre);

            	//menu de opciones
                System.out.println("Ingrese la opción que desea elegir: ");
                System.out.println("1. Mostrar todo ");
            	System.out.println("2. Buscar DPI");
                int op = read.nextInt();
            	
                //mostrar todos los datos ingresados
                if (op == 1) {
                System.out.print("Nombres ingresados: " + Arrays.toString(nombre));
                System.out.print("Edades ingresadas: " + Arrays.toString(edad));
                System.out.print("DPI ingresados: " + Arrays.toString(dpis));      
    }
                //Buscar DPI
                if(op == 2) {
                  	System.out.println("Ingrese valor a buscar");
            		int search = read.nextInt();
            		
            		System.out.println("DPI: " + dpis[binarySearch(dpis,search)] + 
            				" Nombre: " + dpis[binarySearch(dpis,search)] + 
            				" Edad: " + dpis[binarySearch(dpis,search)]);
                }else {
                    System.out.println("No existe o no ha sido ingresado");
                }
            	break;
                }
            }
        }	
   
      
    	
		//Método ordenamiento por selección
    	public static void ordenamientoSeleccion(int dpi2[],int edades[], String nombres[]) {
            int indiceMenor;

            for (int i = 0;i<dpi2.length; i++) {
                indiceMenor = i;
                
                for (int j = i+1; j<dpi2.length; j++) {
                    if (dpi2[j] < dpi2[indiceMenor]) {
                        indiceMenor = j;
                    }
                }
                if (i != indiceMenor) {
                    intercambiar(dpi2, i, indiceMenor,edades,nombres);
                }
            }
        }
        	
        //Intercambiando valores con variables auxiliares
    	static void intercambiar(int[] dpi3, int i, int j,int edades[] ,String nombres[]) {
            int aux = dpi3[i];
            int aux2 = edades[i];
            String aux3 = nombres[i];
            dpi3[i] = dpi3[j];
            dpi3[j] = aux;
            edades[i] = edades[j];
            edades[j] = aux2;
            nombres[i] = nombres[j];
            nombres[j] = aux3;
        }

    	
        	//Método búsqueda binaria
        	public static int binarySearch(int[] number, int numberToSearch) {
        	    
      		  int size = number.length;  // Número de elementos
      		  int middle = size/2;        // Mitad del array
      		    
      		  if (number[middle] == numberToSearch)
      		    return middle;
      		  else if (size == 1)
      		    return -1;
      		  else if (number[middle] > numberToSearch)
      		    return binarySearch(Arrays.copyOfRange(number,0,middle),numberToSearch); //llamada recursiva
      		  else
      		    return binarySearch(Arrays.copyOfRange(number,middle+1,size),numberToSearch);    
      		}
     }       	
        

