import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int loops = 1; loops <= t; ++loops) {
            //Input
//            int n = in.nextInt();
//            int m = in.nextInt();
            String s = in.next();

            //Solution
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - 48;
                for (int j = 0; j < num; j++) {
                    builder.append("(");
                }
                builder.append(num);
                for (int j = 0; j < num; j++) {
                    builder.append(")");
                }

            }
            String result = builder.toString();

            while (result.contains(")(")) {
                result = result.replace(")(", "");
            }



            //Result
            System.out.println("Case #" + loops + ": " + result);
        }
    }
}