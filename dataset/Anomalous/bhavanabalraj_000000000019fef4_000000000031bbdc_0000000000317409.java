import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int length = path.length();

            boolean isPossible = false;
            int time = 0;

            for (int i = 0; i <= length; i++) {
                if (Math.abs(x) + Math.abs(y) <= time) {
                    isPossible = true;
                    break;
                }

                if (i < length) {
                    char direction = path.charAt(i);
                    switch (direction) {
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
                time++;
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + time);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}