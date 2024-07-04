import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        boolean[] usedNumberLine;
        boolean[][] usedNumberColumn;
        boolean repetedNumberLine;
        boolean[] repetedNumberColumn;
        int[][] mat;

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for(int i=0; i<T; i++){ //para cada uma das matrizes
            int r = 0;
            int N = in.nextInt();
            mat = new int[N][N];
            usedNumberColumn = new boolean[N][N+1];
            repetedNumberColumn = new boolean[N+1];
            for(int j=0; j<N; j++){ //para cada uma das linhas
                usedNumberLine = new boolean[N+1];
                repetedNumberLine = false;
                for(int k=0; k<N; k++){ //para cada uma das colunas
                    int number = in.nextInt();
                    mat[j][k] = number;

                    if(usedNumberLine[number])
                        repetedNumberLine = true;
                    else
                        usedNumberLine[number] = true;

                    if (usedNumberColumn[k][number]) {
                        repetedNumberColumn[k] = true;
                    }
                    else
                        usedNumberColumn[k][number] = true;
                }
                if(repetedNumberLine)
                    r++;
            }
            int c=0;
            for(boolean repeted: repetedNumberColumn){
                if(repeted)
                    c++;
            }

            int x = i+1;
            int k = 0;
            for(int j=0; j<N; j++){
                k += mat[j][j];
            }

            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);

        }
    }
}
