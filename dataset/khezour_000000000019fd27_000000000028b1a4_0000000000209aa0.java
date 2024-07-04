import java.util.*;
import java.io.*;

public class Solution {

    boolean possible = false ;

    static int nodecount;
    static int totalcount = 0;
    long timetaken = 0;
    long sum;
    long branch;
    Random rng;

    /**
     *
     * @return
     */

    /**************************************************
     *
     * Part A
     *
     *
     ***************************************************/



    /**
     * Sets up latin square for recursive generation
     * @param n
     * @return
     */
    public static int[][] genAllSquares(int n , int k){
        int[][] square = new int[n][n];
        nodecount = 1;
        for(int i=0;i<square.length;i++){
            square[i][0] =i;
        }
        for(int i=0;i<square.length;i++){
            square[0][i] =i;
        }

        for(int x=0;x < n;x++){
            if(verify(square,x,1,1)){
                square[1][1]=x;
                if(n==2){
                    GenSquares(square,1,2,n); //Special case
                }
                else{
                    GenSquares(square,2,1,n);
                }
                if ( check(square , n , k ) ) return square;
            }
        }
        return null;
    }

    public static boolean verify(int[][] s,int x, int i, int j){
        for(int a=0; a<i;a++){
            if(s[a][j]==x) return false;
        }
        for(int a=0; a<j;a++){
            if(s[i][a]==x) return false;
        }
        return true;
    }
    /**
     * Recursive, Branches over all candidates for a position
     * i,j in the square, if square is full, increments totalCount
     * @param square
     * @param i
     * @param j
     * @param n
     */
    private static void GenSquares(int[][] square, int i, int j, int n){
        nodecount++;
        if(j==n){
            totalcount++;
            return;
        }
        int newi=i+1;
        int newj= j;

        if(newi==n){
            newj=j+1;
            newi=1;
        }
        for(int x=0;x < n;x++){
            if(verify(square,x,i,j)){
                square[i][j]=x;
                GenSquares(square,newi,newj,n);
            }
        }
        return;
    }


    static boolean check(int[][] square , int n , int K){
        int s = 0;
        for (int k = 0; k < n; k++) {
            s += square[k][k]+1 ;
        }
        if ( s == K ) return true;
        else return false ;
    }

    public static void main( String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();
            int K = in.nextInt();

            int[][] allsq = genAllSquares(N , K) ;
            if (allsq == null)
                System.out.println("Case #" + x + ": " +"IMPOSSIBLE");
            else {
                System.out.println("Case #" + x + ": " + "POSSIBLE");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(allsq[i][j]+1 +" ");
                    }
                    System.out.println();
                }
            }

        }
    }

}
