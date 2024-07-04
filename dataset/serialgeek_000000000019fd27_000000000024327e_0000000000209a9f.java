import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static class Operation {
        public int num(char ch) {
            return ch - '0';
        }

        public String balParen(String str) {
            StringBuilder sb = new StringBuilder();
            // adding first element
            int first = num(str.charAt(0)), open = 0;
            for (int i = 0; i < first; i++) {
                sb.append('(');
                open++;
            }
            sb.append(str.charAt(0));
            char[] chArr = str.toCharArray();
            for (int i = 1; i < chArr.length; i++) {
                // calculate diff between i-1 and i
                int diff = num(chArr[i - 1]) - num(chArr[i]);
                if (diff == 0) {
                    sb.append(chArr[i]);
                } else if (diff < 0) {
                    for (int j = 0; j < open; j++) {
                        sb.append(')');
                    }
                    open = num(chArr[i]);
                    for (int j = 0; j < open; j++) {
                        sb.append('(');
                    }
                    sb.append(chArr[i]);
                } else {
                    for (int j = 0; j < diff; j++) {
                        sb.append(')');
                        open--;
                    }
                    sb.append(chArr[i]);
                }
            }
            for (int i = 0; i < open ; i++) {
                sb.append(')');
            }
            return sb.toString();
        }

        public String paren(String str) {
            StringBuilder sb = new StringBuilder(str);
            char[] chArr = str.toCharArray();
            int index = 0;
            for (int i = 0; i < chArr.length; i++) {
                if (chArr[i] == '0') {
                    index++;
                    continue;
                } else if (chArr[i] == '1') {
                    int offset = index;
                    if (i == 0) {
                        offset = index - 1 >= 0 ? index - 1 : 0;
                    }
                    sb.insert(offset, '(');
                    index++;
                    int j = 0;
                    for (j = i; j < chArr.length && chArr[j] == '1'; j++) {
                        // do nothing
                    }
                    index += (j - i);
                    sb.insert(index, ')');
                    i = j - 1;
                    index++;
                }
            }
            return sb.toString();
        }

        public void solve(Scanner scan) throws IOException {
            int T = scan.nextInt(), t = 0;
            while (T-- > 0) {
                t++;
                String str = scan.next();

                System.out.println("Case #" + t + ": " + balParen(str));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Operation obj = new Operation();
        obj.solve(scan);
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
