import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int ks, int n, int[][]m) {
        //trace of matrix
        int k = 0;
        //# of repeated rows
        int r = 0;
        //# of repeated columns
        int c = 0;
        Set<Integer> num = new HashSet<Integer>();
        boolean rep = false;
        for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                int temp = m[i][j];
                if(i==j){
                    k+=temp;
                }
                if(!num.contains(temp)){
                    num.add(temp);
                }else{
                    rep = true;
                }
            }
            num.clear();
            if(rep==true){
                r++;
            }
            rep = false;
        }
        for(int j=0; j<n; j++){
            for(int i =0; i<n; i++){
                int temp = m[i][j];
                if(!num.contains(temp)){
                    num.add(temp);
                }else{
                    rep = true;
                }
            }
            num.clear();
            if(rep==true){
                c++;
            }
            rep = false;
        }
        System.out.println("Case #" + ks + ": " + k +" "+r+" "+c);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        //T test cases
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            //N by N matrix
            int N = input.nextInt();
            int [][] matrix = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j =0; j<N; j++){
                    matrix[i][j]= input.nextInt();
                }

            }
            solve(ks, N, matrix);
        }
    }
}
