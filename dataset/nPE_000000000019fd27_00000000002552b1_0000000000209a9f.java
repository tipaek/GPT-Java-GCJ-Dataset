import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            String nesting = "";
            boolean open = false;
            for (int j = 0; j < n.length(); ++j) {
                if (n.charAt(j) != '0' && !open) {
                    nesting += '(';
                    open = true;
                }

                if (n.charAt(j) == '0' && open) {
                    nesting += ')';
                    open = false;
                }
                nesting += n.charAt(j);
            }
            if (open)
                nesting += ')';
            System.out.println("Case #" + i + ": " + nesting);
        }
    }
}
