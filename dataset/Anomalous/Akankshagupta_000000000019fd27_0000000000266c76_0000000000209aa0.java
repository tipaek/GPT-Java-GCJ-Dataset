import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[][] squareArray = new int[n][n];

            if (k < n) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
                continue;
            }

            int baseValue = k / n;
            int remainder = k % n;

            for (int i = n - 1; i >= 0; i--) {
                squareArray[i][i] = baseValue;
                if (remainder > 0) {
                    squareArray[i][i]++;
                    remainder--;
                }
            }

            populateSquare(squareArray, n);

            if (hasDuplicates(squareArray, n)) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": POSSIBLE");
                printSquare(squareArray, n);
            }
        }
    }

    private static boolean hasDuplicates(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            if (containsDuplicates(array[i])) return true;
            if (containsDuplicates(getColumn(array, i))) return true;
        }
        return false;
    }

    private static boolean containsDuplicates(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            if (map.containsKey(value)) return true;
            map.put(value, 1);
        }
        return false;
    }

    private static int[] getColumn(int[][] array, int columnIndex) {
        int[] column = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            column[i] = array[i][columnIndex];
        }
        return column;
    }

    private static void populateSquare(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            int value = array[i][i];
            int temp = 1;
            for (int j = i + 1; j < size; j++) {
                if (temp == value) temp++;
                array[i][j] = temp++;
            }
            for (int j = 0; j < i; j++) {
                if (temp == value) temp++;
                array[i][j] = temp++;
            }
        }
    }

    private static void printSquare(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}