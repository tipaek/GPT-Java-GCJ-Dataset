import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int testCaseCount = scn.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            String inputString = scn.next();
            int stringLength = inputString.length();
            int[] parenthesesBalance = new int[stringLength + 1];

            parenthesesBalance[0] = inputString.charAt(0) - '0';
            parenthesesBalance[stringLength] = '0' - inputString.charAt(stringLength - 1);
            for (int i = 1; i < stringLength; i++) {
                parenthesesBalance[i] = inputString.charAt(i) - inputString.charAt(i - 1);
            }

            System.out.print("Case #" + t + ": ");
            for (int i = 0; i < stringLength; i++) {
                if (parenthesesBalance[i] > 0) {
                    for (int j = 0; j < parenthesesBalance[i]; j++) {
                        System.out.print('(');
                    }
                } else if (parenthesesBalance[i] < 0) {
                    for (int j = 0; j < -parenthesesBalance[i]; j++) {
                        System.out.print(')');
                    }
                }
                System.out.print(inputString.charAt(i));
            }

            if (parenthesesBalance[stringLength] > 0) {
                for (int j = 0; j < parenthesesBalance[stringLength]; j++) {
                    System.out.print('(');
                }
            } else {
                for (int j = 0; j < -parenthesesBalance[stringLength]; j++) {
                    System.out.print(')');
                }
            }
            System.out.println();
        }
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