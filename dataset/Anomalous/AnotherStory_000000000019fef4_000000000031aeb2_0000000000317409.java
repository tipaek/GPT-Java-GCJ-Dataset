import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            boolean reached = false;

            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                switch (direction) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                int distance = Math.abs(x) + Math.abs(y);

                if (distance <= (i + 1)) {
                    System.out.println("Case #" + caseNumber + ": " + (i + 1));
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}