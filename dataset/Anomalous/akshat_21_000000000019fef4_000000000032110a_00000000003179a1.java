import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws Exception {
        InputReader.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = InputReader.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            long u = InputReader.nextLong();
            TreeSet<Integer>[] possibleDigits = new TreeSet[26];
            for (int i = 0; i < 26; i++) {
                possibleDigits[i] = new TreeSet<>();
                for (int j = 0; j <= 9; j++) {
                    possibleDigits[i].add(j);
                }
            }

            for (int i = 0; i < 10000; i++) {
                long num = InputReader.nextLong();
                if (num == -1) {
                    num = (long) Math.pow(10, u) - 1;
                }
                String s = InputReader.next();
                int length = s.length();
                long maxNum = Math.min(num, (long) Math.pow(10, length) - 1);
                String maxNumStr = Long.toString(maxNum);

                for (int j = maxNumStr.length() - 1; j > 0; j--) {
                    int maxDigit = maxNumStr.charAt(j) - '0';
                    for (int k = j - 1; k >= 0; k--) {
                        int currentDigit = maxNumStr.charAt(k) - '0';
                        if (k > 0 && currentDigit >= 1) {
                            maxDigit = 9;
                            break;
                        } else if (k == 0 && currentDigit > 1) {
                            maxDigit = 9;
                            break;
                        }
                    }
                    for (int k = maxDigit + 1; k <= 9; k++) {
                        possibleDigits[s.charAt(j) - 'A'].remove(k);
                    }
                }

                int maxDigit = maxNumStr.charAt(0) - '0';
                possibleDigits[s.charAt(0) - 'A'].remove(0);
                for (int k = maxDigit + 1; k <= 9; k++) {
                    possibleDigits[s.charAt(0) - 'A'].remove(k);
                }
            }

            char[] result = new char[10];
            for (int i = 0; i < 26; i++) {
                if (possibleDigits[i].size() == 1) {
                    int digit = possibleDigits[i].first();
                    result[digit] = (char) ('A' + i);
                    for (int j = 0; j < 26; j++) {
                        possibleDigits[j].remove(digit);
                    }
                    i = -1; // Restart the loop
                }
            }

            out.print("Case #" + caseNumber + ": ");
            for (char c : result) {
                out.print(c);
            }
            out.println();
            caseNumber++;
        }

        out.close();
    }
}

class InputReader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    static String nextLine() throws IOException {
        return reader.readLine();
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}