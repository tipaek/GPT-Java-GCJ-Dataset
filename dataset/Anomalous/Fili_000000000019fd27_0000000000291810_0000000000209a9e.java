import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int[] array = new int[B];
            int counter = 0;

            while (counter < B) {
                if (counter == 0) {
                    counter = initializeArray(input, array, counter, B);
                } else {
                    counter = updateArray(input, array, counter, B);
                }
            }

            StringBuilder result = new StringBuilder();
            for (int k : array) {
                result.append(k);
            }
            System.out.println(result.toString());
            if (input.next().equals("N")) {
                break;
            }
        }
    }

    private static int initializeArray(Scanner input, int[] array, int counter, int B) {
        for (int j = 0; j < 5; j++) {
            System.out.println(j + 1);
            array[j] = Integer.parseInt(input.next());
            counter++;
        }
        for (int j = B - 1; j >= B - 5; j--) {
            System.out.println(j + 1);
            array[j] = Integer.parseInt(input.next());
            counter++;
        }
        return counter;
    }

    private static int updateArray(Scanner input, int[] array, int counter, int B) {
        int temp = counter / 2;
        int equalIndex = findEqualIndex(array, temp, B);
        int notEqualIndex = findNotEqualIndex(array, temp, B);

        boolean changeEqual = false;
        boolean changeNotEqual = false;

        if (equalIndex != -1) {
            System.out.println(equalIndex + 1);
            if (Integer.parseInt(input.next()) != array[equalIndex]) {
                changeEqual = true;
            }
        }

        if (notEqualIndex != -1) {
            System.out.println(notEqualIndex + 1);
            if (Integer.parseInt(input.next()) != array[notEqualIndex]) {
                changeNotEqual = true;
            }
        }

        if (equalIndex == -1 || notEqualIndex == -1) {
            System.out.println(1);
            input.next();
        }

        applyChanges(array, temp, B, changeEqual, changeNotEqual);

        for (int j = temp; j < temp + 4; j++) {
            System.out.println(j + 1);
            array[j] = Integer.parseInt(input.next());
            counter++;
        }
        for (int j = B - 1 - temp; j > B - 1 - temp - 4; j--) {
            System.out.println(j + 1);
            array[j] = Integer.parseInt(input.next());
            counter++;
        }

        return counter;
    }

    private static int findEqualIndex(int[] array, int temp, int B) {
        for (int j = 0; j < temp; j++) {
            if (array[j] == array[B - j - 1]) {
                return j;
            }
        }
        return -1;
    }

    private static int findNotEqualIndex(int[] array, int temp, int B) {
        for (int j = 0; j < temp; j++) {
            if (array[j] != array[B - j - 1]) {
                return j;
            }
        }
        return -1;
    }

    private static void applyChanges(int[] array, int temp, int B, boolean changeEqual, boolean changeNotEqual) {
        for (int j = 0; j < temp; j++) {
            if (array[j] == array[B - j - 1] && changeEqual) {
                array[j] = array[B - j - 1] = 1 - array[j];
            }
            if (array[j] != array[B - j - 1] && changeNotEqual) {
                array[j] = array[B - j - 1] = 1 - array[j];
            }
        }
    }
}