
import java.io.*;
import java.util.*;
class Solution {



    double xLim;
    double yLim;
    String ans = "";
    char[] dir ={'E','W','S','N'};

    public boolean dfs(int x, int y, int xPoint, int yPoint,int jump, String s)
    {

//        System.out.println(x+" "+y+" "+xPoint+"  "+yPoint+"  "+s);
        if(x==xPoint && y==yPoint)
        {
            ans = s;
            return true;
        }

       if(Math.abs(xPoint)>xLim ||Math.abs(yPoint)>yLim) return false;
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
            Solution s1 = new Solution();
            int x = in.nextInt();
            int y = in.nextInt();
            if(Math.abs(x)<=4 && Math.abs(y)<=4)
            {
                s1.xLim = 4;
                s1.yLim = 4;
            }
            else if(Math.abs(x)<=100 && Math.abs(y)<=100)
            {
                s1.xLim = 100;
                s1.yLim = 100;
            }
            else
            {
                s1.xLim = Math.pow(10,9);
                s1.yLim = Math.pow(10,9);

            }

            if(!s1.dfs(x,y,0,0,1,""))
                System.out.println("Case #"+tc+": IMPOSSIBLE");
            else
            {
                System.out.println("Case #"+tc+": "+s1.ans);
            }

        }


    }
}

