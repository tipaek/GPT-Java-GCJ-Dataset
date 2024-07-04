import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {

            // Read size of data
            long x = in.nextInt();
            long y = in.nextInt();

            if((Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) || (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {


                long nearestPowerOfTwo = 1;

                while (nearestPowerOfTwo * 2 < Math.abs(x) + Math.abs(y))
                    nearestPowerOfTwo *= 2;

                String result = "";
                while (nearestPowerOfTwo >= 1) {

                    if (Math.abs(x) > Math.abs(y)) {

                        if (x < 0) {
                            x = x + nearestPowerOfTwo;
                            result += "W";
                        } else {
                            x = x - nearestPowerOfTwo;
                            result += "E";
                        }
                    }
                    else{
                            if (y < 0) {
                                y = y + nearestPowerOfTwo;
                                result += "S";
                            } else {
                                y = y - nearestPowerOfTwo;
                                result += "N";
                            }

                    }

                    nearestPowerOfTwo = nearestPowerOfTwo / 2;
                }

                System.out.println("Case #" + i + ": " + new StringBuilder(result).reverse().toString());
            }

        }
    }


}
  