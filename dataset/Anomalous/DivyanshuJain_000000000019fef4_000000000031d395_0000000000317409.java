import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline after the integer input

        for (int i = 0; i < T; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            sc.nextLine(); // Consume the newline after the integer inputs
            String s1 = sc.nextLine().trim();

            int dX = X;
            int dY = Y;
            boolean isPossible = false;

            if (dX == 0 && dY == 0) {
                isPossible = true;
                System.out.println("Case #" + (i + 1) + ": " + 0);
            } else {
                int l = s1.length();
                for (int j = 0; j < l; j++) {
                    char ch = s1.charAt(j);
                    switch (ch) {
                        case 'N':
                            dY += 1;
                            break;
                        case 'S':
                            dY -= 1;
                            break;
                        case 'W':
                            dX -= 1;
                            break;
                        case 'E':
                            dX += 1;
                            break;
                    }
                    int dTotal = Math.abs(dX) + Math.abs(dY);
                    if (dTotal <= (j + 1)) {
                        System.out.println("Case #" + (i + 1) + ": " + (j + 1));
                        isPossible = true;
                        break;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}