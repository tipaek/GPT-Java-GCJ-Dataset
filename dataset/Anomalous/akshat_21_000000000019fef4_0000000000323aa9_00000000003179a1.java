import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = Reader.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            long u = Reader.nextLong();
            TreeSet<Integer>[] possibleDigits = new TreeSet[26];
            for (int i = 0; i < 26; i++) {
                possibleDigits[i] = new TreeSet<>();
                for (int j = 0; j <= 9; j++) {
                    possibleDigits[i].add(j);
                }
            }

            for (int i = 0; i < 10000; i++) {
                long num = Reader.nextLong();
                if (num == -1) {
                    num = (long) Math.pow(10, u) - 1;
                }
                String s = Reader.next();
                String numStr = Long.toString(Math.min(num, (long) Math.pow(10, s.length()) - 1));

                for (int j = numStr.length() - 1; j > 0; j--) {
                    int maxDigit = numStr.charAt(j) - '0';
                    for (int k = j - 1; k >= 0; k--) {
                        int currentDigit = numStr.charAt(k) - '0';
                        if (k > 0 && currentDigit >= 1 || k == 0 && currentDigit > 1) {
                            maxDigit = 9;
                            break;
                        }
                    }
                    for (int k = maxDigit + 1; k <= 9; k++) {
                        possibleDigits[s.charAt(j) - 'A'].remove(k);
                    }
                }

                possibleDigits[s.charAt(0) - 'A'].remove(0);
                for (int k = numStr.charAt(0) - '0' + 1; k <= 9; k++) {
                    possibleDigits[s.charAt(0) - 'A'].remove(k);
                }
            }

            char[] answer = new char[10];
            for (int i = 0; i < 26;) {
                if (possibleDigits[i].size() == 1) {
                    int digit = possibleDigits[i].first();
                    answer[digit] = (char) ('A' + i);
                    for (int j = 0; j < 26; j++) {
                        possibleDigits[j].remove(digit);
                    }
                    i = 0;
                } else {
                    i++;
                }
            }

            out.print("Case #" + caseNumber + ": ");
            for (char c : answer) {
                out.print(c);
            }
            out.println();
            caseNumber++;
        }

        out.close();
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String nextLine() throws IOException {
        return reader.readLine();
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
}