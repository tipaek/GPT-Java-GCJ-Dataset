import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            int[] originalOrder = new int[24 * 60 + 1];

            for (int i = 0; i < numTasks; i++) {
                tasks[i][0] = scanner.nextInt();
                originalOrder[tasks[i][0]] = i;
                tasks[i][1] = scanner.nextInt();
            }

            int[][] sortedTasks = new int[numTasks][2];
            System.arraycopy(tasks, 0, sortedTasks, 0, numTasks);

            char[] assignments = new char[numTasks];
            for (int i = 0; i < numTasks; i++) {
                assignments[i] = ' ';
            }

            mergeSort(sortedTasks, 0, numTasks - 1);

            int cEnd = -1, jEnd = -1;
            boolean possible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numTasks; i++) {
                if (sortedTasks[i][0] >= cEnd) {
                    cEnd = sortedTasks[i][1];
                    assignments[originalOrder[sortedTasks[i][0]]] = 'C';
                } else if (sortedTasks[i][0] >= jEnd) {
                    jEnd = sortedTasks[i][1];
                    assignments[originalOrder[sortedTasks[i][0]]] = 'J';
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (char assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }
    }

    private static void mergeSort(int[][] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[][] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            leftArray[i][0] = array[left + i][0];
            leftArray[i][1] = array[left + i][1];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j][0] = array[mid + 1 + j][0];
            rightArray[j][1] = array[mid + 1 + j][1];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i][0] <= rightArray[j][0]) {
                array[k][0] = leftArray[i][0];
                array[k][1] = leftArray[i][1];
                i++;
            } else {
                array[k][0] = rightArray[j][0];
                array[k][1] = rightArray[j][1];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k][0] = leftArray[i][0];
            array[k][1] = leftArray[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            array[k][0] = rightArray[j][0];
            array[k][1] = rightArray[j][1];
            j++;
            k++;
        }
    }
}