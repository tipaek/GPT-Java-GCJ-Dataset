import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = sc.nextInt();
			int[] start = new int[1000];
			int[] end = new int[1000];
			
			for(int test=0; test< T; test++) {
				int N = sc.nextInt();
				for(int i=0; i<N; i++) {
					start[i] = sc.nextInt();
					end[i] = sc.nextInt();
				}
				String y = solution(N, start, end);
				System.out.println("Case #"+(test+1)+": "+y);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	private final static String IMPOSSIBLE = "IMPOSSIBLE";
	private final static int[] workC = new int[1440];
	private final static int[] workJ = new int[1440];
	private static String solution(int N, int[] start, int[] end) {
		StringBuffer sb = new StringBuffer();
		
		Arrays.fill(workC, 0);
		Arrays.fill(workJ, 0);
		for(int i=0; i<N; i++) {
			int sumC=0, sumJ=0;
			for(int time=start[i]; time<end[i]; time++) {
				sumC += workC[time];
				sumJ += workJ[time];
			}
			if(sumC == 0) {
				Arrays.fill(workC, start[i], end[i], 1);
				sb.append('C');
			} else if(sumJ == 0) {
				Arrays.fill(workJ, start[i], end[i], 1);
				sb.append('J');
			} else {
				return IMPOSSIBLE;
			}
		}
		
		return sb.toString();
	}
}
