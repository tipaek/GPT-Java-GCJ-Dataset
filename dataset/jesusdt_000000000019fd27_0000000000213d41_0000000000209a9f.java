import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
    	String s = in.nextLine().replace("\n", "");
        System.out.println("Case #" + i + ": " + solve(s));
      }
      in.close();
    }

	private static String solve(String s) {
		int[] parentheses = new int[s.length()+1];
		int[] digits = new int[s.length()];
		int depth = 0;
		for(int i = 0; i < s.length(); i++) {
			digits[i] = Integer.valueOf(s.substring(i, i+1));
			parentheses[i] = digits[i] - depth;
			depth = digits[i];
		}
		parentheses[s.length()] = -1*depth;
		
		String sf = "";
		for(int j = 0; j < s.length(); j++) {
			String p = "";
			if(parentheses[j] > 0) {
				p = new String(new char[parentheses[j]]).replace('\u0000', '(');
			}else if(parentheses[j] < 0) {
				p = new String(new char[-1*parentheses[j]]).replace('\u0000', ')');
			}
			sf += p+digits[j];
		}
		if(parentheses[s.length()] < 0)
			sf += new String(new char[-1*parentheses[s.length()]]).replace('\u0000', ')');
		
		return sf;
	}
	
}
