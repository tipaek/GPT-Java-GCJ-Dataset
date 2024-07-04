import java.math.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);

        int testcases = ob.nextInt();
        for (int test = 1; test<=testcases; test++) {
            int x=ob.nextInt();
            int y=ob.nextInt();
            String s = ob.next();
            char[] arr = s.toCharArray();

            int i=0;
            int ans=Integer.MAX_VALUE;
            int[][] next = new int[s.length()+1][2];
            next[0] = new int[]{x, y};
            while(i<s.length()) {
                if(arr[i]=='S')
                    y--;
                else if(arr[i]=='N')
                    y++;
                else if(arr[i]=='E')
                    x++;
                else if(arr[i]=='W')
                    x--;
                next[i+1]=new int[]{x, y};
                i++;
            }
            i=s.length();
            while(i>0) {
                int pos[] = next[i];
                int mid = Math.abs(pos[0]) + Math.abs(pos[1]);

                if(mid<=i) {
                    ans = Math.min(ans, Math.max(mid, i));
                }
                i--;
            }
            if(ans!=Integer.MAX_VALUE)
                System.out.println("Case #"+test+": "+ans);
            else
                System.out.println("Case #"+test+": IMPOSSIBLE");
        }
    }
}