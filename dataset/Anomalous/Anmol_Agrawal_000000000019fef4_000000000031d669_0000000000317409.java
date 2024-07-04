import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int requiredDistance = (x + y) / 2;
            boolean canMeet = false;
            int index = 0;

            for (; index < moves.length(); index++) {
                int currentDistance = Math.abs(x) + Math.abs(y);
                if (currentDistance <= requiredDistance) {
                    canMeet = true;
                    break;
                }

                char move = moves.charAt(index);
                switch (move) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }

            int finalDistance = Math.abs(x) + Math.abs(y);
            if (finalDistance <= requiredDistance) {
                canMeet = true;
            }

            if (canMeet) {
                System.out.println("Case #" + testCase + ": " + index);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}