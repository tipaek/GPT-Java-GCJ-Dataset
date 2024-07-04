import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            
            if (activities == 1) {
                System.out.println("Case #" + i + ": C");
            } else if (activities == 2) {
                System.out.println("Case #" + i + ": CJ");
            } else {
                char[] schedule = new char[activities];
                int[] cameron = new int[1440];
                int[] jamie = new int[1440];
                boolean impossible = false;
                
                for (int j = 0; j < activities; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    
                    if (isAvailable(cameron, start, end)) {
                        markBusy(cameron, start, end);
                        schedule[j] = 'C';
                    } else if (isAvailable(jamie, start, end)) {
                        markBusy(jamie, start, end);
                        schedule[j] = 'J';
                    } else {
                        impossible = true;
                    }
                }
                
                if (impossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.print("Case #" + i + ": ");
                    System.out.println(new String(schedule));
                }
            }
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}