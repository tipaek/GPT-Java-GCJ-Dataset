import java.io.*;
import java.util.*;

public class Solution {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTest = Integer.parseInt(br.readLine());
		
		//System.out.println(numTest);
	  
		for (int n = 1; n <= numTest; n++) {
			//System.out.println("~~~~~~~~~~~~~~~~~");
			String[] line = br.readLine().split("\\s+");
			String result = helper(Integer.valueOf(line[0]), Integer.valueOf(line[1]), false);
			System.out.println("Case #" + n + ": " + result);
		}
		
	}
	
	private static String helper(int n1, int n2, boolean divide) {
		//System.out.println("=======");
		//System.out.println(n1 + " " + n2);
		if (n1 == 0 && n2 == 0) return "";
		if (divide) {
			if (Math.abs(n1 % 2) == 1 || Math.abs(n2 % 2) == 1) return "IMPOSSIBLE";
			n1 = n1/2;
			n2 = n2/2;
		}
		//System.out.println(n1 + " " + n2);
		String result;
		if (((n1 % 2 == 0) && (Math.abs(n2 % 2) == 1)) || ((Math.abs(n1 % 2) == 1) && (n2 % 2 == 0))) {
			if (Math.abs(n1 % 2) == 1) {
				String result1;
				if (n1 + 1 == n1 * 2 && n2 == n2 * 2) result1 = "IMPOSSIBLE";
				else result1 = helper(n1 + 1, n2, true);
				String result2;
				if (n1 - 1 == n1 * 2 && n2 == n2 * 2) result2 = "IMPOSSIBLE";
				else result2 = helper(n1 - 1, n2, true);
				
				if (result1.equals("IMPOSSIBLE") && result2.equals("IMPOSSIBLE")) result = "IMPOSSIBLE";
				else if (result1.equals("IMPOSSIBLE")) result = "E" + result2;
				else if (result2.equals("IMPOSSIBLE")) result = "W" + result1;
				else {
					if (result1.length() < result2.length()) result = "W" + result1;
					else result = "E" + result2;
				}
			}
			else {
				
				String result1;
				if (n1 == n1 * 2 && n2 + 1 == n2 * 2) result1 = "IMPOSSIBLE";
				else result1 = helper(n1, n2 + 1, true);
				String result2;
				if (n1 == n1 * 2 && n2 - 1 == n2 * 2) result2 = "IMPOSSIBLE";
				else result2 = helper(n1, n2 - 1, true);			
				
				if (result1.equals("IMPOSSIBLE") && result2.equals("IMPOSSIBLE")) result = "IMPOSSIBLE";
				else if (result1.equals("IMPOSSIBLE")) result = "N" + result2;
				else if (result2.equals("IMPOSSIBLE")) result = "S" + result1;
				else {
					if (result1.length() < result2.length()) result = "S" + result1;
					else result = "N" + result2;
				}
			}
		}
		else result = "IMPOSSIBLE";
		//System.out.println(result);
		return result;
	}
}