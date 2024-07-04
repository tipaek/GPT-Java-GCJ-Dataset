import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    private static int readInt(Scanner scanner) {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static void printLine(PrintStream out, int value) {
        out.println(value);
        out.flush();
    }

    private static void printLine(PrintStream out, String message) {
        out.println(message);
        out.flush();
    }

    private static void solveFor10(Scanner scanner, PrintStream out) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            printLine(out, i);
            result.append(readInt(scanner));
        }
        printLine(out, result.toString());
        String response = scanner.nextLine();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Wrong answer.");
        }
    }

    private static void solveFor20(Scanner scanner, PrintStream out) {
        int[] array = new int[20];
        for (int i = 1; i <= 5; i++) {
            printLine(out, i);
            array[i - 1] = readInt(scanner);
            printLine(out, 21 - i);
            array[20 - i] = readInt(scanner);
        }
        for (int i = 6; i <= 10; i++) {
            printLine(out, i);
            array[i - 1] = readInt(scanner);
            printLine(out, 21 - i);
            array[20 - i] = readInt(scanner);
        }
        processBlock(scanner, out, array, 0);
        processBlock(scanner, out, array, 10);
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }
        printLine(out, result.toString());
        String response = scanner.nextLine();
        if (!"Y".equals(response)) {
            throw new RuntimeException("Wrong answer.");
        }
    }

    private static void processBlock(Scanner scanner, PrintStream out, int[] array, int start) {
        int sameIndex = -1;
        int distinctIndex = -1;
        for (int i = 0; i < 5 && (sameIndex == -1 || distinctIndex == -1); i++) {
            if (array[start + i] == array[19 - start - i]) {
                sameIndex = start + i;
            } else {
                distinctIndex = start + i;
            }
        }
        if (sameIndex == -1 || distinctIndex == -1) {
            int index = (distinctIndex == -1) ? sameIndex : distinctIndex;
            printLine(out, index + 1);
            int result = readInt(scanner);
            if (array[index] != result) {
                complementBlock(array, start);
            }
            return;
        }
        printLine(out, sameIndex + 1);
        int sameResult = readInt(scanner);
        boolean sameEqual = array[sameIndex] == sameResult;
        printLine(out, distinctIndex + 1);
        int distinctResult = readInt(scanner);
        boolean distinctEqual = array[distinctIndex] == distinctResult;
        if (sameEqual) {
            if (!distinctEqual) {
                reverseBlock(array, start);
            }
        } else {
            if (distinctEqual) {
                reverseBlock(array, start);
                complementBlock(array, start);
            } else {
                complementBlock(array, start);
            }
        }
    }

    private static void complementBlock(int[] array, int start) {
        for (int i = 0; i < 5; i++) {
            array[start + i] ^= 1;
            array[19 - start - i] ^= 1;
        }
    }

    private static void reverseBlock(int[] array, int start) {
        for (int i = 0; i < 5; i++) {
            int temp = array[start + i];
            array[start + i] = array[19 - start - i];
            array[19 - start - i] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            if (bitLength == 10) {
                solveFor10(scanner, out);
            } else if (bitLength == 20) {
                solveFor20(scanner, out);
            }
        }
        scanner.close();
    }
}