import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        int b = reader.nextInt();
        char[] arr = new char[b];

        while (t-- > 0) {
            for (int i = 1; i <= 10; ++i) {
                System.out.println(i);
                System.out.flush();
                arr[i - 1] = reader.next().charAt(0);
                if (arr[i - 1] == 'N') return;
            }
            System.out.println(new String(arr));
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int k = reader.nextInt();
        int count = 0;

        while (n-- > 0) {
            int x = reader.nextInt();
            if (x % k == 0) count++;
        }

        System.out.println(count);
    }
}