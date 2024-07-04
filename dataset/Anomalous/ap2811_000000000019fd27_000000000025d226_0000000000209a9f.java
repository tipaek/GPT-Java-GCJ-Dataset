import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int o = 1; o <= t; o++) {
            String s = sc.next();
            int[] ar = new int[s.length()];
            int length = s.length();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                ar[i] = Character.getNumericValue(s.charAt(i));
            }

            for (int i = 0; i < ar[0]; i++) {
                result.append("(");
            }

            for (int i = 0; i < length - 1; i++) {
                result.append(ar[i]);
                int diff = ar[i] - ar[i + 1];
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        result.append(")");
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        result.append("(");
                    }
                }
            }

            result.append(ar[length - 1]);
            for (int i = 0; i < ar[length - 1]; i++) {
                result.append(")");
            }

            System.out.println("Case #" + o + ": " + result);
        }
    }
}