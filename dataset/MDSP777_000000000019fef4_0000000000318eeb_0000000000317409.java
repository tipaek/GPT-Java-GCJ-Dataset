import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			char[] moves = sc.next().toCharArray();
			int m = 100000000;
			for(int i=0; i<=moves.length; i++) {
				int dist = Math.abs(x)+Math.abs(y);
				if(dist<=i) m = Math.min(m, i);
				if(i==moves.length) break;
				if(moves[i]=='N') y++;
				else if(moves[i]=='S') y--;
				else if(moves[i]=='E') x++;
				else x--;
			}
			System.out.println("Case #"+t+": "+(m==100000000 ? "IMPOSSIBLE" : m));
		}
	}
}
