import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> ans = new ArrayList<>();
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        sc.nextLine();
        for (int i = 1; i <= t; ++i) {
            String input = sc.nextLine();
            String ansStr = "";
            int count = 0;
            for (int j = 0; j < input.length(); j++) {
                int x = Integer.parseInt(String.valueOf(input.charAt(j)));
                while (x != count) {
                    if (count > x) {
                        ansStr = ansStr + ")";
                        count--;
                    } else {
                        ansStr = ansStr + "(";
                        count++;
                    }
                }
                ansStr = ansStr+ input.charAt(j);
            }
            while (count!=0){
                ansStr=ansStr+")";
                count--;
            }
            ans.add("Case #"+i+": "+ansStr);
        }
        for (String an : ans) {
            System.out.println(an);
        }
    }
}