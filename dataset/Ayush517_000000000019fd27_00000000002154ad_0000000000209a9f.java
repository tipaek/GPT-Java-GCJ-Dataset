import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        for(int tim=1;tim<=t;tim++) {
            String s = ob.next();
            StringBuilder sb = new StringBuilder("");
            int br=0;
            int prev=0;
            for(int i=0;i<s.length();i++) {
                int dig = s.charAt(i)-'0';
                if(dig>br) {
                    for(int j=0;j<dig-br;j++)
                        sb.append('(');
                    sb.append(dig);
                    br=dig;
                } else if (dig==br) {
                    sb.append(dig);
                } else {
                    for(int j=0;j<br-dig;j++)
                        sb.append(')');
                    sb.append(dig);
                    br=dig;
                }
            }
            for(int i=0;i<br;i++)
                sb.append(')');
            System.out.println("Case #"+tim+": "+sb.toString());
        }
    }
}