import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            if (activities == 1) {
                System.out.println("Case #" + t + ": C");
            } else if (activities == 2) {
                System.out.println("Case #" + t + ": CJ");
            } else {
                char[] schedule = new char[activities];
                int[] cameron = new int[1441];
                int[] jamie = new int[1441];
                boolean impossible = false;
                
                for (int i = 0; i < activities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    
                    if (isAvailable(cameron, start, end)) {
                        markSchedule(cameron, start, end);
                        schedule[i] = 'C';
                    } else if (isAvailable(jamie, start, end)) {
                        markSchedule(jamie, start, end);
                        schedule[i] = 'J';
                    } else {
                        impossible = true;
                    }
                }
                
                if (impossible) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    System.out.print("Case #" + t + ": ");
                    System.out.println(new String(schedule));
                }
            }
        }
        scanner.close();
    }
    
    private static boolean isAvailable(int[] person, int start, int end) {
        for (int i = start; i < end; i++) {
            if (person[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] person, int start, int end) {
        for (int i = start; i < end; i++) {
            person[i] = 1;
        }
    }
}