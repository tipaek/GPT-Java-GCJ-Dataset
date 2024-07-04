import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[] m = in.next().toCharArray();
            int result = Integer.MAX_VALUE;
            int distance = 0;
            int duration = 0;

            if (x==0 && y==0) {
                result = 0;
            } else {
                for (int i=0; i<m.length; i++) {
                    switch (m[i]) {
                        case 'N':
                            y++;
                            break;
                        case 'S':
                            y--;
                            break;
                        case 'E':
                            x++;
                            break;
                        case 'W':
                            x--;
                            break;
                    }
                    distance = Math.abs(x) + Math.abs(y);
                    if (i+1 >= distance) {
                        if (i+1 < result) {
                            result = i+1;
                        }
                    }

                }
            }

            if (result < Integer.MAX_VALUE) {
                System.out.println("Case #" + ti + ": " + result);
            } else {
                System.out.println("Case #" + ti + ": IMPOSSIBLE");

            }
        }
    }
}
