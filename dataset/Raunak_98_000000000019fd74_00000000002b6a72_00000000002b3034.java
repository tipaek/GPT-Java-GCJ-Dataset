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
            String temp="";
            for(int i =0;i<n;i++)
            {
                if(s[i].length()==1)
                {
                    if(i==0)
                        s[i]=s[i+1];
                    else
                        s[i]=s[i-1];
                }
                if(temp.length()<s[i].length())
                    temp=s[i];
            }
            int c = 0;
            temp=temp.substring(1);
            for(int i=0;i<n;i++)
            {
                s[i]=s[i].substring(1);
                if(temp.contains(s[i]))
                    c++;
            }
            //System.out.println(c);
            if(c==n)
                System.out.println("Case #"+z+": "+temp);
            else
                System.out.println("Case #"+z+": *");
                
            z++;
        }
    }
}
