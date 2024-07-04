import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String str[] = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);
            int n = (r - 1) * (s - 1);
            bw.write("Case #" + i + ": " + n + "\n");
            for (int x = 1; x <= r - 1; x++) {
                int cur = (r * s) - ((x - 1) * s) - 1 - r + x;
                for (int y = 1; y <= s - 1; y++) {
                    int ans = r - x;
                    bw.write("" + cur + " " + ans + "\n");
                    cur--;
                }
            }
        }
        bw.flush();
    }
}