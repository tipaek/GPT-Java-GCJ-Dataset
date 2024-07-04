import java.util.Arrays;
import java.util.Scanner;
public class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int c=1; c<=T; c++){
            int n = s.nextInt();
            int d = s.nextInt();
            long arreglo[] = new long[n];
            for(int i=0; i<n; i++){
                arreglo[i] = s.nextLong();
            }
            Arrays.sort(arreglo);
            int iguales = 1;
            int solucion = 2;
            int indice = 0;
            for(int i=0; i<arreglo.length-1;i++){
                if( arreglo[i] == arreglo[i+1] ){
                    if( i+2 < arreglo.length ){
                        if( arreglo[i+1] == arreglo[i+2] ){
                            iguales = 3;
                            break;
                        }
                    }
                    iguales = 2;
                    indice = i;
                }
            }
            if( iguales == 2 && d == 2){
                solucion = 0;
            }
            else if( d==2 ){
                solucion = 1;
            }
            else if( iguales == 3 ){
                solucion = 0;
            }
            else if( iguales == 2 ){
                for(int i=0; i<d; i++){
                    if( arreglo[i] > arreglo[indice] ){
                        solucion = 1;
                        break;
                    }
                }
            }
            else if( d == 3 ){
                for(int i=0; i<n; i++){
                    for(int j=1; j<n; j++){
                        if( ( arreglo[i] == arreglo[j] / 2 && arreglo[j]%2==0 ) || (arreglo[j] == arreglo[i] / 2 && arreglo[i]%2 == 0 )){
                            solucion = 1;
                        }
                    }
                }
            }
            System.out.println("Case #"+c+": "+solucion);
        }
    }
}
