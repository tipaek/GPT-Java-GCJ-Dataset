import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int t = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        aa: for (int k = 0; k < t; k++) {
            // TODO index starts at 0 but query 1 based
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
                    if (dumpArray(initialArray).length() != b) {
                        throw new Exception();
                    }
                    System.out.println(dumpArray(initialArray));
                    String judge = sc.nextLine();
                    if ("N".equals(judge)) {
                        break aa;
                    }
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
                    if (dumpArray(initialArray).length() != b) {
                        throw new Exception();
                    }
                    System.out.println(dumpArray(initialArray));
                    String judge = sc.nextLine();
                    if ("N".equals(judge)) {
                        break aa;
                    }
                    break;
                }

                if ((!validatingMode && currQuery % 10 == 1) || (validatingMode && currValidationQuery % 10 == 1)) {
                    // Next will be a shift
                    // We need to validate what happened
                    if (!validatingMode && currQuery % 10 == 1) {
                        startQuery = 1;
                        endQuery = b;
                    }
                    validatingMode = true;

                }
            }
        }

    }

    private static Integer[] haveClue(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> toCompare = new ArrayList<>();
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
        // Add complementary array
        toCompare.add(complemented);
        // Add initial array
        if (!arrEq(complemented, initialArray)) {
            toCompare.add(initialArray);
        }
        // Add reverse array
        boolean shouldAdd = true;
        for (int i = 0; i < toCompare.size(); i++) {
            Integer[] currArray = toCompare.get(i);
            if (arrEq(currArray, reversed)) {
                shouldAdd = false;
                break;
            }
        }
        if (shouldAdd) {
            toCompare.add(reversed);
        }

        // Add both array
        shouldAdd = true;
        for (int i = 0; i < toCompare.size(); i++) {
            Integer[] currArray = toCompare.get(i);
            if (arrEq(currArray, both)) {
                shouldAdd = false;
                break;
            }
        }
        if (shouldAdd) {
            toCompare.add(both);
        }

        // Test
        int matches = 0;
        Integer[] match = null;
        for (int i = 0; i < toCompare.size(); i++) {
            Integer[] currArray = toCompare.get(i);
            if (arrEq(currArray, changedArray)) {
                matches++;
                match = currArray;
            }
        }

        if (matches == 1) {
//            System.out.println(">>> " + dumpArray(match));
            return match;
        } else {
            return null;
        }
    }

    private static boolean arrEq(Integer[] a, Integer[] b) {
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
            s += array[i] != null ? array[i] : ".";
        }

        return s;
    }
}
