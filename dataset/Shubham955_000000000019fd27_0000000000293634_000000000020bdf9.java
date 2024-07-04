import java.util.Scanner;
class Demo
{
    
    
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int h=1;
        while(h<=t)
        {
            int n=scan.nextInt();
            int a[][]=new int[n][2];
            int jt[][]=new int[n][2];
            int ct[][]=new int[n][2];
            String s="";
            for(int i=0;i<n;i++)
            {
                a[i][0]=scan.nextInt();
                a[i][1]=scan.nextInt();
            
            }
            for(int l=0;l<n;l++)
            {
                int m=0;
                for(int i=0;i<jt.length;i++)
                {
                if(a[l][1]<=jt[i][0] || a[l][0]>=jt[i][1])
                {
                }
                else
                m=1;
                }
                int o=0;
                for(int i=0;i<ct.length;i++)
                {
                if(a[l][1]<=ct[i][0] || a[l][0]>=ct[i][1])
                {
                }
                else
                o=1;
                }
                if(m==0)
                s+="J";
                else if(o==0)
                s+="C";
                else
                {
                s="IMPOSSIBLE";
                break;
                }
            }
            
        }
    }
}