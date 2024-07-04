import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int t = 1; t <= testCount; ++t) {
            String s = in.next();
            String res = calculate(s);
            System.out.println("Case #" + t + ": " + res);
        }
    }

    private static String calculate(String s)
    {
        int depth = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cNum = Character.getNumericValue(c);
            int diff = depth - cNum;
            if (diff > 0) { // Closing
                appendCharacter(res, ')', diff);
            } else {
                appendCharacter(res, '(', -diff);
            }
            res.append(c);
            depth = cNum;
        }
        if (depth > 0) {
            appendCharacter(res, ')', depth);
        }

        return res.toString();
    }

    private static void appendCharacter(StringBuilder s, Character c, int num)
    {
        for (int j = 0; j < num; j++) {
            s.append(c);
        }
    }
}
