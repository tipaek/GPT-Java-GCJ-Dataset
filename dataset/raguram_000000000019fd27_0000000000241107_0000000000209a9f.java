import java.util.*;
class Main
{
    public static String s="",w="";
    public static int r=0;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int y=sc.nextInt();
        String[] out=new String[y+1];
        for(int j=0;j<=y;j++)
        {
            
            String x=sc.nextLine();
            int temp=0,temp2=0;
            for(int i=0;i<x.length();i++)
            {
                if(i==x.length()-1)
                    temp2=1;
                w=w+x.charAt(i);    
                try4(Integer.parseInt(w),temp,temp2);
                temp=Integer.parseInt(w);
                w="";
            }
            out[j]=s;
            s="";
            r=0;
        }
        for(int j=1;j<=y;j++)
        System.out.println("Case #"+(j)+": "+out[j]);
    }
    
    public static void try4(int x,int temp,int temp2)
    {
        if(temp<x)
        {
            for(int i=0;i<x-temp;i++)
            {
                s=s+"(";
                r++;
            }
            s=s+Integer.toString(x);
        }
        else if(temp>x)
        {
            for(int i=0;i<temp-x;i++)
            {
                s=s+")";
                r--;
            }
            s=s+Integer.toString(x);
        }
        else
            s=s+Integer.toString(x); 
        if(temp2==1)
            for(int i=0;i<r;i++)
                s=s+")";
    }
    
}
