import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int T = fastReader.nextInt();

        for (int i = 0; i < T; i++) {
            String input = fastReader.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + output(input));
        }
    }

    private static String output(String input) {
        int currDepth = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';

            if (num > currDepth) {
                stringBuilder.append(appendLeft(num, currDepth));
            } else if (num < currDepth) {
                stringBuilder.append(appendRight(num, currDepth));
            } else {
                stringBuilder.append(num);
            }

            currDepth = num;
        }

        for (int i = 0; i < currDepth; i++) {
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }

    private static String appendLeft(int num, int currDepth) {
        StringBuilder str = new StringBuilder();
        for (int i = currDepth; i < num; i++) {
            str.append('(');
        }
        str.append(num);
        return str.toString();
    }

    private static String appendRight(int num, int currDepth) {
        StringBuilder str = new StringBuilder();
        for (int i = num; i < currDepth; i++) {
            str.append(')');
        }
        str.append(num);
        return str.toString();
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    void close() throws IOException {
        br.close();
    }
}
