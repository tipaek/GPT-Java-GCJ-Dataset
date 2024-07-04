import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        boolean flag = true;
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int startC1 = 0;
            int startJ1 = 0;
            int endC1 = 0;
            int endJ1 = 0;
            int startC2 = 0;
            int startJ2 = 0;
            int endC2 = 0;
            int endJ2 = 0;
            String result = "";
            String result2 = "";
            String result1 = "";
            for (int j = 0; j < n; j++) {
                int start = s.nextInt();
                int end = s.nextInt();
                if (start >= endC1 || end <= startC1) {
                    result1 = result1 + "C";
                    startC1 = start;
                    endC1 = end;
                } else if (start >= endJ1 || end <= startJ1) {
                    result1 = result1 + "J";
                    startJ1 = start;
                    endJ1 = end;
                } else {
                    result1 = "IMPOSSIBLE";
                }

                if (start >= endJ2 || end <= startC2) {
                    result2 = result2 + "J";
                    startJ2 = start;
                    endJ2 = end;
                } else if (start >= endC2 || end <= startJ2) {
                    result2 = result2 + "C";
                    startC2 = start;
                    endC2 = end;
                } else {
                    result2 = "IMPOSSIBLE";
                }

                if (!result1.equalsIgnoreCase("IMPOSSIBLE")) {
                    result = result1;
                } else if (!result1.equalsIgnoreCase("IMPOSSIBLE")) {
                    result = result2;
                } else {
                    result = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);

        }
    }
}
