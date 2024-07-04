import java.util.*;
class Solution
{
    static int co=1;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String s=sc.next();
            check(s);
        }
    }
    public static void check(String s)
    {
        String[] ar=s.split("");
        String s1="";
        int count=0;
        for(int i=0;i<ar.length;i++)
        {

            int n= Integer.parseInt(ar[i]);
            if((i>0 && n!= Integer.parseInt(ar[i-1])) || i==0 )
            {
                if(count>n)
                {
                    for(int m=0;m<count-n;m++) {
                        s1 += ")";
                        count--;
                    }
                }
                else {
                    for (int j = 0; j < n; j++) {
                        s1 += "(";
                        count++;
                        if (count == n)
                            break;
                    }
                }
            }
            if((n==0 && count!=0))
            {

                for(int k=0;k<count;k++)
                    s1+=")";
                count = 0;
            }
            else if( i==ar.length-1)
            {
                s1+=n;
                for(int k=0;k<count;k++)
                    s1+=")";
                break;
            }
            s1+=n;
        }
        System.out.println("Case #"+co+": "+s1);
        co++;
    }
}