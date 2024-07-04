import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); in.nextLine();
        for( int i = 1; i <= T; i++ ) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int curr = 0;
            for( int j = 0; j < s.length(); j++ ) {
                int digit = Integer.parseInt(s.charAt(j)+"");
                if( j == 0 ) {
                    int ct = digit;
                    curr += digit;
                    while(ct-->0) sb.append("(");
                } else {
                    int prev = Integer.parseInt(s.charAt(j-1)+"");
                    if( digit > prev ) {
                        int ct = digit-prev;
                        curr += ct;
                        while(ct-->0) sb.append("(");
                    } else if( digit < prev ) {
                        int ct = prev-digit;
                        curr -= ct;
                        while(ct-->0) sb.append(")");
                    }
                }
                sb.append(digit);
            }
            while(curr-->0) sb.append(")");
            System.out.println(sb.toString());
        }
    }
}