

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String solve(int[][] activities) {
        StringBuilder result = new StringBuilder();
        Map<String, int[] > map = new HashMap<>();

        if( activities.length == 1 ){
            return "J";
        }

        List<Map<String, int[]>> lst = new ArrayList<>();
        map.put("J", activities[0]);
        map.put("C", activities[1]);

        lst.add( map );
        result.append("J");
        result.append("C");

        for (int i = 2; i < activities.length; i++) {

            int[] activity = activities[i];

            int[] jim = lst.get( lst.size() - 1).get("J");
            int[] cam = lst.get( lst.size() - 1).get("C");

            if ( overlap(jim, activity ) && overlap(cam, activity)) {
                return "IMPOSSIBLE";
            }
            if( !overlap(jim, activity) && !overlap(cam, activity)){
                String actor = ( jim[1] < cam[1]) ? "J" : "C";
                if( actor.equals("J")){
                    map.put("J", activity);
                    result.append("J");
                }else{
                    map.put("C", activity);
                    result.append("C");
                }

            }else if( !overlap(jim, activity ) ){
                map.put("J", activity);
                result.append("J");
            }else{
                map.put("C", activity);
                result.append("C");
            }


        }

        return result.toString();
    }

    public static boolean overlap( int[] first, int[] second ){
        if( second[1] < first[0]){
            return false;
        }
        if( second[0] >= first[1]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NestedDepths.FastReader fastReader = new NestedDepths.FastReader();
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
