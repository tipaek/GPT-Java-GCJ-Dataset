import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            StringBuilder result = new StringBuilder();

            int nestingDepth = 0;
            for (int j = 0; j < s.length(); j++) {
                int number = Integer.parseInt(s.substring(j, j + 1));
                if (number > nestingDepth) {
                    for (int k = 0; k < number - nestingDepth; k++) {
                        result.append("(");
                    }
                } else if (number < nestingDepth) {
                    for (int k = 0; k < nestingDepth - number; k++) {
                        result.append(")");
                    }
                }
                nestingDepth = number;
                result.append(s.charAt(j));
            }

            if (nestingDepth > 0) {
                for (int k = 0; k < nestingDepth; k++) {
                    result.append(")");
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

}
