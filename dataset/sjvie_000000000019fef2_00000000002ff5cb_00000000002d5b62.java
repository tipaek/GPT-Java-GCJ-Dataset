import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for (int currentCase = 1; currentCase <= amountCases; currentCase++) {
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        boolean xNeg = x < 0;
        boolean yNeg = y < 0;

        x = Math.abs(x);
        y = Math.abs(y);


        String x1 = Integer.toBinaryString(x).replace('1', 'E');
        String y1 = Integer.toBinaryString(y).replace('1', 'N');

        String x2 =null;
        if (x1.length() <= y1.length()) {
            x2 = Integer.toBinaryString((int) Math.pow(2, y1.length()) - x);
            while (x2.length() < y1.length()) {
                x2 = "0" + x2;
            }
            x2 = "E" + x2.replace('1', 'W');
        }

        String y2 = null;
        if (y1.length() <= x1.length()) {
            y2 = Integer.toBinaryString((int) Math.pow(2, x1.length()) - y);
            while (y2.length() < x1.length()) {
                y2 = "0" + y2;
            }
            y2 = "N" + y2.replace('1', 'S');
        }

        boolean impossible = false;

        String output = "";
        String currX = x1;
        String currY = y1;
        for (int i = 0; i < Math.max(currX.length(), currY.length()); i++) {
            char xc = '0';
            char yc = '0';

            if (currX.length() > i) {
                xc = currX.charAt(currX.length() - i - 1);
            }

            if (currY.length() > i) {
                yc = currY.charAt(currY.length() - i - 1);
            }
            if (yc != '0' && xc != '0') {
                impossible = true;
            } else if (yc != '0') {
                output += yc;
            } else {
                output += xc;
            }
        }

        if(impossible && y2 != null){
            impossible = false;
            output = "";
            currX = x1;
            currY = y2;

            for (int i = 0; i < Math.max(currX.length(), currY.length()); i++) {
                char xc = '0';
                char yc = '0';

                if (currX.length() > i) {
                    xc = currX.charAt(currX.length() - i - 1);
                }

                if (currY.length() > i) {
                    yc = currY.charAt(currY.length() - i - 1);
                }
                if (yc != '0' && xc != '0') {
                    impossible = true;
                } else if (yc != '0') {
                    output += yc;
                } else {
                    output += xc;
                }
            }
        }

        if(impossible && x2 != null){
            impossible = false;
            output = "";
            currX = x2;
            currY = y1;
            for (int i = 0; i < Math.max(currX.length(), currY.length()); i++) {
                char xc = '0';
                char yc = '0';

                if (currX.length() > i) {
                    xc = currX.charAt(currX.length() - i - 1);
                }

                if (currY.length() > i) {
                    yc = currY.charAt(currY.length() - i - 1);
                }
                if (yc != '0' && xc != '0') {
                    impossible = true;
                } else if (yc != '0') {
                    output += yc;
                } else {
                    output += xc;
                }
            }
        }


        if (xNeg) {
            output = output.replace('E', 'P');
            output = output.replace('W', 'E');
            output = output.replace('P', 'W');
        }
        if (yNeg) {
            output = output.replace('N', 'P');
            output = output.replace('S', 'N');
            output = output.replace('P', 'S');
        }
        if (impossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(output);
        }
    }
}