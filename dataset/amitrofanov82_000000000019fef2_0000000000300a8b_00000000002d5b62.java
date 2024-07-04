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
		for (int i = 0; i <= 300000 ; i++) {
			String comb = Integer.toString(i, 4);
			sum = calcSum(comb);
			//System.out.println(combToResult(comb) + ":" + sum.y + ", " + sum.y);
			if (sum.x == x && sum.y == y) {
				return combToResult(comb);
			}
			for (int j = 1; j < 17; j++) {
				comb = '0' + comb;
				sum = calcSum(comb);
				if (sum.x == x && sum.y == y) {
					return combToResult(comb);
				}
			}
		}
		
		
		return "IMPOSSIBLE";
	}

	private static String combToResult(String comb) {
		return comb.replaceAll("0", "W").replaceAll("1", "E").replaceAll("2", "S").replaceAll("3", "N");
	}

	private static Coord calcSum(String comb) {
		long x = 0;
		long y = 0;
		
		for (int i = 0; i < comb.length(); i++) {
			long jump = (long) Math.pow(2.0, i + 0.0);
			switch(comb.charAt(i)){
			case '0': //W
				x-= jump;
				break;
			case '1': //E
				x+= jump;
				break;
			case '2': //S
				y-= jump;
				break;
			case '3': //N
				y+= jump;
				break;
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
