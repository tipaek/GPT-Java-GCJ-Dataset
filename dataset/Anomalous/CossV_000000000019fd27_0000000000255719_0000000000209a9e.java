import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int t = 0; t < testCases; t++) {
            Integer[] initialArray = new Integer[bitLength];
            Integer[] changedArray = new Integer[bitLength];
            int startQuery = 1;
            int endQuery = bitLength;
            int currQuery = 1;
            int lastStartQuery = startQuery;
            int lastEndQuery = endQuery;
            boolean validatingMode = false;

            while (true) {
                // Query from start
                System.out.println(startQuery);
                int response = Integer.parseInt(scanner.nextLine());
                if (validatingMode) {
                    changedArray[startQuery - 1] = response;
                } else {
                    initialArray[startQuery - 1] = response;
                }
                startQuery++;
                currQuery++;
                if (!validatingMode) {
                    lastStartQuery = startQuery;
                }
                if (validatingMode && (initialArray = haveClue(initialArray, changedArray)) != null) {
                    startQuery = lastStartQuery;
                    endQuery = lastEndQuery;
                    validatingMode = false;
                }
                if (startQuery > endQuery) {
                    System.out.println(arrayToString(initialArray));
                    scanner.nextLine();
                    break;
                }

                // Query from end
                System.out.println(endQuery);
                response = Integer.parseInt(scanner.nextLine());
                if (validatingMode) {
                    changedArray[endQuery - 1] = response;
                } else {
                    initialArray[endQuery - 1] = response;
                }
                endQuery--;
                currQuery++;
                if (!validatingMode) {
                    lastEndQuery = endQuery;
                }
                if (validatingMode && (initialArray = haveClue(initialArray, changedArray)) != null) {
                    startQuery = lastStartQuery;
                    endQuery = lastEndQuery;
                    validatingMode = false;
                }
                if (startQuery > endQuery) {
                    System.out.println(arrayToString(initialArray));
                    scanner.nextLine();
                    break;
                }

                if (currQuery % 10 == 1) {
                    validatingMode = true;
                    startQuery = 1;
                    endQuery = bitLength;
                }
            }
        }
    }

    private static Integer[] haveClue(Integer[] initialArray, Integer[] changedArray) {
        Integer[] complemented = complementArray(initialArray);
        Integer[] reversed = reverseArray(initialArray);
        Integer[] both = complementArray(reversed);

        if (areArraysEqualIgnoreNull(changedArray, complemented)) {
            return complemented;
        } else if (areArraysEqualIgnoreNull(changedArray, reversed)) {
            return reversed;
        } else if (areArraysEqualIgnoreNull(changedArray, both)) {
            return both;
        } else if (areArraysEqualIgnoreNull(changedArray, initialArray)) {
            return initialArray;
        } else {
            return null;
        }
    }

    private static Integer[] complementArray(Integer[] array) {
        Integer[] complemented = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                complemented[i] = array[i] == 1 ? 0 : 1;
            }
        }
        return complemented;
    }

    private static Integer[] reverseArray(Integer[] array) {
        Integer[] reversed = new Integer[array.length];
        System.arraycopy(array, 0, reversed, 0, array.length);
        Collections.reverse(Arrays.asList(reversed));
        return reversed;
    }

    private static boolean areArraysEqualIgnoreNull(Integer[] a, Integer[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && b[i] != null && !a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    private static String arrayToString(Integer[] array) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : array) {
            sb.append(num);
        }
        return sb.toString();
    }
}