import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String result = "";
            int intervalsCount = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < intervalsCount; i++) {
                try {
                    String[] intervalString = scanner.nextLine().split(" ");
                    // The original code does not use intervalString, so no further action is taken here
                } catch (Exception e) {
                    // Exception is caught but not handled in the original code
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }

    public static boolean listContains(int[] interval, List<int[]> intervalsList) {
        for (int[] existingInterval : intervalsList) {
            if (existingInterval != null && existingInterval.length == 2) {
                if (overlaps(interval[0], interval[1], existingInterval[0], existingInterval[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}