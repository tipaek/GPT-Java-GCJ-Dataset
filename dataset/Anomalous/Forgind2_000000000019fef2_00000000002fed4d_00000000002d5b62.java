import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder path = new StringBuilder();
            String[] input = scanner.nextLine().trim().split(" ");
            int goalX = Integer.parseInt(input[0]);
            int goalY = Integer.parseInt(input[1]);

            if (isSameParity(goalX, goalY)) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }

            while (goalX != 0 || goalY != 0) {
                if (goalX == 0 && goalY == -1) {
                    goalY++;
                    path.append('S');
                } else if (goalX == 0 && goalY == 1) {
                    goalY--;
                    path.append('N');
                } else if (goalY == 0 && goalX == -1) {
                    goalX++;
                    path.append('W');
                } else if (goalY == 0 && goalX == 1) {
                    goalX--;
                    path.append('E');
                } else if (isOdd(goalX)) {
                    if (isSameMod(goalX + 1, goalY, 4)) {
                        goalX--;
                        path.append('E');
                    } else {
                        goalX++;
                        path.append('W');
                    }
                } else {
                    if (isSameMod(goalX, goalY + 1, 4)) {
                        goalY--;
                        path.append('N');
                    } else {
                        goalY++;
                        path.append('S');
                    }
                }
                goalX >>= 1;
                goalY >>= 1;
            }
            System.out.println("Case #" + caseNumber + ": " + path.toString());
        }
        scanner.close();
    }

    private static boolean isSameParity(int x, int y) {
        return (x % 2 == y % 2);
    }

    private static boolean isOdd(int x) {
        return (x % 2 != 0);
    }

    private static boolean isSameMod(int x, int y, int mod) {
        return (x % mod == y % mod);
    }
}