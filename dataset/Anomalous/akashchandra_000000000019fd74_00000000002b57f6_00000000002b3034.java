import java.util.Scanner;

class Solution {
    public static Scanner sc = new Scanner(System.in);

    public static void merge(int[] lengths, String[] strings, int start, int mid, int end) {
        int leftIndex = start, rightIndex = mid + 1;
        int[] tempLengths = new int[end - start + 1];
        String[] tempStrings = new String[end - start + 1];
        int k = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (lengths[leftIndex] <= lengths[rightIndex]) {
                tempLengths[k] = lengths[leftIndex];
                tempStrings[k++] = strings[leftIndex++];
            } else {
                tempLengths[k] = lengths[rightIndex];
                tempStrings[k++] = strings[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            tempLengths[k] = lengths[leftIndex];
            tempStrings[k++] = strings[leftIndex++];
        }

        while (rightIndex <= end) {
            tempLengths[k] = lengths[rightIndex];
            tempStrings[k++] = strings[rightIndex++];
        }

        System.arraycopy(tempLengths, 0, lengths, start, tempLengths.length);
        System.arraycopy(tempStrings, 0, strings, start, tempStrings.length);
    }

    public static void mergeSort(int[] lengths, String[] strings, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(lengths, strings, start, mid);
            mergeSort(lengths, strings, mid + 1, end);
            merge(lengths, strings, start, mid, end);
        }
    }

    public static String check(String[] strings, int n) {
        String suffix = strings[n - 1].substring(1);
        for (int i = n - 2; i >= 0; i--) {
            if (!suffix.contains(strings[i].substring(1))) {
                return "*";
            }
        }
        return suffix;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            String[] strings = new String[n];
            int[] lengths = new int[n];

            for (int i = 0; i < n; i++) {
                strings[i] = sc.next();
                lengths[i] = strings[i].length();
            }

            mergeSort(lengths, strings, 0, n - 1);
            System.out.println("Case #" + caseNum + ": " + check(strings, n));
        }
    }
}