import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Solution {
    	public static class pair{
		int x;
		int y;
		String Dir;
		public pair(int a,int b,String s1) {
			x = a;
			y = b;
			Dir = s1;
		}
	}
	public static String BFS(int x,int y) {
		Queue<pair> qu = new LinkedList<Solution.pair>();
		qu.add(new pair(0,0,""));
		while(!qu.isEmpty()) {
			pair curr = qu.poll();
			if(curr.x == x && curr.y ==y) {
				return curr.Dir;
			}
			if(Math.abs(curr.x)>= 100 || Math.abs(curr.y)>= 100 ) {
				return "IMPOSSIBLE";
			}
			qu.add(new pair(curr.x+1, curr.y, curr.Dir+"E"));
			qu.add(new pair(curr.x, curr.y+1, curr.Dir+"N"));
			qu.add(new pair(curr.x, curr.y-1, curr.Dir+"S"));
			qu.add(new pair(curr.x-1, curr.y, curr.Dir+"W"));
		}
		return "IMPOSSIBLE";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		for (int i = 1; i <=tot; i++) {
			String ans = BFS(sf.nextInt(), sf.nextInt());
			System.out.println("Case #"+i+": "+ans);
		}
		sf.close();
	}
}