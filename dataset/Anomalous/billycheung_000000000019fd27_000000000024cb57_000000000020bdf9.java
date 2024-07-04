import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int segments = scanner.nextInt();
            System.out.println("Case #" + testCase + ": " + assignParents(scanner, segments));
        }
    }

    private static String assignParents(Scanner scanner, int segments) {
        if (segments == 0) {
            return "";
        }
        
        int[][] startTimes = new int[segments][2];
        int[][] endTimes = new int[segments][2];
        
        for (int i = 0; i < segments; i++) {
            startTimes[i][0] = scanner.nextInt();
            endTimes[i][0] = scanner.nextInt();
            startTimes[i][1] = i;
            endTimes[i][1] = i;
        }
        
        Arrays.sort(startTimes, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(endTimes, (a, b) -> Integer.compare(a[0], b[0]));
        
        char[] result = new char[segments];
        int activeTasks = 0, endIndex = 0;
        
        for (int i = 0; i < segments; i++) {
            int currentIndex = startTimes[i][1];
            
            if (startTimes[i][0] < endTimes[endIndex][0]) {
                if (++activeTasks > 2) {
                    return "IMPOSSIBLE";
                }
                result[currentIndex] = (i == 0 || result[startTimes[i - 1][1]] == 'C') ? 'J' : 'C';
            } else {
                result[currentIndex] = result[endTimes[endIndex][1]];
                endIndex++;
            }
        }
        
        return new String(result);
    }
}