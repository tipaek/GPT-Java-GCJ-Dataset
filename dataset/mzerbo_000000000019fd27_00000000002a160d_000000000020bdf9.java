import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.valueOf(sc.nextLine());
		for(int t =1; t<=T;t++) {
			int cameron = 0;
			int jamie = 0;
			int N = Integer.valueOf(sc.nextLine());
			StringBuilder res = new StringBuilder("");
			for (int i = 0; i < N; i++) {
				res.append('Z');
			}
			int[][] times = new int[N][3];
			for(int i=0; i<N; i++) {
				times[i][0] = 25*60;
			}
			for(int i=0; i<N; i++) {
				String line = sc.nextLine();
				String[] time = line.split(" ");
				int s = Integer.valueOf(time[0]);
				int e = Integer.valueOf(time[1]);
				int j = i-1;
				while(j>=0 && times[j][0]>s) {
					times[j+1][0] = times[j][0];
					times[j+1][1] = times[j][1];
					times[j+1][2] = times[j][2];
					j--;
				}
				times[j+1][0] = s;
				times[j+1][1] = e;
				times[j+1][2] = i;
			}
			for(int i=0; i<N; i++) {
				int s = times[i][0];
				int e = times[i][1];
				if(cameron<=s) {
					cameron = e;
					res.replace(times[i][2], times[i][2]+1, "C");
				} else if (jamie<=s) {
					jamie=e;
					res.replace(times[i][2], times[i][2]+1, "J");
				} else {
					res = new StringBuilder("IMPOSSIBLE");
					break;
				}
			}
			String s = res.toString();
			System.out.println("Case #" + t + ": " + s);
		}
		
		sc.close();
	}

}
