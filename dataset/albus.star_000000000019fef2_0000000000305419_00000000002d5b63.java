import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCase = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        for (int testNumber = 1; testNumber <= testCase; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw, A, B);
            pw.println();
        }
        pw.close();
    }

    public static void solve(Scanner input, PrintWriter pw, int A, int B) throws IOException {
        for (int i = -50; i <= 50; i++) {
            for (int j = -50; j <= 50; j++) {
                System.out.println(i + " " + j);
                System.out.flush();
                String next = input.next();
                if (next.equals("CENTER")) {
                    return;
                }
            }
        }
    }

    public static int[] toBinary(long number) {
        int[] chars = new int[34];
        int start = 33;
        while (number > 0) {
            chars[start--] = (int) (number % 2);
            number /= 2;
        }
        return chars;
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            nullOrGet();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            nullOrGet();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            nullOrGet();
            return stk.nextToken();
        }

        private StringTokenizer nullOrGet() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
            return stk;
        }
    }

}
