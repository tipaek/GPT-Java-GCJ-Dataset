import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] l = new int[n];
            int[] r = new int[n];
            int[] indices = new int[n];

            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
                indices[i] = i;
            }

            // Sort intervals by start time using selection sort
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (l[j] < l[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(l, i, minIndex);
                swap(r, i, minIndex);
                swap(indices, i, minIndex);
            }

            StringBuilder result = new StringBuilder();
            int[] dutyEndTime = new int[2]; // dutyEndTime[0] for C, dutyEndTime[1] for J
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (l[i] >= dutyEndTime[0]) {
                    dutyEndTime[0] = r[i];
                    result.append('C');
                } else if (l[i] >= dutyEndTime[1]) {
                    dutyEndTime[1] = r[i];
                    result.append('J');
                } else {
                    isPossible = false;
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (isPossible) {
                char[] charArray = result.toString().toCharArray();
                // Reorder the result to the original input order
                for (int i = 0; i < n - 1; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < n; j++) {
                        if (indices[j] < indices[minIndex]) {
                            minIndex = j;
                        }
                    }
                    swap(indices, i, minIndex);
                    swap(charArray, i, minIndex);
                }
                result = new StringBuilder(String.valueOf(charArray));
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}