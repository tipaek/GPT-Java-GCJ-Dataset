import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int[] c=new int[1440];
            int[] ju=new int[1440];
            String s="";
            int flag1=0;
            for(int j=0;j<n;j++)
            {
                int val1=sc.nextInt();
                int val2=sc.nextInt();
                int flag=0;
                for(int k=val1;k<val2;k++)
                {
                    if(c[k]!=0)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    s+='C';
                    Arrays.fill(c,val1,val2,1);
                }
                else
                {
                    for(int k=val1;k<val2;k++)
                    {
                        if(ju[k]!=0)
                        {
                            flag=2;
                            break;
                        }
                    }
                    if(flag == 1)
                    {
                        s+='J';
                        Arrays.fill(ju,val1,val2,1);
                    }
                    if(flag == 2)
                    {
                        flag1=1;
                    }
                }
                //System.out.println(s+" "+flag1+" "+flag);
            }
            if(flag1==0)
                System.out.println("Case #"+i+": "+s);
            else
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}