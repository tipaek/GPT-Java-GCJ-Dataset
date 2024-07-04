import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Stack;

class ND {

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

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            processCase(i);
        }
    }

    public void processCase(int caseNumber) throws Exception {
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
            } else {
                int openDiff = openCounter - digit;
                int closedDiff = closedCounter - digit;

                if (openDiff > 0) {
                    for (int j = 0; j < openDiff; j++) {
                        stack.push("(");
                    }
                    stack.push(String.valueOf(digit));
                    closedCounter += closedDiff;
                } else if (closedDiff > 0) {
                    for (int j = 0; j < closedDiff; j++) {
                        stack.push(")");
                    }
                    stack.push(String.valueOf(digit));
                    closedCounter -= closedDiff;
                } else {
                    stack.push(String.valueOf(digit));
                }
            }
        }

        for (int j = 0; j < closedCounter; j++) {
            stack.push(")");
        }

        stack.forEach(System.out::print);
        System.out.println();
    }

    static void printStack(Stack<String> stack) {
        if (stack.isEmpty()) {
            return;
        }

        String top = stack.pop();
        printStack(stack);
        System.out.print(top + " ");
        stack.push(top);
    }
}