import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int tr=s.nextInt();
            int[][] a=new int[tr][tr];
            int c1=0,d1=0,sum=0;
            Boolean b=true,c=true;
            for(int j=0;j<tr;j++)
            {
                for(int k=0;k<tr;k++)
                {
                    a[j][k]=s.nextInt();
                    if(i==j)
                        sum=sum+a[j][k];
                    if(a[j][k]!=a[j][0])
                    {
                        b=false;break;
                    }
                    if(a[j][k]!=a[0][k])
                    {
                        c=false;break;
                    }
                }
            }
             if(b)
                c1++;
            if(c)
                d1++;
            System.out.println("case #"+i+": "+sum+" "+c1+" "+d1);
        }
    }
}