import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int r=0,c=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i,t,n,arr[][],x,j;
		int vr[],vc[];
		String s[],out[];
		t=Integer.parseInt(br.readLine());
		out=new String[t];
		for(x=0;x<t;x++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			for(i=0;i<n;i++) {
				s=br.readLine().split(" ");
				for(j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			r=0;c=0;
			find(arr, n);
			out[x]="Case #"+(x+1)+": "+trace(arr, n)+" "+r+" "+c;
		}
		for(x=0;x<t;x++) {
			System.out.println(out[x]);
		}
	}


	private static int trace(int[][] arr,int r) {
		int i=0,sum=0;
		for(i=0;i<r;i++) {
			sum=sum+arr[i][i];
		}
		return sum;
	}

	private static void find(int[][] arr,int n) {
		int i,j;
		int vis[]=new int[n];
		clear(vis);
		
		for(i=0;i<n;i++) {
			clear(vis);
			for(j=0;j<n;j++) {
				if(vis[arr[i][j]-1]==0) {
					vis[arr[i][j]-1]++;
				}
				else {
					r++;
					break;
				}
			}
		}
		for(i=0;i<n;i++) {
			clear(vis);
			for(j=0;j<n;j++) {
				if(vis[arr[j][i]-1]==0) {
					vis[arr[j][i]-1]++;
				}
				else {
					c++;
					break;
				}
			}
		}
	}


	private static void clear(int[] vis) {
		for(int i=0;i<vis.length;i++) {
			vis[i]=0;
		}
	}


}
