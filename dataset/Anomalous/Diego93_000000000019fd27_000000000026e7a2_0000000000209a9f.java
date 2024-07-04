import java.util.Scanner;
import java.util.function.Consumer;

public class Solution {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i);
        }
    }

    private static void processTestCase(int testCaseNumber) {
        String input = getString();
        String result = transformString(input);
        System.out.println(String.format("Case #%d: %s", testCaseNumber, result));
    }

    private static String transformString(String input) {
        String[] replacements = {
                "(1)", "((2))", "(((3)))", "((((4))))", "(((((5)))))",
                "((((((6))))))", "(((((((7)))))))", "((((((((8))))))))", "(((((((((9)))))))))"
        };

        for (int i = 1; i <= 9; i++) {
            input = input.replaceAll(String.valueOf(i), replacements[i - 1]);
        }

        for (int i = 0; i < 10; i++) {
            input = input.replaceAll("\\)\\(", "");
        }

        return input;
    }

    private static String getString() {
        return scanner.next();
    }

    private static int getInt() {
        return scanner.nextInt();
    }

    private static long getLong() {
        return scanner.nextLong();
    }

    private static Integer[] getArrayInt(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = getInt();
        }
        return array;
    }

    private static Long[] getArrayLong(int size) {
        Long[] array = new Long[size];
        for (int i = 0; i < size; i++) {
            array[i] = getLong();
        }
        return array;
    }

    private static Integer[][] getMatrixInt(int rows, int cols) {
        Integer[][] matrix = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = getArrayInt(cols);
        }
        return matrix;
    }

    private static void forEachChar(String str, Consumer<Character> consumer) {
        for (int i = 0; i < str.length(); i++) {
            consumer.accept(str.charAt(i));
        }
    }

    private static <T> void forEach(T[] array, Consumer<T> consumer) {
        for (T element : array) {
            consumer.accept(element);
        }
    }
}