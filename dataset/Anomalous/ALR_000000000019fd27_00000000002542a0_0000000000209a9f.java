import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Input {
        int[] s;

        public Input(int[] s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return "Input [s=" + Arrays.toString(s) + "]";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(new File("./data/data1.in"));

        int T = Integer.parseInt(scan.nextLine());
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            Input input = readInput(scan);
            String solution = solve(input);
            // System.err.println(input);
            System.out.println("Case #" + caseNum + ": " + solution);
        }
    }

    private static String solve(Input input) {
        StringBuilder result = new StringBuilder();
        int previous = 0;
        int openParentheses = 0;

        for (int current : input.s) {
            if (current > previous) {
                int diff = current - previous;
                for (int j = 0; j < diff; j++) result.append("(");
                result.append(current);
                openParentheses += diff;
            } else if (current == previous) {
                result.append(current);
            } else {
                int diff = previous - current;
                for (int j = 0; j < diff; j++) result.append(")");
                result.append(current);
                openParentheses -= diff;
            }
            previous = current;
        }

        for (int j = 0; j < openParentheses; j++) result.append(")");
        return result.toString();
    }

    private static Input readInput(Scanner scan) {
        String inputString = scan.nextLine();
        int[] s = new int[inputString.length()];

        for (int i = 0; i < inputString.length(); i++) {
            s[i] = Character.getNumericValue(inputString.charAt(i));
        }

        return new Input(s);
    }
}