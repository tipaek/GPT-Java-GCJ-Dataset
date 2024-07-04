import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];
            
            for (int i = 0; i < n; i++) {
                arrival[i] = scanner.nextInt();
                departure[i] = scanner.nextInt();
            }
            
            String result = scheduleTasks(n, arrival, departure);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
    
    private static String scheduleTasks(int n, int[] arrival, int[] departure) {
        // Sort tasks by their arrival times
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arrival[j] < arrival[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arrival, i, minIndex);
            swap(departure, i, minIndex);
        }
        
        int[] jobCompletion = new int[2]; // jobCompletion[0] for 'J', jobCompletion[1] for 'C'
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (arrival[i] >= jobCompletion[0]) {
                jobCompletion[0] = departure[i];
                result.append("J");
            } else if (arrival[i] >= jobCompletion[1]) {
                jobCompletion[1] = departure[i];
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}