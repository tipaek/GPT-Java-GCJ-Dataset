import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static int getNextInt(Scanner scanner) {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static void printAndFlush(PrintStream out, int value) {
        out.println(value);
        out.flush();
    }

    private static void printAndFlush(PrintStream out, String value) {
        out.println(value);
        out.flush();
    }

    private static void solveFor10Bits(Scanner scanner, PrintStream out) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            printAndFlush(out, i);
            result.append(getNextInt(scanner));
        }
        printAndFlush(out, result.toString());
        String response = scanner.nextLine();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Wrong answer.");
        }
    }

    private static void solveFor20Bits(Scanner scanner, PrintStream out) {
        int[] array = new int[20];
        for (int i = 1; i <= 5; i++) {
            printAndFlush(out, i);
            array[i - 1] = getNextInt(scanner);
            printAndFlush(out, 21 - i);
            array[20 - i] = getNextInt(scanner);
        }
        for (int i = 6; i <= 10; i++) {
            printAndFlush(out, i);
            array[i - 1] = getNextInt(scanner);
            printAndFlush(out, 21 - i);
            array[20 - i] = getNextInt(scanner);
        }
        processBlock(scanner, out, array, 0);
        processBlock(scanner, out, array, 10);
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }
        printAndFlush(out, result.toString());
        String response = scanner.nextLine();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Wrong answer.");
        }
    }

    private static void processBlock(Scanner scanner, PrintStream out, int[] array, int startIndex) {
        int sameIndex = -1;
        int distinctIndex = -1;
        for (int i = 0; i < 5 && (sameIndex == -1 || distinctIndex == -1); i++) {
            if (array[startIndex + i] == array[array.length - 1 - startIndex - i]) {
                sameIndex = startIndex + i;
            } else {
                distinctIndex = startIndex + i;
            }
        }
        if (sameIndex == -1 || distinctIndex == -1) {
            int index = (distinctIndex == -1) ? sameIndex : distinctIndex;
            printAndFlush(out, index + 1);
            int response = getNextInt(scanner);
            if (array[index] == response) return;
            complementArray(array, startIndex);
            return;
        }
        printAndFlush(out, sameIndex + 1);
        int sameResponse = getNextInt(scanner);
        boolean isSameEqual = array[sameIndex] == sameResponse;
        printAndFlush(out, distinctIndex + 1);
        int distinctResponse = getNextInt(scanner);
        boolean isDistinctEqual = array[distinctIndex] == distinctResponse;
        if (isSameEqual) {
            if (isDistinctEqual) {
                return;
            } else {
                reverseArray(array, startIndex);
                return;
            }
        } else {
            if (isDistinctEqual) {
                reverseArray(array, startIndex);
                complementArray(array, startIndex);
                return;
            } else {
                complementArray(array, startIndex);
                return;
            }
        }
    }

    private static void complementArray(int[] array, int startIndex) {
        for (int i = 0; i < 5; i++) {
            array[startIndex + i] ^= 1;
            array[array.length - 1 - startIndex - i] ^= 1;
        }
    }

    private static void reverseArray(int[] array, int startIndex) {
        for (int i = 0; i < 5; i++) {
            int temp = array[startIndex + i];
            array[startIndex + i] = array[array.length - 1 - startIndex - i];
            array[array.length - 1 - startIndex - i] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int testCases = scanner.nextInt();
        int bitCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            if (bitCount == 10) {
                solveFor10Bits(scanner, out);
            } else if (bitCount == 20) {
                solveFor20Bits(scanner, out);
            }
        }
        scanner.close();
    }
}