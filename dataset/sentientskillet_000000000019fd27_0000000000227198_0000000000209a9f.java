import java.io.*;

public class Solution {
    public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(f.readLine());
        for(int i=0; i<T; i++) {
            int[] S = readInts();
            out.printf("Case #%d: %s%n", i+1, insertParen(S));
        }
        out.close();
    }
    public static String insertParen(int[] S) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        final int N = S.length;
        for(int i =0; i<N; i++) {
            int cur = S[i];
            while(open>cur) {
                sb.append(")");
                open--;
            }
            while(open<cur) {
                sb.append("(");
                open++;
            }
            sb.append(cur);
        }
        for(; open>0; open--) sb.append(")");

        return sb.toString();
    }

    public static int[] readInts() throws IOException {
        String str = f.readLine();
        int[] arr = new int[str.length()];
        for(int i=0; i<str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }
}
