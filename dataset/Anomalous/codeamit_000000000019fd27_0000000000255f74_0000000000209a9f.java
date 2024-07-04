import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Stack;

public class ND {

    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private int numCases;

    public static void main(String[] args) {
        try {
            new ND().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            handleCase(i);
        }
    }

    private void handleCase(int caseNumber) throws IOException {
        String inputStr = in.readLine();
        Stack<String> stack = new Stack<>();

        int openCounter = 0;
        int closedCounter = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            int currentDigit = Character.getNumericValue(inputStr.charAt(i));

            if (openCounter == 0 && closedCounter == 0) {
                for (int j = 0; j < currentDigit; j++) {
                    stack.push("(");
                }
                stack.push(String.valueOf(currentDigit));
                closedCounter += currentDigit;
            } else {
                int intermediateOpenCounter = currentDigit - openCounter - closedCounter;
                int intermediateClosedCounter = closedCounter - currentDigit;

                if (intermediateOpenCounter > 0) {
                    for (int j = 0; j < intermediateOpenCounter; j++) {
                        stack.push("(");
                    }
                    stack.push(String.valueOf(currentDigit));
                    closedCounter += intermediateOpenCounter;
                } else if (intermediateClosedCounter > 0) {
                    for (int j = 0; j < intermediateClosedCounter; j++) {
                        stack.push(")");
                    }
                    stack.push(String.valueOf(currentDigit));
                    closedCounter -= intermediateClosedCounter;
                } else {
                    stack.push(String.valueOf(currentDigit));
                }
            }
        }

        for (int j = 0; j < closedCounter; j++) {
            stack.push(")");
        }

        stack.forEach(out::print);
        out.println();
    }
}