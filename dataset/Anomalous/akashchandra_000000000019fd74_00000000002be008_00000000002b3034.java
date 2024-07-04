import java.util.*;

class Solution {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            int[] starIndices = new int[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
                starIndices[i] = patterns[i].indexOf("*");
            }

            mergeSort(starIndices, patterns, 0, n - 1);
            System.out.println("Case #" + caseNumber + ": " + check(patterns, starIndices, n));
            caseNumber++;
        }
    }

    private static void mergeSort(int[] lengths, String[] strings, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(lengths, strings, start, mid);
            mergeSort(lengths, strings, mid + 1, end);
            merge(lengths, strings, start, mid, end);
        }
    }

    private static void merge(int[] lengths, String[] strings, int start, int mid, int end) {
        int leftIndex = start, rightIndex = mid + 1, mergedIndex = 0;
        int[] mergedLengths = new int[end - start + 1];
        String[] mergedStrings = new String[end - start + 1];

        while (leftIndex <= mid && rightIndex <= end) {
            if (lengths[leftIndex] <= lengths[rightIndex]) {
                mergedLengths[mergedIndex] = lengths[leftIndex];
                mergedStrings[mergedIndex++] = strings[leftIndex++];
            } else {
                mergedLengths[mergedIndex] = lengths[rightIndex];
                mergedStrings[mergedIndex++] = strings[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            mergedLengths[mergedIndex] = lengths[leftIndex];
            mergedStrings[mergedIndex++] = strings[leftIndex++];
        }

        while (rightIndex <= end) {
            mergedLengths[mergedIndex] = lengths[rightIndex];
            mergedStrings[mergedIndex++] = strings[rightIndex++];
        }

        System.arraycopy(mergedLengths, 0, lengths, start, mergedIndex);
        System.arraycopy(mergedStrings, 0, strings, start, mergedIndex);
    }

    private static String check(String[] patterns, int[] starIndices, int n) {
        String[] reversedPatterns = new String[n];
        int[] reversedStarIndices = new int[n];
        int[] prefixLengths = new int[n];
        int[] suffixLengths = new int[n];

        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        int maxPrefixLength = 0;
        int maxSuffixLength = 0;

        for (int i = 0; i < n; i++) {
            reversedPatterns[i] = patterns[n - 1 - i];
            reversedStarIndices[i] = starIndices[n - 1 - i];
            prefixLengths[i] = reversedStarIndices[i];
            suffixLengths[i] = reversedPatterns[i].length() - reversedStarIndices[i] - 1;

            if (prefixLengths[i] > maxPrefixLength) {
                maxPrefixLength = prefixLengths[i];
                prefix.setLength(0);
                prefix.append(reversedPatterns[i], 0, prefixLengths[i]);
            }

            if (suffixLengths[i] > maxSuffixLength) {
                maxSuffixLength = suffixLengths[i];
                suffix.setLength(0);
                suffix.append(reversedPatterns[i], reversedStarIndices[i] + 1, reversedPatterns[i].length());
            }
        }

        String result = prefix.toString() + suffix.toString();

        for (int i = 0; i < n; i++) {
            String[] parts = patterns[i].split("\\*");
            if (!result.startsWith(parts[0]) || !result.endsWith(parts[1])) {
                return "*";
            }
        }

        return result;
    }
}