import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = in.readInt();
        
        for (int t = 0; t < testCases; t++) {
            String input = in.readLine();
            String result = processInput(input);
            out.write("Case #" + (t + 1) + ": " + result);
            out.newLine();
        }
        out.close();
    }

    private static String processInput(String input) {
        if (input.isEmpty()) {
            return "";
        }
        
        int num = Character.getNumericValue(input.charAt(0));
        int openBrackets = num;
        StringBuilder result = new StringBuilder();
        
        result.append("(".repeat(Math.max(0, openBrackets))).append(num);
        
        for (int i = 1; i < input.length(); i++) {
            int prevNum = Character.getNumericValue(input.charAt(i - 1));
            num = Character.getNumericValue(input.charAt(i));
            int diff = num - prevNum;
            
            if (diff > 0) {
                result.append("(".repeat(diff));
                openBrackets += diff;
            } else if (diff < 0) {
                result.append(")".repeat(-diff));
                openBrackets += diff;
            }
            result.append(num);
        }
        
        result.append(")".repeat(openBrackets));
        return result.toString();
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public InputReader(InputStream stream) {
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

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                sb.appendCodePoint(c);
            }
            c = read();
        }
        return sb.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}