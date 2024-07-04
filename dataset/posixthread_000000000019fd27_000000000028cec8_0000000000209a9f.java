import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static int MAX = 101;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCases = Integer.parseInt(sc.nextLine());

        for (int k = 0; k < numCases; k++) {

            // Get the string
            String line = sc.nextLine();

            System.out.print("Case #" + (k + 1) + ": ");
            System.out.println(getTheSPrime(line));
        }

        sc.close();
    }

    private static String getTheSPrime(String line) {
        String result = "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            int digit = Integer.parseInt(line.substring(i, i + 1));
            int stackSize = stack.size();
            if (stackSize == 0) {
                for (int j = 0; j < digit; j++) {
                    stack.push('(');
                    result += "(";
                }
                result += digit;
            } else if (stackSize == digit) {
                result += digit;
            } else if (stackSize > digit) {
                for (int j = 0; j < stackSize - digit; j++) {
                    stack.pop();
                    result += ")";
                }
                result += digit;
            } else if (stackSize < digit) {
                for (int j = 0; j < digit - stackSize; j++) {
                    stack.push('(');
                    result += "(";
                }
                result += digit;
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            result += ")";
        }

        return result;
    }
}


