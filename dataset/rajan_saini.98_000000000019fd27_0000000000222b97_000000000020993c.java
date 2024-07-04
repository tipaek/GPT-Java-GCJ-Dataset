import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(in.readLine().trim());
            int[][] arr = new int[n][n];
            for(int j=0; j<n; j++) {
                String[] temp = in.readLine().trim().split("\\s+");
                for(int k=0; k<n; k++) {
                    arr[j][k] = Integer.parseInt(temp[k]);
                }
            }
            
            
            
            int s=0, r=0, c=0;
            
            for(int j=0; j<n; j++) {
                int[] temp = new int[n];
                for(int k=0; k<n; k++) {
                    if(j==k) {
                        s += arr[j][k];
                    }
                    temp[arr[j][k]-1] = 1;
                }
                
                for(int k=0; k<n; k++) {
                    if(temp[k]==0) {
                        r++;
                        break;
                    }
                }
            }
            
            for(int j=0; j<n; j++) {
                int[] temp = new int[n];
                for(int k=0; k<n; k++) {
                    temp[arr[k][j]-1] = 1;
                }
                
                for(int k=0; k<n; k++) {
                    if(temp[k]==0) {
                        c++;
                        break;
                    }
                }
            }
            
            sb.append("Case #"+(i+1)+": "+s+" "+r+" "+c+"\n");
        }
        
        System.out.println(sb.toString());
    }
}