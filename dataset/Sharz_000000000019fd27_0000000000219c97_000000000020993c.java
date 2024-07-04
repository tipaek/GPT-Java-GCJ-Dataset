import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            System.out.print("Case #" + i + ": ");
            int count = 0;
            int tmp = 0;
            int d = 0;
            for (int j = 0; j < s.length(); j++) {
                d = Integer.parseInt(s.charAt(j)+"");
                if (count < d) {
                    tmp = Math.abs(d - count);
                    count += tmp;
                    while (tmp-- > 0)
                        System.out.print("(");
                } else if (count > d) {
                    tmp = count - d;
                    count -= tmp;
                    while (tmp-- > 0)
                        System.out.print(")");
                }
                System.out.print(s.charAt(j));
                if (j+1 == s.length() && count > 0){
                    while (count-- > 0)
                        System.out.print(")");
                }
            }
            System.out.print(System.lineSeparator());
        }
	}
}
