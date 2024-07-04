import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt=0;
        while (T > 0) {
            ++cnt;
            System.out.print("Case #"+cnt+": ");
            --T;
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String moves = scanner.next();
            boolean flag = true;
            int pepper_x = Y;
            int pepper_y = X;
            for (int i = 0; i < moves.length(); ++i) {
                if (moves.charAt(i) == 'N') {
                    pepper_x++;
                } else if (moves.charAt(i) == 'S') {
                    pepper_x--;
                } else if (moves.charAt(i) == 'E') {
                    pepper_y++;
                } else if (moves.charAt(i) == 'W') {
                    pepper_y--;
                }
                if (Math.abs(pepper_x) + Math.abs(pepper_y) <= (i + 1)) {
                    System.out.println(i + 1);
                    flag = false;
                    break;
                }
            }
            if (flag)
                    System.out.println("IMPOSSIBLE");
        }
    }
}
