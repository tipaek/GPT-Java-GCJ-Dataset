import java.util.*;
class Main
{
    public static void main(String arg[])
    {
        int i,j;
        Scanner sc=new Scanner(System.in);
        int s[]=new int[20];
        int e[]=new int[20];
        int testcase =sc.nextInt();
	   for(int t=1;t<=testcase;t++)
	   {
        int n=sc.nextInt();
        //System.out.print("enter start and end time");
        for(i=0;i<n;i++)
        {
            s[i]=sc.nextInt();
            e[i]=sc.nextInt();
        }
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n-1;j++)
            {
                if(s[i]>s[j])
                {
                    int temp=s[i];
                    s[i]=s[j];
                    s[j]=temp;
                    int temp1=e[i];
                    e[i]=e[j];
                    e[j]=temp1;
                }
            }
        }
        
        String st="C";
        for(i=0;i<n-1;i++)
        {
            if(e[i+1]<=s[i])
            {
                st+="C";
                //st="IMPOSSIBLE";
            }
            else if(e[i+1]>s[i] )
            {
                st+="J";
            }
            else if(i>=1 && e[i]>s[i+1])
            {
                st="IMPOSSIBLE";
            }
        }
        System.out.println("Case #"+t+":"+" "+st);
    }
}
}