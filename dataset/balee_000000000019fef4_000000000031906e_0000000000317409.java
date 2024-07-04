import java.io.FileInputStream;
import java.util.*;

public class Solution {

	private static String process(Scanner in) {

		int x = in.nextInt();
		int y = in.nextInt();
		char[] steps = in.next().toCharArray();
		
		for(int i = 0; i < steps.length; i++) {
			switch(steps[i]) {
			case 'N': y++; break;
			case 'S': y--; break;
			case 'E': x++; break;
			case 'W': x--; break;
			}
			if (Math.abs(x) + Math.abs(y) <= i + 1)
				return Integer.toString(i + 1);
		}
				
		return "IMPOSSIBLE";
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) 
			System.out.format("Case #%d: %s\n", i, process(in));
	}
}