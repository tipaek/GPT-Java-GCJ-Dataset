/**
 * Author: Nirav Talaviya
 */

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = readInt();
        for(int tt=1;tt<=t;tt++) {
            int[] a1 = readintarr();
            int n = a1[0];
            int d = a1[1];
            HashSet<Long> set = new HashSet<>();
            long[] a = readlongarr();
            Arrays.sort(a);
            for(int i=0;i<a.length;i++){
                set.add(a[i]);
            }
            boolean found = false;
            if (d == 2) {
                for (int i = 0; !found && i + 1 < a.length; i++) {
                    if (!found && a[i] == a[i + 1]) {
                        found = true;
                        System.out.println("Case #" + tt + ": 0");
                    }
                }
                if(!found){
                    found=true;
                    System.out.println("Case #" + tt + ": 1");
                }
            }
            if (d == 3) {
                for (int i = 0; !found && i + 2 < a.length; i++) {
                    if (!found && a[i] == a[i + 2]) {
                        found = true;
                        System.out.println("Case #" + tt + ": 0");
                    }
                }
                for(int i=0;!found && i<a.length;i++){
                    if(set.contains(a[i]*2)){
                        found = true;
                        System.out.println("Case #" + tt + ": 1");
                    }
                }
                if(!found){
                    System.out.println("Case #" + tt + ": 2");

                }
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

    
    
    