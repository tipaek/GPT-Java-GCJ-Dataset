import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int t = 0; t < testCases; t++) {
            Integer[] initialArray = new Integer[bitLength];
            Integer[] changedArray = new Integer[bitLength];
            int start = 1, end = bitLength, queryCount = 1;
            int lastStart = start, lastEnd = end;
            boolean isValidating = false;

            while (true) {
                if (queryCount % 10 == 1 && queryCount > 1) {
                    isValidating = true;
                    start = 1;
                    end = bitLength;
                }

                System.out.println(start);
                int response = Integer.parseInt(sc.nextLine());
                if (isValidating) {
                    changedArray[start - 1] = response;
                } else {
                    initialArray[start - 1] = response;
                }
                start++;
                queryCount++;

                if (!isValidating) {
                    lastStart = start;
                }

                if (isValidating && (initialArray = applyClue(initialArray, changedArray)) != null) {
                    start = lastStart;
                    end = lastEnd;
                    isValidating = false;
                }

                if (start > end) {
                    System.out.println(arrayToString(initialArray));
                    sc.nextLine();
                    break;
                }

                System.out.println(end);
                response = Integer.parseInt(sc.nextLine());
                if (isValidating) {
                    changedArray[end - 1] = response;
                } else {
                    initialArray[end - 1] = response;
                }
                end--;
                queryCount++;

                if (!isValidating) {
                    lastEnd = end;
                }

                if (isValidating && (initialArray = applyClue(initialArray, changedArray)) != null) {
                    start = lastStart;
                    end = lastEnd;
                    isValidating = false;
                }

                if (start > end) {
                    System.out.println(arrayToString(initialArray));
                    sc.nextLine();
                    break;
                }
            }
        }
    }

    private static Integer[] applyClue(Integer[] initialArray, Integer[] changedArray) {
        Integer[] complemented = complementArray(initialArray);
        Integer[] reversed = reverseArray(initialArray);
        Integer[] complementedReversed = complementArray(reversed);

        if (arraysEqualIgnoringNull(changedArray, complemented) && !arraysEqualIgnoringNull(changedArray, reversed) && !arraysEqualIgnoringNull(changedArray, complementedReversed)) {
            return complemented;
        } else if (!arraysEqualIgnoringNull(changedArray, complemented) && arraysEqualIgnoringNull(changedArray, reversed) && !arraysEqualIgnoringNull(changedArray, complementedReversed)) {
            return reversed;
        } else if (!arraysEqualIgnoringNull(changedArray, complemented) && !arraysEqualIgnoringNull(changedArray, reversed) && arraysEqualIgnoringNull(changedArray, complementedReversed)) {
            return complementedReversed;
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

    private static boolean arraysEqualIgnoringNull(Integer[] a, Integer[] b) {
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