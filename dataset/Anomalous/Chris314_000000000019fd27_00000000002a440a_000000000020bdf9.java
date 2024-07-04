import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int N = in.nextInt();
            int[] start = new int[N];
            int[] end = new int[N];
            int[] nums = new int[N];
            int[] startCopy = new int[N];

            for (int j = 0; j < N; j++) {
                start[j] = in.nextInt();
                startCopy[j] = start[j];
                end[j] = in.nextInt();
                nums[j] = j;
            }

            sortIntervals(start, end, 0, N - 1);
            sortIntervals(startCopy, nums, 0, N - 1);

            StringBuilder ans = new StringBuilder("C");
            char currentChar = 'C';
            int[] maxEnd = computeMaxEndArray(end);

            for (int j = 1; j < N; j++) {
                if (start[j] >= maxEnd[j - 1]) {
                    ans.append(currentChar);
                } else {
                    int countC = 0;
                    int countJ = 0;

                    for (int k = 0; k < j; k++) {
                        if (start[j] < end[k]) {
                            if (ans.charAt(k) == 'C') {
                                countC++;
                            } else {
                                countJ++;
                            }
                        }
                    }

                    if (countC >= 1 && countJ >= 1) {
                        ans = new StringBuilder("IMPOSSIBLE");
                        break;
                    }

                    currentChar = (countC >= 1) ? 'J' : 'C';
                    ans.append(currentChar);
                }
            }

            if (!ans.toString().equals("IMPOSSIBLE")) {
                char[] resultArray = new char[N];
                for (int k = 0; k < N; k++) {
                    resultArray[nums[k]] = ans.charAt(k);
                }
                ans = new StringBuilder(new String(resultArray));
            }

            System.out.println("Case #" + (i + 1) + ": " + ans);
        }
    }

    private static int[] computeMaxEndArray(int[] end) {
        int max = -1;
        int[] maxEndArray = new int[end.length];
        for (int i = 0; i < end.length; i++) {
            if (end[i] > max) {
                max = end[i];
            }
            maxEndArray[i] = max;
        }
        return maxEndArray;
    }

    private static void sortIntervals(int[] start, int[] end, int first, int last) {
        if (first >= last) {
            return;
        }

        int mid = (first + last) / 2;
        sortIntervals(start, end, first, mid);
        sortIntervals(start, end, mid + 1, last);

        mergeIntervals(start, end, first, mid, last);
    }

    private static void mergeIntervals(int[] start, int[] end, int first, int mid, int last) {
        int[] tempStart = new int[last - first + 1];
        int[] tempEnd = new int[last - first + 1];
        int i = first, j = mid + 1, k = 0;

        while (i <= mid && j <= last) {
            if (start[i] < start[j]) {
                tempStart[k] = start[i];
                tempEnd[k++] = end[i++];
            } else {
                tempStart[k] = start[j];
                tempEnd[k++] = end[j++];
            }
        }

        while (i <= mid) {
            tempStart[k] = start[i];
            tempEnd[k++] = end[i++];
        }

        while (j <= last) {
            tempStart[k] = start[j];
            tempEnd[k++] = end[j++];
        }

        for (i = first; i <= last; i++) {
            start[i] = tempStart[i - first];
            end[i] = tempEnd[i - first];
        }
    }
}