import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Shuffle {
        int a;
        int b;

        Shuffle(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public List<Shuffle> shuffle(int r, int s) {
        List<Shuffle> result = new ArrayList<>();
        if (r > 1) {
            for (int i = 1; i < s; i++) {
                result.add(new Shuffle(r, r * s - r - i));
            }
            result.addAll(shuffle(r - 1, s));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int numberOfTests = scanner.nextInt();
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            List<Shuffle> shuffles = solution.shuffle(r, s);
            System.out.printf("Case #%d: %d%n", testIndex, shuffles.size());
            for (Shuffle shuffle : shuffles) {
                System.out.printf("%d %d%n", shuffle.a, shuffle.b);
            }
        }
        scanner.close();
    }
}