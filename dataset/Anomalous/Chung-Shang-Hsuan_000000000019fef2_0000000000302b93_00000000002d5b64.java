import java.util.Scanner;

public class Solution {

    public void print2(int r, int s) {
        int k = s * r - r - 1;
        for (int times = 0; times < s - 1; times++) {
            System.out.println(r + " " + k);
            k--;
        }
    }

    public Solution(int caseNumber, int r, int s) {
        System.out.println("Case #" + caseNumber + ": " + (s - 1) * (r - 1));
        for (int i = r; i >= 2; i--) {
            print2(i, s);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 1; c <= cases; c++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            new Solution(c, r, s);
        }
    }
}