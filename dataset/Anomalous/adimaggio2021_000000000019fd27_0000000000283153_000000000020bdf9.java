import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][2];
            int[] originalOrder = new int[24 * 60 + 1];
            char[] assignments = new char[n];
            
            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                originalOrder[tasks[i][0]] = i;
                tasks[i][1] = scanner.nextInt();
                assignments[i] = 't';
            }
            
            int[][] sortedTasks = new int[n][2];
            for (int i = 0; i < n; i++) {
                sortedTasks[i][0] = tasks[i][0];
                sortedTasks[i][1] = tasks[i][1];
            }
            
            sort(sortedTasks, 0, n - 1);
            
            int cEnd = -1;
            int jEnd = -1;
            boolean possible = true;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                if (sortedTasks[i][0] >= cEnd) {
                    cEnd = -1;
                }
                if (sortedTasks[i][0] >= jEnd) {
                    jEnd = -1;
                }
                if (cEnd == -1) {
                    cEnd = sortedTasks[i][1];
                    assignments[originalOrder[sortedTasks[i][0]]] = 'C';
                } else if (jEnd == -1) {
                    jEnd = sortedTasks[i][1];
                    assignments[originalOrder[sortedTasks[i][0]]] = 'J';
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (int i = 0; i < n; i++) {
                    if (assignments[i] == 't') {
                        assignments[i] = (assignments[originalOrder[tasks[i][0]]] == 'C') ? 'J' : 'C';
                    }
                    result.append(assignments[i]);
                }
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
        
        scanner.close();
    }

    static void merge(int[][] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i][0] = arr[left + i][0];
            leftArray[i][1] = arr[left + i][1];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j][0] = arr[mid + 1 + j][0];
            rightArray[j][1] = arr[mid + 1 + j][1];
        }
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i][0] <= rightArray[j][0]) {
                arr[k][0] = leftArray[i][0];
                arr[k][1] = leftArray[i][1];
                i++;
            } else {
                arr[k][0] = rightArray[j][0];
                arr[k][1] = rightArray[j][1];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k][0] = leftArray[i][0];
            arr[k][1] = leftArray[i][1];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k][0] = rightArray[j][0];
            arr[k][1] = rightArray[j][1];
            j++;
            k++;
        }
    }

    static void sort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
}