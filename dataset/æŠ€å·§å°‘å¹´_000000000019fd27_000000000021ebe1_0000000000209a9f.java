import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
//            char[] array = s.toCharArray();
//            int j = 0;
//            StringBuilder builder = new StringBuilder();
//            boolean isOpen = false;
//            while (j < array.length) {
//                if (array[j] == '0') {
//                    if (isOpen) {
//                        builder.append(")");
//                        isOpen = false;
//                    }
//                    builder.append('0');
//                } else {
//                    if (!isOpen) {
//                        builder.append("(");
//                        isOpen = true;
//                    }
//                    builder.append('1');
//                }
//                j++;
//            }
//            if (isOpen) {
//                builder.append(')');
//            }
//            System.out.println(String.format("Case #%d: %s", i, builder.toString()));
            System.out.println("!!!!");
        }

    }


}