import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            boolean flipX = false;
            boolean flipY = false;
            String path = "";
            int x = in.nextInt();
            if (x < 0) {
                x = Math.abs(x);
                flipX = true;
            }
            int y = in.nextInt();
            if (y < 0) {
                y = Math.abs(y);
                flipY = true;
            }
            if (x % 2 == 1 && y % 2 == 0) {
                int minusX = x - 1;
                int plusX = x + 1;
                if ((minusX & y) == 0) {
                    x = minusX;
                    if (flipX){
                        path = "W";
                    } else{
                        path = "E";
                    }
                } else if ((plusX & y) == 0) {
                    x = plusX;
                    if (flipX){
                        path = "E";
                    } else{
                        path = "W";
                    }
                }
            } else if (y % 2 == 1 && x % 2 == 0) {
                int minusY = y - 1;
                int plusY = y + 1;
                if ((minusY & x) == 0) {
                    y = minusY;
                    if (flipY){
                        path = "S";
                    } else{
                        path = "N";
                    }
                } else if ((plusY & x) == 0) {
                    y = plusY;
                    if (flipY){
                        path = "N";
                    } else{
                        path = "S";
                    }
                }
            } else {
                path = "IMPOSSIBLE";
            }
            int max = Math.max(x,y);

            for (int j = 1; j < Integer.toBinaryString(max).length(); j++) {
                int jumpAmount = (int)Math.pow(2, j);
                if ((jumpAmount & x) == jumpAmount){
                    if(flipX){
                        path += "W";
                    } else {
                        path += "E";
                    }
                } else {
                    if(flipY){
                        path += "S";
                    } else {
                        path += "N";
                    }
                }
            }
            System.out.println(String.format("Case #%d: %s", i, path));
        }
    }
}
