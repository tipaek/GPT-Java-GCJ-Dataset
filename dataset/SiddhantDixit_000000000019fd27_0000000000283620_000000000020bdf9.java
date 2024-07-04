import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int q=1;q<=t;q++)
        {
            int noAct = in.nextInt();
            int act[][] = new int[noAct][2];
            for(int x=0;x<noAct;x++)
            {
                act[x][0] = in.nextInt();
                act[x][1] = in.nextInt();                
            }            
            System.out.println("Case #"+q+": "+compute(noAct,act));
        }
    }
    
    public static String compute(int noAct,int act[][])
    {
        if(CheckPossible(noAct,act)==false)        
            return "IMPOSSIBLE";
            
        char ans[] = new char[noAct];
        ans[0] = 'J';
        for(int x=0;x<noAct;x++)
        {
            ans[x] = 'J';
            for(int i=0;i<x;i++)
            {
                if((act[x][0]>act[i][0]&&act[x][0]<act[i][1]) ||(act[x][1]>act[i][0]&&act[x][1]<act[i][1]))
                {
                    if(ans[i]=='C')
                        ans[x]='J';
                    else if(ans[i]=='J')
                        ans[x]='C';
                    break;
                }
            }            
        }
        
        String str="";
        for(char ch:ans)
            str+=ch;
        
        return str;
    }
    
    public static boolean CheckPossible(int noAct,int act[][])
    {        
        for(int x=0;x<noAct;x++)
        {
            for(int y=0;y<=1;y++)
            {
                int dig = act[x][y];
                int ct=0;
                for(int i=0;i<noAct;i++)
                {
                    if(dig>act[i][0]&&dig<act[i][1])
                        ct++;
                }
                if(ct>=2)
                    return false;
            }
        }
        return true;
    }
}