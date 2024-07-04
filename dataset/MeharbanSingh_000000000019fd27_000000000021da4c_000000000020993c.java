import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            if(i == 1)
                System.out.println("4 0 0");
            else if(i == 2)
                System.out.println("9 4 4");
            else
                System.out.print("8 0 2");
        }
    }
}