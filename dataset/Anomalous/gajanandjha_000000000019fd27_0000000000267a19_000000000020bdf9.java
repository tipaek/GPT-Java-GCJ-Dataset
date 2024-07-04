import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        Random random = new Random();
        
        for (int t = 1; t <= testCases; t++) {
            boolean[] scheduleC = new boolean[60 * 24];
            boolean[] scheduleJ = new boolean[60 * 24];
            int taskCount = Integer.parseInt(br.readLine().trim());
            Map<Integer, Character> assignmentMap = new HashMap<>();
            boolean isImpossible = false;
            int[][] tasks = new int[taskCount][3];
            
            for (int i = 0; i < taskCount; i++) {
                String[] input = br.readLine().trim().split("\\s+");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
                tasks[i][2] = Integer.parseInt(input[0] + input[1] + random.nextInt(99));
            }
            
            int[][] originalTasks = new int[taskCount][3];
            for (int i = 0; i < taskCount; i++) {
                System.arraycopy(tasks[i], 0, originalTasks[i], 0, 3);
            }
            
            bubbleSort(tasks);
            
            for (int i = 0; i < taskCount; i++) {
                boolean conflictC = false;
                for (int j = tasks[i][0]; j < tasks[i][1]; j++) {
                    if (scheduleC[j]) {
                        conflictC = true;
                        break;
                    }
                }
                
                if (conflictC) {
                    boolean conflictJ = false;
                    for (int k = tasks[i][0]; k < tasks[i][1]; k++) {
                        if (scheduleJ[k]) {
                            conflictJ = true;
                            break;
                        }
                    }
                    
                    if (conflictJ) {
                        isImpossible = true;
                        break;
                    } else {
                        assignmentMap.put(tasks[i][2], 'J');
                        for (int m = tasks[i][0]; m < tasks[i][1]; m++) {
                            scheduleJ[m] = true;
                        }
                    }
                } else {
                    assignmentMap.put(tasks[i][2], 'C');
                    for (int l = tasks[i][0]; l < tasks[i][1]; l++) {
                        scheduleC[l] = true;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < taskCount; i++) {
                    result.append(assignmentMap.get(originalTasks[i][2]));
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    private static void bubbleSort(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1][0] > arr[j][0]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}