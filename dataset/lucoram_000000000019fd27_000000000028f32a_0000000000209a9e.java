import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader bufferedReader;
    private static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = readInt();
        for (int casenum = 1; casenum <= testCases; casenum++) {
            int b = readInt();
            String r = "";

            for (int k = 1; k <= 10; k++) {
                System.out.println(k);
                System.out.flush();
                r += nextLine();
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
        String s = bufferedReader.readLine();
        if (s == null) {
            exitImmediately();
        }
        stringTokenizer = null;
        return s;
    }

    private static String nextToken() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(nextLine().trim());
        }
        return stringTokenizer.nextToken();
    }

}
