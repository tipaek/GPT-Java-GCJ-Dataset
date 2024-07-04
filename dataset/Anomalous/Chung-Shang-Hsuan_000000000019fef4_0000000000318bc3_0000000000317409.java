import java.util.Scanner;

public class Solution {

    private int x;
    private int y;
    private String tour;

    public Solution(int east, int north, String tour) {
        this.x = east;
        this.y = north;
        this.tour = tour;
    }

    public String calculate() {
        int curX = x;
        int curY = y;
        for (int i = 0; i <= tour.length(); i++) {
            if (Math.abs(curX) + Math.abs(curY) <= i) {
                return Integer.toString(i);
            }
            if (i == tour.length()) {
                break;
            }
            switch (tour.charAt(i)) {
                case 'N':
                    curY++;
                    break;
                case 'S':
                    curY--;
                    break;
                case 'E':
                    curX++;
                    break;
                case 'W':
                    curX--;
                    break;
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        for (int c = 1; c <= cases; c++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String s = scanner.nextLine();
            Solution solution = new Solution(x, y, s);
            System.out.println("Case #" + c + ": " + solution.calculate());
        }
        scanner.close();
    }
}