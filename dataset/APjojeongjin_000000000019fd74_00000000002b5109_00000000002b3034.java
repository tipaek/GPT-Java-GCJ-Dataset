import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = scan.nextInt();

		for (int test = 0; test < T; test++) {
			int test_input = scan.nextInt();
			
			String answer = "";
			for(int j=0; j<test_input; j++) {
				String temp = scan.next();
				if(temp.charAt(0)=='*') {
					temp = temp.substring(1);
				}
				
				if(answer.contains(temp)) {
					
				}else if(temp.contains(answer)) {
					answer = temp;
				}else {
					answer = "*";
					break;
				}
			}

			System.out.println("Case #" + (test + 1) + ": "+answer);
		}
	}
}