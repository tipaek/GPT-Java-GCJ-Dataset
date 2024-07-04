
import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int i = 1;
		while(i<=t) {
		    int n = s.nextInt();
		    int tr = s.nextInt();
		    int sum = n*(n+1)/2;
		    int res[][] = new int[n][n];
		    int j =0;
		    if ((tr%n == 0 && tr/n <=n) || (tr == sum && n>2)){
		        int a[] = new int[n];
		    if (tr/n <= n){
		        int st = tr/n;
		        a[0] = st;
		        int temp = 1;
		        j = 1;
		         while(j< n){
		                if (temp == st){
		                  temp++;
		                  continue;
		                }
		                a[j] = temp;
		                temp++;
		                j++;
		    }
		    j = 0;
		    while(j<n){
                res[j] = a;
                a = rotate(a);
                j++;
		            }
		}
		else {
		             j = 0;
		            while(j< n)
		                a[j++] = j;
		            j = 0;
		            while(j<n){
		                int p[] = rev(a);
		                res[j] = p;
		                a = rotate(a);
		                j++;
		            }
		    }
	    System.out.println("Case #"+i+": "+"POSSIBLE");
	    j = 0;int k =0;
	    while(j<n){
	        k = 0;
	        while(k<n)
	            System.out.print(res[j][k++]+" ");
	       System.out.println();
	       j++;
	    }
	}
	else
	    System.out.println("Case #"+i+": "+"IMPOSSIBLE");
	i++;
}
}
static int[] rotate(int a[]){
    int l = a.length;
    int i = 1;
    int res[] = new int[l];
    res[0] = a[l-1];
    while(i< l){
        res[i] = a[i-1];
        i++;
    }
    return res;
}
static int[] rev (int a[]){
    int l = a.length;
    int res[] = new int[l];
    int i = 0;
    while(i<l){
        res[i] = a[l-1-i];
        i++;
    }
    return res;
}
}