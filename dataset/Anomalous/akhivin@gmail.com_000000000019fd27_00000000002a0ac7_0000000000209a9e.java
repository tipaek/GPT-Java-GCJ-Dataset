import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static int askBit(Scanner scanner, int num) {
        printOutput(String.valueOf(num + 1));
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
            int[] answer = solve(input, bitsLength);
            boolean result = outputAnswerAndGetResponse(input, answer);
            if (!result) {
                System.exit(77);
            }
        }
    }

    private static boolean outputAnswerAndGetResponse(Scanner input, int[] answer) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int bit : answer) {
            builder.append(bit);
        }
        printOutput(builder.toString());

        char response = (char) System.in.read();
        return response == 'Y';
    }
}