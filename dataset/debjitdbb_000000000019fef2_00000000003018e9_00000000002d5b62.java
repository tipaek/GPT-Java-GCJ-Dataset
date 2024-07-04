import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int mm = 1; mm <= T; mm++) {
            boolean flag=true;
            String str[] = br.readLine().split(" ");
            long x = Long.parseLong(str[0]);
            long y = Long.parseLong(str[1]);
            String ans = "";
            while (x != 0 || y != 0)
            {
                if (Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1)
                {
                    ans = "IMPOSSIBLE";
                    // ans = "";
                    flag =false;
                    break;
                }
                if (Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0)
                {
                    ans = "IMPOSSIBLE";
                    flag=false;
                    // ans = "";
                    break;
                }

                if (Math.abs(x) % 2 == 1)
                {
                    if ((x - 1) / 2 == 0 && y == 0)
                    {
                        ans += "E";
                        x -= 1;
                    }
                    else if ((x + 1) / 2 == 0 && y == 0)
                    {
                        ans += "W";
                        x += 1;
                    }
                    else if (((x - 1) / 2 + y / 2) % 2 == 0)
                    {
                        ans += "W";
                        x += 1;
                    }
                    else
                    {
                        ans += "E";
                        x -= 1;
                    }
                }
                if (Math.abs(y) % 2 == 1)
                {
                    if ((y - 1) / 2 == 0 && x / 2 == 0)
                    {
                        ans += "N";
                        y -= 1;
                    }
                    else if ((y + 1) / 2 == 0 && x / 2 == 0)
                    {
                        ans += "S";
                        y += 1;
                    }
                    else if (((y - 1) / 2 + x / 2) % 2 == 0)
                    {
                        ans += "S";
                        y += 1;
                    }
                    else
                    {
                        ans += "N";
                        y -= 1;
                    }
                }
                x = x / 2;
                y = y / 2;
            }
            // System.out.println(ans);
            // if(flag==true)
            //     sb.append("Case #" + mm + ": ");
            // else
                sb.append("Case #" + mm + ": ");
            sb.append(ans);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}