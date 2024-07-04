import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG?new Scanner(new FileInputStream("test.in")):new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in.nextInt(), in.nextInt(), in.next()));
        }
    }

    static String solve(int x, int y, String path) {
        char[] arrayPath = path.toCharArray();
        for(int i = 0; i <= arrayPath.length; ++i) {
            if(Math.abs(x)+Math.abs(y) <= i) {
                return i+"";
            }
            else if(i < arrayPath.length){
                if(arrayPath[i] == 'N') {
                    y += 1;
                } else if(arrayPath[i] == 'S') {
                    y -= 1;
                } else if(arrayPath[i] == 'E') {
                    x += 1;
                } else if(arrayPath[i] == 'W') {
                    x -= 1;
                }
            }
        }
        return "IMPOSSIBLE";
    }
}