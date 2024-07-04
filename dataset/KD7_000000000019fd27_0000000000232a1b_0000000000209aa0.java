import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static boolean possible=false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i,t,n,d,arr[][],j,x;
		int row[][],col[][];
		String s[],out[];
		t=Integer.parseInt(br.readLine());
		out=new String[t];
		for(x=0;x<t;x++) {
			s=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			d=Integer.parseInt(s[1]);
			row=new int[n][n];
			col=new int[n][n];
			for(i=0;i<n;i++) {
				for(j=0;j<n;j++) {
					row[i][j]=0;
					col[i][j]=0;
				}
			}
			arr=new int[n][n];
			possible=false;
			sum(arr,0,n,d,row,col);
			out[x]="";
			if(possible) {
				out[x]+=("Case #"+(x+1)+": POSSIBLE")+"\n";
				for(i=0;i<n;i++) {
					for(j=0;j<n;j++) {
						out[x]+=(arr[i][j]+" ");
					}
					out[x]+="\n";
				}
			}
			else {
				out[x]=("Case #"+(x+1)+": IMPOSSIBLE")+"\n";
			}
		}
		for(x=0;x<t;x++) {
			System.out.print(out[x]);
		}
	}

	private static void sum(int[][] arr, int p, int n, int d, int[][] row, int[][] col) {
		//System.out.println(p+" "+d+" "+n);
		if(d==0)
		{
			//System.out.println("Passed");
			fill(arr,n,0,0,row,col);
			return;
		}
		if(p==n)
			return;
		for(int i=1;i<=n;i++) {
			if(d>=i) {
				arr[p][p]=i;
				row[p][i-1]=1;
				col[p][i-1]=1;
				sum(arr, p+1, n, d-i, row, col);
				if(possible) {
					return;
				}
				row[p][i-1]=0;
				col[p][i-1]=0;
			}
		}
	}

	private static void fill(int[][] arr, int n, int i, int j, int[][] row, int[][] col) {
		if(j==n) {
			j=0;
			i++;
		}
		if(i==n) {
			possible=true;
			return;
		}
		if(i==j) {
			fill(arr, n, i, j+1, row, col);
			return;
		}
		int p,q;
		for(p=1;p<=n;p++) {
			if(row[i][p-1]==0 && col[j][p-1]==0) {
				arr[i][j]=p;
				row[i][p-1]=1;
				col[j][p-1]=1;
				fill(arr, n, i, j+1, row, col);
				if(possible)
					return;
				row[i][p-1]=0;
				col[j][p-1]=0;
			}
			
		}
	}

}
