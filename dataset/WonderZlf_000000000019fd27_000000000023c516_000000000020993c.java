import java.io.*;
import java.util.*;

public class Solution {
 
    private static class Pair{
        public int sum;
        public int r;
        public int c;
 
        public Pair(int sum, int r, int c) {
            this.sum = sum;
            this.r = r;
            this.c = c;
        }
    }
 
    private static Pair count(int i,int j,int N, int[][] matrixN ){
        int r=0;
        int c=0;
        int[] tempRow = new int[N];
        for (int k=0;k<N;k++){
            tempRow[k]= matrixN[i][k];
        }
        Arrays.sort(tempRow);
        for (int h=1;h<N;h++){
            if(tempRow[h-1]==tempRow[h]){
                r++;
                break;
            }
        }
 
        int[] tempCol = new int[N];
        for (int k=0;k<N;k++){
            tempCol[k]= matrixN[k][j];
        }
        Arrays.sort(tempCol);
        for (int h=1;h<N;h++){
            if(tempCol[h-1]==tempCol[h]){
                c++;
                break;
            }
        }
        return new Pair(0,r,c);
    }
 
    private static Pair solve(int N, int[][] matrixN){
        int sum=0;
        int r=0;
        int c=0;
        boolean calculate=true;
        int i=0, j=0;
        while (i<N){
            sum+=matrixN[i][j];
            Pair tempN= count(i,j,N,matrixN);
            r+=tempN.r;
            c+=tempN.c;
            i++;j++;
        }
        return new Pair(sum,r,c);
    }
 
    public static void main(String []args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        // use for online test and submit
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int N = scanner.nextInt();
                int[][] matrixN = new int[N][N];
                for (int i=0;i<N;i++){
                    String input = scanner.nextLine();
                    if (input.equals("")) input =scanner.nextLine();
                    String[] numbers = input.split(" ");
                    for (int j=0;j<N;j++){
                        matrixN[i][j]=Integer.parseInt(numbers[j]);
                    }
                }
                Pair result = solve(N,matrixN);
                System.out.println("Case #" + testNumber + ": " + result.sum + " " + result.r+ " " + result.c);
            }
        }
    }
}
