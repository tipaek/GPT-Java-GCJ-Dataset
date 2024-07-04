import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next();
            char[] directionArray = directions.toCharArray();

            int[][] positions = new int[directions.length() + 1][2];
            positions[0] = new int[]{x, y};

            for (int i = 0; i < directionArray.length; i++) {
                switch (directionArray[i]) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                positions[i + 1] = new int[]{x, y};
            }

            int result = Integer.MAX_VALUE;
            for (int i = directionArray.length; i > 0; i--) {
                int[] pos = positions[i];
                int distance = Math.abs(pos[0]) + Math.abs(pos[1]);

                if (distance <= i) {
                    result = Math.min(result, i);
                }
            }

            if (result != Integer.MAX_VALUE) {
                System.out.println("Case #" + test + ": " + result);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}