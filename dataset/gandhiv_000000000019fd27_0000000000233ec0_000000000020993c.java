import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int i1;
		for(i1=1;i1<=n1;i1++){
		    int n = sc.nextInt();
		    int[][] ar = new int[n][n];
		    int i,j,k=0,r,c,t;
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++){
		            ar[i][j] = sc.nextInt();
		            if(i==j)
		                k+=ar[i][j];
		        }
		    }
		    r = func(ar,n);
		    int[][] tr = new int[n][n];
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++){
		            tr[i][j] = ar[j][i];
		        }
		    }
		    c = func(tr,n);
		    System.out.println("Case #"+i1+": "+k+" "+r+" "+c);
		}
	}
	public static int func(int[][] ar, int n){
	    int i,j,res=0;
	    for(i=0;i<n;i++){
	        HashSet<Integer> hs = new HashSet<Integer>();
	        for(j=0;j<n;j++){
	            hs.add(ar[i][j]);
		    }
		    if(hs.size()!=n)
		        res++;
	    }
	    return res;
	}
}
