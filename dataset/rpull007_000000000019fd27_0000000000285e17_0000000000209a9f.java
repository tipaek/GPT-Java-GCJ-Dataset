import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author RP
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        // For each test case
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + solve(s));
        }

    }

    public static String solve(String s) {
        String result = "";
        int nestLevel = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && nestLevel == 0) {
                result = result.concat("0");
            }
            else if (s.charAt(i) == '0' && nestLevel == 1) {
                result = result.concat(")0");
                nestLevel=0;
            }
            else if (s.charAt(i) == '1' && nestLevel == 0) {
                result = result.concat("(1");
                nestLevel=1;
            }
            else if (s.charAt(i) == '1' && nestLevel == 1) {
                result = result.concat("1");
            }
            if (i == (s.length() - 1) && nestLevel == 1) {
                result = result.concat(")");
                nestLevel = 0;
            }

        }
        return result;
    }

}