
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Solution {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int[] rowSum = new int[n];
            int[] colSum = new int[n];
            int[] nCount = new int[n+1];
            int nRow = 0;
            int nCol = 0;
            int trace = 0;
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    a[j][k] = sc.nextInt();
                    rowSum[j] += a[j][k];
                    colSum[k] += a[j][k];
                    if(j == k){
                        trace += a[j][k];
                    }
                }
            }

            boolean isNaturalLatinSquare = true;


            for(int j=0; j<n; j++) {
                for (int k = 0; k < n; k++) {
                    nCount[a[j][k]]++;
                }
                boolean repeat = false;
                for(int x=1; x<n+1 && !repeat; x++){
                    if(nCount[x] != 1)
                        repeat = true;
                }
                if(repeat)
                    nRow++;
                for(int x=1; x<n+1; x++){
                    nCount[x] = 0;
                }
            }

            for(int k=0; k<n; k++) {
                for (int j = 0; j < n; j++) {
                    nCount[a[j][k]]++;
                }
                boolean repeat = false;
                for(int x=1; x<n+1 && !repeat; x++){
                    if(nCount[x] != 1)
                        repeat = true;
                }
                if(repeat)
                    nCol++;
                for(int x=1; x<n+1; x++){
                    nCount[x] = 0;
                }

            }


            System.out.println("Case #"+ (i+1) + ": " + trace + " " + nRow + " " + nCol);
        }
    }

}
