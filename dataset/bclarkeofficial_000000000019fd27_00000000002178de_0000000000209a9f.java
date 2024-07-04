import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            StringBuilder result = new StringBuilder();
            int curr = 0;
            String line = in.nextLine();
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                int num = Character.getNumericValue(c);
                int diff = num-curr;
                if (diff > 0) {
                    while(diff > 0) {
                        result.append("(");
                        diff--;
                    }
                } else {
                    while(diff < 0) {
                        result.append(")");
                        diff++;
                    }
                }
                result.append(c);
                curr = num;
            }

            while(curr > 0) {
                result.append(")");
                curr--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}