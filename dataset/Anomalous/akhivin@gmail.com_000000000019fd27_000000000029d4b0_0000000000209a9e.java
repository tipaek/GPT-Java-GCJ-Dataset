import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    private static final int[] BITS = {0, 0, 0, 1, 1, 0, 1, 1, 1, 1};
    private static final boolean DEBUG = false;

    private static int askBit(Scanner scanner, int index) {
        if (DEBUG) {
            return BITS[index];
        }
        output(String.valueOf(index + 1));
        return scanner.nextInt();
    }

    private static void output(String message) {
        System.out.print(message);
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

            if (bitsRead > 150) {
                throw new RuntimeException();
            }
        }

        return bits;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = getScanner();
        int testCases = input.nextInt();
        int bitsLength = input.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int[] answer = solve(input, bitsLength);
            boolean result = outputAnswerAndGetResponse(input, answer);
            if (!result) {
                return;
            }
        }
    }

    private static Scanner getScanner() throws FileNotFoundException {
        if (DEBUG) {
            return new Scanner(new FileInputStream(new File("input.txt")));
        }
        return new Scanner(System.in);
    }

    private static boolean outputAnswerAndGetResponse(Scanner input, int[] answer) {
        StringBuilder builder = new StringBuilder();
        for (int bit : answer) {
            builder.append(bit);
        }
        output(builder.toString());

        String response = input.nextLine();
        return "Y".equals(response.trim());
    }
}