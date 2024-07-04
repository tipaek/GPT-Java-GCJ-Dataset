import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String s = in.nextLine();
            System.err.println(s);

            StringBuilder result = new StringBuilder();
            boolean open = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '1') {
                    if (!open) {
                        result.append("(");
                        open = true;
                    }
                    result.append(c);
                } else {
                    if (open) {
                        result.append(")");
                        open = false;
                    }
                    result.append(c);
                }
            }
            if (open) {
                result.append(")");
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }

    }
}
