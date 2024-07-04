import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int bitLength = Integer.parseInt(input[1]);

        for (int testCase = 0; testCase < testCases; testCase++) {
            Integer[] initialArray = new Integer[bitLength];
            Integer[] changedArray = new Integer[bitLength];
            int startQuery = 1;
            int endQuery = bitLength;
            int currentQuery = 1;
            int validationQuery = 1;
            int lastStartQuery = startQuery;
            int lastEndQuery = endQuery;
            boolean validating = false;

            while (true) {
                // Query from start
                System.out.println(startQuery);
                int response = Integer.parseInt(scanner.nextLine());
                if (validating) {
                    changedArray[startQuery - 1] = response;
                } else {
                    initialArray[startQuery - 1] = response;
                }
                startQuery++;
                if (!validating) {
                    currentQuery++;
                } else {
                    validationQuery++;
                }
                if (!validating) {
                    lastStartQuery = startQuery;
                }
                if (validating) {
                    Integer[] clueArray = findClue(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        validating = false;
                    }
                }
                if (startQuery > endQuery) {
                    if (formatArray(initialArray).length() != bitLength) {
                        throw new Exception();
                    }
                    System.out.println(formatArray(initialArray));
                    String judgeResponse = scanner.nextLine();
                    if ("N".equals(judgeResponse)) {
                        break;
                    }
                    break;
                }

                // Query from end
                System.out.println(endQuery);
                response = Integer.parseInt(scanner.nextLine());
                if (validating) {
                    changedArray[endQuery - 1] = response;
                } else {
                    initialArray[endQuery - 1] = response;
                }
                endQuery--;
                if (!validating) {
                    currentQuery++;
                } else {
                    validationQuery++;
                }
                if (!validating) {
                    lastEndQuery = endQuery;
                }
                if (validating) {
                    Integer[] clueArray = findClue(initialArray, changedArray);
                    if (clueArray != null) {
                        startQuery = lastStartQuery;
                        endQuery = lastEndQuery;
                        initialArray = clueArray;
                        validating = false;
                    }
                }
                if (startQuery > endQuery) {
                    if (formatArray(initialArray).length() != bitLength) {
                        throw new Exception();
                    }
                    System.out.println(formatArray(initialArray));
                    String judgeResponse = scanner.nextLine();
                    if ("N".equals(judgeResponse)) {
                        break;
                    }
                    break;
                }

                if ((!validating && currentQuery % 10 == 1) || (validating && validationQuery % 10 == 1)) {
                    // Switch to validation mode
                    validating = true;
                    startQuery = 1;
                    endQuery = bitLength;
                }
            }
        }
    }

    private static Integer[] findClue(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> possibleArrays = new ArrayList<>();
        Integer[] complementedArray = complementArray(initialArray);
        Integer[] reversedArray = reverseArray(initialArray);
        Integer[] bothArray = complementArray(reversedArray);

        possibleArrays.add(complementedArray);
        if (!Arrays.equals(complementedArray, initialArray)) {
            possibleArrays.add(initialArray);
        }
        if (!arrayListContains(possibleArrays, reversedArray)) {
            possibleArrays.add(reversedArray);
        }
        if (!arrayListContains(possibleArrays, bothArray)) {
            possibleArrays.add(bothArray);
        }

        return findMatchingArray(possibleArrays, changedArray);
    }

    private static Integer[] complementArray(Integer[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result[i] = array[i] == 1 ? 0 : 1;
            }
        }
        return result;
    }

    private static Integer[] reverseArray(Integer[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }

    private static boolean arrayListContains(List<Integer[]> list, Integer[] array) {
        for (Integer[] item : list) {
            if (Arrays.equals(item, array)) {
                return true;
            }
        }
        return false;
    }

    private static Integer[] findMatchingArray(List<Integer[]> possibleArrays, Integer[] changedArray) {
        int matches = 0;
        Integer[] match = null;
        for (Integer[] array : possibleArrays) {
            if (Arrays.equals(array, changedArray)) {
                matches++;
                match = array;
            }
        }
        return matches == 1 ? match : null;
    }

    private static String formatArray(Integer[] array) {
        StringBuilder result = new StringBuilder();
        for (Integer value : array) {
            result.append(value != null ? value : ".");
        }
        return result.toString();
    }
}