import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t, n;
        t = Integer.parseInt(in.readLine());
        for (int a = 0; a < t; a++) {
            n = Integer.parseInt(in.readLine());
            //int timing[][]=new int[n][2];
            int CStart = -1, CEnd = -1, JStart = -1, JEnd = -1;
            String ans = "";
            for (int b = 0; b < n; b++) {
                String str[] = in.readLine().split(" ");
                if(ans.equals("IMPOSSIBLE"))
                    continue;
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                if (!((start>=CStart && start<CEnd) || (end>=CStart && end<CEnd) || (start<=CStart && end>CEnd))) {
                    CStart = start;
                    CEnd = end;
                    ans += "C";
                } else if (!((start>=JStart && start<JEnd) || (end>=JStart && end<JEnd) || (start<=JStart && end>JEnd))) {

                    JStart=start;
                    JEnd=end;
                    ans+="J";
                }
                else
                {
                    ans="IMPOSSIBLE";
                }
            }
            System.out.println("Case #"+(a+1)+": "+ans);
        }
    }
}

