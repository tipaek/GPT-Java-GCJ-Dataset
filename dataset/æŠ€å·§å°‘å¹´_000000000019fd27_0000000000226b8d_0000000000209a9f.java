import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution{public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            char[] array = s.toCharArray();
            int j = 0;
            StringBuilder builder = new StringBuilder();
            int preNum = 0;
            while (j < array.length) {
                int curNum = array[j] - '0';
                if (preNum != curNum) {
                    if (preNum < curNum) {
                        int x = curNum - preNum;
                        for (int k = 0; k < x; k++) {
                            builder.append('(');
                        }
                    } else {
                        int y = preNum - curNum;
                        for (int k = 0; k < y; k++) {
                            builder.append(')');
                        }
                    }
                }
                builder.append(curNum);
                preNum = curNum;
                j++;
            }
            int lastNum = array[array.length - 1] - '0';
            for (int k = 0; k < lastNum; k++) {
                builder.append(')');
            }
            System.out.println(String.format("Case #%d: %s", i, builder.toString()));
        }
    }
}