
import java.util.*;
import java.io.*;

public class Solution {

    private static final int[][] data = new int[100][100];
    static int N;
    private static Set<Integer> uniq = new HashSet<>(200);

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            String input = in.next().trim();
            //System.err.println("input"+input);
            StringBuilder sb =new StringBuilder();
            int depth = 0;
            for (char c : input.toCharArray()) {
                int digit = c-'0';
                while (digit>depth) {
                    sb.append("(");
                    depth++;
                }
                while (digit<depth) {
                    sb.append(")");
                    depth--;
                }
                sb.append(digit);
            }
            while (0 < depth) {
                sb.append(")");
                depth--;
            }

            System.out.println("Case #" + run + ": " + sb.toString());
            //in.nextLine();
        }
    }


}
