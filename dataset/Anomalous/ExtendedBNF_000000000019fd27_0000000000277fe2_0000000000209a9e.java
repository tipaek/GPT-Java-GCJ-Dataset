import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            solve(scanner, B);
            System.out.flush();
            String response = scanner.next();
            if (response.equals("N")) break;
        }
    }

    public static void solve(Scanner scanner, int B) {
        int[] array = new int[B + 1];
        int samePairIndex = -1;
        int differentPairIndex = -1;
        int differentPairValue = -1;
        int lastIndex = 5;

        // Initialize array
        for (int i = 0; i <= B; i++) {
            array[i] = -1;
        }

        // First 10 digits
        for (int i = 1; i <= 5; i++) {
            array[i] = getInput(scanner, i);
            array[B - i + 1] = getInput(scanner, B - i + 1);

            if (array[i] == array[B - i + 1]) {
                samePairIndex = i;
            } else {
                differentPairIndex = i;
                differentPairValue = array[i];
            }
        }

        while (!isFinished(array)) {
            updateArray(array, determineChange(array, samePairIndex, differentPairIndex, differentPairValue, scanner));

            for (int i = lastIndex + 1; !isFinished(array) && i < lastIndex + 5; i++) {
                array[i] = getInput(scanner, i);
                array[B - i + 1] = getInput(scanner, B - i + 1);

                if (samePairIndex == -1 && array[i] == array[B - i + 1]) {
                    samePairIndex = i;
                }
                if (differentPairIndex == -1 && array[i] != array[B - i + 1]) {
                    differentPairIndex = i;
                }
            }
            lastIndex += 4;
            differentPairValue = array[differentPairIndex];
        }

        for (int i = 1; i <= B; i++) {
            System.out.print(array[i]);
        }
        System.out.flush();
        System.out.println();
    }

    public static int getInput(Scanner scanner, int index) {
        System.out.println(index);
        System.out.flush();
        return scanner.nextInt();
    }

    public static int determineChange(int[] array, int samePairIndex, int differentPairIndex, int differentPairValue, Scanner scanner) {
        if (samePairIndex != -1 && differentPairIndex != -1) {
            int newSamePairValue = getInput(scanner, samePairIndex);
            int newDifferentPairValue = getInput(scanner, differentPairIndex);

            if (newSamePairValue == array[samePairIndex]) {
                return (newDifferentPairValue == array[differentPairIndex]) ? 4 : 1;
            } else {
                return (newDifferentPairValue == differentPairValue) ? 3 : 2;
            }
        } else if (samePairIndex == -1) {
            int newDifferentPairValue = getInput(scanner, differentPairIndex);
            return (newDifferentPairValue == array[differentPairIndex]) ? 4 : 2;
        } else {
            int newSamePairValue = getInput(scanner, samePairIndex);
            return (newSamePairValue == array[samePairIndex]) ? 4 : 2;
        }
    }

    public static void updateArray(int[] array, int action) {
        if (action == 4) return;

        if (action == 1 || action == 3) {
            for (int i = 1; i <= array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i];
                array[array.length - i] = temp;
            }
        }

        if (action == 2 || action == 3) {
            for (int i = 1; i < array.length; i++) {
                array[i] = 1 - array[i];
            }
        }
    }

    public static boolean isFinished(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) return false;
        }
        return true;
    }
}