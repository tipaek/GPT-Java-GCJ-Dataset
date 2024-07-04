
import java.io.*;
import java.util.*;
class Solution {

    String ans = null;
    char[] dir ={'E','W','S','N'};

    public void dfs(int x, int y, int xPoint, int yPoint,int jump, String s)
    {
        if(x==xPoint && y==yPoint)
        {
            if(ans ==null || ans.length()>s.length())
                     ans = s;
            return;
        }
       int jp = (int) Math.pow(2,jump-1);
       if(Math.abs(xPoint)>3*Math.abs(x) || Math.abs(yPoint)>3*Math.abs(y) ) return;
        
        dfs(x,y,xPoint,yPoint-jp,jump+1,s+"S");
        dfs(x,y,xPoint+jp,yPoint,jump+1,s+"E");
        dfs(x,y,xPoint,yPoint+jp,jump+1,s+"N");
        dfs(x,y,xPoint-jp,yPoint,jump+1,s+"W");

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase;
        testCase = in.nextInt();

        for (int tc = 1; tc<=testCase; tc++)
        {
            Solution s1 = new Solution();
            int x = in.nextInt();
            int y = in.nextInt();
           s1.dfs(x,y,0,0,1,"");
            if(s1.ans==null)
                System.out.println("Case #"+tc+": IMPOSSIBLE");
            else
            {
                System.out.println("Case #"+tc+": "+s1.ans);
            }

        }


    }
}

