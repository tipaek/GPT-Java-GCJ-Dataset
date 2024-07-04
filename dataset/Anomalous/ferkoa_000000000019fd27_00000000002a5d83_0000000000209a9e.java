import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    //////////////////////////////////////////////////
    private static int readNextInt(Scanner scanner) {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    //////////////////////////////////////////////////
    private static void printAndFlush(PrintStream out, int value) {
        out.println(value);
        out.flush();
    }

    //////////////////////////////////////////////////
    private static void printAndFlush(PrintStream out, String message) {
        out.println(message);
        out.flush();
    }

    //////////////////////////////////////////////////
    private static void solveFor10(Scanner scanner, PrintStream out) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            printAndFlush(out, i);
            result.append(readNextInt(scanner));
        }
        printAndFlush(out, result.toString());
        String response = scanner.nextLine();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Wrong answer.");
        }
    }

    //////////////////////////////////////////////////
    private static void solveFor20(Scanner scanner, PrintStream out) {
        int[] array = new int[20];
        for (int i = 1; i <= 5; i++) {
            printAndFlush(out, i);
            array[i - 1] = readNextInt(scanner);
            printAndFlush(out, 21 - i);
            array[20 - i] = readNextInt(scanner);
        }
        for (int i = 6; i <= 10; i++) {
            printAndFlush(out, i);
            array[i - 1] = readNextInt(scanner);
            printAndFlush(out, 21 - i);
            array[20 - i] = readNextInt(scanner);
        }
        processBlock(scanner, out, array, 0);
        processBlock(scanner, out, array, 5);
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

    //////////////////////////////////////////////////
    private static void processBlock(Scanner scanner, PrintStream out, int[] array, int start) {
        int sameIndex = -1;
        int distinctIndex = -1;
        for (int i = 0; i < 5 && (sameIndex == -1 || distinctIndex == -1); i++) {
            if (array[start + i] == array[array.length - 1 - start - i]) {
                sameIndex = start + i;
            } else {
                distinctIndex = start + i;
            }
        }
        if (sameIndex == -1 || distinctIndex == -1) {
            int index = distinctIndex == -1 ? sameIndex : distinctIndex;
            printAndFlush(out, index + 1);
            int response = readNextInt(scanner);
            if (array[index] == response) {
                return;
            }
            complementArray(array, start);
            return;
        }
        printAndFlush(out, sameIndex + 1);
        int sameResponse = readNextInt(scanner);
        boolean isSameEqual = array[sameIndex] == sameResponse;
        printAndFlush(out, distinctIndex + 1);
        int distinctResponse = readNextInt(scanner);
        boolean isDistinctEqual = array[distinctIndex] == distinctResponse;
        if (isSameEqual) {
            if (isDistinctEqual) {
                return;
            } else {
                reverseArray(array, start);
                return;
            }
        } else {
            if (isDistinctEqual) {
                reverseArray(array, start);
                complementArray(array, start);
                return;
            } else {
                complementArray(array, start);
                return;
            }
        }
    }

    //////////////////////////////////////////////////
    private static void complementArray(int[] array, int start) {
        for (int i = 0; i < 5; i++) {
            array[start + i] ^= 1;
            array[array.length - 1 - start - i] ^= 1;
        }
    }

    //////////////////////////////////////////////////
    private static void reverseArray(int[] array, int start) {
        for (int i = 0; i < 5; i++) {
            int temp = array[start + i];
            array[start + i] = array[array.length - 1 - start - i];
            array[array.length - 1 - start - i] = temp;
        }
    }

    //////////////////////////////////////////////////
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            if (bitLength == 10) {
                solveFor10(scanner, out);
            } else if (bitLength == 20) {
                solveFor20(scanner, out);
            }
        }
        scanner.close();
    }
}