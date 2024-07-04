import java.util.*;

public class Solution
{
    public static void main(String []arg)
    {
        int count=0;
        int i,j,t,n,dif;
        String line;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(i=0;i<t;i++)
        {
            count=0;
            line=sc.next();
            String dup="";
            char[] charline=line.toCharArray();
            for(j=0;j<charline.length;j++)
            {
                int x=Character.getNumericValue(charline[j]);
                if(x>=count)
                {
                    dif=x-count;
                    count=count+dif;
                    for(int k=0;k<dif;k++)
                    {
                        dup=dup+"(";
                    }
                    dup=dup+charline[j];
                }
                else
                {
                    dif=count-x;
                    count=count-dif;
                    for(int k=0;k<dif;k++)
                    {
                        dup=dup+")";
                    }
                    dup=dup+charline[j];
                }
            }
            for(j=0;j<count;j++)
            {
                dup=dup+")";
            }
            System.out.println(dup);
        }
    }
}