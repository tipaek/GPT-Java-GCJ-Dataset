import java.util.*;
import java.io.*;
public class Solution {

	static int solve(int n, int[] rows) {
		int result = 1000;
		return result;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		String res = "";
		for (int i = 1; i <= t; ++i) {
			for(int k=0; k<55; k++) {
				System.out.println(k + " " + k);
				res = in.next();
				if (res == "CENTER") {
					break;
				}
				System.out.println((-1 * k) + " " + k);
				res = in.next();
				if (res == "CENTER") {
					break;
				}
				System.out.println(k + " " + (-1 * k));
				res = in.next();
				if (res == "CENTER") {
					break;
				}
				System.out.println((-1 * k) + " " + (-1 * k));
				res = in.next();
				if (res == "CENTER") {
					break;
				}
			}
		}
		in.close();
	}

}
