
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      int a = in.nextInt(), b = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
            shouldReturn = false;
            getOutput(a, b, in);
      }
    }
    static boolean shouldReturn = false;
    static int limit = (int)Math.pow(10,9);
    static int[][] range = new int[][]{
        {-1*limit/2, limit/2}, {0, limit/2}, {limit/2, limit/2}, 
        {limit/2, 0}, {0,0}, {-limit/2, 0}, 
        {-limit/2, -limit/2}, {0, -limit/2}, {limit/2, -limit/2}};
        // use step and limit*2/step + 0 instead

    private static Boolean shouldReturn(String output) {
        if (output.equals("HIT")) return false;
        else if (output.equals("MISS")) return false;
        shouldReturn = true;
        return true;
    }

    private static String getOut(boolean isX, int other, int target) {
        if (isX) {
            return "" + target + " " + other;
        }
        return "" + other + " " + target;
    }

    private static int find(Scanner in, boolean isX, int other, int low, int high){
        if (shouldReturn) return 0;
        if (low == high) return low;
        int mid = (low + high) / 2; //TODO mid = low?
        if (mid == low) mid = low + 1;
        String output , output2;
        System.out.println(getOut(isX, other, low));
        output = in.nextLine();
        if (shouldReturn(output)) return 0;
        System.out.println(getOut(isX, other, mid));
        output2 = in.nextLine();
        if (shouldReturn(output2)) return 0;
        if (output != output2) {
            if (mid == low + 1) return output.equals("HIT")? low : mid;
            return find(in, isX, other, low, mid);
        } else {
            return find(in, isX, other, mid, high);
        }
    }

    private static void getOutput(int A, int B, Scanner in) {
        int x = 0, y = 0;
        for (int[] dir : range) {
            System.out.println("" + dir[0] + " " + dir[1]);
            String output = in.nextLine();
            if (shouldReturn(output)) return;
            if(output.equals("HIT")) {
                x = dir[0];
                y = dir[1];
                break;
            }
        }
        int x1 = find(in, true, y, -limit, x);
        int x2 = find(in, true, y, x, limit);
        int y1 = find(in, false, x, -limit, y);
        int y2 = find(in, false, x, y, limit);
        if (shouldReturn) return;

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;
        System.out.println("" + midX + " " + midY);
    }

}