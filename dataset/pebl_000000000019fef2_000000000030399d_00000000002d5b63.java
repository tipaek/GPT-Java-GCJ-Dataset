import java.util.Scanner;

public class Solution {

	static int MAX = 1000000000;
	static int INT = MAX / 5;

	static boolean found = false;
	
	// First or last hit
	private static int binsearchX(Scanner sc, int xmin, int x, int y, boolean firstHit) {
		while(xmin + 1 < x) {
			int midt = (xmin + x) >> 1;
			System.out.println(midt+" "+y);
			String judge = sc.next();
			if (judge.equals("CENTER")) {
				found = true;
				return midt;
			}
			if (judge.equals("HIT")) {
				if (firstHit)
					x = midt;
				else
					xmin = midt;
			} else {
				if (firstHit)
					xmin = midt;
				else
					x = midt;
			}
		}
		
		if (firstHit)
			return x;
		else
			return xmin;
	}	

	// First or last hit
	private static int binsearchY(Scanner sc, int x, int ymin, int y, boolean firstHit) {
		while(ymin + 1 < y) {
			int midt = (ymin + y) >> 1;
			System.out.println(x+" "+midt);
			String judge = sc.next();
			if (judge.equals("CENTER")) {
				found = true;
				return midt;
			}
			if (judge.equals("HIT")) {
				if (firstHit)
					y = midt;
				else
					ymin = midt;
			} else {
				if (firstHit)
					ymin = midt;
				else
					y = midt;
			}
		}
		
		if (firstHit)
			return y;
		else
			return ymin;
	}
	
	private static void solve(int nr, Scanner sc) {
		found = false;
		
		int x = 0;
		int y = 0;
		outer:
		for(x=-MAX+INT; x<MAX; x+= INT) {
			for(y=-MAX+INT; y<MAX; y+= INT) {
				System.out.println(x+" "+y);
				String judge = sc.next();
				if (judge.equals("CENTER"))
					return;
				if (judge.equals("HIT"))
					break outer;
			}			
		}
		
		// Binsearch X
		int xmin = Math.max(-MAX-1,x-INT);
		int xstart = binsearchX(sc, xmin,x,y,true);
		if (found)
			return;
		int xend = binsearchX(sc, x,MAX+1,y,false);
		if (found)
			return;

		int xmidt = (xend+xstart) >> 1;
			
		int ymin = Math.max(-MAX-1,y-INT);
		int ystart = binsearchY(sc,xmidt,ymin,y,true);
		if (found)
			return;
		int yend = binsearchY(sc,xmidt,y,MAX+1,false);
		if (found)
			return;
		int ymidt = (ystart+yend) >> 1;
		
		
		System.out.println(xmidt+" "+ymidt);
		String judge = sc.next();
		if (judge.equals("CENTER"))
			return;

		for(int a=-2; a<2; a++) {
			for(int b=-2; b<2; b++) {
				System.out.println((xmidt+a)+" "+(ymidt+b));
				String fuck = sc.next();
				if (fuck.equals("CENTER"))
					return;
			}
		}		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}
