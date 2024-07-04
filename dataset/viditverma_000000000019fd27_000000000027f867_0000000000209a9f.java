import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String open [] = {"","(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
        String close[] = {"",")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};
        for (int cases = 1; cases <= test; ++cases) {
            String s = in.next();
            StringBuilder sb =new StringBuilder();
            int len = s.length();
            int ob = 0;
            int value = s.charAt(0)-48;
            sb.append(open[value]+value);
            ob = value;
            for(int i = 1;i<len;i++)
            {
                char prev = s.charAt(i-1);
                char current = s.charAt(i);
                if(current == prev)
                {
                    sb.append(current);
                }
                else if(current < prev)
                {
                    value = prev-current;
                    sb.append(close[value]+current);
                    ob -= value;
                }
                else
                {
                    value = current-prev;
                    sb.append(open[value]+current);
                    ob += value;
                }
            }
            sb.append(close[ob]);
            System.out.println("Case #"+cases+": "+sb.toString());
        }
    }
}