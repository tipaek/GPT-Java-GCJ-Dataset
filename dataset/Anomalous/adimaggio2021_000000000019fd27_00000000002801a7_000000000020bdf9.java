import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            int[] originalOrder = new int[24 * 60 + 1];
            boolean isPossible = true;

            // Read input tasks and store their original order
            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                originalOrder[tasks[i][0]] = i;
                tasks[i][1] = scanner.nextInt();
            }

            // Clone tasks array for sorting
            int[][] sortedTasks = tasks.clone();
            mergeSort(sortedTasks, 0, taskCount - 1);

            char[] assignments = new char[taskCount];
            for (int i = 0; i < taskCount; i++) {
                assignments[i] = 't';
            }

            int endTimeC = -1;
            int endTimeJ = -1;
            String result = "";

            for (int i = 0; i < taskCount; i++) {
                if (sortedTasks[i][0] >= endTimeC) {
                    endTimeC = sortedTasks[i][1];
                    assignments[originalOrder[sortedTasks[i][0]]] = 'C';
                } else if (sortedTasks[i][0] >= endTimeJ) {
                    endTimeJ = sortedTasks[i][1];
                    assignments[originalOrder[sortedTasks[i][0]]] = 'J';
                } else {
                    System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int i = 0; i < taskCount; i++) {
                    if (assignments[i] == 't') {
                        assignments[i] = (assignments[originalOrder[tasks[i][0]]] == 'C') ? 'J' : 'C';
                    }
                    result += assignments[i];
                }
                System.out.println("Case #" + (testCase + 1) + ": " + result);
            }
        }
        scanner.close();
    }

    private static void mergeSort(int[][] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[][] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[][] leftArray = new int[leftSize][2];
        int[][] rightArray = new int[rightSize][2];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i][0] = array[left + i][0];
            leftArray[i][1] = array[left + i][1];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j][0] = array[middle + 1 + j][0];
            rightArray[j][1] = array[middle + 1 + j][1];
        }

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
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

        while (i < leftSize) {
            array[k][0] = leftArray[i][0];
            array[k][1] = leftArray[i][1];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k][0] = rightArray[j][0];
            array[k][1] = rightArray[j][1];
            j++;
            k++;
        }
    }
}