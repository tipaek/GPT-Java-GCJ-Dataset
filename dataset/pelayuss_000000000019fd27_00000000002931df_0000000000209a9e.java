import java.util.Scanner;
class Solution{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int B = s.nextInt();
        for(int i=1; i<T+1; i++){
            int arreglo[]= new int[B];
            int terminados = 0;
            int inicio = 0;
            int fin = B-1;
            for(int j=0; j<150; j++){
                if( j<10 || (j%10 != 0 && j%10 != 1) ){
                    if(j%2 ==0 ){
                        System.out.println(inicio+1);
                        arreglo[inicio] = s.nextInt();
                        inicio++;
                        terminados++;
                    }
                    else{
                        System.out.println(fin+1);
                        arreglo[fin] = s.nextInt();
                        fin--;
                        terminados++;
                    }
                    if(terminados == B){
                        print(arreglo);
                        String basura = s.next();
                        break;
                    }
                }
                else if( j%10 == 0 ){
                    int importantes[] = coords(arreglo, inicio);
                    if( importantes[0] == -1 || importantes[0] == -2 ){
                        System.out.println(1);
                        int valor = s.nextInt();
                        if( valor != arreglo[0]){
                            arreglo = complemento(arreglo, inicio);
                        }
                        System.out.println(B);
                    }
                    else{
                        System.out.println( importantes[0] + 1 );
                        int valor1 = s.nextInt();
                        System.out.println( importantes[1] + 1 );
                        int valor2 = s.nextInt();
                        if( arreglo [ importantes[0] ] != valor1  && arreglo[ importantes[1] ] != valor2){
                            arreglo = complemento(arreglo, inicio);
                        }
                        else if( arreglo [ importantes[0] ] == valor1  && arreglo[ importantes[1] ] != valor2 ){
                            arreglo = reversa(complemento(arreglo, inicio), inicio);
                        }
                        else if( arreglo [ importantes[0] ] != valor1  && arreglo[ importantes[1] ] == valor2 ){
                            arreglo = reversa(arreglo, inicio);
                        }

                    }
                    j++;
                }
            }
        }
    }
    public static void print(int ar[]){
        String salida = "";
        for(int i=0; i<ar.length; i++){
            salida = salida + ar[i];
        }
        System.out.println(salida);
    }
    public static int[] coords(int arr[], int inicio){
        int salida[] = new int[4];
        boolean esPalindromo = true;
        for(int i=0; i<inicio; i++){
            if( arr[i] != arr[arr.length - i - 1]  ){
                esPalindromo = false;
                salida[0] = i;
                salida[3] = arr.length - i - 1;
                break;
            }
        }
        boolean esAntiPalindromo = true;
        for(int i=0; i<inicio; i++){
            if( arr[i] == arr[arr.length - i - 1]  ){
                esAntiPalindromo = false;
                salida[1] = i;
                salida[2] = arr.length - i - 1;
                break;
            }
        }
        if(esPalindromo){
            for(int i=0; i<4; i++){
                salida[i] = -1;
            }
            return salida;
        }
        if(esAntiPalindromo){
            for(int i=0; i<4; i++){
                salida[i] = -2;
            }
            return salida;
        }
        return salida; 
    }
    public static int[] complemento(int arreglo[], int inicio){
        for(int i=0; i<inicio; i++){
            arreglo[i] = 1 - arreglo[i];
            arreglo[arreglo.length - 1 - i] = 1 - arreglo[arreglo.length - 1 - i];
        }
        return arreglo;
    }
    public static int[] reversa(int arreglo[], int inicio){
        for(int i=0; i< inicio; i++){
            int aux = arreglo[i];
            arreglo[i] = arreglo[ arreglo.length - 1 - i ];
            arreglo[ arreglo.length - 1 - i ] = aux;
        }
        return arreglo;
    }
}