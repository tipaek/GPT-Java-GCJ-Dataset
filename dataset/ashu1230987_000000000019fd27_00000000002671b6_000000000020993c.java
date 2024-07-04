//package vest;

import java.util.Scanner;
 class Solution{
	static StringBuilder answer= new StringBuilder();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		int ca= 1;
		while(K>0) {
			int N = s.nextInt();
			int[][] m = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j =0;j<N;j++) {
				  m[i][j]=s.nextInt();
				}
			}
			int[] a =latinmatrix(m) ;
			answer.append("Case #"+ca+": ");
			answer.append(a[0]+" "+a[1]+" "+a[2]+("\n"));
			K=K-1;
			ca=ca+1;}
		System.out.println(answer);
		}
	
   public static int[] latinmatrix(int[][] arr){
	   int ro=0;
	   int co =0,d=0;
	    for(int i=0;i<arr.length;i++){
	    	d=d+arr[i][i];
	    	if(same(arr[i])) {
	    		ro=ro+1;
	    	}
	    	int[] col=new int[arr.length];
	    	for(int j=0;j<arr.length;j++) {
	    		col[j]=arr[j][i];
	    	}
	    	
	    	if(same(col)) {
	    		co=co+1;
	    	}
	    }
	    int[] ans = new int[3];
	    ans[1]=ro;ans[2]=co;ans[0]=d;
	    return ans;
	
   }
   public static boolean same(int[] ar) {
	   for(int x=0;x<ar.length;x++) {
		   for(int j=0;j<ar.length;j++) {
			   if(x!=j&&ar[x]==ar[j]) {
				   return true;
			   }
		   }
	   }
	   return false;
   }
}

