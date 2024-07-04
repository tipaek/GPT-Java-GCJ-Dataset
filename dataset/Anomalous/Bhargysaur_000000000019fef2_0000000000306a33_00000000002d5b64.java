import java.util.Scanner;

public class Solution {

    public static void sortSegment(int r, int s) {
        if (r == 1 || s == 1) return;

        int t = r * s;
        for (int i = 1; i < s; i++) {
            System.out.println(r + " " + ((t - r * i) - i));
        }

        sortSegment(r - 1, s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            int s = sc.nextInt();

            int total = (r - 1) * (s - 1);

            System.out.println("Case #" + (i + 1) + ": " + total);

            sortSegment(r, s);
        }
    }
}