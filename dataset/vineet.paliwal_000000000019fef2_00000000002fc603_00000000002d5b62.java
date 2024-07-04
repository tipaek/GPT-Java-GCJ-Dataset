import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static Solution main;
	
	class Point {
		long x;
		long y;
		Point prev;
		char move;
		long ms;
		public Point(long a,long b, Point p, char m,long s) {
			x = a;
			y = b;
			prev = p;
			move = m;
			ms = s;
		}
	}
	public static void main(String[] args) {
		main = new Solution();
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 1 ; i <= t ; i++) {
			long x = scan.nextLong();
			long y = scan.nextLong();
			ArrayList<Point> list = new ArrayList<Point>();
			list.add(main.new Point(0,0,null,' ',1));
			int iter = 0;
			Point ans = null;
			while(list.size() <10000000) {
				Point p = list.get(iter++);
				if((p.x==x)&&(p.y==y)) {
					ans = p;
					break;
				}
				ArrayList<Point> plist = getMoves(p);
				for(int a = 0 ; a < plist.size() ; a++) {
					list.add(plist.get(a));
				}
			}
			String ret = "";
			System.out.print("Case #" + i + ": ");
			if(ans==null) {
				System.out.println("IMPOSSIBLE");
			} else {
				while(ans.prev!=null) {
					ret = ans.move + ret;
					ans = ans.prev;
				}
				System.out.println(ret);
			}
			
		}
	}
	
	public static ArrayList<Point> getMoves(Point p) {
		ArrayList<Point> list = new ArrayList<Point>();
		long step = p.ms;
		Point p1 = main.new Point(p.x+step,p.y,p,'E',p.ms*2);
		Point p2 = main.new Point(p.x-step,p.y,p,'W',p.ms*2);
		Point p3 = main.new Point(p.x,p.y+step,p,'N',p.ms*2);
		Point p4 = main.new Point(p.x,p.y-step,p,'S',p.ms*2);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		return list;
	}

}
