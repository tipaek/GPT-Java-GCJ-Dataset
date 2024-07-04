
import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int i = 1;
		while(i<=t) {
		    int n = s.nextInt();
		    int a[][] = new int[n][n];
		    int j = 0, k = 0, res_r = 0, res_c = 0, sum = 0;
		    while(j< n) {
		        boolean b[] = new boolean[n];
		        k = 0;
		        while(k< n){
		            int z = s.nextInt();
		            if (j == k)
		                sum = sum + z;
		            if (! b[z-1])
		                b[z-1] = true;
		            else {
		                if(res_r < (j+1))
		                    res_r++;
		            }
		            a[j][k] = z;
		            k++;
		    }
		    j++;
		}
		j = 0; k = 0;
		while(j< n){
		    boolean b[] = new boolean[n];
		        k = 0;
		    while(k<n) {
		        int z = a[k][j];
		        if (! b[z-1])
		                b[z-1] = true;
		            else {
		                if(res_c < (j+1))
		                    res_c++;
		            }
		            k++;
		    }
		    j++;
		}
		System.out.println("Case #"+i+": "+sum+" "+res_r+" "+res_c);
		i++;
		
	}
}
}