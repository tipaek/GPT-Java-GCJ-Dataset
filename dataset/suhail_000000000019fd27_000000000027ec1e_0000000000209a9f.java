import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String[]  arr = new String[t];
        for (int i = 0; i < t; ++i) {
            arr[i] = in.next();
        }
        int j=1;StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            char[] ch = str.toCharArray();

            sb.append("Case #"+j+": ");
            if(ch[0] == '0') {
                sb.append("0");
            } if(ch[0] == '1') {
                sb.append("(1");
            }
            for(int i = 1; i<ch.length; i++) {
                if(ch[i-1] == '0' && ch[i] == '0') {
                    sb.append("0");
                } else if(ch[i-1] == '0' && ch[i] == '1') {
                    sb.append("(1");
                }else if(ch[i-1] == '1' && ch[i] == '1') {
                    sb.append("1");
                } else if(ch[i-1] == '1' && ch[i] == '0') {
                    sb.append(")0");
                }

            }
            if(ch[ch.length-1] == '1') {
                sb.append(")");
            }
            sb.append("\n");
            j++;
        }
        System.out.println(sb.toString());
    }
}