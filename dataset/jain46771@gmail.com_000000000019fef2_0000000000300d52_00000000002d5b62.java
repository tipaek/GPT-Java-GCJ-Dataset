import java.io.*;
import java.util.*;

class Solution {

    static String ans = "";
    char[] dir ={'E','W','S','N'};

    public static boolean dfs(int x, int y, int xPoint, int yPoint,int jump, String s)
    {

//        System.out.println(x+" "+y+" "+xPoint+"  "+yPoint+"  "+s);
        if(x==xPoint && y==yPoint)
        {
            ans = s;
            return true;
        }

       if(Math.abs(x)<Math.abs(xPoint) || Math.abs(y)<Math.abs(yPoint)) return false;
        boolean ret ;
        int jp = (int) Math.pow(2,jump-1);

        ret = dfs(x,y,xPoint,yPoint-jp,jump+1,s+"S")||
                dfs(x,y,xPoint+jp,yPoint,jump+1,s+"E")||
                dfs(x,y,xPoint,yPoint+jp,jump+1,s+"N")||
                dfs(x,y,xPoint-jp,yPoint,jump+1,s+"W");
        return ret;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase;
        testCase = in.nextInt();

        for (int tc = 1; tc<=testCase; tc++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            if(!dfs(x,y,0,0,1,""))
                System.out.println("Case #"+tc+": IMPOSSIBLE");
            else
            {
                System.out.println("Case #"+tc+": "+ans);
            }

        }


    }
}