import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer casos = sc.nextInt();
        
        for(int caso = 1; caso <= casos; caso++){
            Integer N = sc.nextInt();
            Integer[][] matriz = new Integer[N][N];
            Integer k = 0, r = 0, c = 0;
            for(int i = 0; i < N ; i++){
                Set<Integer> fila = new HashSet<Integer>();
                for(int j = 0; j < N; j++){
                    matriz[i][j] = sc.nextInt();
                    fila.add(matriz[i][j]);
                    
                    if(i == j){
                        k += matriz[i][j];
                    }
                }
                if(fila.size() != N){
                    r++;
                }
            }
            for(int j = 0; j < N; j++){
                 Set<Integer> columna = new HashSet<Integer>();
                for(int i = 0; i < N; i++){
                    columna.add(matriz[i][j]);
                }
                if(columna.size() != N){
                    c++;
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d",caso,k,r,c));
        }
    }
}