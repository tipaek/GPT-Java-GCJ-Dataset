
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      for (int i = 1; i <= t; ++i) {
        int input = in.nextInt();
        List<int[]> outs = getOutput(input);
        String output = "";
        for (int[] out : outs) {
            output = output + "\n" + out[0] + " " + out[1];
        }
        System.out.println("Case #" + i + ":" + output);
      }
    }

    private static List<int[]> getOutput(int input) {
        List<int[]> output = new ArrayList<>();
        output.add(new int[]{1,1});
        if (input == 1) {
            return output;
        }
        int level = 0;
        while ((level * (level+1) / 2 + 1) <= input){
            level++;
        }
        level--;
        int remain = input - level * (level+1) / 2 - 1;
        for (int i = 1; i <= level; i++) {
            output.add(new int[]{i+1, 2});
        }
        for (int i = remain; i > 0; i--) {
            output.add(new int[]{level + 1, 1});
            level--;
        }

        return output;
    }
}