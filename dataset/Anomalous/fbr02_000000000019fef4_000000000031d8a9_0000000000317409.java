import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            processTestCase(t);
        }
    }

    private void processTestCase(int testCaseNumber) {
        Map<Integer, Integer> timeToPositionMap = new HashMap<>();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        String tour = scanner.next();
        int tourLength = tour.length();

        timeToPositionMap.put(0, Y);
        for (int i = 0; i < tourLength; i++) {
            if (tour.charAt(i) == 'N') {
                Y++;
            } else {
                Y--;
            }
            timeToPositionMap.put(i + 1, Y);
        }

        int startTime = X;
        int maxWalkDistance = 0;

        for (int currentTime = startTime; currentTime <= tourLength; currentTime++) {
            int currentPosition = Math.abs(timeToPositionMap.get(currentTime));
            if (currentPosition <= maxWalkDistance) {
                System.out.println("Case #" + testCaseNumber + ": " + (maxWalkDistance + startTime));
                return;
            }
            maxWalkDistance++;
        }

        System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
    }
}