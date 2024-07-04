import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int t = 0; t < testCases; t++) {
            Integer[] initialArray = new Integer[bitLength];
            Integer[] changedArray = new Integer[bitLength];
            int startQuery = 1;
            int endQuery = bitLength;
            int queryCount = 1;
            int validationQueryCount = 1;
            int lastStartQuery = startQuery;
            int lastEndQuery = endQuery;
            boolean isValidating = false;

            while (true) {
                // Query from start
                System.out.println(startQuery);
                int response = Integer.parseInt(sc.nextLine());
                if (isValidating) {
                    changedArray[startQuery - 1] = response;
                } else {
                    initialArray[startQuery - 1] = response;
                }
                startQuery++;
                if (!isValidating) {
                    queryCount++;
                } else {
                    validationQueryCount++;
                }
                if (!isValidating) {
                    lastStartQuery = startQuery;
                }
                if (isValidating) {
                    Integer[] clueArray = getClueArray(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        isValidating = false;
                    }
                }
                if (startQuery > endQuery) {
                    if (formatArray(initialArray).length() != bitLength) {
                        throw new Exception();
                    }
                    System.out.println(formatArray(initialArray));
                    String judgeResponse = sc.nextLine();
                    if ("N".equals(judgeResponse)) {
                        break;
                    }
                    break;
                }

                // Query from end
                System.out.println(endQuery);
                response = Integer.parseInt(sc.nextLine());
                if (isValidating) {
                    changedArray[endQuery - 1] = response;
                } else {
                    initialArray[endQuery - 1] = response;
                }
                endQuery--;
                if (!isValidating) {
                    queryCount++;
                } else {
                    validationQueryCount++;
                }
                if (!isValidating) {
                    lastEndQuery = endQuery;
                }
                if (isValidating) {
                    Integer[] clueArray = getClueArray(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        isValidating = false;
                    }
                }
                if (startQuery > endQuery) {
                    if (formatArray(initialArray).length() != bitLength) {
                        throw new Exception();
                    }
                    System.out.println(formatArray(initialArray));
                    String judgeResponse = sc.nextLine();
                    if ("N".equals(judgeResponse)) {
                        break;
                    }
                    break;
                }

                if ((!isValidating && queryCount % 10 == 1) || (isValidating && validationQueryCount % 10 == 1)) {
                    if (!isValidating && queryCount % 10 == 1) {
                        startQuery = 1;
                        endQuery = bitLength;
                    }
                    isValidating = true;
                }
            }
        }
    }

    private static Integer[] getClueArray(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> possibleArrays = new ArrayList<>();
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

        possibleArrays.add(complemented);
        if (!arraysEqual(complemented, initialArray)) {
            possibleArrays.add(initialArray);
        }

        if (possibleArrays.stream().noneMatch(arr -> arraysEqual(arr, reversed))) {
            possibleArrays.add(reversed);
        }

        if (possibleArrays.stream().noneMatch(arr -> arraysEqual(arr, both))) {
            possibleArrays.add(both);
        }

        int matchCount = 0;
        Integer[] match = null;
        for (Integer[] arr : possibleArrays) {
            if (arraysEqual(arr, changedArray)) {
                matchCount++;
                match = arr;
            }
        }

        return matchCount == 1 ? match : null;
    }

    private static boolean arraysEqual(Integer[] a, Integer[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && b[i] != null && !a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    private static String formatArray(Integer[] array) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : array) {
            sb.append(num != null ? num : ".");
        }
        return sb.toString();
    }
}