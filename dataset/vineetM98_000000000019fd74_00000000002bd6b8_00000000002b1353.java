import java.util.*;
class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int count=1;
		while(t-->0) {
			int n=sc.nextInt();
			int m=(int)(Math.ceil(Math.log(n+1)/Math.log(2)));
			long[][] pas=pascal(m);
			int[][] res=new int[500][2];
			int S=1,i=0,j=0,nx=-1,ny=-1;
			res[0][0]=1;
			res[0][1]=1;
			pas[0][0]=-1;
			n=n-1;
			while(S<=500 && n>0) {
				i=res[S-1][0]-1;
				j=res[S-1][1]-1;
				long max=Integer.MIN_VALUE;
				if(i>0 && j>0&& pas[i-1][j-1]<=n && pas[i-1][j-1]!=0 && pas[i-1][j-1]>=max) {
					max=pas[i-1][j-1];
					nx=i-1;
					ny=j-1;
				}
				if(i>0 && pas[i-1][j]<=n && pas[i-1][j]!=0 && pas[i-1][j]>=max) {
					max=pas[i-1][j];
					nx=i-1;
					ny=j;
				}
				if(j>0 && pas[i][j-1]<=n && pas[i][j-1]!=0 && pas[i][j-1]>=max) {
					max=pas[i][j-1];
					nx=i;
					ny=j-1;
				}
				if(j<m-1 && pas[i][j+1]<=n && pas[i][j+1]!=0 && pas[i][j+1]>=max) {
					max=pas[i][j+1];
					nx=i;
					ny=j+1;
				}
				if(i<m-1 && pas[i+1][j]<=n && pas[i+1][j]!=0 && pas[i+1][j]>=max) {
					max=pas[i+1][j];
					nx=i+1;
					ny=j;
				}
				if(j<m-1 && i<m-1 && pas[i+1][j+1]<=n && pas[i+1][j+1]!=0 && pas[i+1][j+1]>=max) {
					max=pas[i+1][j];
					nx=i+1;
					ny=j+1;
				}
				n=(int)(n-max);
				pas[nx][ny]=0;
				res[S][0]=nx+1;
				res[S][1]=ny+1;
				S++;
			}
			System.out.println("Case #"+count+":");
			for(i=0;i<S;i++) {
				System.out.println(res[i][0]+" "+res[i][1]);
			}
			count++;
		}
		
	}
	public static long[][] pascal(int n) {
		long[][] pas=new long[n][n];
		//Arrays.fill(pas, 0);
		for(int l=0;l<n;l++) {
			for(int i=0;i<=l;i++)
				pas[l][i]=binCoeff(l,i);
		}
		return pas;
	}
	public static long binCoeff(int n,int k) {
		if(k>(n-k))
			k=n-k;
		long res=1;
		for(int i=0;i<k;i++) {
			res*=(n-i);
			res/=(i+1);
		}
		return res;
	}
}

