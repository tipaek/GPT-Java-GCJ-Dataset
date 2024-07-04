
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int k = 1; k <= T; k++) {
            int N= sc.nextInt();
            int[][] matriz= new int[N][N];
            int contDiag=0;
            int contRow=0;
            int contCol=0;
            for (int i = 0; i < N; i++) {
                int[] contHor= new int[N];
                boolean existsDuplicate=true;
                for (int j = 0; j < N; j++) {
                    matriz[i][j]=sc.nextInt();
                    if(i==j){
                       contDiag+=matriz[i][j];
                    }
                    contHor[(matriz[i][j]-1)]++;
                    if(contHor[(matriz[i][j]-1)]==2 && existsDuplicate ){
                        contRow++;
                        existsDuplicate=false;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                int[] contVertical= new int[N];
                boolean existsDuplicate=true;
                for (int j = 0; j < N; j++) {
                    contVertical[(matriz[j][i]-1)]++;
                    if(contVertical[(matriz[j][i]-1)]==2 && existsDuplicate ){
                        contCol++;
                        existsDuplicate=false;
                    }

                }
            }
            System.out.println("Case #"+ k + ": " +contDiag+" "+contRow+ " " + contCol);
        }
    }
}
