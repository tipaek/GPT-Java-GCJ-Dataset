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
			boolean won = false;
			for (int x : new int[] {(int) (-Math.pow(10, 9)/2), (int) (Math.pow(10, 9)/2)}) {
				for (int y : new int[] {(int) (-Math.pow(10, 9)/2), (int) (Math.pow(10, 9)/2)}) {
					if (!tried && !won) {
						System.out.println(x + " " + y);
						String result = s.next();
						if (result.equals("HIT")) {
							int x0 = find_edge_x(x,y,b);
							if (x0 == 1000000001) {
								won = true;
								break;
							}
							int x1 = find_edge_x(x,y,-b);
							if (x1 == 1000000001) {
								won = true;
								break;
							}
							int y0 = find_edge_y(x,y,b);
							if (y0 == 1000000001) {
								won = true;
								break;
							}
							int y1 = find_edge_y(x,y,-b);
							if (y1 == 1000000001) {
								won = true;
								break;
							}	
							c_x = (x0 + x1)/2;
							c_y = (y0 + y1)/2;
							tried = true;
						} else if (result.equals("CENTER")) {
							won = true;
						}
					}
				}
			}
			
			if (!tried && !won) {
				int x = 0;
				int y = 0;
				int x0 = find_edge_x(x,y,b);
				if (x0 == 1000000001) {
					won = true;
					break;
				}
				int x1 = find_edge_x(x,y,-b);
				if (x1 == 1000000001) {
					won = true;
					break;
				}
				int y0 = find_edge_y(x,y,b);
				if (y0 == 1000000001) {
					won = true;
					break;
				}
				int y1 = find_edge_y(x,y,-b);
				if (y1 == 1000000001) {
					won = true;
					break;
				}	
				c_x = (x0 + x1)/2;
				c_y = (y0 + y1)/2;
			}
			
			for (int x : new int[] {-3,-2,-1,0,1,2,3}) {
				for (int y : new int[] {-3,-2,-1,0,1,2,3}) {
					if (!won) {
						System.out.println(c_x + x + " " + c_y + y);
						String result = s.next();
						if (result.equals("CENTER")) {
							won = true;
						}
					}
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
			if (result.equals("CENTER")) {
				return 1000000001;
			}
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
			if (result.equals("CENTER")) {
				return 1000000001;
			}
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