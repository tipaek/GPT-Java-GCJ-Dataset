import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int o = 0; o<t; o++) {
            String s = in.next();
            String msg = "";
            int delta = 0;
            for(int i=0; i<s.length(); i++) {
                int d = s.charAt(i) - '0';
                int diff = delta - d;
                for (int j = 1; j<= Math.abs(diff); j++) {
                    msg += ( diff < 0 ? "(" : ")");
                }
                msg += Character.toString(s.charAt(i));
                delta -= diff;
            }
            for (int j = 1; j<= Math.abs(delta); j++) {
                msg += ( delta < 0 ? "(" : ")");
            }
            System.out.println("Case #"+(o+1)+": "+msg);
        }
    }
}