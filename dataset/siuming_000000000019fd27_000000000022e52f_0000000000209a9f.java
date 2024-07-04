import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class Solution {
    private static int convertCharToInt(char c) {
        return (int) (c - '0');
    }

    private static String solve(String inputString) {
        int curDepth = 0;
        int curNum = 0;
        int diff = 0;
        String inputStringAppendZero = inputString.concat("0");
        // List<Character> outputCharList = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); 
        for (char c: inputStringAppendZero.toCharArray()) {
            curNum = c - '0';
            diff = curNum - curDepth;
            if (diff != 0) {
                for (int i = 0; i < Math.abs(diff); i++){
                    // outputCharList.add((diff > 0) ? '(' : ')');
                    sb.append((diff > 0) ? '(' : ')');
                }
            }
            sb.append(c);
            curDepth = curNum;
        }
        String retString = sb.toString();
        return retString.substring(0, retString.length() - 1);
    }
    
    public static void main(String... args) {
        try {
            // BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            // int n = Integer.parseInt(in.readLine());
            int n = in.nextInt();
            String[] inputStrings = new String[n];
			for (int i = 0; i < n; i++) {
                inputStrings[i] = in.next();
			}
			for (int i = 0; i < n; i++) {
				String result = solve(inputStrings[i]);
				System.out.println(String.format("Case #%d: %s", i + 1, result));
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
}