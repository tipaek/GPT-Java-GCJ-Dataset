import java.util.Scanner;
import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i=0; i<testCase; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			System.out.println("Case #" + (i+1) + ": " + findSolution(X,Y));
		}
	}

	private static String findSolution(int x, int y) {
		if (x==0 && y==0) {
			return "";
		}
		//String direction = "";
		List<String[]> queue = new LinkedList<String[]>();
		queue.add(new String[] {"0","0",""});
		queue.add(null);
		int curMove = 1;
		while (queue.size()>0) {
			String[] cur = queue.remove(0);
			if (cur == null) {
				curMove = curMove*2;
				if (queue.size() > 0) {
					queue.add(null);
				}
				continue;
			}
			int[] nextMove = new int[] {curMove, curMove*-1};
			char[] direction = new char[] {'E','N','W','S'};
			for (int i=0; i<2; i++) {
				for (int j=0; j<2; j++) {	
					cur[j] = "" + (Integer.parseInt(cur[j]) + nextMove[i]);
					int nextX = Integer.parseInt(cur[0]);
					int nextY = Integer.parseInt(cur[1]);
					//System.out.println(cur[0] + " " + cur[1]);
					if (nextX == x && nextY == y) {
						return cur[2] + direction[i*2+j];
					}
					
					if (x < 0 && nextX <0 && nextX*-1 > x*-1) {
						//continue;
					} else if (x > 0 && nextX > 0 && nextX > x) {
						//continue;
					} else if (y < 0 && nextY <0 && nextY*-1 > y*-1) {
						//continue;
					} else if (y > 0 && nextY > 0 && nextY > y) {
						//continue;
					} else if ((cur[0].equals("" + x) && nextX != x) || (cur[1].equals("" + y) && nextY != y)){
						//continue;
					} else {
						queue.add(new String[] {cur[0],cur[1], cur[2] + direction[i*2+j]});					
					}
					cur[j] = "" + (Integer.parseInt(cur[j]) - nextMove[i]);
				}
			}
			
			//curMove = curMove*2;
		}
		return "IMPOSSIBLE";
		
		
	}
}
