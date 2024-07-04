import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tt = t;
        while(t-->0){
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = sc.nextInt();
                    if(i==j)
                        trace+=mat[i][j];
                }
            }
            int r = 0;
            for(int i=0;i<n;i++){
                HashSet<Integer> hs = new HashSet();
                for(int j=0;j<n;j++){
                    if(hs.contains(mat[i][j])){
                        r++;
                        break;
                    }
                    else{
                        hs.add(mat[i][j]);
                    }
                }
            }
            int c = 0;
            for(int i=0;i<n;i++){
                HashSet<Integer> hs = new HashSet();
                for(int j=0;j<n;j++){
                    if(hs.contains(mat[j][i])){
                        c++;
                        break;
                    }
                    else{
                        hs.add(mat[j][i]);
                    }
                }
            }
            System.out.println("Case #"+(tt-t)+": "+trace+" "+r+" "+c);
        }
    }
}