import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int t = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        for (int k = 0; k < t; k++) {
            // TODO index starts at 0 but query 1 based
            Integer[] initialArray = new Integer[b];
            Integer[] changedArray = new Integer[b];
            int startQuery = 1;
            int endQuery = b;
            int currQuery = 1;
            int lastStartQuery = startQuery;
            int lastEndQuery = endQuery;
            boolean validatingMode = false;
            while (true) {
                // Check from start
                System.out.println(startQuery);
                int resp = Integer.parseInt(sc.nextLine());
                if (validatingMode) {
                    changedArray[startQuery - 1] = resp;
                } else {
                    initialArray[startQuery - 1] = resp;
                }
                startQuery++;
                currQuery++;
                if (!validatingMode) {
                    lastStartQuery = startQuery;
                }
                if (validatingMode && haveClue(initialArray, changedArray) != null) {
                    startQuery = lastStartQuery;
                    endQuery = lastEndQuery;
                    initialArray = haveClue(initialArray, changedArray);
                    validatingMode = false;
                }
                if (startQuery > endQuery) {
                    System.out.println(dumpArray(initialArray));
                    sc.nextLine();
                    break;
                }

                // Check from end
                System.out.println(endQuery);
                resp = Integer.parseInt(sc.nextLine());
                if (validatingMode) {
                    changedArray[endQuery - 1] = resp;
                } else {
                    initialArray[endQuery - 1] = resp;
                }
                endQuery--;
                currQuery++;
                if (!validatingMode) {
                    lastEndQuery = endQuery;
                }
                if (validatingMode && haveClue(initialArray, changedArray) != null) {
                    startQuery = lastStartQuery;
                    endQuery = lastEndQuery;
                    initialArray = haveClue(initialArray, changedArray);
                    validatingMode = false;
                }
                if (startQuery > endQuery) {
                    // TODO May be wrong
                    System.out.println(dumpArray(initialArray));
                    sc.nextLine();
                    break;
                }

                if (currQuery % 10 == 1) {
                    // Next will be a shift
                    // We need to validate what happened
                    validatingMode = true;
                    startQuery = 1;
                    endQuery = b;
                }
            }
        }

    }

    private static Integer[] haveClue(Integer[] initialArray, Integer[] changedArray) {
        Integer[] complemented = new Integer[initialArray.length];
        Integer[] reversed = new Integer[initialArray.length];
        Integer[] both = new Integer[initialArray.length];
        System.arraycopy(initialArray, 0, reversed, 0, initialArray.length);
        Collections.reverse(Arrays.asList(reversed));
        System.arraycopy(initialArray, 0, both, 0, initialArray.length);
        Collections.reverse(Arrays.asList(both));
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] != null) {
                complemented[i] = initialArray[i] == 1 ? 0 : 1;
            }
        }
        for (int i = 0; i < both.length; i++) {
            if (both[i] != null) {
                both[i] = both[i] == 1 ? 0 : 1;
            }
        }

        if (areArraysEqualIgnoreNull(changedArray, complemented) && !areArraysEqualIgnoreNull(changedArray, reversed) && !areArraysEqualIgnoreNull(changedArray, both)) {
            return complemented;
        } else if (!areArraysEqualIgnoreNull(changedArray, complemented) && areArraysEqualIgnoreNull(changedArray, reversed) && !areArraysEqualIgnoreNull(changedArray, both)) {
            return reversed;
        } else if (!areArraysEqualIgnoreNull(changedArray, complemented) && !areArraysEqualIgnoreNull(changedArray, reversed) && areArraysEqualIgnoreNull(changedArray, both)) {
            return both;
        } else {
            return null;
        }
    }

    private static boolean areArraysEqualIgnoreNull(Integer[] a, Integer[] b) {
        boolean equal = true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && b[i] != null) {
                if (!a[i].equals(b[i])) {
                    equal = false;
                    break;
                }
            }
        }

        return equal;
    }

    private static String dumpArray(Integer[] array) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }

        return s;
    }
}
