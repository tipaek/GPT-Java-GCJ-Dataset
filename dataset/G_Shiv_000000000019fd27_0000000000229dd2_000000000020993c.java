import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
     
        for(int i=1;i<=t;i++){
            int n = s.nextInt();
            int r = 0;
            int c = 0;
            int k = 0;
            int[][] input = new int[2*n][n+1];
            for(int j=0;j<n;j++){
                for(int e=0;e<n;e++){
                    int temp = s.nextInt();
                    input[j][temp]++;
                    input[j+n][temp]++;
                    if(j == e)
                        k+=temp;
                }
            }
            for(int j = 0;j<n;j++){
                for(int e = 0;e<n+1;e++){
                    if(input[j][e]>1){
                        r++;
                        break;
                    }
                }
            }
             for(int j = n;j<2*n;j++){
                for(int e = 0;e<n+1;e++){
                    if(input[j][e]>1){
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c);
        }
    }
}