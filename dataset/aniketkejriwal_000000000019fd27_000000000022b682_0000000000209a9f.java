import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int T= in.nextInt();
        in.nextLine();
        int i=0;
        while(i<T)
        {
            i++;
            String S=in.nextLine();
            String S1="";
            int op=0;
            int cl=0;
            for(int j=0;j<S.length();j++)
            {
                while(cl>S.charAt(j)-48)
                {
                    S1=S1+")";
                    cl--;
                    op--;
                }
                while(op<S.charAt(j)-48)
                {
                    S1=S1+"(";
                    op++;
                    cl++;
                }
                S1=S1+S.charAt(j);
            }
            while(cl-->0)
                S1=S1+")";
            System.out.println("Case #"+i+": "+S1);
        }
    }
}
        
            