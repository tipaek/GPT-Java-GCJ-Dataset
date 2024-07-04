import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class Solution {

	private DecimalFormat df = new DecimalFormat("#0.0000000");
	
	public static void main(String[] args) throws FileNotFoundException {
		new Solution().run();
	}

	private void run() throws FileNotFoundException {
//		tests();
		long before = System.nanoTime();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		scan.nextLine();
		IntStream.range(1, T + 1).forEach(i -> {
			String res = solve(scan);
			System.out.printf("Case #%d: %s\n", i, res);
			System.err.printf("Case #%d: %s\n", i, res);
		});
		System.err.println("Took "+((System.nanoTime()-before)/1000000)+" ms");
		scan.close();		
	}

	private class Activity {
		public Activity(int s, int e, int i) {
			startTime = s;
			endTime = e;
			index = i;
		}

		private int index;
		int startTime;
		int endTime;
		char assigned;
	}

	private String solve(Scanner scan) {
		int N = scan.nextInt();
		Activity[] activities = new Activity[N];
		for (int i = 0; i < N; i++) {
			int S = scan.nextInt();
			int E = scan.nextInt();
			activities[i] = new Activity(S, E, i);
		}
		Arrays.sort(activities, (a1, a2) -> a1.endTime - a2.endTime);
		Activity cLast = null;
		Activity jLast = null;
		for (Activity activity : activities) {
			if (!doesOverlap(cLast, activity)) {
				cLast = activity;
				activity.assigned = 'C';
			} else if (!doesOverlap(jLast, activity)) {
				jLast = activity;
				activity.assigned = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}
		Arrays.sort(activities, (a1, a2) -> a1.index - a2.index);
		StringBuffer res = new StringBuffer();
		Arrays.stream(activities).forEach(c -> res.append(c.assigned));
		return res.toString();
	}
	
	
	private boolean doesOverlap(Activity lastActivity, Activity newActivity) {
		if (lastActivity == null)
			return false;
		if (lastActivity.endTime >= newActivity.endTime)
			throw new RuntimeException();
		return (newActivity.startTime < lastActivity.endTime);
	}

	private void tests() {
		singleTest("3\n" + "360 480\n" + "420 540\n" + "600 660", "CJC");
		singleTest("3\n" + "0 1440\n" + "1 3\n" + "2 4", "IMPOSSIBLE");
		singleTest("5\n" + "99 150\n" + "1 100\n" + "100 301\n" + "2 5\n" + "150 250", "CJJCC");
		singleTest("2\n" + "0 720\n" + "720 1440", "CC");
	}
	
	private void singleTest(String input, String expected) {
		String result = solve(new Scanner(new StringReader(input))); 
		if (result.equals(expected))
			return;
		System.err.println("Wrong answer for:\n"+input);
		System.err.println("Got: "+result);
		System.err.println("Expected: "+expected);
		System.exit(1);
	}
// =================================================
	// Below are generic utility methods
	
	BigDecimal choose(final int N, final int K) {
		BigDecimal ret = BigDecimal.ONE;
	    for (int k = 0; k < K; k++) {
	        ret = ret.multiply(BigDecimal.valueOf(N-k))
	                 .divide(BigDecimal.valueOf(k+1));
	    }
	    return ret;
	}
}
