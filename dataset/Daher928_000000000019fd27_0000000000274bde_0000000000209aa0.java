import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

    static void indicium(int N, int K) {
        int[][] arr = new int[N][N];
        boolean[][] rowHisto = new boolean[N][N];
        boolean[][] colHisto = new boolean[N][N];
        boolean possible = indiciumAux(arr, N, K, 0, rowHisto, colHisto);
        
        if (possible && canFillArray(arr, rowHisto, colHisto)){
            System.out.println("POSSIBLE");
            for (int i=0 ; i<N; i++){
                for (int j=0; j<N; j++){
                    System.out.print(arr[i][j]);
                    if (j != N-1)
                        System.out.print(" ");
                }
                System.out.println("");
            }
        }
        else {
           System.out.println("IMPOSSIBLE"); 
        }
    }
    
    static boolean canFillArray(int[][] arr, boolean[][] rowHisto, boolean[][] colHisto) {
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                boolean spotFilled = false;
                if (i==j) continue; //diags are already filled
                for (int x=1; x<=arr.length; x++){
                    if (rowHisto[i][x-1]==true || colHisto[x-1][j]==true)
                        continue;
                    arr[i][j] = x;
                    rowHisto[i][x-1]=true;
                    colHisto[x-1][j]=true;
                    spotFilled = true;
                    break;
                }
                if (spotFilled == false)
                    return false;
            }
        }
        return true;
    }
    static boolean indiciumAux(int[][] arr, int N, int K, int index, boolean[][] rowHisto, boolean[][] colHisto) {
        if (index >= N){
            if (K==0) return true;
            if (K<0 || K>0) return false;
        }
        
        for (int i=1; i<=N; i++){
            arr[index][index] = i;
            if (indiciumAux(arr, N, K-i, index+1, rowHisto, colHisto) == true){
                rowHisto[index][i-1]=true;
                colHisto[i-1][index]=true;
                return true;
            }
        }
        
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {

            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            int N =  Integer.parseInt(arrRowItems[0]);
            int K =  Integer.parseInt(arrRowItems[1]);
            
            int caseNum = tItr+1;
            System.out.print("Case #"+ caseNum + ": ");
            indicium(N, K);
        }

        scanner.close();
    }
}
