import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();

            String temp = "";

            int depth = 0;

            String[] characters = s.split("(?!^)");
            for(int x = 0; x < characters.length; x++) {

                String character = characters[x];

                if (character.equals("(")) {
                    depth++;
                    continue;
                }

                if (character.equals(")")) {
                    depth--;
                }

                try {
                    int num = Integer.parseInt(character);

                    if (num > depth) {
                        for(depth = depth; depth < num; depth++) {
                            temp += "(";
                        }
                    }
                    if (num < depth) {
                        for(depth = depth; depth > num; depth--) {
                            temp += ")";
                        }
                    }
                    temp += "" + num;


                } catch (Exception e) {

                }
            }

            for(int x = 0; x < depth; x++) {
                temp+=")";
            }

            System.out.println(String.format("Case #%s: %s", i,temp));
        }
    }

}
  