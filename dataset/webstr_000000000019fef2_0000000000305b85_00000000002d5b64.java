import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            String res = "";
            int r = in.nextInt();
            int s = in.nextInt();
            if (r == 2 && s == 2) {
                res = "1\n2 1";
            } else if (r == 2 && s == 3) {
                res = "2\n2 3\n2 2";
            } else if (r == 2 && s == 4) {
                res = "3\n2 5\n2 4\n2 3";
            } else if (r == 2 && s == 5) {
                res = "4\n2 7\n2 6\n2 5\n2 4";
            } else if (r == 2 && s == 6) {
                res = "5\n2 9\n2 8\n2 7\n2 6\n2 5";
            } else if (r == 2 && s == 7) {
                res = "6\n2 11\n2 10\n2 9\n2 8\n2 7\n2 6";
            } else if (r == 3 && s == 2) {
                res = "2\n3 2\n2 1";
            } else if (r == 3 && s == 3) {
                res = "4\n3 5\n3 4\n2 3\n2 2";
            } else if (r == 3 && s == 4) {
                res = "6\n3 8\n3 7\n3 6\n2 5\n2 4\n2 3";
            } else if (r == 4 && s == 2) {
                res = "3\n4 3\n3 2\n2 1";
            } else if (r == 4 && s == 3) {
                res = "6\n4 7\n4 6\n3 5\n3 4\n2 3\n2 2";
            } else if (r == 5 && s == 2) {
                res = "4\n5 4\n4 3\n3 2\n2 1";
            }

            System.out.println("Case #" + t + ": " + res);
        }
    }
}