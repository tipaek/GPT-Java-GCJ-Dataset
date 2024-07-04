import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < t; i++) {
            String s = in.nextLine().trim();
            int p = 0;
            StringBuilder builder = new StringBuilder();
            for (char c: s.toCharArray()) {
                int k = Integer.parseInt(c+"");
                if (k > p)
                    for (; p < k; p++)
                        builder.append('(');
                else if (k < p) {
                    for (; p > k; p--)
                        builder.append(')');
                }

                builder.append(c);
            }

            for (; p > 0; p--)
                builder.append(')');
            System.out.printf("\nCase #%d: %s", i+1, builder.toString());
        }
    }
}