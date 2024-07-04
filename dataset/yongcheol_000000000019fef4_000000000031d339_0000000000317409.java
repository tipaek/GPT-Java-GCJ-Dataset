
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static class Point implements Comparable {
		public int x, y;
		public int cnt;
		
		@Override
		public int compareTo(Object o) {
			Point obj = null;
			if(o instanceof Point)
				obj = (Point)o;
			
			if(this.cnt < obj.cnt) 
				return -1;
			else if(this.cnt == obj.cnt)
				return 0;
			else 
				return 1;

		}

		Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	public static void init() {
		
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		
		int T = sc.nextInt();
		
		boolean isPossible = false;
		for(int t = 1; t<= T; t++) {
			System.out.print("Case #" + t +  ": ");
			
			init(); 
			
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			String M = sc.next();
			
			int cnt = 0;
			
			X += 1000;
			Y += 1000;
			
			ArrayList<Point> list = new ArrayList<>();
			
			list.add(new Point(X, Y, cnt));
			
			for(char ch : M.toCharArray()) {
				++cnt;
				
				switch(ch) {
				case 'N':
					Y += 1; break;
				case 'S':
					Y -= 1; break;
				case 'W':
					X -= 1; break;
				case 'E':
					X += 1; break;
				
				}
				
				list.add(new Point(X, Y, cnt));
			}
			
			list.sort(null);
			
			int x = 1000;
			int y = 1000;
			int ans = 0;
			
			for(Point p : list) {
				
				int diff = Math.abs(x - p.x) + Math.abs(y - p.y);
				
				if(diff <= p.cnt) {
					ans = p.cnt;
					isPossible = true;
					break;
				}
			}
			
			if(isPossible && ans != 0) {
				System.out.println(ans);
			} else {
				System.out.println("IMPOSSIBLE");
			}
			
		}
		
	}

}
