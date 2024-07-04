import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution {
	public static void main (String[] args) throws java.lang.Exception{
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int  i =0; i<t;i++){
            int n = in.nextInt();
            
            int trc=0;
            int r =0;
            int c =0;
            
            int[][] a = new int[n][n];
            for(int j = 0; j<n;j++){
                int[] flag = new int[n+1];
                int flagon = 0;
                for(int k =0; k<n;k++){
                    a[j][k]= in.nextInt();
                    if(j==k) trc = trc+  a[j][k];
                    if(flag[a[j][k]]==1 && flagon==0) {r++; flagon++;}
                    if(flag[a[j][k]]==0) flag[a[j][k]]++;
                }
            }
            
            
            for(int j = 0; j<n;j++){
                int[] flag = new int[n+1];
                int flagon = 0;
                for(int k =0; k<n;k++){
                    if(flag[a[k][j]]==1 && flagon==0) {c++; flagon++;}
                    if(flag[a[k][j]]==0) flag[a[k][j]]++;
                }
            }
            
            
            
            
            
            System.out.println("Case #"+(i+1) + ":"+ " "+trc+ " "+r+ " "+c);
        }
	}
}
