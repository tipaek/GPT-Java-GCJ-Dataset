import java.util.*;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;


public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int x = input.nextInt();
            int y = input.nextInt();
            String result = "";
            boolean stop = false;
            boolean imp = false;
            String n = "N";
            String s = "S";
            String e = "E";
            String w = "W";
            if (x < 0) {
                x = -x;
                e = "W";
                w = "E";
            }
            if (y < 0) {
                y = -y;
                n = "S";
                s = "N";
            }
            while (!stop) {
                if (x == 0) {
                    if (y == 1) {
                        result += n;
                        break;
                    }else if (y == -1){
                        result+=s;
                        break;
                    }
                }
                if (y == 0) {
                    if (x == 1) {
                        result +=e;
                        break;
                    }else if (y == -1){
                        result+=w;
                        break;
                    }
                }
                if (x % 2 == 0 & y % 2 == 0 || x % 2 == 1 && y % 2 == 1) {
                    stop = true;
                    imp = true;
                    break;
                }
                if (x%2 == 1) {
                    if ((y % 4 == 2 && x % 4 == 3) || (y % 4 == 0 && x % 4 == 1)) {
                        result+=w;
                        x = x+1;
                        x = x / 2;
                        y = y/2;
                    }else {
                        result+=e;
                        x = x-1;
                        x = x / 2;
                        y = y/2;
                    }
                }else{
                    if ((x % 4 == 2 && y % 4 == 3) || (x % 4 == 0 && y % 4 == 1)) {
                        result+=s;
                        y = y + 1;
                        y = y/2;
                        x = x/2;
                    }else {
                        result+=n;
                        y = y - 1;
                        y = y/2;
                        x = x/2;
                    }
                }
            }
            if (imp) {
                System.out.println("Case #" + (turn + 1) + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (turn + 1) + ": " + result);
            }
        }
    }
}