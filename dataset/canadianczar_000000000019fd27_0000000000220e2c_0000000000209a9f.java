import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine()), test = 1;
        while (test <= tests) {
            String line = in.nextLine();
            solve(test, line);
            test++;
        }
        in.close();
    }
    public static void solve(int test, String line) {
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (sb.length()==0) {
                if (c=='0') sb.append(c);//add 0
                else sb.append('(').append(c);//add ( and 1
            } else {
                int last = sb.length() - 1;
                if (sb.charAt(last) == '0') {
                    if (c=='0') sb.append(c);//add 0
                    else sb.append('(').append(c);//add ( and 1
                } else {//last is 1
                    if (c=='0') sb.append(')').append(c);//add ) and 0
                    else sb.append(c);//add 1
                }
            }
        }
        if (sb.length() >= 1 && sb.charAt(sb.length()-1)=='1') sb.append(')');
        System.out.printf("Case #%d: %s\n", test, sb.toString());
    }
}