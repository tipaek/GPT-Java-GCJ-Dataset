import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			String res = "IMPOSSIBLE";
			HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			int stick = 1, i = 1;
			Point Delim=new Point(-1,-1);
			q.add(Delim);
			x: while (!q.isEmpty()) {
				while(q.peek()!=Delim) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					//System.out.println(x+" "+y);
					if(map.containsKey(x)) {
						ArrayList<Integer> list=map.get(x);
						list.add(y);
						map.put(x, list);
					}else {
						ArrayList<Integer> list= new ArrayList<>();
						list.add(y);
						map.put(x,list);
					}
					//System.out.println(x+" "+y);
					String st = p.s;
					if (x == X && y == Y) {
						res = st;
						break x;
					}
					if(isValid(X,Y,x-stick,y)) {
						//if(!map.containsKey(x-stick) || !map.get(x).contains(x))
						q.add(new Point(x-stick,y,st+"W"));
					}
					if(isValid(X,Y,x+stick,y)) {
						//if(!map.containsKey(x) || !map.get(x).contains(x))
						q.add(new Point(x+stick,y,st+"E"));
					}
					if(isValid(X,Y,x,y-stick)) {
						//if(!map.containsKey(x) || !map.get(x).contains(x))
						q.add(new Point(x,y-stick,st+"S"));
					}
					if(isValid(X,Y,x,y+stick)) {
						//if(!map.containsKey(x) || !map.get(x).contains(x))
						q.add(new Point(x,y+stick,st+"N"));
					}
					
				}
				q.poll();
				if(!q.isEmpty()) {
					q.add(Delim);
				}
				stick*=2;
			}
			System.out.println("Case #"+tc+": "+res);

		}
	}
	static boolean isValid(int X, int Y, int x,int y) {
		if(Math.abs(x)<=Math.abs(X) && Math.abs(y)<=Math.abs(Y))
			return true;
		return false;
	}
}

class Point {
	String s;
	int x, y;

	Point(int x, int y) {
		s = "";
		this.x = x;
		this.y = y;
	}

	Point(int x, int y, String s) {
		this.s = s;
		this.x = x;
		this.y = y;
	}
}