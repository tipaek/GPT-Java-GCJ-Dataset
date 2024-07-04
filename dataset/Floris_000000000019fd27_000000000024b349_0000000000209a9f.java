import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            String s = sc.next()+"0";
            StringBuilder result = new StringBuilder();
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                int v = s.charAt(i)-'0';
                for (;c<v;c++) result.append('(');
                for (;c>v;c--) result.append(')');
                result.append(s.charAt(i));
            }
            result.deleteCharAt(result.length()-1);
            System.out.printf("Case #%d: %s%n", cs, result.toString());
        }
    }
}
