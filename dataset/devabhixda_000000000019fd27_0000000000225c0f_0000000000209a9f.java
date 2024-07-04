import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = scan.next();
            int a = 0;
            StringBuilder sb = new StringBuilder(str);
            for(int j=0;j<str.length();j++) {
                if(str.charAt(j)!='0'){
                    sb.insert(j+2*a, '(');
                    sb.insert(j+2*(a+1), ')');
                    a++;
                }
            }
            for(int j=0;j<sb.length()-1;j++){
                if(sb.charAt(j)==')' && sb.charAt(j+1)=='(') {
                    sb.deleteCharAt(j);
                    sb.deleteCharAt(j);
                }
            }
            System.out.println("Case #"+i+": "+sb.toString());
        }
    }
}