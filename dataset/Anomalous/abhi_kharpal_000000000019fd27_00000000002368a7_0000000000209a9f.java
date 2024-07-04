import java.util.*;
import java.io.*;

class Codechef {

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

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

    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader();
        int testCaseCount = reader.nextInt();
        int caseNumber = 0;

        while (testCaseCount-- > 0) {
            caseNumber++;
            String input = reader.nextLine();
            int length = input.length();
            char[] characters = input.toCharArray();
            List<Character> result = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                int digit = characters[i] - '0';

                if (digit == 0) {
                    result.add(characters[i]);
                } else if (digit == 1) {
                    result.add('(');
                    result.add('1');

                    for (int j = i + 1; j < length; j++) {
                        if (characters[j] == '1') {
                            result.add(characters[j]);
                        } else {
                            i = j - 1;
                            break;
                        }
                    }
                    result.add(')');
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}