import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        int t,n,i,j,flag1,sona=0;
        String check="";
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t!=0)
        {
            n=sc.nextInt();
            char s[]=new char[n];
            for(i=1;i<=n;i++)
            s[i-1]='0';
            int a[]=new int[n];
            int b[]=new int[n];
            for(i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            flag1=0;check="";
            for(i=0;i<n;i++)
            {
                for(j=i+1;j<n;j++)
                {
                    if((a[j]>a[i]&&a[j]<b[i])||(b[j]<b[i]&&b[j]>a[i]))
                    {
                        if(check.indexOf(""+j)!=-1)
                        {
                            sona++;
                            System.out.println("Case #"+sona+": "+"IMPOSSIBLE");
                            flag1=1;
                            break;
                        }
                        else
                        s[j]=(char)(48+49-(int)s[i]);
                        check=check+j;
                    }
                }
                if(flag1==1)
                break;
            }
            if(flag1!=1)
            {
                sona++;
                System.out.print("Case #"+sona+": ");
                for(i=0;i<n;i++)
                {
                if(s[i]=='0')
                System.out.print("J");
                else
                System.out.print("C");
                }
                System.out.println();
            }
            t--;
        }
    }
}