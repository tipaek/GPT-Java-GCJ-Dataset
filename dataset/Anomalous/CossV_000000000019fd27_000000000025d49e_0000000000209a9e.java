import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int t = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        
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
                // Check from start
                System.out.println(startQuery);
                int resp = Integer.parseInt(sc.nextLine());
                if (validatingMode) {
                    changedArray[startQuery - 1] = resp;
                } else {
                    initialArray[startQuery - 1] = resp;
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
                    Integer[] clueArray = haveClue(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        validatingMode = false;
                    }
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
                if (!validatingMode) {
                    currQuery++;
                } else {
                    currValidationQuery++;
                }
                if (!validatingMode) {
                    lastEndQuery = endQuery;
                }
                if (validatingMode) {
                    Integer[] clueArray = haveClue(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        validatingMode = false;
                    }
                }
                if (startQuery > endQuery) {
                    System.out.println(dumpArray(initialArray));
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

    private static Integer[] haveClue(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> toCompare = new ArrayList<>();
        Integer[] complemented = complementArray(initialArray);
        Integer[] reversed = reverseArray(initialArray);
        Integer[] both = complementArray(reversed);

        toCompare.add(complemented);
        if (!Arrays.equals(complemented, initialArray)) {
            toCompare.add(initialArray);
        }
        if (!containsArray(toCompare, reversed)) {
            toCompare.add(reversed);
        }
        if (!containsArray(toCompare, both)) {
            toCompare.add(both);
        }

        int matches = 0;
        Integer[] match = null;
        for (Integer[] candidate : toCompare) {
            if (Arrays.equals(candidate, changedArray)) {
                matches++;
                match = candidate;
            }
        }

        return matches == 1 ? match : null;
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
        Integer[] reversed = Arrays.copyOf(array, array.length);
        Collections.reverse(Arrays.asList(reversed));
        return reversed;
    }

    private static boolean containsArray(List<Integer[]> list, Integer[] array) {
        for (Integer[] item : list) {
            if (Arrays.equals(item, array)) {
                return true;
            }
        }
        return false;
    }

    private static String dumpArray(Integer[] array) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : array) {
            sb.append(num);
        }
        return sb.toString();
    }
}