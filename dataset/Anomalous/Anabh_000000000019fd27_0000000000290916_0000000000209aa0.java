import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean possible = false;

            switch (n) {
                case 2:
                    if (k == 2 || k == 4) {
                        possible = true;
                    }
                    break;
                case 3:
                    if (k == 6) {
                        possible = true;
                    }
                    break;
                case 4:
                    if (k == 8 || k == 12) {
                        possible = true;
                    }
                    break;
                case 5:
                    if (k == 15) {
                        possible = true;
                    }
                    break;
            }

            if (possible) {
                System.out.println("Case #" + i + ": POSSIBLE");
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}