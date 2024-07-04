import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int bitLength = reader.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            boolean[] bitArray = new boolean[bitLength];

            if (bitLength == 10) {
                for (int i = 0; i < bitLength; i++) {
                    System.out.println(i + 1);
                    bitArray[i] = reader.next().equals("1");
                }

                for (boolean bit : bitArray) {
                    System.out.print(bit ? 1 : 0);
                }
                System.out.println();

                String response = reader.next();
                if (!response.equals("Y")) {
                    break;
                }
            } else {
                break;
            }
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
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
}