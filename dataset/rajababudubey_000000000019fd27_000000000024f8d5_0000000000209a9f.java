class Solution
{
    public static void main(String gg[])
    {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int test=sc.nextInt();
        for(int x=1;x<=test;++x)
        {
            sc.nextLine();
            
            String s=sc.nextLine();
            int size=s.length();
            
            int stat=0; // paranthesis closed initially
            String ans="";
            
            for(int i=0;i<size;++i)
            {
                if(stat==0) //closed
                {
                    if(s.charAt(i)=='1')
                    {   
                        ans=ans+"("+s.charAt(i);
                        stat=1;
                    }
                    else ans=ans+s.charAt(i);
                }
                else if(stat==1) //open
                {
                    if(s.charAt(i)=='0')
                    {
                        ans=ans+")"+s.charAt(i);
                        stat=0;
                    }
                    else ans=ans+s.charAt(i);
                }
            }
            if(stat==1) ans=ans+")";
            System.out.println("Case #"+x+": "+ans);
        }
    }
}