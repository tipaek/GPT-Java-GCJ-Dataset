import java.util.Scanner;

public class Solution {

    private String s;
    private int x; // E
    private int y; // N

    public Solution(int x, int y) {
        this.x = x;
        this.y = y;
        this.s = "";
    }

    private int mod(int a, int b) {
        return ((a % b) + b) % b;
    }

    public void calculate() {
        if (x == 0 && y == 0) return;
        
        if (x == 0) {
            if (y == 1) {
                s += "N";
            } else if (y == -1) {
                s += "S";
            }
            return;
        } else if (y == 0) {
            if (x == 1) {
                s += "E";
            } else if (x == -1) {
                s += "W";
            }
            return;
        }
        
        if (mod(y, 2) == 1 && mod(x, 2) == 0) {
            // Must be N or S
            if (mod(x, 4) == 0) {
                if (mod(y, 4) == 1) {
                    s += "S";
                    y++;
                } else {
                    s += "N";
                    y--;
                }
            } else {
                if (mod(y, 4) == 1) {
                    s += "N";
                    y--;
                } else {
                    s += "S";
                    y++;
                }
            }
        } else if (mod(x, 2) == 1 && mod(y, 2) == 0) {
            // Must be E or W
            if (mod(y, 4) == 0) {
                if (mod(x, 4) == 1) {
                    s += "W";
                    x++;
                } else {
                    s += "E";
                    x--;
                }
            } else {
                if (mod(x, 4) == 1) {
                    s += "E";
                    x--;
                } else {
                    s += "W";
                    x++;
                }
            }
        } else {
            s = "IMPOSSIBLE";
            return;
        }
        
        x /= 2;
        y /= 2;
        calculate();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 1; c <= cases; c++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Solution solution = new Solution(x, y);
            solution.calculate();
            System.out.println("Case #" + c + ": " + solution.s);
        }
        scanner.close();
    }
}