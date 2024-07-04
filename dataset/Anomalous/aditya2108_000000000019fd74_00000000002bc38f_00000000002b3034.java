import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            int N = sc.nextInt();
            String result = solve(N);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    static String solve(int N) {
        String[] arr = new String[N];
        int maxLength = 0;
        int maxLengthIndex = -1;
        boolean isValid = true;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
            if (i >= 1 && arr[i].length() > maxLength) {
                maxLength = arr[i].length();
                maxLengthIndex = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != maxLengthIndex) {
                String sub = arr[i].substring(1);
                if (!arr[maxLengthIndex].contains(sub)) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            return arr[maxLengthIndex].substring(1);
        }
        return "*";
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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