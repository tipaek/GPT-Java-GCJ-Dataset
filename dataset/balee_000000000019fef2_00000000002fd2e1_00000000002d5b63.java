import java.util.*;

public class Solution {

	static boolean LOG = false;
	static int MIN = -1000000000;
	static int MAX = 1000000000;
	static int sx;
	static int sy;

	static void log(String str) {
		if (LOG)
			System.err.println(str);
	}
	
	static class Pos {
		int x;
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}

	static String send(Scanner in, String str) {
		log("Send: " + str);
		System.out.println(str);
		System.out.flush();
		String read = in.next();
		log("Read: " + read);
		return read;
	}                     

	private static boolean tryToSetCentre(Scanner in, int x, int y) {
		String answer = send(in, x + " " + y);
		if (!"MISS".equals(answer)) {
			sx = x;
			sy = y;
			return true;
		}
		return false;
	}
	
	private static Pos findEdgeX(Scanner in, int xIn, int xOut, int y) {
		if (Math.abs(xIn - xOut) == 1)
			return new Pos(xIn, y);
		int mid = (xIn + xOut) / 2;
		String answer = send(in, mid + " " + y);
		if ("MISS".equals(answer)) 
			return findEdgeX(in, xIn, mid, y);
		return findEdgeX(in, mid, xOut, y);
	}
	
	private static Pos findEdgeY(Scanner in, int yIn, int yOut, int x) {
		log("EdgeY in: " + yIn + " out: " + yOut);
		if (Math.abs(yIn - yOut) == 1)
			return new Pos(x, yIn);
		int mid = (yIn + yOut) / 2;
		String answer = send(in, x + " " + mid);
		if ("MISS".equals(answer)) 
			return findEdgeY(in, yIn, mid, x);
		return findEdgeY(in, mid, yOut, x);
	}

	private static boolean process(Scanner in, int A, int B) {
		if (!tryToSetCentre(in, MAX/2, 0))
			if (!tryToSetCentre(in, -MAX/2, 0))
				if (!tryToSetCentre(in, 0, MAX/2))
					tryToSetCentre(in, 0, -MAX/2);

		log("START: " + sx + " " + sy);

		Pos p1 = findEdgeX(in, sx, -MAX-1, sy);
		log("P1: " + p1.toString());
		Pos p2 = findEdgeX(in, sx, MAX+1, sy);
		log("P2: " + p2.toString());
		Pos p3 = findEdgeY(in, sy, -MAX-1, sx);
		log("P3: " + p3.toString());
		Pos p4 = findEdgeY(in, sy, MAX+1, sx);
		log("P4: " + p4.toString());

		log("P1: " + p1.toString());
		log("P2: " + p2.toString());
		log("P3: " + p3.toString());
		log("P4: " + p4.toString());
		
		int x = (p1.x + p2.x) / 2;
		int y = (p3.y + p4.y) / 2;
		log("Result: " + x + " " + y);
		String result = send(in, x + " " + y);		
		return "CENTER".equals(result);
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();
		log(T+ " " + A + " " + B);
		for(int i = 0; i < T; i++) 
			if (!process(in, A, B))
				break;
	}
}
