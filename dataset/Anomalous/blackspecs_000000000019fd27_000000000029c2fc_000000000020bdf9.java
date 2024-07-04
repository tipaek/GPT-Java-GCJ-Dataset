import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pair1 {
    int x;
    char y;

    public Pair1(int x, char y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            Pair[] pairs = new Pair[n];

            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                pairs[j] = new Pair(x, y);
            }

            Pair[] sortedPairs = Arrays.copyOf(pairs, n);
            Arrays.sort(sortedPairs, Comparator.comparingInt(p -> p.x));

            int aEndTime = 0;
            int bEndTime = 0;
            boolean isPossible = true;
            Pair1[] results = new Pair1[n];

            for (int j = 0; j < n; j++) {
                if (sortedPairs[j].x >= aEndTime) {
                    results[j] = new Pair1(sortedPairs[j].x, 'C');
                    aEndTime = sortedPairs[j].y;
                } else if (sortedPairs[j].x >= bEndTime) {
                    results[j] = new Pair1(sortedPairs[j].x, 'J');
                    bEndTime = sortedPairs[j].y;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                StringBuilder ansBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (pairs[j].x == results[k].x) {
                            ansBuilder.append(results[k].y);
                            results[k].x = -1; // Mark as used
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + ansBuilder.toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}