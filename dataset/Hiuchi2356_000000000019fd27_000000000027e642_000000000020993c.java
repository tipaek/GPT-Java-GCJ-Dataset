import java.util.*;

class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int smp=sc.nextInt();
		for(int h=0; h<smp; h++) {
			int N=sc.nextInt();
			int sum=0,t=0,y=0;
			int[][] c=new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					c[i][j]=sc.nextInt();
					if(i==j) {
						sum+=c[i][j];
					}
				}
			}
			for(int i=0; i<N; i++) {
				int[] p=new int[N+1];
				Arrays.fill(p, 0);
				for(int j=0; j<N; j++) {
					p[c[i][j]]++;
				}
				for(int j=0; j<=N; j++) {
					if(p[j]>1) {
						y++;
						break;
					}
				}
			}
			for(int i=0; i<N; i++) {
				int[] p=new int[N+1];
				Arrays.fill(p, 0);
				for(int j=0; j<N; j++) {
					p[c[j][i]]++;
				}
				for(int j=0; j<=N; j++) {
					if(p[j]>1) {
						t++;
						break;
					}
				}
			}
			System.out.println("Case #"+(h+1)+": "+sum+" "+y+" "+t);
		}
	}
}