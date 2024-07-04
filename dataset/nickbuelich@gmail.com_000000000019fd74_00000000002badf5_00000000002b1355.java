import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	static int H,W;
	static int[][] B;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			B = new int[H][W];
			long answer = 0;
			for(int a=0;a<H;a++){
				for(int b=0;b<W;b++){
					B[a][b]=sc.nextInt();
				}
			}
			
			while(true){
				boolean death = false;
				int[][] G = new int[H][W];
				for(int a=0;a<H;a++){
					for(int b=0;b<W;b++){
						if(B[a][b]!=0){
							answer+=B[a][b];
							if (!DIE(a,b)){
								G[a][b]=B[a][b];
							}
							else{
								death=true;
							}
						}
					}
				}
				B = G;
				if (!death)break;
			}
				
			System.out.printf("Case #%d: %s%n", t, answer);
		}
	}

	private static boolean DIE(int a, int b) {
		long friends = 0;
		long score = 0;
		stuff: for(int d=0;d<4;d++){
			int cy = a;
			int cx = b;
			while(true){
				cy+=dy[d];
				cx+=dx[d];
				if (cy<0||cx<0||cy==H||cx==W)continue stuff;
				if(B[cy][cx]!=0){
					friends++;
					score+=B[cy][cx];
					continue stuff;
				}
			}
		}
		
		return (friends*B[a][b])<score;
	}
}
