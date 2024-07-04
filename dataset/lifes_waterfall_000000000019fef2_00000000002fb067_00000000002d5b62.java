import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();

            StringBuilder predresult = new StringBuilder();
            int currentX = x;
            int currentY = y;

            int differenceX = Math.abs(x - 0);
            int differenceY = Math.abs(y - 0);
            int difference = differenceX + differenceY;

            int j = 1;
            int stepValue = 0;
            for (;stepValue < difference; j++) {
                stepValue += Math.pow(2, j - 1);
            }

            j--;
            while (j > 0) {
                if (Math.abs(currentX - 0) > Math.abs(currentY - 0)) {
                    if ((currentX - 0) > 0) {
                        currentX -= Math.pow(2, j - 1);
                        predresult.append("W");
                    } else {
                        currentX += Math.pow(2, j - 1);
                        predresult.append("E");
                    }
                } else {
                    if ((currentY - 0) > 0) {
                        currentY -= Math.pow(2, j - 1);
                        predresult.append("S");
                    } else {
                        currentY += Math.pow(2, j - 1);
                        predresult.append("N");
                    }
                }
                j--;
            }

            String res;
            if (currentX == 0 && currentY == 0) {
                StringBuilder result = new StringBuilder();
                for (char c : predresult.toString().toCharArray()) {
                    switch (c) {
                        case ('W'):
                            result.insert(0, "E");
                            break;
                        case ('E'):
                            result.insert(0, "W");
                            break;
                        case ('N'):
                            result.insert(0, "S");
                            break;
                        case ('S'):
                            result.insert(0, "N");
                            break;
                    }
                }
                res = result.toString();
            } else {
                res = "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + res);
        }
    }
}
