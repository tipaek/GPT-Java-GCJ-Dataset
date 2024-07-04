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
        output("" + (index + 1));
        return scanner.nextInt();
    }

    private static void output(String s) {
        System.out.print(s);
        System.out.flush();
    }

    public static int[] solve(Scanner scanner, int length) {
        int bitsRead = 0;
        int tries = 0;
        int[] bits = new int[length];

        while (bitsRead < length) {
            tries++;
            int bit = askBit(scanner, bitsRead);
            if (tries % 10 == 1) {
                continue;
            }
            bits[bitsRead++] = bit;

            if (bitsRead > 150) {
                throw new RuntimeException("Exceeded maximum bits read limit");
            }
        }

        return bits;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = getScanner();
        int testCases = scanner.nextInt();
        int bitsLength = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int[] answer = solve(scanner, bitsLength);
            if (!outputAnswerAndGetResponse(scanner, answer)) {
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

    private static boolean outputAnswerAndGetResponse(Scanner scanner, int[] answer) {
        StringBuilder builder = new StringBuilder();
        for (int bit : answer) {
            builder.append(bit);
        }
        output(builder.toString());

        while (true) {
            String response = scanner.nextLine().trim();
            if ("Y".equals(response)) {
                return true;
            } else if ("N".equals(response)) {
                System.exit(9);
            }
        }
    }
}