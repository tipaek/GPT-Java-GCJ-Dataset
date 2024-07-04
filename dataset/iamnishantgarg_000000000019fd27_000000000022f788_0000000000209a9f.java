import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        for(int l=1;l<=t;l++)
        {
            String inp=in.next();
            String result="";
            int n=inp.length();
            int i=0;
            while(i<n)
            {
                char c=inp.charAt(i);
                int j=i;
                String tmp="";
                while(j<n&&inp.charAt(j)==c)
                {
                    tmp+=inp.charAt(j);
                    j++;
                }
                if(c=='0')
                result+=tmp;
                else
                result+="("+tmp+")";
                i=j;
            }
            System.out.println("Case #"+l+": "+result);
        }
    }
}