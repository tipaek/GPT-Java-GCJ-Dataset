import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("indicum.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			//System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				solve(testNumber,n,k);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static void solve(int testNumber, int n, int k) {
		boolean result = false;
		if(k % n == 0 && k / n > 0 &&  k / n <= n) {
			result = true;
		}
		String resStr =  result ? "POSSIBLE" : "IMPOSSIBLE";
		System.out.println("Case #" + testNumber + ": " + resStr);
		if(result) {
			List<String> myList = new LinkedList<String>();
			int start = k/n;
			for (int i = start; i <= n; i++) {
				myList.add(""+i);
			}
			for (int i = 1; i < start; i++) {
				myList.add(""+i);
			}
			for (int i = 0; i < n; i++) {
				System.out.println(String.join(" ", myList));
				// shuffle
				String last = myList.remove(n-1);
				myList.add(0, last);
			}
		}
	}

	
}
