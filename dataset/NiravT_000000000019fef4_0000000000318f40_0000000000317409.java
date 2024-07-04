/**
 * Author: Nirav Talaviya
 */

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t =readInt();
        for(int tt=1;tt<=t;tt++){
            String []str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            String s = str[2];
            int minute = 0;
            boolean flag= true;
            if(flag && Math.abs(x)+Math.abs(y)==0){
                flag =false;
                System.out.println("Case #"+tt+": "+minute);
            }else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'N') {
                        y++;
                    } else if (s.charAt(i) == 'S') {
                        y--;
                    } else if (s.charAt(i) == 'E') {
                        x++;
                    } else {
                        x--;
                    }
                    minute++;
                    if(flag && Math.abs(x)+Math.abs(y)<=minute){
                        flag =false;
                        System.out.println("Case #"+tt+": "+minute);
                    }
                }
            }
            if(flag){
                System.out.println("Case #"+tt+": IMPOSSIBLE");
            }
        }

    }

    static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static long readLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    static int[] readintarr() throws IOException {
        String[] ___str___ = br.readLine().split(" ");
        int[] ___arr___ = new int[___str___.length];
        for (int i = 0; i < ___str___.length; i++) {
            ___arr___[i] = Integer.parseInt(___str___[i]);
        }
        return ___arr___;
    }

    static long[] readlongarr() throws IOException {
        String[] ___str___ = br.readLine().split(" ");
        long[] ___arr___ = new long[___str___.length];
        for (int i = 0; i < ___str___.length; i++) {
            ___arr___[i] = Long.parseLong(___str___[i]);
        }
        return ___arr___;
    }
}

    
    
    