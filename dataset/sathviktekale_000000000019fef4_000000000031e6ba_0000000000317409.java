import java.util.*;

public class Solution
{
    public static void main(String args[])
    {
        int t,n,x,y;
        String str;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            str=sc.next();
            int stp=0;
            for(int j=0;j<str.length();j++)
            {
                char c=str.charAt(j);
                if(x==0 && y==0)
                {
                    break;
                }
                else
                {
                    if(c=='S')
                    {
                        stp++;
                        if(x!=0 && y==0)
                        {
                            continue;
                        }
                        else if(x!=0 && y!=0)
                        {
                            x--;
                            y--;
                        }
                        else if(x==0 && y!=0)
                        {
                            if(y-2>=0)
                            {
                                y=y-2;
                            }
                            else
                            {
                                y--;
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                    else if(c=='N' || c=='E')
                    {
                        stp++;
                    }
                    else if(c=='W')
                    {
                        stp++;
                        if(y!=0 && x==0)
                        {
                            continue;
                        }
                        else if(y!=0 && x!=0)
                        {
                            x--;
                            y--;
                        }
                        else if(y==0 && x!=0)
                        {
                            if(x-2>=0)
                            {
                                x=x-2;
                            }
                            else
                            {
                                x--;
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
            }
            if(x!=0 || y!=0)
            {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+(i+1)+": "+stp);
            }
        }
    }
}