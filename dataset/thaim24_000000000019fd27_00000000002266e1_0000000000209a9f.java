import java.util.Scanner;

public  class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            String S = sc.next();

            System.out.println("Case #" + (t+1) + ": " + solve(S));
        }
    }

    private static String solve(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for(int i=0; i<S.length(); i++) {
            int next = S.charAt(i) - '0';

            for (; level < next; level++) {
                sb.append("(");
            }
            for (; level > next; level--) {
                sb.append(")");
            }

            sb.append(next);
        }

        for (; level > 0; level--) {
            sb.append(")");
        }

        return sb.toString();
    }
}

