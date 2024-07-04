
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static final int INF = 100000000;
	static int N,K;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1;test<=tests;test++) {
			N = in.nextInt();
			K = in.nextInt();
			boolean can = true;
			int[][] M = new int[N][N];
			if(K%N==0) {
				int start = -1,tra = 0;;
				for(int i=0;i<N;i++) {
					start++;
					for(int j=0;j<N;j++) {
						M[i][j] = (j+start)!=N?(j+start)%N+1:1;
						if(i==j) tra += M[i][j];
					}
				}
				int num = K-tra;
				int less = num<0?-N:N;
				while(num!=0) {
					int si = INF,sj = INF;
					lab:
					for(int i=0;i<N;i++) {
						for(int j=0;j<N;j++) {
							if((M[i][i]+M[j][j])-(M[i][j]+M[j][i])/less>0) {
								si = i;
								sj = j;
								break lab;
							}
						}
					}
					if(si!=INF&&sj!=INF) {
						int[] temp = new int[N];
						temp = M[si];
						M[si] = M[sj];
						M[sj] = temp;
					}else {
						can = false;
						break;
					}
					num -= less;
				}
			}else {
				can = false;
			}
			if(can) {
				System.out.printf("Case #%d: %s\n",test,"POSSIBLE");
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						System.out.printf("%d%c",M[i][j],j+1==N?'\n':' ');
					}
				}
			}else {
				System.out.printf("Case #%d: %s\n",test,"IMPOSSIBLE");
			}
		}
	}
	
}
