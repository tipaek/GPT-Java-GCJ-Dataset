import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ex = in.nextLine();

            System.out.println("Case #" + i + ": " + solve(ex));
        }
    }

    public static String solve(String ex){
        String result = "";
        int curNest = 0;
        for(int i = 0; i < ex.length(); i++){
            int c = Character.getNumericValue(ex.charAt(i));
            boolean done = false;
            while (!done) {
                if (c == curNest) {
                    result = result + Integer.toString(c);
                    done = true;
                } else if (c > curNest) {
                    result = result + "(";
                    curNest++;
                } else {
                    result = result + ")";
                    curNest--;
                }
            }
        }
        while (curNest > 0){
            result = result + ")";
            curNest--;
        }
        return result;
    }
}