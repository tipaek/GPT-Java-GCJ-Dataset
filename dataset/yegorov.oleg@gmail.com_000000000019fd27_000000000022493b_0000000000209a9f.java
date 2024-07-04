import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();

            StringBuilder sb = new StringBuilder();

            int curP = 0;
            for (char c : line.toCharArray()) {
                int val = Character.getNumericValue(c);

                for (int j=0; j < val-curP; j++) {
                    sb.append('(');
                }
                for (int j=0; j < curP - val; j++) {
                    sb.append(')');
                }

                sb.append(c);
                curP = val;
            }

            for (int j=0; j < curP; j++) {
                sb.append(')');
            }

            System.out.printf("Case #%d: %s%n", i, sb.toString());
        }
    }
}

