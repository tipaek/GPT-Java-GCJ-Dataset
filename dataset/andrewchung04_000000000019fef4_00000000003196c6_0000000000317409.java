import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            boolean factor = true;

            for (int j = 0; j < moves.length(); j++) {
                if(moves.charAt(j) == 'N') {
                    y++;
                }
                else if(moves.charAt(j) == 'E') {
                    x++;
                }
                else if(moves.charAt(j) == 'S') {
                    y--;
                }
                else {
                    x--;
                }

                if(Math.abs(x) + Math.abs(y) <= j + 1) {
                    System.out.println("Case #" + (i + 1) + ": " + (j + 1));
                    factor = false;
                    break;
                }
            }

            if(factor) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }




        }
    }
}
