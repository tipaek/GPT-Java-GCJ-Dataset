import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Alexey")) {
			sc = new Scanner(new FileInputStream("input.txt"));
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < testCases + 1; i++) {
			String[] taskLine1 = sc.nextLine().split(" ");
			long x = Integer.parseInt(taskLine1[0]);
			long y = Integer.parseInt(taskLine1[1]);
			String result = readAndresolveSingleCase(x, y);
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndresolveSingleCase(long x, long y) {
		Coord sum;
		for (int i = 0; i <= 1500000; i++) {
			String comb = Integer.toString(i, 5);
			sum = calcSum(comb);
			//System.out.println(combToResult(comb) + ":" + sum.y + ", " + sum.y);
			if (sum.x == x && sum.y == y) {
				return combToResult(comb);
			}
		}
		
		
		return "IMPOSSIBLE";
	}

	private static String combToResult(String comb) {
		return comb.replaceAll("0", "").replaceAll("1", "W")
				.replaceAll("2", "E").replaceAll("3", "S").replaceAll("4", "N");
	}

	private static Coord calcSum(String comb) {
		long x = 0;
		long y = 0;
		
		for (int i = 0; i < comb.length(); i++) {
			long jump = (long) Math.pow(2.0, i + 0.0);
			switch(comb.charAt(i)){
			case '1': //W
				x-= jump;
				break;
			case '2': //E
				x+= jump;
				break;
			case '3': //S
				y-= jump;
				break;
			case '4': //N
				y+= jump;
				break;
			case '0':
				return new Coord(-10, -10);
			default:
				throw new RuntimeException("oops");
			}
		}
		
		return new Coord(x,y);
	}
	
	
	
	

}

class Coord {
	long x; long y;
	
	public Coord (long x0, long y0) {
		x= x0; y = y0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + x + "," + y;
	}
}
