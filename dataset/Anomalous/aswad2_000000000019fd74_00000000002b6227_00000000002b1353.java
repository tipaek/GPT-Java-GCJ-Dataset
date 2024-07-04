import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    public void execute() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int number = reader.nextInt();
            System.out.println("Case #" + (caseIndex + 1) + ":");
            
            if (number <= 500) {
                for (int i = 1; i <= number; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                for (int i = 3; i < 500; i++) {
                    System.out.println(1 + " " + i);
                }
            }
        }
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
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
            String line = "";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}