import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int x=1;x<=n;x++)
        {
            String str = in.next();      
            String nest = fString(getNest(str));
            System.out.println("Case #"+x+": "+nest);
        }            
    }
    
    public static String getNest(String str)
    {
        String nstr="";
        for(int x=0;x<str.length();x++)
        {
            int dig = Integer.parseInt(str.charAt(x)+"");
            for(int l=1;l<=dig;l++)
            {
                nstr+="(";
            }
            nstr+=dig;
            for(int l=1;l<=dig;l++)
            {
                nstr+=")";
            }
        }
        return nstr;
    }
    
    public static String fString(String str)
    {    
        while(str.contains(")("))
        {
            str = str.replace(")(","");
        }
        return str;
    }
}
