import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private String addBrackets(String line) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < line.length() + 1; j++) {
            int value = (j < line.length()) ? Character.getNumericValue(line.charAt(j)) : 0;
            int prevValue = (j == 0) ? 0 : Character.getNumericValue(line.charAt(j - 1));
            String bracketToAppend = (value > prevValue) ? "(" : ")";
            for (int k = 0; k < Math.abs(value - prevValue); k++) {
                sb.append(bracketToAppend);
            }
            if (j < line.length()) {
                sb.append(value);
            }
        }
        return sb.toString();
    }

    private void run() throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String line = sc.nextLine();
            System.out.println("Case #" + i + ": " + addBrackets(line));
        }
        sc.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}
