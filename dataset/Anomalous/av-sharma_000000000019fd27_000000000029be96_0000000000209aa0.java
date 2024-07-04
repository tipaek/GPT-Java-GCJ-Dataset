import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            String latinSq = getLatinSquare(n, k);
            
            System.out.print("Case #" + t + ": ");
            if (latinSq.isEmpty()) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.print("POSSIBLE\n" + latinSq);
            }
        }
    }

    private static String getLatinSquare(int n, int k) {
        switch (n) {
            case 2:
                if (k == 4) return "2 1\n1 2\n";
                break;
            case 3:
                if (k == 3) return "1 2 3\n3 1 2\n2 3 1\n";
                if (k == 6) return "2 3 1\n1 2 3\n3 1 2\n";
                if (k == 9) return "3 1 2\n2 3 1\n1 2 3\n";
                break;
            case 4:
                if (k == 4) return "1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1\n";
                if (k == 6) return "1 2 4 3\n2 1 3 4\n4 3 2 1\n3 4 1 2\n";
                if (k == 7) return "1 2 3 4\n3 1 4 2\n4 3 2 1\n2 4 1 3\n";
                if (k == 8) return "2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2\n";
                if (k == 9) return "4 1 3 2\n1 3 2 4\n2 4 1 3\n3 2 4 1\n";
                if (k == 10) return "4 1 2 3\n1 4 3 2\n2 3 1 4\n3 2 4 1\n";
                if (k == 11) return "4 1 3 2\n2 4 1 3\n1 3 2 4\n3 2 4 1\n";
                if (k == 12) return "4 2 3 1\n2 4 1 3\n3 1 2 4\n1 3 4 2\n";
                if (k == 13) return "4 3 2 1\n2 4 1 3\n1 2 3 4\n3 1 4 2\n";
                if (k == 14) return "4 3 2 1\n3 4 1 2\n1 2 3 4\n2 1 4 3\n";
                if (k == 16) return "4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4\n";
                break;
            case 5:
                if (k == 5) return "1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n";
                if (k == 7) return "1 2 3 4 5\n5 1 2 3 4\n2 4 1 5 3\n3 5 4 2 1\n4 3 5 1 2\n";
                if (k == 8) return "1 2 3 4 5\n2 1 5 3 4\n3 4 2 5 1\n4 5 1 2 3\n5 3 4 1 2\n";
                if (k == 9) return "4 1 5 3 2\n1 2 3 4 5\n2 4 1 5 3\n5 3 2 1 4\n3 5 4 2 1\n";
                if (k == 10) return "5 1 2 3 4\n1 2 3 4 5\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n";
                if (k == 11) return "5 4 1 3 2\n1 2 5 4 3\n3 1 2 5 4\n2 3 4 1 5\n4 5 3 2 1\n";
                if (k == 12) return "5 1 3 4 2\n2 3 1 5 4\n1 4 2 3 5\n4 2 5 1 3\n3 5 4 2 1\n";
                if (k == 13) return "5 1 2 3 4\n1 5 4 2 3\n2 3 1 4 5\n3 4 5 1 2\n4 2 3 5 1\n";
                if (k == 14) return "5 1 4 3 2\n2 3 1 5 4\n4 2 3 1 5\n1 4 5 2 3\n3 5 2 4 1\n";
                if (k == 15) return "5 1 2 3 4\n3 4 5 1 2\n1 2 3 4 5\n4 5 1 2 3\n2 3 4 5 1\n";
                if (k == 16) return "5 2 3 4 1\n2 5 4 1 3\n1 4 2 3 5\n3 1 5 2 4\n4 3 1 5 2\n";
                if (k == 17) return "5 1 2 3 4\n4 5 1 2 3\n1 3 5 4 2\n2 4 3 1 5\n3 2 4 5 1\n";
                if (k == 18) return "5 1 2 3 4\n2 5 1 4 3\n3 4 5 1 2\n1 3 4 2 5\n4 2 3 5 1\n";
                if (k == 19) return "5 2 3 4 1\n1 5 2 3 4\n2 4 5 1 3\n3 1 4 2 5\n4 3 1 5 2\n";
                if (k == 20) return "5 2 4 1 3\n3 5 2 4 1\n1 3 5 2 4\n2 4 1 3 5\n4 1 3 5 2\n";
                if (k == 21) return "5 2 3 1 4\n4 5 2 3 1\n1 4 5 2 3\n2 3 1 4 5\n3 1 4 5 2\n";
                if (k == 22) return "5 3 1 2 4\n4 5 3 1 2\n2 4 5 3 1\n3 1 2 4 5\n1 2 4 5 3\n";
                if (k == 23) return "5 4 3 2 1\n1 5 4 3 2\n4 2 5 1 3\n2 3 1 4 5\n3 1 2 5 4\n";
                if (k == 25) return "5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n";
                break;
            default:
                break;
        }
        return "";
    }
}

class FastReader {
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

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
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
}