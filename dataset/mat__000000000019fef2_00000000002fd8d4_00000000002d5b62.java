import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int x = in.nextInt();
            int y = in.nextInt();

            String output = expogo(x, y);

            System.out.println("Case #" + i + ": " + output);

        }
    }

    static String expogo(int x, int y) {

        int xAbs = Math.abs(x);
        int yABs = Math.abs(y);

        if ((xAbs + yABs) % 2 == 0) return "IMPOSSIBLE";

        int sum = xAbs + yABs;

        int n = 0;
        if (sum > 2) {
            n = (int) Math.ceil(Math.log10(sum) / Math.log10(2)) - 1;
        }

        int currentX = x;
        int currentY = y;


        StringBuilder sb = new StringBuilder();

        for (int i = n; i >= 0; i--) {
            if (Math.abs(currentX) > Math.abs(currentY)) {
                if (currentX > 0) {
                    sb.append("E");
                    currentX = currentX - (int) Math.pow(2, i);
                } else {
                    sb.append("W");
                    currentX = currentX + (int) Math.pow(2, i);
                }
            } else {
                if (currentY > 0) {
                    sb.append("N");
                    currentY = currentY - (int) Math.pow(2, i);
                } else {
                    sb.append("S");
                    currentY = currentY + (int) Math.pow(2, i);
                }
            }
        }

        return sb.reverse().toString();

    }

}
