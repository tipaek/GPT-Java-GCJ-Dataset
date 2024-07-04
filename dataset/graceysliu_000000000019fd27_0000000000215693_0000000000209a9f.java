import java.io.File;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        in.nextLine();

        for (int n = 0; n < numTests; n++) {
            String s = in.nextLine();
            StringBuilder result = new StringBuilder(s);

            // BUILDING BRUTE STRING
            int index = 0; // offset in result
            for (int i = 0; i < s.length(); i++) {
                // insert correct # for ALL integers
                // using i to represent size index in s
                int curr = (int) (s.charAt(i) - '0');
                for (int j = 0; j < curr; j++) {
                    result.insert(index, '(');
                }
                index += curr + 1; // +1 for int itself
                for (int j = 0; j < curr; j++) {
                    result.insert(index, ')');
                }
                index += curr;
            }

            // OPTIMIZING STRING
            for (int i = 0; i < result.length(); i++) {
                while (result.charAt(i) == ')' && ((i + 1) < result.length()) && result.charAt(i + 1) == '(') {
                    // can optimize here!!
                    result.deleteCharAt(i);
                    result.deleteCharAt(i);
                    i--;
                }
            }

            System.out.println("Case #" + (n + 1) + ": " + result);
        }
    }
}