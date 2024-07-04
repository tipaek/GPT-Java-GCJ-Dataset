import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int qq = readInt();
        for (int casenum = 1; casenum <= qq; casenum++) {
            int b = readInt();

            StringBuilder r = new StringBuilder("");

            for (int k = 1; k <= 10; k++) {
                System.out.println(k);
                System.out.flush();
                r.append(nextLine());
            }

            System.out.println(r);
            System.out.flush();

            String res = nextLine();

            if (res.equals("N")) {
                exitImmediately();
            }
        }
    }

    private static void exitImmediately() {
        System.exit(0);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException {
        String s = br.readLine();
        if (s == null) {
            exitImmediately();
        }
        st = null;
        return s;
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
        }
        return st.nextToken();
    }

}
