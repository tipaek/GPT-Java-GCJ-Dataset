import java.util.Scanner;

public class Vestige{
    public static int calcularDiagonal(int [][] x, int tamano){
        int w = -1;
        int resul = 0;
        for(int i = 0; i < tamano; i++){
            w++;
            for(int j = 0; j < tamano; j++){
                resul = x [i][w];    
            }
        }
    }
    
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);
        int casos = entrada.nextInt();
        int altoancho = entrada.nextInt();
        int [][] array = new int [altoancho][altoancho];
        for(int i = 0; i < altoancho; i++){
            for(int x = 0; x < altoancho; x++){
                String cadena = entrada.next().trim();
                cadena.replace(" ", "");
                array[i][x] = Character.getNumericValue(cadena.charAt(x));
            }
            
            
        }
        
        
        
    }
    
}


