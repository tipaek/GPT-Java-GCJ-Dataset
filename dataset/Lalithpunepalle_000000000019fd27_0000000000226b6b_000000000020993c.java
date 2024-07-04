import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        int trace = 0;
        for(int i=0;i<t;i++){
            int n = inp.nextInt();
            int[][] ar = new int[n][n];
            int c = 0;
            int d = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    ar[j][k] = inp.nextInt();
                }
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(j == k){
                        trace = trace + ar[j][k];
                    }
                }
            }
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        if(ar[j][k] == ar[j][l]){
                            c++;
                        }
                        if(ar[k][j] == ar[l][j]){
                            d++;
                        }
                    }
                }
            }
            int x = t+1;
            System.out.println("Case #"+x+": "+trace + " " + c+" "+d);
        }
    }
}