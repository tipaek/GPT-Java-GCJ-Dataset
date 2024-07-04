import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String pathString = scanner.next();
            System.out.println(pathString);
            char[] path = pathString.toCharArray();

            int totalTime = -1;
            if (x == 0 && y == 0) {
                totalTime = 0;
            } else {
                for (int i = 0; i < path.length; i++) {
                    switch (path[i]) {
                        case 'S': y--; break;
                        case 'W': x--; break;
                        case 'E': x++; break;
                        case 'N': y++; break;
                    }
                    if (Math.abs(x) + Math.abs(y) <= i + 1) {
                        totalTime = i + 1;
                        break;
                    }
                }
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            if (totalTime != -1) {
                System.out.println(totalTime);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}