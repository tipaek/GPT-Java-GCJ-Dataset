import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read Number of Test Case
        int t = in.nextInt();
        for (int input = 1; input <= t; ++input) {

            // Read size of data
            int x = in.nextInt();
            int y = in.nextInt();

            String direction = in.next();
            boolean canTakePhoto = false;

            int time = 0;
            for (char c: direction.toCharArray()) {

                time++;

                if(c == 'N') {
                    y++;
                } else if (c == 'S') {
                    y--;
                }else if (c == 'E') {
                    x++;
                }else if (c == 'W') {
                    x--;
                }

                int timeToGo = Math.abs(x) + Math.abs(y);

                if(timeToGo <= time) {
                    canTakePhoto = true;
                    break;
                }

            }

            if(!canTakePhoto) {
                System.out.println("Case #" + input + ": IMPOSSIBLE");
            } else {

                System.out.println("Case #" + input + ": " + time);
            }




        }

    }


}
  