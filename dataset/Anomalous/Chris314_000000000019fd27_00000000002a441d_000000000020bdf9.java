import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int N = scanner.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            int[] indices = new int[N];
            int[] sortedStart = new int[N];

            for (int j = 0; j < N; j++) {
                start[j] = scanner.nextInt();
                sortedStart[j] = start[j];
                end[j] = scanner.nextInt();
                indices[j] = j;
            }

            sort(start, end, 0, N - 1);
            sort(sortedStart, indices, 0, N - 1);

            StringBuilder result = new StringBuilder("C");
            char currentChar = 'C';
            int[] maxEnd = computeMaxArray(end);

            for (int j = 1; j < N; j++) {
                if (start[j] >= maxEnd[j - 1]) {
                    result.append(currentChar);
                } else {
                    int countC = 0;
                    int countJ = 0;

                    for (int k = 0; k < j; k++) {
                        if (start[j] < end[k]) {
                            if (result.charAt(k) == 'C') {
                                countC++;
                            } else {
                                countJ++;
                            }
                        }
                    }

                    if (countC >= 1 && countJ >= 1) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }

                    currentChar = (countC >= 1) ? 'J' : 'C';
                    result.append(currentChar);
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                char[] outputArray = new char[N];
                for (int k = 0; k < N; k++) {
                    outputArray[indices[k]] = result.charAt(k);
                }
                result = new StringBuilder();
                for (char c : outputArray) {
                    result.append(c);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int[] computeMaxArray(int[] end) {
        int max = -1;
        int[] maxArray = new int[end.length];
        for (int i = 0; i < end.length; i++) {
            if (end[i] > max) {
                max = end[i];
            }
            maxArray[i] = max;
        }
        return maxArray;
    }

    private static void sort(int[] start, int[] end, int first, int last) {
        if (first >= last) {
            return;
        }

        int mid = (first + last) / 2;
        sort(start, end, first, mid);
        sort(start, end, mid + 1, last);

        merge(start, end, first, mid, last);
    }

    private static void merge(int[] start, int[] end, int first, int mid, int last) {
        int[] sortedStart = new int[last - first + 1];
        int[] sortedEnd = new int[last - first + 1];
        int leftIndex = first, rightIndex = mid + 1, sortedIndex = 0;

        while (leftIndex <= mid && rightIndex <= last) {
            if (start[leftIndex] <= start[rightIndex]) {
                sortedStart[sortedIndex] = start[leftIndex];
                sortedEnd[sortedIndex++] = end[leftIndex++];
            } else {
                sortedStart[sortedIndex] = start[rightIndex];
                sortedEnd[sortedIndex++] = end[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            sortedStart[sortedIndex] = start[leftIndex];
            sortedEnd[sortedIndex++] = end[leftIndex++];
        }

        while (rightIndex <= last) {
            sortedStart[sortedIndex] = start[rightIndex];
            sortedEnd[sortedIndex++] = end[rightIndex++];
        }

        for (int i = 0; i < sortedStart.length; i++) {
            start[first + i] = sortedStart[i];
            end[first + i] = sortedEnd[i];
        }
    }
}