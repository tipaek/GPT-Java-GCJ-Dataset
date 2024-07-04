import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Nb of test cases

        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine(); // Entry
            String s2 = "";

            for (char c : s.toCharArray()) {
                int digit = Integer.parseInt(String.valueOf(c));
                for (int j = 0; j <digit; j++) {
                    s2 = s2 + "(";
                }
                s2 = s2 + digit;
                for (int j = 0; j <digit; j++) {
                    s2 = s2 + ")";
                }
            }

            // On clean
            int initialSize = s2.length();
            int finalSize = 0;
            while (initialSize != finalSize) {
                initialSize = s2.length();
                s2 = s2.replace(")(", "");
                finalSize = s2.length();
            }
            
            System.out.println("Case #" + i + ": " + s2);
        }
    }
}