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
                    Integer[] clueArray = getClueArray(initialArray, changedArray);
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
                    Integer[] clueArray = getClueArray(initialArray, changedArray);
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

    private static Integer[] getClueArray(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> possibleArrays = generatePossibleArrays(initialArray);

        for (Integer[] possibleArray : possibleArrays) {
            if (arraysEqual(possibleArray, changedArray)) {
                return possibleArray;
            }
        }
        return null;
    }

    private static List<Integer[]> generatePossibleArrays(Integer[] initialArray) {
        List<Integer[]> possibleArrays = new ArrayList<>();
        Integer[] complemented = complementArray(initialArray);
        Integer[] reversed = reverseArray(initialArray);
        Integer[] both = complementArray(reversed);

        possibleArrays.add(complemented);
        if (!arraysEqual(complemented, initialArray)) {
            possibleArrays.add(initialArray);
        }
        if (!listContainsArray(possibleArrays, reversed)) {
            possibleArrays.add(reversed);
        }
        if (!listContainsArray(possibleArrays, both)) {
            possibleArrays.add(both);
        }

        return possibleArrays;
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
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    private static boolean listContainsArray(List<Integer[]> list, Integer[] array) {
        for (Integer[] arr : list) {
            if (arraysEqual(arr, array)) {
                return true;
            }
        }
        return false;
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
        for (Integer i : array) {
            sb.append(i);
        }
        return sb.toString();
    }
}