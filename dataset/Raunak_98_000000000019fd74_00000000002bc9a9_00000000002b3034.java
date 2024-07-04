import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        int z=1;
        while(t-->0)
        {
            int n = sc.nextInt();
            String s[]=new String[n];
            for(int i=0;i<n;i++)
            {
                String str = sc.next();
                s[i]=str;
            }
            String tempL="";
            String tempR="";
            for(int i =0;i<n;i++)
            {
                int j =s[i].indexOf("*");
                String l = s[i].substring(0,j);
                String r = s[i].substring(j+1);
                if(tempL.length()<l.length())
                    tempL=l;
                if(tempR.length()<r.length())
                    tempR=r;
            }
            boolean f = true;
            for(int i=0;i<n;i++)
            {
                int j =s[i].indexOf("*");
                String l = s[i].substring(0,j);
                String r = s[i].substring(j+1);
                if(!tempL.startsWith(l))
                {
                    f=false;
                    break;
                }
                if(!tempR.endsWith(r))
                {
                    f=false;
                    break;
                }
            }
            if(!f)
                System.out.println("Case #"+z+": *");
            else
            {
                String answer = tempL+tempR;
                System.out.println("Case #"+z+": "+answer);
            }
                
            z++;
        }
    }
}
