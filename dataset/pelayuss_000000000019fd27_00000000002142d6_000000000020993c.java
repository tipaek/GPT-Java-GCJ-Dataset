import java.util.Scanner;
class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0; i < T; i++){
            int n = s.nextInt();
            int array[][]= new int[n][n];
            int traza = 0;
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    array[j][k] = s.nextInt();
                    if( j==k ){
                        traza = traza + array[j][j];
                    }
                }
            }
            int repeticionesX = 0;
            int repeticionesY = 0;
            for(int j=0; j<n; j++){
                boolean numeros[] = new boolean[n]; 
                for(int k=0; k<n; k++){
                    numeros[array[j][k]-1] = true;
                }
                for(int k=0; k<n; k++){
                    if(!numeros[k]){
                        repeticionesY++;
                        break;
                    }
                }
            }
            for(int j=0; j<n; j++){
                boolean numeros[] = new boolean[n]; 
                for(int k=0; k<n; k++){
                    numeros[array[k][j]-1] = true;
                }
                for(int k=0; k<n; k++){
                    if(!numeros[k]){
                        repeticionesX++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+traza+" "+repeticionesY+" "+repeticionesX);
        }
    }
}