import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = Integer.parseInt(scan.nextLine());

		for (int test = 0; test < T; test++) {
			int test_input = Integer.parseInt(scan.nextLine());
			
			String answer = "";
			int detect = 0;
			for(int j=0; j<test_input; j++) {
				String temp = scan.nextLine();
				if(temp.charAt(0)=='*') {
					temp = temp.substring(1);
				}
				
				if(answer.contains(temp)) {
					
				}else if(temp.contains(answer)) {
					answer = temp;
				}else {
					detect = 1;
				}
			}
			
			if(detect==1) {
				System.out.println("Case #" + (test + 1) + ": "+"*");
			}else System.out.println("Case #" + (test + 1) + ": "+answer);
		}
	}
}