import java.util.*;

public class Solution {
    private final int T ;
    private final String in;

    public Solution(int T, String in) {
        this.T = T;
        this.in = in;
    }

    public void solve() {
        int N = in.length();

        int currentDepth = 0;

        StringBuilder sb = new StringBuilder(String.format("Case #%s: ", T));

        for (int i = 0; i < N; i++) {
            final int newDepth = Integer.parseInt(String.valueOf(in.charAt(i)));

            if(currentDepth > newDepth) {
                for (int j = currentDepth; j > newDepth; j--) {
                    sb.append(")");
                }
            } else if(currentDepth < newDepth) {
                for (int j = currentDepth; j < newDepth; j++) {
                    sb.append("(");
                }
            }
            sb.append(newDepth);

            currentDepth = newDepth;
        }

        if(currentDepth > 0) {
            for (int i = 0; i < currentDepth; i++) {
                sb.append(")");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final String input = in.nextLine();

            final Solution solution = new Solution(t + 1, input);

            solution.solve();
        }
    }
}
