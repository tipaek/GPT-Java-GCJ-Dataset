import java.util.Scanner;

public class Solution {

    private int t;
    private Scanner scanner;
    private static int radius;
    private static final long EDGE_DISTANCE = 1000000000;
    private int smallestHitX;
    private int smallestHitY;

    public Solution(int t, Scanner scanner) {
        this.t = t;
        this.scanner = scanner;
    }

    public void solve() {
        int gap = (int) ((EDGE_DISTANCE - radius) * 2);
        long[] gapArray = new long[gap + 1];
        for (int i = 0; i <= gap; i++) {
            gapArray[i] = i;
        }
        smallestHitX = gap + 1;
        int left = 0;
        int right = gap + 1;

        while (left <= right) {
            int center = (left + right) / 2;
            System.out.println((-EDGE_DISTANCE + center) + " " + 0);
            String response = scanner.next();
            if (response.equals("HIT")) {
                if (center < smallestHitX) {
                    smallestHitX = center;
                }
                if (left == right) {
                    break;
                }
                right = center - 1;
            } else {
                if (left == right) {
                    break;
                }
                left = center + 1;
            }
        }

        smallestHitY = gap + 1;
        left = 0;
        right = gap + 1;

        while (left <= right) {
            int center = (left + right) / 2;
            System.out.println(0 + " " + (-EDGE_DISTANCE + center));
            String response = scanner.next();
            if (response.equals("HIT")) {
                if (center < smallestHitY) {
                    smallestHitY = center;
                }
                if (left == right) {
                    break;
                }
                right = center - 1;
            } else {
                if (left == right) {
                    break;
                }
                left = center + 1;
            }
        }

        System.out.println((-gap / 2 + smallestHitX) + " " + (-gap / 2 + smallestHitY));
        scanner.next();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        radius = scanner.nextInt();
        scanner.nextInt(); // Skip the unnecessary input
        for (int i = 0; i < testCases; i++) {
            new Solution(i + 1, scanner).solve();
        }
        scanner.close();
    }
}