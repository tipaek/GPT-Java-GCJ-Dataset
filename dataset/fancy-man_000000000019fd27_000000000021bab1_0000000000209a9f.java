
import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int c = 1; c <= t; ++c) {

            char[] line = in.nextLine().toCharArray();
            int n = line.length;

            byte[] array =  new byte[n];
            for (int i=0; i<n; i++)
                array[i] = (byte)Character.digit(line[i], 10);

            String result = "";
            int level = 0;
            for (int i=0; i<n; i++)
            {
                int diff = array[i] - level;
                while (diff > 0)
                {
                    diff--;
                    level++;
                    result += '(';
                }
                while (diff < 0)
                {
                    diff++;
                    level--;
                    result += ')';
                }
                result += array[i];
            }

            while (level > 0)
            {
                level--;
                result += ')';
            }

            System.out.println("Case #" + c + ": " + result);
        }
    }
}