import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{

    public static String checkString(String s) {

        int openBraces = 0;
        Integer prev = 0;
        StringBuffer stringBugger = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {

            Integer cur = Integer.valueOf(String.valueOf(s.charAt(i)));

            if(prev == cur)
            {
                stringBugger.append(cur);
            }

            if(cur < prev)
            {
                char[] endBracketsArray = new char[Integer.valueOf(String.valueOf(prev - cur))];
                Arrays.fill(endBracketsArray, ')');
                String endBracket = new String(endBracketsArray);
                stringBugger.append(endBracket);
                stringBugger.append(cur);
                openBraces = openBraces - (prev - cur);
            }

            if(cur > prev)
            {
                char[] startBracketsArray = new char[Integer.valueOf(String.valueOf((cur-openBraces)))];
                Arrays.fill(startBracketsArray, '(');
                String startBrackets = new String(startBracketsArray);
                stringBugger.append(startBrackets);
                stringBugger.append(cur);
                openBraces = cur;
            }

            prev = cur;

        }

        if(openBraces > 0)
        {
            char[] endBracketsArray = new char[Integer.valueOf(String.valueOf(openBraces))];
            Arrays.fill(endBracketsArray, ')');
            String endBracket = new String(endBracketsArray);
            stringBugger.append(endBracket);

        }

        return stringBugger.toString();

    }


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = in.nextInt();
        in.nextLine();

        for (int k = 1; k <= testCase; ++k) {

            String rowString = in.nextLine();
            System.out.println("Case #" + k + ": " + checkString(rowString));
        }
    }
}
