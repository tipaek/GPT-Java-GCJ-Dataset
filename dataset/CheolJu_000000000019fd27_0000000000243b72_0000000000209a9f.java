import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// class name should be "Solution"
public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // number of test
        int n_test = in.nextInt() ;
        in.nextLine(); // just move to next line

        String s = "";
        String s_out = "";
        for (int i = 0; i < n_test; i++) {

            // get string S
            s = in.next();

            // if all zero (no 1), just return
            if (!s.contains("1")) {
                // OUTPUT
                System.out.println("Case #" + (i+1) + ": " + s);
                continue;
            }

            if (!s.contains("0")) {
//                System.out.println("0 not contained");
                // OUTPUT
                System.out.println("Case #" + (i + 1) + ": " + "(" + s + ")");
                continue;
            }

            String temp = "";
            for (int j = 0; j < s.length(); j++) {

                // if s_out is empty
                if (s_out.equals("")) {

                    // if current one is 1, open a parentheses
                    char c = s.charAt(j);
                    if (c == '1')
                        s_out += "(";
                    s_out += Character.toString(c);

                } else {

                    char c_prev = s_out.charAt(s_out.length()-1);
                    char c = s.charAt(j);

                    if (c_prev == '1') {

                        // close
                        if (c != '1') {
                            s_out += ")";
                        }
//                        // add to out
//                        s_out += Character.toString(c);
                    } else {

                        // open
                        if (c != '0') {
                            s_out += "(";
                        }
//                        // add to out
//                        s_out += Character.toString(c);
                    }
                    // add to out
                    s_out += Character.toString(c);
                }
            }

            // if ends with 1, close
            if (s_out.charAt(s_out.length()-1) == '1')
                s_out += ")";

            // OUTPUT
            System.out.println("Case #" + (i+1) +": " + s_out);
        }
    }
}
