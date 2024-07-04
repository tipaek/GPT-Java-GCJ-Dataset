import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();ob.nextLine();
        for(int tc=1;tc<=t;tc++)
        {
            String s=ob.nextLine();
            String ans="";int depth=0;
            for(int i=0;i<s.length();i++)
            {
                int x=Integer.parseInt(s.charAt(i)+"");
                for(int j=1;j<=x-depth;j++)
                ans+="(";
                
                for(int j=1;j<=depth-x;j++)
                ans+=")";

                ans+=x;
                depth=x; 
                //System.out.println(ans);               
            }
            for(int i=1;i<=depth;i++)
            ans+=")";
            
            System.out.println("Case #"+tc+": "+ans);
        }
        

    }
}
