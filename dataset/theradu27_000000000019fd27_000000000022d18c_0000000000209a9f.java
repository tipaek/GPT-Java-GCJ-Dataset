

import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int test  = scn.nextInt(), opened ,closed;
        String values, ans;
        for(int k = 0; k < test; k++) {
            ans = "";
            values = scn.next();
            opened = 0;
            for(int i = 0; i < values.length(); i++) {
                while(values.charAt(i) -'0' > opened) {
                    opened++;
                    ans += "(";
                }
                ans += values.charAt(i);
                if(i < values.length() - 1 && values.charAt(i) < values.charAt(i + 1)) {
                    closed = values.charAt(i + 1) - values.charAt(i);
                    for(int j = 0; j < closed; j++) {
                        ans += "(";
                        opened++;
                    }
                }
                if(i < values.length() - 1 && values.charAt(i) > values.charAt(i + 1)) {
                    closed = values.charAt(i) - values.charAt(i + 1);
                    for(int j = 0; j < closed; j++) {
                        ans += ")";
                        opened--;
                    }
                }


            }
            while(opened > 0) {
                ans += ")";
                opened--;
            }
            System.out.println(ans);

        }
    }
}