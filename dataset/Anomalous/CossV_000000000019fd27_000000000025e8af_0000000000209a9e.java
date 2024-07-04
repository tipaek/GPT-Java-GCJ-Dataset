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
            int left = 1, right = b;
            int queryCount = 1, validationQueryCount = 1;
            boolean isValidating = false;

            while (true) {
                int response = query(sc, left, isValidating, initialArray, changedArray);
                left++;
                if (!isValidating) queryCount++;
                else validationQueryCount++;

                if (isValidating && processValidation(initialArray, changedArray)) {
                    resetValidationState(initialArray, changedArray, left, right);
                    isValidating = false;
                }

                if (left > right) {
                    if (!processFinalResponse(sc, initialArray)) break;
                    break;
                }

                response = query(sc, right, isValidating, initialArray, changedArray);
                right--;
                if (!isValidating) queryCount++;
                else validationQueryCount++;

                if (isValidating && processValidation(initialArray, changedArray)) {
                    resetValidationState(initialArray, changedArray, left, right);
                    isValidating = false;
                }

                if (left > right) {
                    if (!processFinalResponse(sc, initialArray)) break;
                    break;
                }

                if (shouldSwitchToValidation(queryCount, validationQueryCount, isValidating)) {
                    isValidating = true;
                    left = 1;
                    right = b;
                }
            }
        }
    }

    private static int query(Scanner sc, int index, boolean isValidating, Integer[] initialArray, Integer[] changedArray) {
        System.out.println(index);
        int response = Integer.parseInt(sc.nextLine());
        if (isValidating) changedArray[index - 1] = response;
        else initialArray[index - 1] = response;
        return response;
    }

    private static boolean processValidation(Integer[] initialArray, Integer[] changedArray) {
        Integer[] clueArray = findClue(initialArray, changedArray);
        if (clueArray != null) {
            System.arraycopy(clueArray, 0, initialArray, 0, initialArray.length);
            return true;
        }
        return false;
    }

    private static void resetValidationState(Integer[] initialArray, Integer[] changedArray, int left, int right) {
        left = 1;
        right = initialArray.length;
        Arrays.fill(changedArray, null);
    }

    private static boolean processFinalResponse(Scanner sc, Integer[] initialArray) {
        System.out.println(arrayToString(initialArray));
        String judgeResponse = sc.nextLine();
        return !"N".equals(judgeResponse);
    }

    private static boolean shouldSwitchToValidation(int queryCount, int validationQueryCount, boolean isValidating) {
        return (!isValidating && queryCount % 10 == 1) || (isValidating && validationQueryCount % 10 == 1);
    }

    private static Integer[] findClue(Integer[] initialArray, Integer[] changedArray) {
        List<Integer[]> candidates = generateCandidates(initialArray);

        int matches = 0;
        Integer[] matchingArray = null;
        for (Integer[] candidate : candidates) {
            if (arraysEqual(candidate, changedArray)) {
                matches++;
                matchingArray = candidate;
            }
        }

        return matches == 1 ? matchingArray : null;
    }

    private static List<Integer[]> generateCandidates(Integer[] initialArray) {
        List<Integer[]> candidates = new ArrayList<>();
        Integer[] complemented = complementArray(initialArray);
        Integer[] reversed = reverseArray(initialArray);
        Integer[] both = complementArray(reversed);

        addUniqueCandidate(candidates, complemented);
        addUniqueCandidate(candidates, initialArray);
        addUniqueCandidate(candidates, reversed);
        addUniqueCandidate(candidates, both);

        return candidates;
    }

    private static void addUniqueCandidate(List<Integer[]> candidates, Integer[] candidate) {
        for (Integer[] existing : candidates) {
            if (arraysEqual(existing, candidate)) return;
        }
        candidates.add(candidate);
    }

    private static Integer[] complementArray(Integer[] array) {
        Integer[] complemented = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) complemented[i] = array[i] == 1 ? 0 : 1;
        }
        return complemented;
    }

    private static Integer[] reverseArray(Integer[] array) {
        Integer[] reversed = Arrays.copyOf(array, array.length);
        Collections.reverse(Arrays.asList(reversed));
        return reversed;
    }

    private static boolean arraysEqual(Integer[] a, Integer[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && b[i] != null && !a[i].equals(b[i])) return false;
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