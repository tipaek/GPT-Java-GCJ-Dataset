import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int k = 1; k <= t; k++) {
            String s = in.next();

            String res = balance(s, 1);

            System.out.println("Case #" + k + ": " + res);
        }
    }

    public static String balance(String s, int n) {
        StringBuilder sb = new StringBuilder(s);

        int parens = 0;
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i)=='('){
                parens++;
            }
            if (sb.charAt(i)==')'){
                parens--;
            }

            if (Character.getNumericValue(sb.charAt(i))==n) {
                // System.out.println(arr[i]);
                // System.out.println("parens: "+parens);
                if (parens != n) {
                    int left = i;
                    int right = i;

                    // go left
                    while (left - 1 >= 0 && Character.getNumericValue(sb.charAt(left-1)) >= n) {
                        left--;
                    }

                    // go right
                    while (right + 1 < sb.length() && Character.getNumericValue(sb.charAt(right+1)) >= n) {
                        right++;
                    }
                    right++;

                    sb.insert(right, ')');
                    sb.insert(left, '(');
                    // System.out.println("needs to balance arr["+i+"], left: "+left + ", right: "+right);
                    break;
                }
            }
        }

        if (s.equals(sb.toString())) {
            // System.out.println("no changes");
            if (n<9){
                return balance(sb.toString(), n+1);
            }
        } else {
            // System.out.println("changes! try again");
            return balance(sb.toString(), n);
        }

        return sb.toString();
    }
}