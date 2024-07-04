import java.io.*;

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
			vr=new int[n];
			vc=new int[n];
			for(i=0;i<n;i++) {
				s=br.readLine().split(" ");
				for(j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(s[j]);
				}
				vr[i]=0;
				vc[i]=0;
			}
			r=0;c=0;
			find(arr, 0, 0, vr, vc, n);
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

	private static void find(int[][] arr, int i, int j, int[] vr, int[] vc, int n) {
		if(i>=n || j>=n)
			return ;
		if(vc[j]==1 && vr[i]==1)
			return;
		//System.out.println(i+" "+j);
		int v=arr[i][j];
		int pi=i,pj=j;
		if(vc[j]==0) {
			while(pi-1>=0) {
				pi--;
				if(arr[pi][pj]==v) {
					c++;
					vc[j]=1;
					break;
				}
			}			
		}
		pi=i;pj=j;
		if(vr[i]==0) {
			while(pj-1>=0) {
				pj--;
				if(arr[pi][pj]==v) {
					r++;
					vr[i]=1;
					break;
				}
			}
		}
		//find(arr, i+1, j+1, vr, vc, n);
		find(arr, i, j+1, vr, vc, n);
		find(arr, i+1, j, vr, vc, n);
	}

}
