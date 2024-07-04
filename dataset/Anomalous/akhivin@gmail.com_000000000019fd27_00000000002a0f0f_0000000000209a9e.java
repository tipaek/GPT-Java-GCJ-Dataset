import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static int askBit(Scanner scanner, int num) {
        printOutput("" + (num + 1));
        return scanner.nextInt();
    }

    private static void printOutput(String s) {
        System.out.println(s);
        System.out.flush();
    }

    public static int[] solve(Scanner input, int length) {
        int bitsRead = 0;
        int tries = 0;
        int[] bits = new int[length];

        while (bitsRead < length) {
            tries++;
            int bit = askBit(input, bitsRead);
            if (tries % 10 == 1) {
                continue;
            }
            bits[bitsRead++] = bit;

            if (tries > 150) {
                throw new RuntimeException("Exceeded maximum number of tries");
            }
        }

        return bits;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        int bitsLength = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] result = solve(input, bitsLength);
            if (!processAndCheckResult(input, result)) {
                return;
            }
        }
    }

    private static boolean processAndCheckResult(Scanner input, int[] result) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int value : result) {
            builder.append(value);
        }
        printOutput(builder.toString());

        char response = (char) System.in.read();
        return response == 'Y';
    }
}