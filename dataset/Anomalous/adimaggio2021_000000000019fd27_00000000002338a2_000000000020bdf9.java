import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            int[] order = new int[24 * 60 + 1];
            boolean isPossible = true;
            
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                order[activities[i][0]] = i;
            }
            
            int[] timeMarkers = new int[24 * 60 + 1];
            for (int i = 0; i < numActivities; i++) {
                timeMarkers[activities[i][0]]++;
                timeMarkers[activities[i][1]]--;
            }
            
            int concurrentActivities = 0;
            for (int i = 0; i < timeMarkers.length; i++) {
                concurrentActivities += timeMarkers[i];
                if (concurrentActivities > 2) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                char[] result = new char[numActivities];
                mergeSort(activities, 0, numActivities - 1);
                int endC = -1, endJ = -1;
                
                for (int i = 0; i < numActivities; i++) {
                    int start = activities[i][0];
                    int end = activities[i][1];
                    
                    if (start >= endC) {
                        result[order[start]] = 'C';
                        endC = end;
                    } else if (start >= endJ) {
                        result[order[start]] = 'J';
                        endJ = end;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
                
                if (isPossible) {
                    System.out.println("Case #" + testCase + ": " + new String(result));
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
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
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i][0] = array[left + i][0];
            leftArray[i][1] = array[left + i][1];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j][0] = array[middle + 1 + j][0];
            rightArray[j][1] = array[middle + 1 + j][1];
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