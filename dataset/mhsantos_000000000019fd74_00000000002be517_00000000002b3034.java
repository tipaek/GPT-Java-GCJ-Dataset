import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        tlabel:
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            List<String> strs = new ArrayList<>();
            for (int x = 0; x < n; x++) {
                strs.add(in.nextLine());
            }
            strs.sort((String s1, String s2) -> s2.length() - s1.length());
            String firstString = strs.get(0);
            for(int j = 1; j < n; j++) {
                if (!strs.get(j - 1).endsWith(strs.get(j).substring(1))) {
                    System.out.println("Case #" + i + ": *");
                    continue tlabel;
                }
            }
            System.out.println("Case #" + i + ": " + firstString.substring(1));
        }
    }

}