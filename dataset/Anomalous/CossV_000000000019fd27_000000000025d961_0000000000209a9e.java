import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        for (int k = 0; k < t; k++) {
            Integer[] initialArray = new Integer[b];
            Integer[] changedArray = new Integer[b];
            int startQuery = 1;
            int endQuery = b;
            int currQuery = 1;
            int currValidationQuery = 1;
            int lastStartQuery = startQuery;
            int lastEndQuery = endQuery;
            boolean validatingMode = false;

            while (true) {
                // Query from start
                System.out.println(startQuery);
                int response = Integer.parseInt(sc.nextLine());
                if (validatingMode) {
                    changedArray[startQuery - 1] = response;
                } else {
                    initialArray[startQuery - 1] = response;
                }
                startQuery++;
                if (!validatingMode) {
                    currQuery++;
                } else {
                    currValidationQuery++;
                }
                if (!validatingMode) {
                    lastStartQuery = startQuery;
                }
                if (validatingMode) {
                    Integer[] clueArray = getClue(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        validatingMode = false;
                    }
                }
                if (startQuery > endQuery) {
                    System.out.println(arrayToString(initialArray));
                    sc.nextLine();
                    break;
                }

                // Query from end
                System.out.println(endQuery);
                response = Integer.parseInt(sc.nextLine());
                if (validatingMode) {
                    changedArray[endQuery - 1] = response;
                } else {
                    initialArray[endQuery - 1] = response;
                }
                endQuery--;
                if (!validatingMode) {
                    currQuery++;
                } else {
                    currValidationQuery++;
                }
                if (!validatingMode) {
                    lastEndQuery = endQuery;
                }
                if (validatingMode) {
                    Integer[] clueArray = getClue(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        validatingMode = false;
                    }
                }
                if (startQuery > endQuery) {
                    System.out.println(arrayToString(initialArray));
                    sc.nextLine();
                    break;
                }

                if ((!validatingMode && currQuery % 10 == 1) || (validatingMode && currValidationQuery % 10 == 1)) {
                    validatingMode = true;
                    startQuery = 1;
                    endQuery = b;
                }
            }
        }
    }

    private static Integer[] getClue(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> candidates = new ArrayList<>();
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

        candidates.add(complemented);
        if (!arraysEqual(complemented, initialArray)) {
            candidates.add(initialArray);
        }

        if (candidates.stream().noneMatch(arr -> arraysEqual(arr, reversed))) {
            candidates.add(reversed);
        }

        if (candidates.stream().noneMatch(arr -> arraysEqual(arr, both))) {
            candidates.add(both);
        }

        return candidates.stream()
                .filter(arr -> arraysEqual(arr, changedArray))
                .reduce((a, b) -> null)
                .orElse(null);
    }

    private static boolean arraysEqual(Integer[] a, Integer[] b) {
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