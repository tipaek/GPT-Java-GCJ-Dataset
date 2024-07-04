import java.util.Scanner;
public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int t=scan.nextInt(),i;
        int ncase=1;
        while(t-- > 0)
        {
            String s=scan.next();
            String ans="";
            int d=0;
            for(i=0;i<s.length();i++)
            {
                int cd=(int)(s.charAt(i)-'0');
                while(d != cd)
                {
                    if(d > cd)
                    {
                        ans+=")"; d--;
                    }
                    if(d < cd)
                    {
                        ans+="("; d++;
                    }
                }
                ans+=""+s.charAt(i);
            }
            while(d!=0) { ans+=")"; d--; }
            System.out.println("Case #"+ncase+": "+ans);
            ncase++;
        }
    }




}