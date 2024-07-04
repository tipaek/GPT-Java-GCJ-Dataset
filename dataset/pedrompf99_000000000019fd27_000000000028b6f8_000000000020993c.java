import java.util.*;
public class Solution{
    public static int getTrace(int[][] matriz){
        int total = 0;
        for(int i = 0; i < matriz[0].length; i++)
            total += matriz[i][i];
        return total;
    }
    public static int getRowsDifferent(int[][] matriz){
        int total = 0;
        int tamanho = matriz[0].length;
        for(int i = 0; i < tamanho; i++){
            int array[] = new int[tamanho + 1];
            int diferente = 0;
            for(int j = 0; j < tamanho; j++){
                if(array[matriz[i][j]] == 0){
                    array[matriz[i][j]] = 1;
                } else {
                    diferente = 1;
                }
            }
            if(diferente == 1)
                total++;
        }
        return total;
    }
    public static int getCollumnsDifferent(int[][] matriz){
        int total = 0;
        int tamanho = matriz[0].length;
        for(int i = 0; i < tamanho; i++){
            int array[] = new int[tamanho + 1];
            int diferente = 0;
            for(int j = 0; j < tamanho; j++){
                if(array[matriz[j][i]] == 0){
                    array[matriz[j][i]] = 1;
                } else {
                    diferente = 1;
                }
            }
            if(diferente == 1)
                total++;
        }
        return total;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testes = input.nextInt();
        for(int i = 1; i <= testes; i++){
            int tamanho = input.nextInt();
            int matriz[][] = new int[tamanho][tamanho];
            for(int j = 0; j < tamanho; j++){
                for(int k = 0; k < tamanho; k++){
                    matriz[j][k] = input.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + getTrace(matriz) + " " + getRowsDifferent(matriz) + " " + getCollumnsDifferent(matriz));
        }   
        input.close();
    }
}