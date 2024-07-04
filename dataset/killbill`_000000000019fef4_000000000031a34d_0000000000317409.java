import java.util.*;
class Solution
{ public static int solve(int x,int y, String a)
    {int ans=-1;
        for (int i=0;i<a.length();i++)
        {
            char c=a.charAt(i);
            switch(c)
            {
                case 'N':
                    y+=1;
                    break;
                case 'S':
                    y-=1;
                    break;
                case 'W':
                    x-=1;
                    break;
                case 'E':
                    x+=1;
                    break;

            }
            if((Math.abs(x)+Math.abs(y))<=(i+1))
                {ans=i+1;
                break;}
    
        }
        return ans;



    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int temp=1;
        while(temp<=t)
        {
            int x=s.nextInt();
            int y=s.nextInt();
            String move=s.next();
        if (x==0 && y==0)
        {
            System.out.println("Case #"+temp+": 0");

        }
        else{
        int ans=solve(x,y,move);
        if (ans==-1)
        {
            System.out.println("Case #"+temp+": IMPOSSIBLE");
        }
        else{
            System.out.println("Case #"+temp+": "+ans);
        }}
        temp++;
        }
    }

}