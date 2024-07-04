import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder v = new StringBuilder();
            int min = 0;
            for (int j = 0; j < s.length(); j++) {
                int charAt = Integer.parseInt((s.charAt(j)+""));
                if(charAt > min)
                {
                    while(min != charAt)
                    {
                        v.append("(");
                        min++;
                    }
                    v.append(charAt);
                }else if(charAt < min)
                {
                    v.append(")");
                    v.append(charAt);
                    min--;
                }else
                {
                    v.append(charAt);
                }
            }
            while(min != 0)
            {
                v.append(")");
                min--;
            }
            System.out.println("Case #"+i+": "+v);
        }
    }
}
