
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static final int MAXJUMP = 35;
	
	public static String solve(Scanner sc) throws Exception {
		String ans = "";
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		Point start = new Point(0, 0, 0, "");
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(start);
		
		long[][] iDir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		char[] cDir = {'S', 'E', 'N', 'W'};
		
		int li = (int) (Math.log(Math.abs(X) + Math.abs(Y)) / Math.log(2)) ;
		while(!queue.isEmpty()) {
			
			Point curP = queue.poll();
			
			if(X == curP.x && Y == curP.y) {
				if(ans.length() == 0)
					ans = curP.move;
				
				if(ans.length() > curP.move.length())
					ans = curP.move;
				
				break;
			}
			
			if(curP.ith > MAXJUMP) break;
			if(curP.ith > li + 3) break;

			for(int d = 0; d < 4; d++) {

				long nX = curP.x + (iDir[d][0] << curP.ith);
				long nY = curP.y + (iDir[d][1] << curP.ith);
		
			
				//if(nX == X || nY == Y)
			//		System.out.println(nX + " " + nY + ", i-th : " + (curP.ith + 1));
				
				queue.add(new Point(nX, nY, curP.ith + 1,cDir[d] + curP.move));
			}
			
		}
		
		if(ans.length() == 0)
			ans = "IMPOSSIBLE";
		
		return ans;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			
			System.out.print("Case #" + t + ": ");
			
			System.out.println(solve(sc));
		}
	}
}


class Point {

	public long x, y;
	public int ith;
	public String move;
	
	public Point() {
		x = y = 0;
		ith = 0;
		move = "";
	}
	public Point(long x, long y, int i, String move) {
		this.x = x; this.y = y;
		this.ith = i;
		this.move = move;
	}
}

