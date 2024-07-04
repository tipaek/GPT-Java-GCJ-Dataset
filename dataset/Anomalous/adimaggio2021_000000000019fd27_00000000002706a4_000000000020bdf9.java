import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int m = 0; m < n; m++) {
            int x = in.nextInt();
            boolean possible = true;
            int[][] intervals = new int[x][2];
            int[] originalOrder = new int[24 * 60 + 1];
            char[] assignments = new char[x];
            
            for (int i = 0; i < x; i++) {
                intervals[i][0] = in.nextInt();
                originalOrder[intervals[i][0]] = i;
                intervals[i][1] = in.nextInt();
                assignments[i] = 't';
            }
            
            mergeSort(intervals, 0, x - 1);
            
            int cEnd = -1, jEnd = -1;
            String result = "";
            
            for (int i = 0; i < x; i++) {
                if (intervals[i][0] >= cEnd) {
                    cEnd = -1;
                }
                if (intervals[i][0] >= jEnd) {
                    jEnd = -1;
                }
                
                if (cEnd == -1) {
                    cEnd = intervals[i][1];
                    assignments[originalOrder[intervals[i][0]]] = 'C';
                } else if (jEnd == -1) {
                    jEnd = intervals[i][1];
                    assignments[originalOrder[intervals[i][0]]] = 'J';
                } else {
                    System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (int i = 0; i < x; i++) {
                    if (assignments[i] == 't') {
                        assignments[i] = (i + 1 < x && assignments[i + 1] == 'C') ? 'J' : 'C';
                    }
                    result += assignments[i];
                }
                System.out.println("Case #" + (m + 1) + ": " + result);
            }
        }
    }

    static void merge(int[][] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] leftArr = new int[n1][2];
        int[][] rightArr = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            leftArr[i][0] = arr[left + i][0];
            leftArr[i][1] = arr[left + i][1];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j][0] = arr[mid + 1 + j][0];
            rightArr[j][1] = arr[mid + 1 + j][1];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i][0] <= rightArr[j][0]) {
                arr[k][0] = leftArr[i][0];
                arr[k][1] = leftArr[i][1];
                i++;
            } else {
                arr[k][0] = rightArr[j][0];
                arr[k][1] = rightArr[j][1];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k][0] = leftArr[i][0];
            arr[k][1] = leftArr[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k][0] = rightArr[j][0];
            arr[k][1] = rightArr[j][1];
            j++;
            k++;
        }
    }

    static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
}