import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    	int T = in.nextInt();
    	in.nextLine();

    	for (int testCase = 1; testCase <= T; testCase++) {
    		String S = in.nextLine();

            String newS = addParentheses(S, 0);

    		System.out.println("Case #" + testCase + ": " + newS);
    	}
	}

    public static String addParentheses(String str, int depth) {
        if (str.isEmpty()) {
            return "";
        }

        int index = str.indexOf((char)(depth + '0'));

        if (index == -1) {
            return "(" + addParentheses(str, depth + 1) + ")";
        } else {
            if (str.length() == 1) {
                return str;
            } else {
                return addParentheses(str.substring(0, index), depth) + str.charAt(index) + addParentheses(str.substring(index + 1), depth);
            }
        }
    }
}