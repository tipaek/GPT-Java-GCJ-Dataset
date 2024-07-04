import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i =0;i<T;i++){
            int N = sc.nextInt();
            int[][] Matrix = new int[N][N];
            for(int j=0;j<N;j++){
                for(int k = 0;k<N;k++){
                    Matrix[j][k] = sc.nextInt();
                }
            }

            int K = 0;
            int r = 0;
            int c = 0;
            for(int j=0;j<N;j++){
                Set<Integer> s1 = new HashSet<Integer>(); 
                Set<Integer> s2 = new HashSet<Integer>(); 
                for(int k=0;k<N;k++){
                    if(j==k){
                        // System.out.println(Matrix[j][k]);
                        K += Matrix[j][k];
                    }
                   
                }
                for(int k=0;k<N;k++){
                    if(s1.add(Matrix[j][k]) == false){
                        r++;
                        break;
                    }
                }
                for(int k=0;k<N;k++){
                    if(s2.add(Matrix[k][j]) == false){
                        c++;
                        break;
                    }
                }

            }
            System.out.println("Case #"+T+": "+K + " " + r + " " + c);
        }
    }

}
