
import java.util.Scanner;

public class Solution {	
	static final int limit = (int) 1e9;
	
	@SuppressWarnings("serial")
	static class SuccessException extends RuntimeException {
		
	}
	
	static class Coord {
		int x, y;
		
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	static Scanner in;
	static int T;
	
	static int A, B;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();
		
		for(int merp = 1; merp <= T; merp++) {
			Solution s = new Solution();
			s.solve(merp);
		}
		
		in.close();
	}
	
	void solve(int c) {
		try {
			Coord seed = scan();
			
			Coord guess = new Coord(seed.x, seed.y);
			
			Coord left = binarySearch(seed, new Coord(seed.x - 2 * B, seed.y));
			Coord right = binarySearch(seed, new Coord(seed.x + 2 * B, seed.y));
			Coord up = binarySearch(seed, new Coord(seed.x, seed.y + 2 * B));
			Coord down = binarySearch(seed, new Coord(seed.x, seed.y - 2 * B));
			
			guess.x = (right.x + left.x) / 2;
			guess.y = (up.y + down.y) / 2;
			
			send(guess);
		} catch(SuccessException s) {
			
		}
	}
	
	Coord scan() {
		Coord guess = new Coord(0, 0);
		
		for(int i = -limit + A / 2; i < limit; i += A) {
			for(int j = -limit + A / 2; j < limit; j += A) {
				guess.x = i;
				guess.y = j;
				if(send(guess).equals("HIT"))
					return guess;
			}
		}
		
		return null;
	}
	
	String send(Coord c) {
		if(c.x < -limit || c.y < -limit || c.x > limit || c.y > limit) {
			return "MISS";
		} else {
			System.out.println(c.x + " " + c.y);
			
			String res = in.next();
			
			if(res.equals("WRONG")) {
				System.exit(0);
				return null;
			} else
				return res;
		}
	}
	
	Coord binarySearch(Coord i, Coord o) {
		Coord ib = new Coord(i.x, i.y);
		Coord ob = new Coord(o.x, o.y);
		
		Coord guess = new Coord(-1, -1);
		while(Math.abs(ib.x - ob.x) + Math.abs(ib.y - ob.y) > 1) {
			guess.x = (ib.x + ob.x) / 2;
			guess.y = (ib.y + ob.y) / 2;
			
			switch(send(guess)) {
			case "CENTER":
				throw new SuccessException();
			case "MISS":
				ob.x = guess.x;
				ob.y = guess.y;
				break;
			case "HIT":
				ib.x = guess.x;
				ib.y = guess.y;
				break;
			}
		}
		
		return ib;
	}
}
