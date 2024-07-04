import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String result = solve(scanner, scanner.nextInt());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String solve(Scanner scanner, int N) {
        String[] arr = new String[N];
        int maxLength = 0;
        int maxPos = -1;
        boolean isValid = true;

        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLine();
            if (maxLength < arr[i].length()) {
                maxLength = arr[i].length();
                maxPos = i;
            }
        }

        for (int i = 0; i < N && isValid; i++) {
            if (i != maxPos) {
                String sub = arr[i].substring(1);
                if (!arr[maxPos].contains(sub)) {
                    isValid = false;
                }
            }
        }

        return isValid ? arr[maxPos].substring(1) : "*";
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}