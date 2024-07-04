import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int cas=1; cas<=t; cas++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int sk1[] = new int[r];
			int sk2[] = new int[c];
			int z1[] = new int[r];
			int z2[] = new int[c];
			Arrays.fill(z1, 0);
			Arrays.fill(z2, 0);
			int board[][] = new int[r][c];
			for(int i=0; i<r; i++) {
				sk1[i] = 0;
				for(int j=0; j<c; j++) {
					board[i][j] = sc.nextInt();
					sk1[i] +=board[i][j];
				}
			}
			for(int i=0; i<c; i++) {
				sk2[i] = 0;
				for(int j=0; j<r; j++) {
					sk2[i]+=board[j][i];
				}
			}
			boolean going = true;
			long ans = 0;
			while(going) {
				boolean change = false;
				int next[][] = new int[r][c];
				for(int i=0; i<r; i++) {
					next[i] = Arrays.copyOf(board[i], board[i].length);
				}
				int next1[] = Arrays.copyOf(sk1, sk1.length);
				int next2[] = Arrays.copyOf(sk2, sk2.length);
				int nextz1[] = Arrays.copyOf(z1, z1.length);
				int nextz2[] = Arrays.copyOf(z2, z2.length);
				for(int i=0; i<r; i++) {
					for(int j=0; j<c; j++) {
						if(board[i][j]==0) continue;
						ans+=board[i][j];
						if((double)(board[i][j]+.0000001)<(double)(sk1[i]+sk2[j]-board[i][j])/(double)(r+c-1-z1[i]-z2[j])){
							next[i][j] = 0;
							change = true;
							nextz1[i]++;
							nextz2[j]++;
						}
					}
				}
				sk1 = Arrays.copyOf(next1, next1.length);
				sk2 = Arrays.copyOf(next2, next2.length);
				z1 = Arrays.copyOf(nextz1, nextz1.length);
				z2 = Arrays.copyOf(nextz2, nextz2.length);
				for(int i=0; i<r; i++) {
					board[i] = Arrays.copyOf(next[i], next[i].length);
				}
				if(!change) going = false;
			}
			System.out.println("Case #" + cas + ": " +ans);
		}
		sc.close();
	}
}