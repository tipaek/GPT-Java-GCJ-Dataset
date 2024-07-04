import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(System.in);
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = inputReader.readInt();
        
        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            String input = inputReader.readLine();
            outputWriter.write("Case #" + (testCase + 1) + ": ");
            processInput(input, outputWriter);
            outputWriter.newLine();
        }
        
        outputWriter.close();
    }

    private static void processInput(String input, BufferedWriter writer) throws IOException {
        if (input.isEmpty()) {
            return;
        }

        int currentNumber = Character.getNumericValue(input.charAt(0));
        int openParentheses = currentNumber;

        writeParentheses(writer, openParentheses, '(');
        writer.write(Integer.toString(currentNumber));

        for (int i = 1; i < input.length(); i++) {
            int previousNumber = currentNumber;
            currentNumber = Character.getNumericValue(input.charAt(i));
            int difference = currentNumber - previousNumber;

            if (difference > 0) {
                writeParentheses(writer, difference, '(');
            } else {
                writeParentheses(writer, -difference, ')');
            }

            writer.write(Integer.toString(currentNumber));
        }

        writeParentheses(writer, openParentheses, ')');
    }

    private static void writeParentheses(BufferedWriter writer, int count, char parenthesis) throws IOException {
        for (int i = 0; i < count; i++) {
            writer.write(parenthesis);
        }
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

    public int read() {
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

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar];
    }

    public int readInt() {
        int character = read();
        while (isSpaceChar(character)) {
            character = read();
        }
        int sign = 1;
        if (character == '-') {
            sign = -1;
            character = read();
        }
        int result = 0;
        do {
            if (character < '0' || character > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (character - '0');
            character = read();
        } while (!isSpaceChar(character));
        return result * sign;
    }

    public String readLine() {
        int character;
        StringBuilder buffer = new StringBuilder();
        while ((character = read()) != -1 && character != '\n') {
            if (character != '\r') {
                buffer.append((char) character);
            }
        }
        return buffer.toString();
    }

    private boolean isSpaceChar(int character) {
        return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
    }
}