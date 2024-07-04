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
            if (!s.contains("1")
                    && !s.contains("2")
                    && !s.contains("3")
                    && !s.contains("4")
                    && !s.contains("5")
                    && !s.contains("6")
                    && !s.contains("7")
                    && !s.contains("8")
                    && !s.contains("9")
            ) {
                // OUTPUT
                System.out.println("Case #" + (i+1) + ": " + s);
                continue;
            }

            // if all ones, just embrace with parentheses
            if (!s.contains("0")) {
                // OUTPUT
                System.out.println("Case #" + (i+1) + ": " + "(" + s + ")");
                continue;
            }

//            String temp = "";
            for (int j = 0; j < s.length(); j++) {

                // if s_out is empty
                if (s_out.equals("")) {

                    // if current one is non-zero, open a parentheses
                    char c = s.charAt(j);
                    if (c != '0')
                        s_out += "(";
                    s_out += Character.toString(c);

                } else {

                    char c_prev = s_out.charAt(s_out.length()-1);
                    char c = s.charAt(j);

                    // if previous is non-zero
                    if (c_prev != '0') {

                        // close if current one is zero
                        if (c == '0') {
                            s_out += ")";
                        }
//                        // add to out
//                        s_out += Character.toString(c);
                    } else {

                        // open if current is non-zero
                        if (c != '0') {
                            s_out += "(";
                        }
//                        // add to out
//                        s_out += Character.toString(c);
                    }
                    // add to out
                    s_out += Character.toString(c);
                }
                // if ends with non-zero, close
                if (j == (s.length()-1)) {
                    if (s_out.charAt(s_out.length()-1) != '0')
                        s_out += ")";
                }
            }

//            // if ends with non-zero, close
//            if (s_out.charAt(s_out.length()-1) != '0')
//                s_out += ")";

            // OUTPUT
            System.out.println("Case #" + (i+1) +": " + s_out);
            s_out = "";
        }
    }
}
