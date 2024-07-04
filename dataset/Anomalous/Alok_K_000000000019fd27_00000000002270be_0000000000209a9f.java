import java.io.*;
import java.util.Stack;

class Solution {
    static BufferedReader reader;
    static BufferedWriter writer;

    static void initializeIO() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static String readLine() throws IOException {
        String line;
        do {
            line = reader.readLine();
        } while (line.length() == 0);
        return line;
    }

    static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    static int[] parseIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    static void processCases() throws IOException {
        int t = parseInt(readLine());
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            char[] digits = readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            int currentDepth = 0;

            for (char digit : digits) {
                int value = digit - '0';
                if (value > currentDepth) {
                    for (int i = 0; i < value - currentDepth; i++) {
                        stack.push('(');
                    }
                    currentDepth = value;
                } else if (value < currentDepth) {
                    for (int i = 0; i < currentDepth - value; i++) {
                        stack.push(')');
                    }
                    currentDepth = value;
                }
                stack.push(digit);
            }

            while (currentDepth-- > 0) {
                stack.push(')');
            }

            writer.write("Case #" + caseNum + ": ");
            for (char ch : stack) {
                writer.write(ch);
            }
            writer.write("\n");
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        processCases();
    }
}