import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();
        
        for (int t = 0; t < testCases; t++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(inputString.charAt(0));

            for (int i = 0; i < previousDigit; i++) {
                result.append("(");
            }
            result.append(previousDigit);

            for (int i = 1; i < inputString.length(); i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));
                
                if (currentDigit == 0) {
                    for (int j = 0; j < previousDigit; j++) {
                        result.append(")");
                    }
                } else {
                    char bracket = currentDigit < previousDigit ? ')' : '(';
                    int difference = Math.abs(previousDigit - currentDigit);
                    
                    for (int j = 0; j < difference; j++) {
                        result.append(bracket);
                    }
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int i = 0; i < previousDigit; i++) {
                result.append(")");
            }

            output.append("Case #").append(t + 1).append(": ").append(result).append("\n");
        }
        System.out.println(output);
    }
}

class FastScanner {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar++];
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
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

    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String nextLine() {
        int c = read();
        while (isEndline(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }
}