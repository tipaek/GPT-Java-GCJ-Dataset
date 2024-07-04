import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
	public static Boolean isPossible(int n, int k) {
		int m = 1;
		while (m <= n) {
			if (k == m * n) {
				return true;
			}
			m++;
		}
		return false;
	}
	
	public static int getNext(int num, int n) {
		if (num + 1 <= n) {
			return num + 1;
		}
		return 1;
	}
	public static String getIndicium(int n, int k) {
	
		if (isPossible(n, k)) {
			String res = "POSSIBLE";
			int next = k / n;
	
			for (int i = 0; i < n; i++) {
				String s = next + "";
				for (int j = 1; j < n; j++) {
					next = getNext(next, n);
					s += " " + next;
				}
				res += "\n" + s;
			}
	
			return res;
		}
		else {
			return "IMPOSSIBLE";
		}
	}

    public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""));

        int testCases = scanner.nextInt();//.split(" ");

        for (int i = 1; i <= testCases; i++) {
			
			int n = scanner.nextInt();
			int k = scanner.nextInt();

			// System.out.println("Input "+ input);

			String res = getIndicium(n, k);

			System.out.println("Case #"+i+": "+res);
        }
    }
}
