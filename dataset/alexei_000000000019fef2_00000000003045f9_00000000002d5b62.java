import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int c = 1; c <= T ; c++) {

            int x = in.nextInt();
            int y = in.nextInt();

            if (x + y % 2 == 0) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
                continue;
            }
            int steps = (int) Math.ceil(Math.log(Math.abs(x) + Math.abs(y)) / Math.log(2));

            String result = "";
            while (steps > 0) {
                if (Math.abs(x) > Math.abs(y)) {
                    if (x > 0) {
                        x -= Math.pow(2, steps-1);
                        result = "E" + result;
                    } else {
                        x += Math.pow(2, steps-1);
                        result = "W" + result;
                    }
                } else {
                    if (y > 0) {
                        y -= Math.pow(2, steps-1);
                        result = "N" + result;
                    } else {
                        y += Math.pow(2, steps-1);
                        result = "S" + result;
                    }
                }
                steps--;
            }
            System.out.println(String.format("Case #%d: %s", c, result));
        }
    }
}