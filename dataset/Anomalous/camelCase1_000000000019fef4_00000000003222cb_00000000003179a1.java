import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = nextInt();
        int caseNumber = 1;
        PrintWriter out = new PrintWriter(System.out);
        
        while (testCaseCount-- > 0) {
            int u = nextInt();
            boolean[][] digitConstraints = new boolean[26][10];
            for (boolean[] constraints : digitConstraints) {
                Arrays.fill(constraints, true);
            }
            int[] possibleFirstDigits = new int[26];
            boolean[] characterUsed = new boolean[26];
            
            for (int i = 0; i < 10000; i++) {
                char[] query = next().toCharArray();
                char[] response = next().toCharArray();
                digitConstraints[response[0] - 'A'][0] = false;
                
                if (query[0] != '-' && response.length == query.length) {
                    for (int j = 0; j < query.length; j++) {
                        for (int k = query[j] - '0' + 1; k < 10; k++) {
                            digitConstraints[response[j] - 'A'][k] = false;
                        }
                        int possibleDigit = checkPossibleDigit(digitConstraints, response[j]);
                        if (possibleDigit == -1 || possibleDigit != query[j] - '0') {
                            break;
                        }
                    }
                }
                possibleFirstDigits[response[0] - 'A']++;
                for (char c : response) {
                    characterUsed[c - 'A'] = true;
                }
            }
            
            int mostLikelyFirstDigit = 0;
            StringBuilder answer = new StringBuilder();
            
            for (int j = 0; j < 9; j++) {
                for (int i = 1; i < 26; i++) {
                    if (possibleFirstDigits[i] > possibleFirstDigits[mostLikelyFirstDigit]) {
                        mostLikelyFirstDigit = i;
                    }
                }
                characterUsed[mostLikelyFirstDigit] = false;
                possibleFirstDigits[mostLikelyFirstDigit] = 0;
                answer.append((char) (mostLikelyFirstDigit + 'A'));
            }
            
            for (int i = 0; i < 26; i++) {
                if (characterUsed[i]) {
                    answer.insert(0, (char) (i + 'A'));
                    break;
                }
            }
            
            for (int i = 0; i < 26; i++) {
                int digit = checkPossibleDigit(digitConstraints, (char) ('A' + i));
                if (digit != -1) {
                    int index = answer.indexOf(Character.toString((char) ('A' + i)));
                    answer.setCharAt(digit, answer.charAt(index));
                    answer.setCharAt(index, (char) ('A' + i));
                }
            }
            out.println("Case #" + (caseNumber++) + ": " + answer);
        }
        out.close();
    }

    public static int checkPossibleDigit(boolean[][] digitConstraints, char c) {
        int possibleDigit = -1;
        for (int i = 0; i < 10; i++) {
            if (digitConstraints[c - 'A'][i]) {
                if (possibleDigit == -1) {
                    possibleDigit = i;
                } else {
                    return -1;
                }
            }
        }
        return possibleDigit;
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}