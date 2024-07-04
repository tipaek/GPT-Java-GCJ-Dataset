import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    private static boolean finished = false;
    private static int numQueries = 0;
    private static int[] array;
    private static boolean exploreMode = true;
    private static int increment = 0;
    private static int searchIndex = 1;
    private static int[] lastChange = {0, 0, 0, 0};
    private static int lastRecordedIndex = 1;
    private static int numBits;
    private static Scanner scanner;

    private static void explore() {
        System.out.println(searchIndex);
        int input = scanner.nextInt();
        array[searchIndex] = input;
        numQueries++;

        if (searchIndex == array.length / 2 + 1) finished = true;

        lastRecordedIndex = searchIndex > numBits / 2 ? numBits + 1 - searchIndex : searchIndex - 1;

        searchIndex = numBits + 1 - searchIndex + increment;
        increment = (increment + 1) % 2;

        if (numQueries % 10 == 0) {
            exploreMode = false;
            Arrays.fill(lastChange, 1);
        }
    }

    private static void investigate() {
        int iteration = 0;
        int checkIndex = 1;

        while (iteration < 10 && Arrays.stream(lastChange).sum() > 1) {
            System.out.println(checkIndex);
            int input = scanner.nextInt();
            numQueries++;

            if (array[checkIndex] == input) {
                lastChange[0] = 0; // wasn't complement
            } else {
                lastChange[3] = 0; // something changed
            }
            if (array[numBits + 1 - checkIndex] == input) {
                lastChange[2] = 0; // wasn't reverse and complement
            } else {
                lastChange[1] = 0; // wasn't reverse
            }
            checkIndex++;
            iteration++;
        }

        if (iteration == 10 || Arrays.stream(lastChange).sum() != 1) {
            System.err.println("Error: could not determine change");
        } else {
            if (lastChange[0] == 1) {
                complement();
            } else if (lastChange[1] == 1) {
                reverse();
            } else if (lastChange[2] == 1) {
                complement();
                reverse();
            }
            exploreMode = true;
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        numBits = scanner.nextInt();

        for (int test = 0; test < numTests; test++) {
            array = new int[numBits + 1];

            System.out.println(searchIndex);
            int input = scanner.nextInt();
            array[searchIndex] = input;
            numQueries++;
            searchIndex = numBits + 1 - searchIndex + increment;
            increment = (increment + 1) % 2;

            while (!finished) {
                if (!exploreMode) {
                    investigate();
                } else {
                    explore();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= numBits; i++) {
                result.append(array[i]);
            }

            System.out.println(result);

            scanner.nextLine(); // consume \n
            String confirmation = scanner.nextLine();
            if (confirmation.charAt(0) == 'N') {
                System.err.println("Error in output.");
                return;
            } else {
                resetState();
            }
        }
    }

    private static void resetState() {
        numQueries = 0;
        finished = false;
        exploreMode = true;
        increment = 0;
        searchIndex = 1;
        lastRecordedIndex = 1;
    }

    private static void reverse() {
        for (int i = 1; i <= array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i];
            array[array.length - i] = temp;
        }
    }

    private static void complement() {
        for (int i = 1; i < array.length; i++) {
            array[i] = (array[i] + 1) % 2;
        }
    }
}