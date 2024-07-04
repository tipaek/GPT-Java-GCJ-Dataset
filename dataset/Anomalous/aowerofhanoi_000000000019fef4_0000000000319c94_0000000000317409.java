import java.util.Scanner;

public class Solution {
    static String solve(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String movements = scanner.next();
        
        for (int i = 0; i < movements.length(); i++) {
            char direction = movements.charAt(i);
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
            int time = i + 1;
            if (Math.abs(x) + Math.abs(y) <= time) {
                return String.valueOf(time);
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String result = solve(scanner);
            System.out.println("Case #" + t + ": " + result);
        }
    }
}