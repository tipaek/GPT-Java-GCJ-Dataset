import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		int a = s.nextInt();
		int b = s.nextInt();
		
		for (int test = 1; test <= tests; test++) {
			int c_x = 0;
			int c_y = 0;
			boolean tried = false;
			for (int x : new int[] {(int) (-Math.pow(10, 9)/2), (int) (Math.pow(10, 9)/2)}) {
				for (int y : new int[] {(int) (-Math.pow(10, 9)/2), (int) (Math.pow(10, 9)/2)}) {
					if (!tried) {
						System.out.println(x + " " + y);
						if (!s.next().equals("MISS")) {
							c_x = (find_edge_x(x,y,b) + find_edge_x(x,y,-b))/2;
							c_y = (find_edge_y(x,y,b) + find_edge_y(x,y,-b))/2;
							tried = true;
						}
					}
				}
			}
			
			if (!tried) {
				c_x = (find_edge_x(0,0,b) + find_edge_x(0,0,-b))/2;
				c_y = (find_edge_y(0,0,b) + find_edge_y(0,0,-b))/2;
			}
			
			for (int x : new int[] {-2,-1,0,1,2}) {
				for (int y : new int[] {-2,-1,0,1,2}) {
					System.out.println(c_x + x + " " + c_y + y);
				}
			}
		}
		
		s.close();
	}
	
	public static String attempt(double x, double y) {
		if (Math.abs(x) <= Math.pow(10, 9) && Math.abs(y) <= Math.pow(10, 9)) {
			System.out.println((int) Math.round(x) + " " + (int) Math.round(y));
			return (new Scanner(System.in)).next();
		} else {
			return "MISS";
		}
	}

	public static int find_edge_x(double x, double y, double r) {
		if (Math.abs(r) >= 0.5) {
			String result = attempt(x+r, y);
			if (result.equals("MISS")) {
				return find_edge_x(x, y, r/2);
			} else {
				return find_edge_y(x+r, y, r/2);
			}
		} else {
			return (int) (x+r);
		}
	}
	
	public static int find_edge_y(double x, double y, double r) {
		if (Math.abs(r) >= 0.5) {
			String result = attempt(x, y+r);
			if (result.equals("MISS")) {
				return find_edge_y(x, y, r/2);
			} else {
				return find_edge_y(x, y+r, r/2);
			}
		} else {
			return (int) (y+r);
		}
	}

}