import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int askBit(Scanner scanner, int index) {
        System.out.println(index + 1);
        System.out.flush();
        return scanner.nextInt();
    }

    private static int[] solve(Scanner input, int length) {
        int attempts = 0;
        ArrayList<int[]> candidates = new ArrayList<>();
        int[] bits = initializeArray(length);
        candidates.add(bits);
        int position;

        while (candidates.size() == 1 && (position = findUnknownBitIndex(candidates.get(0))) >= 0) {
            attempts++;
            int[] currentArray = candidates.get(0);
            int bitValue = askBit(input, position);
            if (attempts % 10 == 1) {
                candidates = updateCandidates(candidates, position, bitValue);
            }
            currentArray[position] = bitValue;

            if (attempts > 150) {
                throw new RuntimeException("Too many attempts");
            }
        }

        return bits;
    }

    private static int findUnknownBitIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private static ArrayList<int[]> updateCandidates(ArrayList<int[]> candidates, int position, int bitValue) {
        ArrayList<int[]> newCandidates = new ArrayList<>();
        for (int[] array : candidates) {
            int[] reversedArray = reverseArray(array);
            int[] complementedArray = complementArray(array);
            int[] reversedComplementedArray = reverseArray(complementArray(array));

            if (array[position] >= 0 && array[position] != bitValue) {
                continue;
            }

            array[position] = bitValue;
            if (reversedArray[position] == bitValue) {
                newCandidates.add(reversedArray);
            }
            if (complementedArray[position] == bitValue) {
                newCandidates.add(complementedArray);
            }
            if (reversedComplementedArray[position] == bitValue) {
                newCandidates.add(reversedComplementedArray);
            }
            newCandidates.add(array);
        }

        return newCandidates;
    }

    private static int[] complementArray(int[] array) {
        int[] complementedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            complementedArray[i] = array[i] == 0 ? 1 : (array[i] == 1 ? 0 : array[i]);
        }
        return complementedArray;
    }

    private static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - i - 1];
        }
        return reversedArray;
    }

    private static int[] initializeArray(int length) {
        int[] array = new int[length];
        Arrays.fill(array, -1);
        return array;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        int bitsLength = input.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] solution = solve(input, bitsLength);
            boolean result = submitSolution(input, solution);
            if (!result) {
                System.exit(77);
            }
        }
    }

    private static boolean submitSolution(Scanner input, int[] solution) {
        StringBuilder result = new StringBuilder();
        for (int bit : solution) {
            result.append(bit);
        }
        System.out.println(result.toString());
        System.out.flush();

        String response = input.next("(Y|N)");
        return "Y".equals(response.trim());
    }
}