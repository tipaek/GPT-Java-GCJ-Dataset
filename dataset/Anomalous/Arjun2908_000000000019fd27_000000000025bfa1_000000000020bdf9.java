import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int x = 1; x <= t; x++) {
            int n = scanner.nextInt();
            int[] start = new int[n + 1];
            int[] end = new int[n + 1];
            
            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
            }
            
            start[n] = -5;
            end[n] = -5;
            
            int[] duplicateStart = Arrays.copyOf(start, n);
            
            // Sort intervals by start time
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (start[j] > start[j + 1]) {
                        swap(start, j, j + 1);
                        swap(end, j, j + 1);
                    }
                }
            }
            
            StringBuilder schedule = new StringBuilder("C");
            int c1 = 0, c2 = n;
            
            for (int i = 1; i < n; i++) {
                if (start[i] >= end[c1] || end[i] <= start[c1]) {
                    schedule.append('C');
                    c1 = i;
                } else if (start[i] >= end[c2] || end[i] <= start[c2]) {
                    schedule.append('J');
                    c2 = i;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            if (!schedule.toString().equals("IMPOSSIBLE")) {
                char[] answer = schedule.toString().toCharArray();
                char[] finalAnswer = new char[n];
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (duplicateStart[i] == start[j]) {
                            finalAnswer[i] = answer[j];
                            start[j] = -5;
                            break;
                        }
                    }
                }
                
                schedule = new StringBuilder(new String(finalAnswer));
            }
            
            System.out.println("Case #" + x + ": " + schedule);
        }
        
        scanner.close();
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}