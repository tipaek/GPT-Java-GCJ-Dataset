
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void printMatrix(int in[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(in[i][j] + "  ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = null;
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i =1 ; i <= T; i++) {
            int N = in.nextInt();
            int digonalSum = 0;
            int rowDupCount = 0;
            int colDupCount = 0;
            boolean isRowDup = false;
            boolean isColDup = false;
            int latinSquar[][] = new int[N][N];

            for (int ii = 0; ii < N; ii++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                isRowDup = false;
                for (int jj = 0; jj < N; jj++) {
                    latinSquar[ii][jj] = in.nextInt();
                    if (ii == jj) {
                        digonalSum += latinSquar[ii][jj];
                    }
                    if (rowMap.containsKey(latinSquar[ii][jj])) {
                        isRowDup = true;
                    } else {
                        rowMap.put(latinSquar[ii][jj],1);
                    }
                }
                if(isRowDup) {
                    rowDupCount++;
                }
            }
            for(int ii = 0; ii < N; ii++){
                HashMap<Integer, Integer> colMap = new HashMap<>();
                isColDup = false;
                for(int jj = 0; jj < N; jj++){
                    if(colMap.containsKey(latinSquar[jj][ii])){
                        isColDup = true;
                    } else {
                        colMap.put(latinSquar[jj][ii],1);
                    }
                }
                if(isColDup) {
                    colDupCount++;
                }
            }
            System.out.println("Case #"+i+": "+digonalSum+" "+rowDupCount+" "+colDupCount);
            //processMatrix(latinSquar,N);
            //printMatrix(latinSquar,N);
        }
    }
}
