import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = scan.next();
            char curr = str.charAt(0);
            int start = 0 , end = 2, a=0;
            StringBuilder sb = new StringBuilder(str);
            for(int j=1;j<str.length();j++) {
                if(str.charAt(j)==curr)
                    end++;
                else if(curr!='0') {
                    sb.insert(start, '(');
                    sb.insert(end, ')');
                    a++;
                    curr=str.charAt(j);
                    if(curr!='0'){
                        start=end+1;
                        end=start+2;
                    } else {
                        start=j+1+2*a;
                        end=start+2;
                    }
                }
            }
            curr=str.charAt(str.length()-1);
            // System.out.println(start+" "+end+" "+sb.length());
            if(end<=sb.length()+1 && curr!='0'){
                sb.insert(start, '(');
                sb.insert(end, ')');
            }
            System.out.println("Case #"+i+": "+sb.toString());
        }
    }
}