import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            String input = in.next();
            StringBuilder output = new StringBuilder();

            boolean opened = false;
            for (int j = 0; j < input.length(); j++) {
                int d = Character.getNumericValue(input.charAt(j));

                if (d == 0 && opened) {
                    output.append(")");
                    opened = false;
                } else if (d == 1 && !opened) {
                    output.append("(");
                    opened = true;
                }

                output.append(d);
            }

            if (opened) {
                output.append(")");
            }

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}