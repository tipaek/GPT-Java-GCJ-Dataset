import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int cas=1; cas<=t; cas++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int board[][] = new int[r][c];
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					board[i][j] = sc.nextInt();
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
				for(int i=0; i<r; i++) {
					for(int j=0; j<c; j++) {
						if(board[i][j]==0) continue;
						ans+=board[i][j];
						int compass = 0;
						int num = 0;
						int idx = 1;
						while(i+idx<r) {
							compass+=board[i+idx][j];
							if(board[i+idx][j]!=0) {
								num++;
								break;
							}
							idx++;
						}
						idx = 1;
						while(i-idx>=0) {
							compass+=board[i-idx][j];
							if(board[i-idx][j]!=0) {
								num++;
								break;
							}
							idx++;
						}
						idx = 1;
						while(j-idx>=0) {
							compass+=board[i][j-idx];
							if(board[i][j-idx]!=0) {
								num++;
								break;
							}
							idx++;
						}
						idx = 1;
						while(j+idx<c) {
							compass+=board[i][j+idx];
							if(board[i][j+idx]!=0) {
								num++;
								break;
							}
							idx++;
						}
						if(num==0) continue;
						double avg = (double)compass/(double)num;
						if(board[i][j]<avg){
							next[i][j] = 0;
							change = true;
						}
					}
				}
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