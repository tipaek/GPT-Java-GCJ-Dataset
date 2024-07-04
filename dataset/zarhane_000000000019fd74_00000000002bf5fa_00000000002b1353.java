import java.io.*;
import java.util.*;

public class Solution {
	static int posSwitch = 0;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// READ----------------------------------------------------
			int N = s.nextInt();
			
			// SOLVE----------------------------------------------------
			String res = N + " 2";
			System.out.println("Case #"+tc+":\n"+res);
			
			
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
}