import java.util.*;
public class Nesting
{
    public static String match(char ch)
    {
        String r="";
        int n=Integer.parseInt(ch+"");

        for(int i=1;i<=((n*2)+1);i++)
        {
            if(i<=n)
                r=r+"(";
            else if(i>(n+1))
                r=r+")";
            else
                r=r+n;
        }
        return r;
    }

    public static void main(String args[])
    {
        try
        {
            Scanner in=new Scanner(System.in);
            int t=in.nextInt();
            if((t>=1)&&(t<=100))
            {
                for(int x=1;x<=t;x++)
                {
                    String s=in.next();
                    char ch;
                    String temp="";
                    for(int i=0;i<(s.length());i++)
                    {
                        ch=s.charAt(i);
                        temp=temp+match(ch);                  
                    }

                    System.out.println(temp);
                    String str=temp.replace(")(","");
                    System.out.println("Case #"+x+": "+str);
                }
            }
        }catch(Exception e)
        {
        }
    }
}
