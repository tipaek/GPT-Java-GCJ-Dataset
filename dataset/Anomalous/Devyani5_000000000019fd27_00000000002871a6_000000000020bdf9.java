import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] indices = new int[n];
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                indices[j] = j + 1;
            }
            
            // Sort intervals based on start time
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (intervals[j][0] > intervals[k][0]) {
                        swap(intervals, j, k);
                        swap(indices, j, k);
                    }
                }
            }
            
            char[] assignments = new char[n];
            int endC = -1, endJ = -1;
            boolean possible = true;
            
            for (int k = 0; k < n; k++) {
                if (intervals[k][0] >= endC) {
                    assignments[k] = 'C';
                    endC = intervals[k][1];
                } else if (intervals[k][0] >= endJ) {
                    assignments[k] = 'J';
                    endJ = intervals[k][1];
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                // Reorder assignments to match original indices
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (indices[j] > indices[k]) {
                            swap(indices, j, k);
                            swap(assignments, j, k);
                        }
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + new String(assignments));
            }
        }
    }
    
    private static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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