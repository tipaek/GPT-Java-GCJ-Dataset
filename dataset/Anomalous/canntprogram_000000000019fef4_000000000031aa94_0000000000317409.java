import java.util.Scanner;

public class Solution {
    public static void solve(int caseNumber, int x, int y, String moves) {
        String result = "IMPOSSIBLE";
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
            int currentDistance = Math.abs(x) + Math.abs(y);
            if (currentDistance <= i + 1) {
                result = Integer.toString(i + 1);
                break;
            }
        }
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            solve(caseNumber, x, y, moves);
        }
        scanner.close();
    }
}