import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			String[] line = sc.nextLine().split(" ");
			long left = Long.parseLong(line[0]);
			long right = Long.parseLong(line[1]);
			
			long[] sol = solve(left, right);
			
			System.out.println(
					"Case #" + (index + 1) + ": " +  sol[0] + " " + sol[1] + " " + sol[2]
			);
		}
		sc.close();
		
	}
	
	private static long[] solve(long left, long right) {
		long i = 1;
		while (true) {
			if (left >= right) {
				if (i <= left) {
					left -= i;
				} else {
					break;
				}
			} else {
				if (i <= right) {
					right -= i;
				} else {
					break;
				}
			}
			i++;
		}
		
		return new long[] { i - 1, left, right };
	}
}
