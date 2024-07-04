import java.util.Scanner;

public class Solution {

    private int x;
    private int y;
    private String s;

    public Solution(int east, int north, String tour) {
        this.x = east;
        this.y = north;
        this.s = tour;
    }

    public String calculate() {
        int curx = x;
        int cury = y;
        for (int i = 0; i <= s.length(); i++) {
            if (Math.abs(curx) + Math.abs(cury) <= i) {
                return Integer.toString(i);
            }
            if (i == s.length()) {
                break;
            }
            switch (s.charAt(i)) {
                case 'N':
                    cury++;
                    break;
                case 'S':
                    cury--;
                    break;
                case 'E':
                    curx++;
                    break;
                case 'W':
                    curx--;
                    break;
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 1; c <= cases; c++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            String s = scanner.nextLine().strip();
            Solution solution = new Solution(x, y, s);
            System.out.println("Case #" + c + ": " + solution.calculate());
        }
        scanner.close();
    }
}