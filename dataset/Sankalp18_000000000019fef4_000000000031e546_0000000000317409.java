import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int test = Integer.parseInt(br.readLine());

            for (int t = 1; t <= test; t++) {
                String str[] = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                String s = str[2];
                int dist = 0, min = Integer.MAX_VALUE,len;

                String arr[] = s.split("");
                len=arr.length;
                for (int i = 0; i < len; i++) {
                    if (arr[i].equals("N")) {
                        y++;
                    }
                    else if (arr[i].equals("S")) {
                        y--;
                    }
                    else if (arr[i].equals("E")) {
                        x++;
                    }
                    else {
                        x--;
                    }

                    dist = Math.abs(x) + Math.abs(y);

                    if (dist <= i + 1) {
                        min = Integer.min(i + 1, min);
                    }

                }

                if (min == Integer.MAX_VALUE) {
                    System.out.println("Case #" + t + ": Impossible");
                } else {
                    System.out.println("Case #" + t + ": " + min);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
