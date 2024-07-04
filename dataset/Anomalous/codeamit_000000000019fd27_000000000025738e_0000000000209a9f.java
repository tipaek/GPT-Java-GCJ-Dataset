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
            processCase(i);
        }
    }

    public void processCase(int caseNumber) throws IOException {
        String input = in.readLine();
        Stack<String> stack = new Stack<>();
        int openCounter = 0;
        int closedCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));

            if (openCounter == 0 && closedCounter == 0) {
                for (int j = 0; j < digit; j++) {
                    stack.push("(");
                }
                stack.push(String.valueOf(digit));
                closedCounter += digit;
            }
        }

        for (int j = 0; j < closedCounter; j++) {
            stack.push(")");
        }

        stack.forEach(out::print);
        out.println();
    }
}