import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("nesting-depth.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			//System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				String myStr = scanner.next();
				String result = solve(myStr);
				System.out.println("Case #" + testNumber + ": " + result);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static String solve(String myStr) {
		myStr = myStr.replaceAll("1", "(1)");
		myStr = myStr.replaceAll("2", "((2))");
		myStr = myStr.replaceAll("3", "(((3)))");
		myStr = myStr.replaceAll("4", "((((4))))");
		myStr = myStr.replaceAll("5", "(((((5)))))");
		myStr = myStr.replaceAll("6", "((((((6))))))");
		myStr = myStr.replaceAll("7", "(((((((7)))))))");
		myStr = myStr.replaceAll("8", "((((((((8))))))))");
		myStr = myStr.replaceAll("9", "(((((((((9)))))))))");
		
		//System.out.println(myStr);

		myStr = myStr.replaceAll("\\)\\)\\)\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\)\\)\\(\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\)\\(\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\)\\(\\(", "");
		myStr = myStr.replaceAll("\\)\\(", "");
		
		return myStr;
	}

	
}
