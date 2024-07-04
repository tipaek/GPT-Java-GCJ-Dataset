import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int curT = 1; curT <= t; curT++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            StringBuilder out = new StringBuilder();
            boolean works = true;
            while (true) {
                if (x == 0 && y == 0) break;
                if (x % 2 == 0 && y % 2 == 0) {
                    works = false;
                    break;
                }
                if (x % 2 != 0 && y % 2 != 0) {
                    works = false;
                    break;
                }
                if (x % 2 == 0) {
                    if ((x % 4 == 0) == ((y + (y > 0 ? 1 : -1)) % 4 != 0) && y != 1 && y != -1) {
                        out.append(y > 0 ? 'S' : 'N');
                        y += y > 0 ? 1 : -1;
                    } else {
                        out.append(y > 0 ? 'N' : 'S');
                        y -= y > 0 ? 1 : -1;
                    }
                } else if (y % 2 == 0) {
                    if ((y % 4 == 0) == ((x + (x > 0 ? 1 : -1)) % 4 != 0) && x != 1 && x != -1) {
                        out.append(x > 0 ? 'W' : 'E');
                        x += x > 0 ? 1 : -1;
                    } else {
                        out.append(x > 0 ? 'E' : 'W');
                        x -= x > 0 ? 1 : -1;
                    }
                }
                x /= 2;
                y /= 2;
            }
            System.out.print("Case #" + curT + ": ");
            if (works) {
                System.out.println(out);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
