import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int sum = scanner.nextInt();
            ArrayList<Pair> solution = new ArrayList<>();
            solution.add(new Pair(1, 1));

            System.out.println("Case #" + t + ": ");
            if (sum <= 500) {
                for (int i = 1; i <= sum; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                solution.add(new Pair(2, 1));
                int currentX = 2;
                int currentY = 2;
                int actualSum = 2;
                sum -= 2;

                while (sum - actualSum >= 1) {
                    sum -= actualSum;
                    actualSum++;
                    currentX++;
                    solution.add(new Pair(currentX, currentY));
                }

                currentY--;
                while (sum > 0) {
                    sum--;
                    solution.add(new Pair(currentX, currentY));
                    currentX++;
                }

                for (Pair pair : solution) {
                    System.out.println(pair.x + " " + pair.y);
                }
            }
        }
    }
}