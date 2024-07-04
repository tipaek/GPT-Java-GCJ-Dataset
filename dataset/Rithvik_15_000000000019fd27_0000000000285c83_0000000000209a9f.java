import java.util.*;

class Solution
{
    public static void main(String args[])
    {
    Scanner v=new Scanner(System.in);
        int t=v.nextInt();
        v.nextLine();
        for(int z=1;z<=t;z++)
        {
            char a1[]=v.nextLine().toCharArray();
            int a[]=new int[a1.length];
            String b="";
            for(int i=0;i<a1.length;i++)
            a[i]=(a1[i]-'0');
            int fir=a[0];
            int op=0,cl=0;
            while(fir-->0)
            {
            b=b+"(";
                op++;
            }
            b=b+a[0];
            for(int i=1;i<a.length;i++)
            {
                if(a[i-1]<a[i])
                {
                     int lop=a[i]-a[i-1];
                    
                    while(lop-->0)
                    {
                        b=b+"(";
                        op++;
                    }
                    b=b+a[i];
                }
                if(a[i-1]>a[i])
                {
                    int lop=a[i-1]-a[i];
                    
                    while(lop-->0)
                    {
                        b=b+")";
                     cl++;               
                    }
                        b=b+a[i];
                
                }
                if(a[i-1]==a[i])
                    b=b+a[i];
            
            }
        int la=op-cl;
            while(la-->0)
                b=b+")";
            
            System.out.println("Case"+" #"+z+": "+b);
        }
    }
}