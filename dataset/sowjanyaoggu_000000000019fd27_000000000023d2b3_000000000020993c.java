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
            for(int j=0;j<tr;j++)
            {
                for(int k=0;k<tr;k++)
                {
                    a[j][k]=s.nextInt();
                }
            }
            for(int j=0;j<tr;j++)
            {
                int first=a[j][0];
                boolean c=true;
                
                for(int k=1;k<tr;k++)
                {
                    if(a[j][k]!=first)
                    {
                        b=false;break;
                    }
                }
            if(b)
                c1++;
            }
            for(int j=0;j<tr;j++)
            {
                int second=a[0][j];
                boolean d=true;
                for(int k=1;k<tr;k++)
                {
                    if(a[j][k]!=second)
                    {
                        d=false;break;
                    }
                }
                if(d)
                    d1++;
            }
            System.out.println("case #"+i+": "+sum+" "+c1+" "+d1);
            
        }
    }
}