

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String solve(int[][] activities) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer > map = new HashMap<>();

        if( activities.length == 0 ){
            return "";
        }
        //sort the activites
        Arrays.sort(activities, Comparator.comparingInt(o -> o[0]));

        Map[] dp = new Map[activities.length];
        map.put("J", activities[0][1]);
        map.put("C", 0);
        dp[0] = map;
        result.append("J");

        for (int i = 1; i < activities.length; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            int jim = (int) dp[i - 1].get("J");
            int cam = (int) dp[i - 1].get("C");

            if (start < jim && start < cam) {
                return "IMPOSSIBLE";
            }
            //cam is free
            if( start < jim ){
                result.append("C");
                map.put("C", end );
                dp[i] = map;
            }else{
                //jam is free
                result.append("J");
                map.put("J", end);
                dp[i] = map;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int caseNum = fastReader.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            int len = fastReader.nextInt();
            int[][] activities = new int[len][2];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 2; j++) {
                    activities[i][j] = fastReader.nextInt();
                }
            }

            System.out.println(String.format("Case #%d: %s", ks, solve(activities)));
        }
    }
}


class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
