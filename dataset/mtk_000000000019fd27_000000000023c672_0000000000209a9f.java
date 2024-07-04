import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader ir = new InputReader();
        int testCases = ir.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String s = ir.nextLine();
            StringBuilder expandedS = getExpandedS(s);
//            System.err.println(expandedS.toString());
            String minifiedS = minifyExpandedS(expandedS);
            System.out.println("Case #" + testCase + ": " + minifiedS);
        }
    }

    private static String minifyExpandedS(StringBuilder expandedS) {
        StringBuilder result = new StringBuilder();
        int len = expandedS.length();
        int i = 0;
        Stack<Character> s = new Stack();
        for (; i < len; i++) {
//            System.err.println("check " + (expandedS.charAt(i) == ')'));
            if (expandedS.charAt(i) == ')') {
                char c = expandedS.charAt(i);
                while ( i < len && ( c = expandedS.charAt(i)) == ')') {
                    s.push(c);
                    i++;
                }
//                System.err.println("after 1stwhile char(" + i + ") = " + c + "   stack size " + s.size());
                if (i == len || c == '0') { // if reached end OR found a zero then empty the stack
                    while(!s.empty()) {
                        result.append(s.pop());
                    }
                } else if (c == '(') {
                    // can't hit end since open brackets will be in between somewhere
                    while ( (c = expandedS.charAt(i)) == '(') {
                        i++;
                        if (!s.empty()) {
                            s.pop();
                        } else {
                            break;
                        }
                    }
                    // if more close brackets were found then append them to result
                    while(!s.empty()) {
                        result.append(s.pop());
                    }
                    // one of the above or below will happen
                    // or else append remaining open brackets
                    if (c == '(') {
                        result.append(c);
                        while ( (c = expandedS.charAt(i)) == '(') {
                            result.append(c);
                            i++;
                        }
                    }

                }
//                System.err.println("result so far " + result);
            }
            if (i < len)
                result.append(expandedS.charAt(i));

        }
        if (i < len) {
            result.append(expandedS.substring(i));
        }
        return result.toString();
    }

    /**
     * Return balanced expanded parenthesis expansion
     * e.g. 012 gives 0(1)((2))
     * @param s
     * @return
     */
    private static StringBuilder getExpandedS(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int d = c - '0';
            for (int bracket = 0; bracket < d; bracket++) sb.append('(');
            sb.append(d);
            for (int bracket = 0; bracket < d; bracket++) sb.append(')');
        }
        return sb;
    }

}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer st;

    public InputReader() throws FileNotFoundException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        // reader = new BufferedReader(new InputStreamReader(new FileInputStream("NestingDepth.in")));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine());
        }
        return st.nextToken();
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

/*


( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) ) ( ( 2 ) ) ( ( ( 3 ) ) )
( ( 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) 2 ( 3 ) ) )


18
1234567890987654321
111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999
1230123
3210321
1230321
78090345
34054024025073
99999199999
012
111
000
0000000000000000000000000000000
1234567890
1230321
010101010101
232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323

 */

