import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String result = "";
            try {
                StringBuilder jamieSchedule = new StringBuilder("0".repeat(1441));
                StringBuilder cameronSchedule = new StringBuilder("0".repeat(1441));
                int activities = scanner.nextInt();
                
                for (int j = 0; j < activities; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    
                    if (jamieSchedule.substring(start, end).indexOf("1") == -1) {
                        result += "J";
                        for (int k = start; k < end; k++) {
                            jamieSchedule.setCharAt(k, '1');
                        }
                    } else if (cameronSchedule.substring(start, end).indexOf("1") == -1) {
                        result += "C";
                        for (int k = start; k < end; k++) {
                            cameronSchedule.setCharAt(k, '1');
                        }
                    } else {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            } catch (Exception e) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
}