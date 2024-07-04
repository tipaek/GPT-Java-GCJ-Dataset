import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        
        int testCases = reader.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {

            int number = reader.nextInt();
            System.out.println("Case #" + (testCase + 1) + ":");

            if (number == 501) {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                for (int i = 3; i <= 498; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                for (int i = 1; i <= number; i++) {
                    System.out.println(i + " 1");
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

        String nextToken() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        String nextLine() {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}