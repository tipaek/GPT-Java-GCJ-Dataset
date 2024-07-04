import java.util.Scanner;
public class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int A = (int)'A';
        for(int c=1; c<=T; c++){
            s.nextInt();
            int letras[] = new int[26];
            int letrasParaElCero[] = new int[26];
            for(int i=0; i<26; i++){
                letras[i] = 0;
                letrasParaElCero[i] = 0;
            }
            for(int i=0; i<10000; i++){
                s.next(); //Qi
                String respuesta = s.next();
                char arreglo[] = respuesta.toCharArray();
                for(int j=0; j<arreglo.length; j++){
                    int numero = (int)arreglo[j] - A;
                    if(j == 0){
                        letras[numero]++;
                    }
                    else{
                        letrasParaElCero[numero] = 1;
                    }
                }
            }
            String salida = "";
            for(int j=0;j<10;j++){
                int mayor = 0;
                for(int k=1;k<26;k++){
                    if( letras[mayor] < letras[k] ){
                        mayor = k;
                    }
                }
                letras[mayor] = 0;
                letrasParaElCero[mayor] = 0;
                if( j == 9 ){
                    mayor = 0; 
                    for(int k=1;k<26;k++){
                        if( letrasParaElCero[mayor] < letrasParaElCero[k] ){
                            mayor = k;
                        }
                    }
                    salida = (char)(mayor + A) + salida;
                }
                else{
                    salida = salida + (char)(mayor + A); 
                }
            }
            System.out.println("Case #"+c+": "+salida);
        }
    }
}

